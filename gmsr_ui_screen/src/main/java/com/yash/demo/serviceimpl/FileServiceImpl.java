package com.yash.demo.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yash.demo.dao.FileDAO;
import com.yash.demo.domain.FileModel;
import com.yash.demo.exception.FileStorageException;
import com.yash.demo.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	private final Path fileStorageLocation;
	
	@Autowired
	private FileDAO fileDAO;

	@Override
	public int uploadFile(FileModel fileModel) {
		System.out.println("service: "+fileModel.getStartDate()+" "+ fileModel.getEndDate() +" "+fileModel.getSelectedFileSource() +""+ fileModel.getSelectedUploadType() +""+fileModel.getComments());
		//java.io.File newFile= new java.io.File("C:/Users/ayushi.jain/Desktop/gmsr-files/"+fileModel.getFile().getName());
//		try {
//			newFile.createNewFile();	
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		fileModel.setFilePath(newFile.getAbsolutePath());
//		String pathCheck=fileModel.getFilePath();
//		System.out.println(pathCheck);
		return fileDAO.save(fileModel);
	}
	
	
	
	

    @Autowired
    public FileServiceImpl(FileModel fileModel) {
        this.fileStorageLocation = Paths.get(fileModel.getFilePath())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
	
	public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
