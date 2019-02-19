package com.train.service.impl;

import com.train.mapper.IconMapper;
import com.train.model.Icon;
import com.train.service.IIconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IconServiceImpl implements IIconService {
    @Autowired
    IconMapper iconMapper;

    @Override
    public Integer getIconCount(Map<String, Object> param) {
        return iconMapper.getIconCount(param);
    }

    @Override
    public List<Icon> getIconList(Map<String, Object> param) {
        return iconMapper.getIconList(param);
    }
}
