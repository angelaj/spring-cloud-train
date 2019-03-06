package com.train.processor;

import com.alibaba.fastjson.JSONObject;
import com.train.feign.IconFeignClient;
import com.train.model.Icon;
import com.train.service.IconService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

@Service
public class IconPipeline implements Pipeline{
    private static Logger logger = LoggerFactory.getLogger(IconPipeline.class);

    @Autowired
    private IconFeignClient iconFeignClient;

    @SuppressWarnings("unchecked")
    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().contains("icon")) {
                Icon icon = (Icon) entry.getValue();
                boolean isSuccess = false;
                if (icon != null) {
                    Map<String,Object> resultMap = iconFeignClient.save(icon);
                    if (resultMap!=null && resultMap.get("rsCode").equals("A00000")){
                        isSuccess = true;
                    }
                    logger.info("insertOrUpdateIcon, icon="+ JSONObject.toJSONString(icon)+", result={"+isSuccess+"}");
                }
            }
        }
    }
}
