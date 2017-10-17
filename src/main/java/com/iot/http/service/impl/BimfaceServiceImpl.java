package com.iot.http.service.impl;

import com.bimface.sample.Config;
import com.bimface.sample.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.FileUploadRequest;
import com.bimface.sdk.bean.response.FileBean;
import com.bimface.sdk.exception.BimfaceException;
import com.bimface.sdk.service.UploadService;
import com.iot.common.util.DataWrapper;
import com.iot.common.util.FileOperationsUtil;
import com.iot.http.entity.Files;
import com.iot.http.service.BimfaceService;
import com.iot.http.service.FilesService;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service
public class BimfaceServiceImpl implements BimfaceService {
	BimfaceClient bimfaceClient;
	Config config;
	@Autowired
	FilesService filesService;
	UploadService uploadService;
	FileUploadRequest fileUploadRequest;
	@Override
	public DataWrapper<String> getViewTokenByFileId(Long fileId) {
		// TODO Auto-generated method stub
		DataWrapper<String> test = new DataWrapper<String>();
		bimfaceClient = new BimfaceClient(config.APP_KEY,config.APP_SECRET);
/*		bimfaceClient.getAccessTokenService();
		bimfaceClient.getViewTokenService();*/
		try {
			String str = bimfaceClient.getViewTokenByFileId(fileId);
			test.setData(str);
		} catch (BimfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return test;
	}
	@Override
	public DataWrapper<Long> uploadModelFile(MultipartFile file,HttpServletRequest requestion) {
		// TODO Auto-generated method stub
		DataWrapper<Long> test = new DataWrapper<Long>();
		String filepath="bimface/file";
		bimfaceClient = new BimfaceClient(config.APP_KEY,config.APP_SECRET);
		Files files=filesService.uploadFile(filepath, file, 0, requestion);
		fileUploadRequest.setUrl(files.getUrl());
		fileUploadRequest.setName(files.getName());
		FileBean fileBean=new FileBean();
		try {
			fileBean=uploadService.upload(fileUploadRequest);
		} catch (BimfaceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileBean tests=bimfaceClient.upload("test", files.getUrl());
			test.setData(tests.getFileId());
		} catch (BimfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return test;
	}


   
   


}
