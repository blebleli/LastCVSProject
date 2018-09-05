package kr.or.ddit.board.web.adBoard;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Class Name : AdBoardController.java
 *
 * @author 조계환
 * @since 2018. 9. 4.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 9. 4. 조계환 최초 생성
 *
 * </pre>
 */

// ==========================================
// 목록
// 조회=============================================
//public String boardView()_게시판 메인 화면으로 가는 길

@RequestMapping("/board")
@Controller("adBoardController")
public class AdBoardController {
	private Logger logger = LoggerFactory.getLogger(AdBoardController.class);

	@Resource(name="boardService")
	private BoardServiceInf boardService;

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;

	/**
	 * Method : boardView
	 * Method 설명 : 게시판 메인 화면으로 가는 길
	 * 최초작성일 : 2018. 9. 4.
	 * 작성자 : 조계환
	 * 변경이력 :신규
	 * 조 회 :public String boardView()_게시판 메인 화면으로 가는 길
	 * @return
	 */
	@RequestMapping("/boardMain")
	public String boardListView(@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize,
								Model model) {

		Map<String, Integer> paramMap = new HashMap<String, Integer>();

		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);

		//게시물 페이징 처리
		Map<String, Object> resultMap = boardService.getBoardPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		return "boardList";
	}
	
	/**
	* Method : createNoticePostView
	* Method 설명 :공지사항 게시물 작성 화면으로 넘어가기
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@RequestMapping("/createNoticePostView")
	public String createNoticePostView(){
		return "newNoticePost";
	}
	
	
	/**
	* Method : postView
	* Method 설명 :공지사항 게시글 상세보기
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param bd_id
	* @param model
	* @return
	*/
	@RequestMapping(value="/view" ,method=RequestMethod.POST)
	public String postView(@RequestParam(value="bd_id")String bd_id, Model model){
		
		logger.debug("{}bd_id========================",bd_id);
		//클릭한 게시글의 정보를 객체로 가져옴
		BoardVo post = boardService.getBoard(bd_id);
		
		model.addAttribute("post",post);
		
		return "viewPost";
	}
	
	@RequestMapping("/newComment")
	public String newComment(CommentsVo commentsVo){
		
		boardService.setInsertComments(commentsVo);
		
		return "";
	}
}
