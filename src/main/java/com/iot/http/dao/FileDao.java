package com.iot.http.dao;
import java.util.List;

import com.iot.common.util.DataWrapper;
import com.iot.http.entity.Files;
public interface FileDao {
	Files getById(Long id);
	DataWrapper<Files> getByName(String name);
	boolean deleteFiles(Long id);
	boolean addFiles(Files file);
	DataWrapper<List<Files>> getFilesList();
}
