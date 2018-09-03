package kr.or.ddit.user.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.maeum.board.dao.BoardDaoInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.dao.CvsSearchDaoInf;

import org.springframework.stereotype.Service;

/** 
 * UserSearchService.java 
 * 
 * @author 조계환 
 * @since 2018. 9. 3. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 3.    조계환 최초 생성 
 * 
 * </pre>
 */
@Service("cvsSearchService")
public class CvsSearchService implements CvsSearchServiceInf{

	@Resource(name="cvsSearchService")
	private CvsSearchServiceInf userSearchService;
	
	@Resource(name="cvsSearchDao")
	private CvsSearchDaoInf cvsSearchDao;
	
	@Resource(name="boardDaos")
	private BoardDaoInf boardDaos;
	
	/** 
	 * Method   : getListMember 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 :조계환 
	 * 변경이력 : 신규
	 * @param word
	 * @return 
	 * Method 설명 :매개 변수로 가져온 검색어를 DB상에 포함 검색 (예:대흥점 검색하면 대흥점 포함한 편의점 이름 검색) 
	 */
	@Override
	public List<MemberVo> getListMember(String word) {
		return cvsSearchDao.getListMember(word);
	}
	
//	/**
//	 * Method : getBoardPageList
//	 * 최초작성일 : 2018. 9. 2.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * @param map
//	 * @return
//	 * Method 설명 : 각 게시판 페이징 기법
//	 */
//	@Override
//	public Map<String, Object> getBoardPageList(Map<String, Integer> map) {
//		
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		
//		// 게시판 페이지 리스트 조회
//		List<BoardVo> boardList = boardDaos.getBoardPageList(map);
//		resultMap.put("boardList", boardList);
//		
//		// 게시글 전체 건수 조회
//		int totCnt = boardDaos.getWriteTotCnt();
//		resultMap.put("totCnt", totCnt);
//		
//		// 페이지 네비게이션 html 생성
//		int page = map.get("page");
//		int pageSize = map.get("pageSize");
//		
//		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
//
//		return resultMap;
//	}
//	
//	private String makePageNavi(int page, int pageSize, int totCnt){
//		
//		int cnt = totCnt / pageSize; // 몫
//		int mod = totCnt % pageSize; // 나머지
//		
//		if (mod > 0)
//			cnt++;
//		
//		StringBuffer pageNaviStr = new StringBuffer();
//		
//		int prevPage = page == 1? 1 : page-1;
//		int nextPage = page == cnt ? page : page+1;
//		pageNaviStr.append("<li><a href=\"/board/list?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");
//		
//		for(int i = 1; i <= cnt; i++){
//			// /board/list?page=3&pageSize=10
//			String activeClass = "";
//			if(i == page)
//				activeClass = "class=\"active\"";
//			pageNaviStr.append("<li " + activeClass + "><a href=\"/write/list?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
//		}
//		
//		pageNaviStr.append("<li><a href=\"/board/list?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");
//		
//		return pageNaviStr.toString();
//	}
//	
	

}
