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

	/**
	 * Method : insertFileBoard
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param fileVo
	 * @return
	 * Method 설명 : 게시글 파일 첨부
	 */
	@Override
	public int insertFileBoard(FiledataVo fileVo) {
		return fileDao.insertFileBoard(fileVo);
	}

	/**
	 * Method : deleteFileBoard
	 * 최초작성일 : 2018. 9. 30.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param fileVo
	 * @return
	 * Method 설명 : 게시판 파일 삭제
	 */		
	@Override
	public int deleteFileBoard(FiledataVo fileVo) {
		return fileDao.deleteFileBoard(fileVo);
	}	
	
	/**
	 * Method : getFiledata
	 * 최초작성일 : 2018. 9. 22.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param fileVo
	 * @return
	 * Method 설명 : 게시글 내 첨부파일 전체 조회
	 */
	@Override
	public List<FiledataVo> getFiledata(String bd_id) {
		return fileDao.getFiledata(bd_id);
	}
}