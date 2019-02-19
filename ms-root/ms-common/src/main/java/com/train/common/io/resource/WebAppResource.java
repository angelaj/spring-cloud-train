package com.train.common.io.resource;

import java.io.File;

import com.train.common.io.FileUtil;

/**
 * Web root资源访问对象
 * 
 * @author looly
 * @since 4.1.11
 */
public class WebAppResource extends FileResource {

	/**
	 * 构造
	 * 
	 * @param path 相对于Web root的路径
	 */
	public WebAppResource(String path) {
		super(new File(FileUtil.getWebRoot(), path));
	}

}
