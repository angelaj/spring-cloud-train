package com.train.common.convert.impl;

import java.nio.charset.Charset;

import com.train.common.convert.AbstractConverter;
import com.train.common.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
