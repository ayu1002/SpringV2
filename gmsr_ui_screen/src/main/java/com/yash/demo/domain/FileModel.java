package com.yash.demo.domain;

import java.io.File;
import java.sql.Date;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@ConfigurationProperties(prefix = "file")
public class FileModel {
	private int id;
	private Date startDate;
	private Date endDate;
	
//	@JsonProperty("selectedFileSource")
//	private JsonNode selectedFileSource;
//	
//	@JsonProperty("selectedUploadType")
//	private JsonNode selectedUploadType;
	
	private String selectedFileSource;
	private String selectedUploadType;
	//private MultipartFile file;
	private String filePath;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSelectedFileSource() {
		return selectedFileSource;
	}
	public void setSelectedFileSource(String selectedFileSource) {
		this.selectedFileSource = selectedFileSource;
	}
	
	
	
//	public JsonNode getSelectedFileSource() {
//		return selectedFileSource;
//	}
//	public void setSelectedFileSource(JsonNode selectedFileSource) {
//		this.selectedFileSource = selectedFileSource;
//	}
	public String getSelectedUploadType() {
		return selectedUploadType;
	}
	public void setSelectedUploadType(String selectedUploadType) {
		this.selectedUploadType = selectedUploadType;
	}
	
//	public JsonNode getSelectedUploadType() {
//		return selectedUploadType;
//	}
//	public void setSelectedUploadType(JsonNode selectedUploadType) {
//		this.selectedUploadType = selectedUploadType;
//	}
	
//	public MultipartFile getFile() {
//		return file;
//	}
//	public void setFile(MultipartFile file) {
//		this.file = file;
//	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
