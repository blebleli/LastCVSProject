package kr.or.ddit.admin.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.admin.prod.dao.EventDaoInf;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.EventVo;

@Service("eventService")
public class EventService implements EventServiceInf {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="eventDao")
	private EventDaoInf eventDao;
	
	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시물 10개씩 묶어서 페이징 퍼치
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	
	*/
	@Override
	public Map<String, Object> getBoardPageList(Map<String, Object> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 게시판 페이지 리스트 조회
		List<BoardVo> boardpage = eventDao.getBoardPageList(map);		
		resultMap.put("boardpage", boardpage);
		
		String bd_kind_id = (String) map.get("bd_kind_id"); // 게시판 구분 값 가져오기

		// 게시글 전체 건수 조회
		int totCnt = eventDao.getBoardListTotCnt(bd_kind_id); // 구분 값 넣고 해당 구분 전체 건수 조회
		logger.debug("totCnt ================================>> {}", totCnt);
		resultMap.put("totCnt", totCnt);

		// 페이지 네비게이션 html 생성
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/event/view?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// /board/list?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/event/view?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/event/view?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	@Override
	public int setInsertEvnet(EventVo eventVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EventVo> getListEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEvent(EventVo eventVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEvent(String event_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
