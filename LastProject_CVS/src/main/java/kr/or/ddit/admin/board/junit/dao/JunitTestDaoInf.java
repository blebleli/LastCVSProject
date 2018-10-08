package kr.or.ddit.admin.board.junit.dao;

import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

public interface JunitTestDaoInf {
	
	/**
	 * Method : memberJunitTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param memberVo
	 * @return
	 * Method 설명 : 점주 이름을 팀원 6명으로 수정
	 */
	int memberJunitTest(MemberVo memberVo);
	
	/**
	 * Method : insertBarcodeTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param barcodeVo
	 * @return
	 * Method 설명 : 바코드 생성(발주 신청)
	 */
	int insertBarcodeTest(BarcodeVo barcodeVo);
	
	/**
	 * Method : insertsupplyTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param supplyVo
	 * @return
	 * Method 설명 : 수불 생성(발주)
	 */
	int insertsupplyTest(SupplyVo supplyVo);
	
	/**
	 * Method : insertSupplyListTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param supplyListVo
	 * @return
	 * Method 설명 : 수불 리스트(발주)
	 */
	int insertSupplyListTest(SupplyListVo supplyListVo);
	
	/**
	 * Method : prodReviews
	 * 최초작성일 : 2018. 10. 8.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardVo
	 * @return
	 * Method 설명 : 상품리뷰 작성
	 */
	int prodReviews(BoardVo boardVo);
}