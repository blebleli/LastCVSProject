package kr.or.ddit.board.web.userBoard;

import java.util.HashMap;
import java.util.List;
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
		
		logger.debug("{}bd_id======================== : " + bd_id);
		
		//클릭한 게시글의 정보를 객체로 가져옴
		BoardVo post = boardService.getBoard(bd_id);
		
		//댓글 리스트 출력
		List<CommentsVo> commentsList = boardService.getListComments(bd_id);
		logger.debug("{}=====================commentsList : ",commentsList);
		
		//게시글에 대한 정보를 뿌려주기 위함
		model.addAttribute("post",post);
		//게시글에 대한 댓글들을 뿌려주기 위함
		model.addAttribute("commentsList",commentsList);
		
		return "viewPost";
	}
	
	/**
	* Method : newComment
	* Method 설명 :신규 댓글 작성
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param commentsVo
	* @return
	*/
	@RequestMapping(value="/newComment",method=RequestMethod.POST)
	public String newComment(CommentsVo commentsVo, Model model){
		
		//댓글 작성에 필요한 댓글 내용을 가져옴
		String content = commentsVo.getCm_content();
		logger.debug("content========== : "+content);
		
		//댓글 불러오기에 필요한 게시글 번호를 가져옴
		String id = commentsVo.getBd_id();
		logger.debug("getBd_id()=============== : "+id);
		
		//댓글 공개 여부를 판단하기 위한 값을 불러옴
		String open = commentsVo.getCm_openny();
		logger.debug("open============= : "+open);
		
		//댓글 작성 메서드를 실행
		int cnt = boardService.setInsertComments(commentsVo);
		logger.debug("cnt============== : "+cnt);
		
		//댓글 리스트 출력
		List<CommentsVo> commentsList = boardService.getListComments(commentsVo.getBd_id());
		model.addAttribute("commentsList",commentsList);
		
		//클릭한 게시글의 정보를 가져오기 위해 클릭한 게시글의 고유 아이디를 가져옴
		String bd_id = commentsVo.getBd_id();
		//클릭한 게시글의 정보를 객체로 가져옴
		BoardVo post = boardService.getBoard(bd_id);
		//게시물에 대한 정보를 뿌려주기 위함
		model.addAttribute("post",post);
		
		return "viewPost";
	}
	
	/**
	* Method : deleteComment
	* Method 설명 :댓글 삭제 메서드
	* 최초작성일 : 2018. 9. 7.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param commentsVo
	* @param model
	* @return
	*/
	@RequestMapping(value="/deleteComment",method=RequestMethod.POST)
	public String deleteComment(CommentsVo commentsVo, Model model){
		
		//댓글 삭제에 필요한 댓글 고유 id를 가져옴
		String id = commentsVo.getCm_id();
		logger.debug("id============== : " + id);
		
		return "viewPost";
	}
}
