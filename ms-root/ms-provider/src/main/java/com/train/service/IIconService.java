package com.train.service;

import com.train.model.Icon;

import java.util.List;
import java.util.Map;

public interface IIconService {
    Integer getIconCount(Map<String, Object> param);

    List<Icon> getIconList(Map<String, Object> param);
}
