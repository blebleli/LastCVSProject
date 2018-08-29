package kr.or.ddit.filedata.service;

import java.util.List;

import kr.or.ddit.model.FiledataVo;

public interface FileDataServiceInf {
	
	int newFileData(FiledataVo filedataVo);
	
	List<FiledataVo> getFileDataList();
	
	int updateFileData(FiledataVo filedataVo);
	
	int deleteFileData(String file_id);

}
