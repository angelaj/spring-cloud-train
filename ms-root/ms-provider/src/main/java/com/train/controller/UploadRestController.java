package com.train.controller;

import com.train.common.constant.ResultCode;
import com.train.common.utils.*;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class UploadRestController{
    private Logger logger = LoggerFactory.getLogger(UploadRestController.class);

    @Value(value = "${app.max.size}")
    public long maxSize;

    @Value(value = "${app.ftp.dir}")
    public String ftpDir;

    @Value(value = "${app.ftp.url}")
    public String ftpUrl;

    @Value(value = "${app.ftp.port}")
    public int ftpPort;

    @Value(value = "${app.ftp.username}")
    public String ftpUsername;

    @Value(value = "${app.ftp.password}")
    public String ftpPassword;

    @Value(value = "${app.ftp.domain}")
    public String ftpDomain;

    @PostMapping(value = "/api/upload")
    @ResponseBody
    public Map<String,Object> upload(String filetype, MultipartFile file) {
        Map<String, Object> result = ResultGenerator.getSuccessMap();
        if (null != file) {
            try{
                long size = file.getSize();
                if (size > maxSize) {
                    return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(),"上传文件大小超出限制！");
                }

                //获取到文件名
                String fileName = file.getOriginalFilename();
                String suffix = FileUtils.getExtensionName(fileName);
                String code = RandomUtils.getRandomChar(6);
                String finalFileName = code+"_"+System.currentTimeMillis()+"."+suffix;

                InputStream in = file.getInputStream();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String ftpPath = sdf.format(new Date());
                FTPClient ftpClient = FtpUtils.getFTPClient(ftpUrl,ftpPort,ftpUsername,ftpPassword);
                boolean isSuccess = FtpUtils.uploadFile(ftpClient,ftpDir,ftpPath,finalFileName,in);
                if (isSuccess){
                    String absolutePath = ftpDomain+ftpDir+File.separator+ftpPath+File.separator+finalFileName;
                    String relativePath = ftpDir+File.separator+ftpPath+File.separator+finalFileName;
                    result.put("fileName", fileName);
                    result.put("absolutePath", absolutePath);
                    result.put("relativePath", relativePath);
                    result.put("size", size);
                    return result;
                }else{
                    return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), "upload file fail!");
                }
            }catch (Exception e) {
                e.printStackTrace();
                return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), "upload file error!");
            }
        } else {
            return ResultGenerator.getFailMap(ResultCode.CODE_FAIL.getCode(), "upload file is null!");
        }
    }
}
