package kr.or.ddit.admin.board.junit.dao;

import javax.annotation.Resource;

import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("junitTestDao")
public class JunitTestDao implements JunitTestDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * Method : memberJunitTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param memberVo
	 * @return
	 * Method 설명 : 점주 이름을 팀원 6명으로 수정
	 */
	@Override
	public int memberJunitTest(MemberVo memberVo) {
		return template.update("member.memberJunitTest", memberVo);
	}
	
	/**
	 * Method : insertBarcodeTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param barcodeVo
	 * @return
	 * Method 설명 : 바코드 생성(발주 신청)
	 */
	@Override
	public int insertBarcodeTest(BarcodeVo barcodeVo) {
		return template.insert("barcode.insertBarcode", barcodeVo);
	}
	
	/**
	 * Method : insertsupplyTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param supplyVo
	 * @return
	 * Method 설명 : 수불 생성(발주)
	 */
	@Override
	public int insertsupplyTest(SupplyVo supplyVo) {
		return template.insert("supply.insertsupplyTest", supplyVo);
	}
	
	/**
	 * Method : insertSupplyListTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param supplyListVo
	 * @return
	 * Method 설명 : 수불 리스트(발주)
	 */
	@Override
	public int insertSupplyListTest(SupplyListVo supplyListVo) {
		return template.insert("supply.insertSupplyList", supplyListVo);
	}
	
	/**
	 * Method : prodReviews
	 * 최초작성일 : 2018. 10. 8.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardVo
	 * @return
	 * Method 설명 : 상품리뷰 작성
	 */
	@Override
	public int prodReviews(BoardVo boardVo) {
		return template.insert("board.prodReviews", boardVo);
	}	
}