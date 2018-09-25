package kr.or.ddit.admin.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.dao.AdminProdDaoInf;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.ProdVo;

@Service("adminProdService")
public class AdminProdService implements AdminProdServiceInf {

	
	@Resource(name="adminProdDao")
	AdminProdDaoInf adminProdDao;
	
	
	@Override
	public Map<String, Object> getProdList(AdminProdVo vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("prodList", adminProdDao.getProdList(vo));
		
//		int totCnt = adminProdDao.getProdListCount(vo);
		
//		result.put("pageNavi",  makePageNavi(vo.getPage(), vo.getPageSize(), totCnt));
		
		return  result;
	}

	@Override
	public List<CategoryVo> getProdCategory(CategoryVo vo) {
		return adminProdDao.getProdCategory(vo);
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		// 변경 되어야 할 부분
		pageNaviStr.append("<li><a href=\"/board/boardMain?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// 변경 되어야 할 부분
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/board/boardMain?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
			// 변경 되어야 할 부분
		}
		// 변경 되어야 할 부분
		pageNaviStr.append("<li><a href=\"/board/boardMain?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	
	/** 
	 * Method   : setProdInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param ProdVo
	 * @return int
	 * Method 설명 : 제품 insert
	 */
	@Override
	public int setProdInsert(ProdVo vo) {
		return adminProdDao.setProdInsert(vo);
	}

	/** 
	 * Method   : setCategoryInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param CategoryVo
	 * @return int
	 * Method 설명 : 카테고리 insert
	 */
	@Override
	public int setCategoryInsert(CategoryVo vo) {
		return adminProdDao.setCategoryInsert(vo);
	}

	
	/** 
	 * Method   : setEventInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param EventVo
	 * @return int
	 * Method 설명 : 이벤트 insert
	 */
	@Override
	public int setEventInsert(EventVo vo) {
		return adminProdDao.setEventInsert(vo);
	}

}
