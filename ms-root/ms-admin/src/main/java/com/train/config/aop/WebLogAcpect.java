package com.train.config.aop;

import com.alibaba.fastjson.JSONObject;
import com.train.common.util.ReflectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class WebLogAcpect {
    private Logger logger = LoggerFactory.getLogger(WebLogAcpect.class);

    /**
     * 定义切入点
     */
    @Pointcut("execution(public * com.train.controller..*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        JoinPoint joinPoint = proceedingJoinPoint;

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        HttpSession session = request.getSession();
        String sessioId = session.getId();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String ip=request.getRemoteAddr();
        String uri = request.getRequestURI();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        //这一步获取到的方法有可能是代理方法也有可能是真实方法
        Method m = ((MethodSignature) proceedingJoinPoint.getSignature()).getMethod();
        //判断代理对象本身是否是连接点所在的目标对象，不是的话就要通过反射重新获取真实方法
        if (proceedingJoinPoint.getThis().getClass() != proceedingJoinPoint.getTarget().getClass()) {
            m = ReflectUtil.getMethod(proceedingJoinPoint.getTarget().getClass(), m.getName(), m.getParameterTypes());
        }
        //通过真实方法获取该方法的参数名称
        LocalVariableTableParameterNameDiscoverer paramNames = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = paramNames.getParameterNames(m);
        //获取连接点方法运行时的入参列表
        Object[] args = proceedingJoinPoint.getArgs();
        //将参数名称与入参值一一对应起来
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            params.put(parameterNames[i], args[i]);
        }
        String reqParams = JSONObject.toJSONString(params);

        logger.info("request-info: session_id={"+sessioId+"}, url={" + url+"}, http_method={"+method+"}, ip={"+ip+"}, uri={"+uri+"}, class_method={"
                +classMethod+"}, reqParams={"+reqParams+"}");
        Long startTime = System.currentTimeMillis();
        try {
            Object obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            logger.info("response-info: session_id={" + sessioId+"}, spend-time={"+(endTime-startTime)+"ms}");
            return obj;
        } catch (Throwable exception) {
            exception.printStackTrace();
            logger.error("request-info: session_id={"+sessioId+", url={" + url+"}, http_method={"+method+"}, ip={"+ip+"}, uri={"+uri+"}, class_method={"+classMethod
                    +"}, reqParams={"+reqParams+"}, error-info={"+ exception.toString()+"}");
        }
        return null;
    }
}
