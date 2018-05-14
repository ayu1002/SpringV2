package com.yash.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yash.demo.domain.FileModel;
import com.yash.demo.domain.UploadFileResponse;
import com.yash.demo.service.FileService;


@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		return "test";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadFile(@RequestBody FileModel fileModel, @RequestParam("file") MultipartFile file ) {
		System.out.println(fileModel.getStartDate()+" "+ fileModel.getEndDate() +" "+fileModel.getSelectedFileSource() +""+ fileModel.getSelectedUploadType() +""+fileModel.getComments());
		//System.out.println(fileModel.getFile().getName()+"from controller");
		String fileName=fileService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
		UploadFileResponse response= new UploadFileResponse(fileName, fileDownloadUri);
		if(response!=null) {
			int result= fileService.uploadFile(fileModel);
			if(result!=0) {
				return "file uploaded";
			}
			return "file not uploded";
		}
		return "file not uploded";
	}
}
