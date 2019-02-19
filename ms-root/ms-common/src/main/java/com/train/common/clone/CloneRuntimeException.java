package com.train.common.clone;

import com.train.common.exceptions.ExceptionUtil;
import com.train.common.util.StrUtil;

/**
 * 克隆异常
 * @author xiaoleilu
 */
public class CloneRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 6774837422188798989L;

	public CloneRuntimeException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public CloneRuntimeException(String message) {
		super(message);
	}
	
	public CloneRuntimeException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public CloneRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public CloneRuntimeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
