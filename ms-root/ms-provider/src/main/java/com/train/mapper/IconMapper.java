package com.train.mapper;

import com.train.model.Icon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IconMapper {
    Integer getIconCount(Map<String, Object> param);

    List<Icon> getIconList(Map<String, Object> param);

    Integer insertOrUpdate(Icon icon);
}