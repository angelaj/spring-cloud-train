package com.train.common.convert.impl;

import java.util.UUID;

import com.train.common.convert.AbstractConverter;

/**
 * UUID对象转换器转换器
 * 
 * @author Looly
 * @since 4.0.10
 *
 */
public class UUIDConverter extends AbstractConverter<UUID> {

	@Override
	protected UUID convertInternal(Object value) {
		return UUID.fromString(convertToStr(value));
	}

}
