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
	public String boardCode(String kind) {
			return template.selectOne("tableCode.boardCode", kind);
	}

	@Override
	public String commentsCode() {
		return template.selectOne("tableCode.commentsCode");
	}

	@Override
	public String sale_disCode(String kind) {
		return template.selectOne("tableCode.sale_disCode", kind);
	}

	@Override
	public String sale_listCode() {
		return template.selectOne("tableCode.sale_listCode");
	}

	@Override
	public String disposal_list() {
		return template.selectOne("tableCode.disposal_listCode");
	}

	@Override
	public String supply_listCode() {
		return template.selectOne("tableCode.supply_listCode");
	}

	@Override
	public String filedataCode() {
		return template.selectOne("tableCode.filedataCode");
	}

	@Override
	public String eventCode() {
		return template.selectOne("tableCode.eventCode");
	}

	@Override
	public String reserveCode() {
		return template.selectOne("tableCode.reserveCode");
	}

	@Override
	public String categoryCode() {
		return template.selectOne("tableCode.categoryCode");
	}

	@Override
	public String stock_listCode() {
		return template.selectOne("tableCode.stock_listCode");
	}

	@Override
	public String stockCode() {
		return template.selectOne("tableCode.stockCode");
	}

	@Override
	public String membershipCode() {
		return template.selectOne("tableCode.membershipCode");
	}

	@Override
	public String payCode() {
		return template.selectOne("tableCode.payCode");
	}

	@Override
	public String bookmarkCode() {
		return template.selectOne("tableCode.bookmarkCode");
	}

	@Override
	public String cvs_serviceCode() {
		return template.selectOne("tableCode.cvs_serviceCode");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
