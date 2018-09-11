package kr.or.ddit.filedata.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.filedata.dao.FileDaoInf;
import kr.or.ddit.model.FiledataVo;

import org.springframework.stereotype.Service;



@Service("fileService")
public class FileService implements FileServiceInf {
	
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	

	/**
	 * 
	 * Method : insertFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 파일 정보 저장
	 */
	@Override
	public int insertFile(FiledataVo fileVo) {
		return fileDao.insertFile(fileVo);
	}

	/**
	 * 
	 * Method : getFrofilePicList
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List
	 * Method 설명 : 프로필사진 첨부파일 목록 조회
	 */
	@Override
	public List<FiledataVo> getFrofilePicList(String mem_id) {
		return fileDao.getFrofilePicList(mem_id);
	}

	/**
	 * 
	 * Method : deleteFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 삭제
	 */
	@Override
	public int deleteFile(FiledataVo fileVo) {
		return fileDao.deleteFile(fileVo);
	}

}
