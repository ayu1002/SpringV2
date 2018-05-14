package com.yash.demo.daoimpl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yash.demo.dao.FileDAO;
import com.yash.demo.domain.FileModel;

@Repository
public class FileDAOImpl implements FileDAO{


	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(FileModel fileModel) {
		boolean result = isFileExist(fileModel.getId());
		int var = 0;
		if (result == true) {
			return var;
		}
		System.out.println(fileModel.getSelectedFileSource()+""+fileModel.getSelectedUploadType()+""+fileModel.getStartDate()+""+fileModel.getFilePath());
		String sql = "insert into fileupload(startDate, endDate, selectedFileSource, selectedUploadType, filePath, comments)values(?,?,?,?,?,?)";
		Object[] param = new Object[] { fileModel.getStartDate(), fileModel.getEndDate(), fileModel.getSelectedFileSource(), fileModel.getSelectedUploadType(), fileModel.getFilePath(), fileModel.getComments() };
		jdbcTemplate.update(sql, param);
		return var + 1;
	}

	public boolean isFileExist(int id) {
		boolean result = false;
		String sql = "select count(*) from fileupload where id =?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, id);
		if (count != 0) {
			result = true;
		}
		return result;
	}

}
