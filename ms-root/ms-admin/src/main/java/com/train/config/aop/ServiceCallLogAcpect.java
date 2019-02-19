package com.train.config.aop;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class ServiceCallLogAcpect {
    private Logger logger = LoggerFactory.getLogger(ServiceCallLogAcpect.class);

    /**
     * 定义切入点
     */
    @Pointcut("execution(public * com.train.feign..*.*(..))")
    public void serviceCallLog(){}

    @Around("serviceCallLog()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        JoinPoint joinPoint = proceedingJoinPoint;

        //获取连接点的方法签名对象,在该对象中可以获取到目标方法名,所属类的Class等信息
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

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
        // 获取方法参数
        Object[] reqParamArr = proceedingJoinPoint.getArgs();

        logger.info("service call-info: session_id={"+sessioId+"}, url={" + url+"}, http_method={"+method+"}, ip={"+ip+"}, uri={"+uri+"}, class_method={"
                +classMethod+"}, reqParams={"+JSONObject.toJSONString(reqParamArr)+"}");
        Long startTime = System.currentTimeMillis();
        try {
            Object obj = proceedingJoinPoint.proceed();
            Long endTime = System.currentTimeMillis();
            logger.info("service call-info: session_id={" + sessioId+"}, result={"+JSONObject.toJSONString(obj)+"}, spend-time={"+(endTime-startTime)+"ms}");
            return obj;
        } catch (Throwable exception) {
            exception.printStackTrace();
            logger.error("service call-error: session_id={"+sessioId+", url={" + url+"}, http_method={"+method+"}, ip={"+ip+"}, uri={"+uri+"}, class_method={"+classMethod
                    +"}, reqParams={"+JSONObject.toJSONString(reqParamArr)+"}, error-info={"+ exception.toString()+"}");
        }
        return null;
    }
}
