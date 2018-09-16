package kr.or.ddit.commons.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

@Repository("commonsDao")
public class CommonsDao implements CommonsDaoInf {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<EventVo> getEventPopUpOne() {
		return null;
	}
	
	@Override
	public List<CategoryVo> prodCtgyList() {
		List<CategoryVo> prodCtgyList = template.selectList("category.prodCtgyList");
		return prodCtgyList;
	}

	/** 
	 *               autoCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * Method 설명 :   자동 코드 생성
	 */
	@Override
	public String boardCode(String code) {
			return template.selectOne("tableCode.boardCode", code);
	}

	@Override
	public String commentsCode(String code) {
		return template.selectOne("tableCode.commentsCode", code);
	}

	@Override
	public String sale_disCode(String code) {
		return template.selectOne("tableCode.sale_disCode", code);
	}

	@Override
	public String sale_listCode(String code) {
		return template.selectOne("tableCode.sale_listCode", code);
	}

	@Override
	public String disposal_list(String code) {
		return template.selectOne("tableCode.disposal_listCode", code);
	}

	@Override
	public String supply_listCode(String code) {
		return template.selectOne("tableCode.supply_listCode", code);
	}

	@Override
	public String filedataCode(String code) {
		return template.selectOne("tableCode.filedataCode", code);
	}

	@Override
	public String eventCode(String code) {
		return template.selectOne("tableCode.eventCode", code);
	}

	@Override
	public String reserveCode(String code) {
		return template.selectOne("tableCode.reserveCode", code);
	}

	@Override
	public String categoryCode(String code) {
		return template.selectOne("tableCode.categoryCode", code);
	}

	@Override
	public String stock_listCode(String code) {
		return template.selectOne("tableCode.stock_listCode", code);
	}

	@Override
	public String stockCode(String code) {
		return template.selectOne("tableCode.stockCode", code);
	}

	@Override
	public String membershipCode(String code) {
		return template.selectOne("tableCode.membershipCode", code);
	}

	@Override
	public String payCode(String code) {
		return template.selectOne("tableCode.payCode", code);
	}

	@Override
	public String bookmarkCode(String code) {
		return template.selectOne("tableCode.bookmarkCode", code);
	}

	@Override
	public String cvs_serviceCode(String code) {
		return template.selectOne("tableCode.cvs_serviceCode", code);
	}

	@Override
	public String ProdCode(String code) {
		return template.selectOne("tableCode.ProdCode", code);
	}

	@Override
	public int stockBarcode(String code) {
		return template.selectOne("tableCode.stockBarcode", code);
	}

	@Override
	public int pocketBarcode(String code) {
		return template.selectOne("tableCode.pocketBarcode", code);
	}

	@Override
	public int supplyListBarcode(String code) {
		return template.selectOne("tableCode.supplyListBarcode", code);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
