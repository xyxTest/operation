package com.iot.http.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.iot.http.entity.Files;

public interface FilesService {
	boolean deleteFileByPath(String filePathAndName,HttpServletRequest request);
	Files getById(Long id);
	boolean deleteFileById(Long id);
	boolean addFile(Files file);
	Files uploadFile(String filePath, MultipartFile file, Integer fileType,HttpServletRequest request);
}
