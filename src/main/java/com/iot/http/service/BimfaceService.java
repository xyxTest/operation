package com.iot.http.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.iot.common.util.DataWrapper;


public interface BimfaceService {
	DataWrapper<String> getViewTokenByFileId(Long fileId);
	DataWrapper<Long> uploadModelFile(MultipartFile file,HttpServletRequest request);
}
