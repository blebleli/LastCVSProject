package kr.or.ddit.admin.board.junit.service;

import javax.annotation.Resource;

import kr.or.ddit.admin.board.junit.dao.JunitTestDaoInf;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

import org.springframework.stereotype.Service;

@Service("junitTestService")
public class JunitTestService implements JunitTestServiceInf {

	@Resource(name="junitTestDao")
	private JunitTestDaoInf junitTestDao;
	
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
		return junitTestDao.memberJunitTest(memberVo);
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
		return junitTestDao.insertBarcodeTest(barcodeVo);
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
		return junitTestDao.insertsupplyTest(supplyVo);
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
		return junitTestDao.insertSupplyListTest(supplyListVo);
	}	
}