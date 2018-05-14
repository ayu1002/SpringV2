package com.yash.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.yash.demo.domain.FileModel;

public interface FileService {
	public int uploadFile(FileModel fileModel);

	public String storeFile(MultipartFile file);
}
