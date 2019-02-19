package com.train.feign;

import com.train.feign.hystrix.DictionaryFeignClientHystrix;
import com.train.model.Dictionary;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.provider}",fallback = DictionaryFeignClientHystrix.class)
public interface DictionaryFeignClient {
    @RequestMapping(value = "/api/dictionary/getDictionaryList", method = RequestMethod.POST)
    Map<String,Object> getDictionaryList(@RequestBody Map<String, Object> param);

    @RequestMapping(value = "/api/dictionary/getByDictionaryId", method = RequestMethod.GET)
    Map<String,Object> getByDictionaryId(@RequestParam("dictionaryId") Long dictionaryId);

    @RequestMapping(value = "/api/dictionary/saveDictionary", method = RequestMethod.POST)
    Map<String,Object> saveDictionary(@RequestBody Dictionary dictionary);

    @RequestMapping(value = "/api/dictionary/getDicCodeList", method = RequestMethod.POST)
    Map<String,Object> getDicCodeList(@RequestBody Map<String, Object> param);
}
