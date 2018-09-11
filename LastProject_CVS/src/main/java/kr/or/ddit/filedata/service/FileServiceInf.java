package kr.or.ddit.filedata.service;

import java.util.List;

import kr.or.ddit.model.FiledataVo;

public interface FileServiceInf {
	
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
	

}
