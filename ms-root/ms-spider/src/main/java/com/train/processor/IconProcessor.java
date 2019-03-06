package com.train.processor;

import com.train.model.Icon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Date;
import java.util.List;

@Component
public class IconProcessor implements PageProcessor {
    private static Logger logger = LoggerFactory.getLogger(IconProcessor.class);

    // 主域名
    public static final String URL_LIST = "http://www\\.fontawesome\\.com\\.cn/faicons/";

    private Site site = Site.me()
            .setDomain(URL_LIST)
            .setSleepTime(1000)
            .setRetryTimes(30)
            .setCharset("utf-8")
            .setTimeOut(30000)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void process(Page page) {
        String url = String.valueOf(page.getUrl());

        if (page.getUrl().regex(URL_LIST).match()) {
            List<String> linkList = page.getHtml().xpath("//div[@class=\"fa-hover\"]/a").links().all();
            page.addTargetRequests(linkList);
        }else{
            String[] iconAry = url.split("/");
            String iconName = iconAry[iconAry.length-1];
            String iconStyle= "fa-"+iconName;

            Icon icon = new Icon();
            icon.setIconName(iconName);
            icon.setIconStyle(iconStyle);
            icon.setCreateTime(new Date());
            page.putField("icon", icon);
        }
    }
}
