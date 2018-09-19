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
import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.model.FiledataVo;

@Service("adboardService")
public class adBoardService implements adBoardServiceInf {
	
	@Resource(name="adboardDao")
	private adBoardDaoInf adboardDao;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

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
			logger.debug("boardList ===========> {} "+boardList);
		}
		
		resultMap.put("boardpage", boardpage); // 저장
		
		// 페이지 네비게이션 html 생성
		int totCnt = adboardDao.getBoardTotCnt(); // 게시글 전체 건수 조회
		
		
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		

		
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	private String makePageNavi(int page, int pageSize, int totCnt){
		
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
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 등록, 공지사항 44, 리뷰 55, 이벤트 66
	 */
	@Override
	public int boardCreate(BoardJoinVo boardJoinVo) {
		return adboardDao.boardCreate(boardJoinVo);
	}
	
	/**
	 * Method : setWriteInsert
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시판 생성 한 후 파일 생성 하도록 한다.
	 * 				게시판 생성 실패시 파일 생성이 안된다.
	 */
	public int setWriteInsert(BoardJoinVo boardJoinVo) {
		
		int cnt = 0;
		
		// 게시글 생성
		cnt =+ adboardDao.boardCreate(boardJoinVo);
		
		for(FiledataVo vo : boardJoinVo.getFileList()) { // for문으로 file 가져오기
			// 파일 생성
			cnt =+ fileService.insertFile(vo); // file이 있으면 1씩 증가
		}
		return cnt;
	}
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시판 코드(bd_id)로 게시글 상세 조회를 한다.
	 */
	@Override
	public BoardJoinVo boardDetail(String bd_id) {
		return adboardDao.boardDetail(bd_id);
	}
	
	/**
	 * Method : commentsList
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
	 */
	@Override
	public List<CommentsVo> getListComments(String bd_id) {
		return adboardDao.getListComments(bd_id);
	}
	
	/**
	 * Method : boardDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시물 삭제
	 */
	@Override
	public int boardDelete(String bd_id) {
		return adboardDao.boardDelete(bd_id);
	}
}