package kr.or.ddit.filedata.dao;

import java.util.List;

import kr.or.ddit.model.FiledataVo;


public interface FileDaoInf {
	
	/**
	 * 
	 * Method : insertFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 파일 정보 저장
	 */
	int insertFile(FiledataVo fileVo);
	
	/**
	 * 
	 * Method : getFrofilePicList
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return List
	 * Method 설명 : 프로필사진 첨부파일 목록 조회
	 */
	List<FiledataVo> getFrofilePicList(String mem_id);
	
	/**
	 * 
	 * Method : deleteFile
	 * 최초작성일 : 2018. 09. 11
	 * 작성자 : pc24
	 * 변경이력 :
	 * @return void
	 * Method 설명 : 첨부파일 정보 삭제
	 */
	int deleteFile(FiledataVo fileVo);
	
	/**
	 * Method : insertFileBoard
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param fileVo
	 * @return
	 * Method 설명 : 게시판 파일 첨부
	 */
	int insertFileBoard(FiledataVo fileVo);

	int deleteFileBoard(FiledataVo fileVo);
	
	/**
	 * Method : getFiledata
	 * 최초작성일 : 2018. 9. 22.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param fileVo
	 * @return
	 * Method 설명 : 게시글 내 첨부파일 전체 조회
	 */
	List<FiledataVo> getFiledata(String bd_id);
}