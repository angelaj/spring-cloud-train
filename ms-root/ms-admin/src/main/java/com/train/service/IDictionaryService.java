package com.train.service;

import com.train.model.Dictionary;

import java.util.List;
import java.util.Map;

public interface IDictionaryService {
    Map<String,Object> getDicCodeMap(Map<String, Object> param);

    Integer getDicCodeCount(Map<String, Object> param);

    List<String> getDicCodeList(Map<String, Object> param);

    Integer getDictionaryCount(Map<String, Object> param);

    List<Dictionary> getDictionaryList(Map<String, Object> param);

    Map<String,Object> getDictionaryMap(Map<String, Object> param);

    Dictionary getDictionaryDetail(Long dictionaryId);

    String saveDictionary(Dictionary dictionary);
}
