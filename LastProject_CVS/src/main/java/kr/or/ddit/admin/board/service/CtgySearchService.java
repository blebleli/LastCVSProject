package kr.or.ddit.admin.board.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import kr.or.ddit.admin.board.dao.CtgySearchDaoInf;
import kr.or.ddit.model.CategoryVo;

@Service("ctgySearchService")
public class CtgySearchService implements CtgySearchServiceInf {
	
	@Resource(name="ctgySearchDao")
	private CtgySearchDaoInf ctgySearchDao;
	
	/**
	 * Method : getProdCategoryMd
	 * 최초작성일 : 2018. 9. 23.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param ctgy_group
	 * @return
	 * Method 설명 : 카테고리 대분류 검색시 해당 대분류 내 중분류 자동 조회.
	 */
	@Override
	public List<CategoryVo> getProdCategoryMd(String ctgy_name) {
		return ctgySearchDao.getProdCategoryMd(ctgy_name);
	}
}