package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.model.BoardVo;

/**
 * @Class Name : BoardDaoInf.java
 *
 * @author           
 * @since              
 * @version          
 * @see
 *
 * <pre>
 * @<< 개정이력(Modification Information) >>
 * @
 * @   수정일         수정자        수정내용
 * @ -------------   -------   ------------------------
 * @ 
 *
 * </pre>
 */

//조회================================================================

public interface BoardDaoInf {
	
	int newBoard(BoardVo boardVo);

	List<BoardVo> getBoardList();
	
	int updateBoard(BoardVo boardVo);
	
	int deleteBoard(String bd_id);
	
	
	/**
	 * Method           : getListBestReviewOne
	 * Method 설명  :  카테고리별 최고 평점 제품 1건씩 조회 기능
	 * 최초작성일    : 2018. 8. 29.
	 * 작성자           :  조종원
	 * 변경이력       : 신규
	 * 조회              : 
	 * @return
	 */
	List<BoardVo> getListBestReviewOne();
	
	
}
