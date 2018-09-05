//package kr.or.ddit.maeum.board.service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import kr.or.ddit.maeum.board.dao.BoardDaoInf;
//import kr.or.ddit.model.BoardVo;
//
//@Service("boardService")
//public class BoardService implements BoardServiceInf {
//	
//	@Resource(name="boardDaos")
//	private BoardDaoInf boardDaos;
//
//	/**
//	* Method : getBoardList
//	* Method 설명 :공지사항 게시판의 게시물 리스트 출력
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
//	* @return
//	*/
//	@Override
//	public List<BoardVo> getListBoard(){
//		return boardDaos.getListBoard();
//	}
//	
//	/**
//	* Method : getBoard
//	* Method 설명 :클릭한 공지사항 게시글 상세보기 기능
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :BoardVo getBoard(String bd_id)_클릭한 공지사항 게시글 상세보기 기능
//	* @param bd_id
//	* @return
//	*/
//	@Override
//	public BoardVo getBoard(String bd_id) {
//		return boardDaos.getBoard(bd_id);
//	}
//	
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
//}