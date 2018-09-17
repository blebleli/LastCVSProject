package kr.or.ddit.admin.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.admin.board.dao.adBoardDaoInf;
import kr.or.ddit.admin.board.model.BoardJoinVo;

@Service("adboardService")
public class adBoardService implements adBoardServiceInf {
	
	@Resource(name="adboardDao")
	private adBoardDaoInf adboardDao;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 관리자 - 각 게시판 페이징 기법
	 */
	@Override
	public Map<String, Object> adBoardViewList(Map<String, Object> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 게시판 페이지 리스트 조회
		List<BoardJoinVo> boardpage = adboardDao.adBoardViewList(map);
		for (BoardJoinVo boardList : boardpage){
			logger.debug("boardList ===========> {} "+boardList.getBd_title());
		}
		
		resultMap.put("boardpage", boardpage); // 저장
		
		// 페이지 네비게이션 html 생성
		int totCnt = adboardDao.getBoardTotCnt(); // 게시글 전체 건수 조회
		
		String BD_KIND_ID = (String) map.get("BD_KIND_ID");
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(BD_KIND_ID, page, pageSize, totCnt));
		
		return resultMap;
	}
	
	private String makePageNavi(String BD_KIND_ID, int page, int pageSize, int totCnt){
		
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지
		
		if (mod > 0)
			cnt++;
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/admin/boardView?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i = 1; i <= cnt; i++){
			// /admin/boardView?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/admin/boardView?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}
		
		pageNaviStr.append("<li><a href=\"/admin/boardView?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return pageNaviStr.toString();
		
	}
}