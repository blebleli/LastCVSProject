package kr.or.ddit.admin.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.dao.AdminProdDaoInf;
import kr.or.ddit.model.CategoryVo;

@Service("adminProdService")
public class AdminProdService implements AdminProdServiceInf {

	
	@Resource(name="adminProdDao")
	AdminProdDaoInf adminProdDao;
	
	
	@Override
	public Map<String, Object> getProdList(AdminProdVo vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("prodList", adminProdDao.getProdList(vo));
		
		int totCnt = adminProdDao.getProdListCount(vo);
		
		result.put("pageNavi",  makePageNavi(vo.getPage(), vo.getpageSize(), totCnt));
		
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

}
