package kr.or.ddit.board.web.userBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.model.FiledataVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

@RequestMapping("/board")
@Controller("adBoardController")
public class AdBoardController {
	
	private Logger logger = LoggerFactory.getLogger(AdBoardController.class);

	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	/**
	 * Method : boardSearch
	 * Method 설명 : 사용자 공지사항 검색 조회
	 * 최초작성일 : 2018. 9. 26.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * 조 회 : 사용자 공지사항 검색 조회
	 * @return
	 */
	@RequestMapping("/boardSearch")
	public String boardSearch(@RequestParam(value="page", defaultValue="1") int page,
							  @RequestParam(value="pageSize", defaultValue="10") int pageSize,
							  @RequestParam(value="i", defaultValue="") String i,
							  @RequestParam(value="i_search", defaultValue="") String i_search,
							  @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id, Model model){
		System.out.println("page >>>>>>>>>>>>>>>>>>>>>>>>>> "+page);
		System.out.println("pageSize >>>>>>>>>>>>>>>>>>>>>>>>>> "+pageSize);
		System.out.println("i >>>>>>>>>>>>>>>>>>>>>>>>>> "+i);
		System.out.println("i_search >>>>>>>>>>>>>>>>>>>>>>>>>> "+i_search);
		System.out.println("bd_kind_id >>>>>>>>>>>>>>>>>>>>>>>>>> "+bd_kind_id);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);
		
		Map<String, Object> resultMap = null;
		
		if(i.equals("1")){ // 제목 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_title", i_search);
			resultMap = boardService.getBoardPageSearch(paramMap);
		}else if(i.equals("2")){ // 내용 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_content", i_search);
			resultMap = boardService.getBoardPageSearch(paramMap);
		}else if(i.equals("3")){ // 제목 + 내용 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_parent", i_search); // 값이 분산되어 넣기가 불가능해서 부모코드에 임시로 검색량 넣어서 넘김.
			resultMap = boardService.getBoardPageSearch(paramMap);
		}else if(i.equals("4")){ // 작성자 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("mem_name", i_search);
			resultMap = boardService.getBoardPageSearch(paramMap);
		}
		
		model.addAttribute("i", i);
		model.addAttribute("bd_kind_id",bd_kind_id);
		model.addAllAttributes(resultMap);
		
		return "boardList";
	}

	/**
	 * Method : boardListView
	 * Method 설명 : 사용자 공지사항 메인 화면 조회
	 * 최초작성일 : 2018. 9. 4.
	 * 작성자 : 조계환
	 * 변경이력 : 신규
	 * 조 회 : 사용자 공지사항 메인 화면 조회
	 * @return
	 */
	@RequestMapping("/boardMain")
	public String boardListView(@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize,
								Model model) {
		String bd_kind_id="44";
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);

		//게시물 페이징 처리
		Map<String, Object> resultMap = boardService.getBoardPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		model.addAttribute("bd_kind_id", bd_kind_id);
		
		return "boardList";
	}

	/**
	 * Method : boardSearch
	 * Method 설명 : 사용자 이벤트&행사 검색 조회
	 * 최초작성일 : 2018. 9. 26.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * 조 회 : 사용자 이벤트&행사 검색 조회
	 * @return
	 */
	@RequestMapping("/eventSearch")
	public String eventSearch(@RequestParam(value="page", defaultValue="1") int page,
							  @RequestParam(value="pageSize", defaultValue="10") int pageSize,
							  @RequestParam(value="i", defaultValue="") String i,
							  @RequestParam(value="i_search", defaultValue="") String i_search,
							  @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id, Model model){
		System.out.println("page >>>>>>>>>>>>>>>>>>>>>>>>>> "+page);
		System.out.println("pageSize >>>>>>>>>>>>>>>>>>>>>>>>>> "+pageSize);
		System.out.println("i >>>>>>>>>>>>>>>>>>>>>>>>>> "+i);
		System.out.println("i_search >>>>>>>>>>>>>>>>>>>>>>>>>> "+i_search);
		System.out.println("bd_kind_id >>>>>>>>>>>>>>>>>>>>>>>>>> "+bd_kind_id);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);
		
		Map<String, Object> resultMap = null;
		
		if(i.equals("1")){ // 제목 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_title", i_search);
			resultMap = boardService.getEventPageSearch(paramMap);
		}else if(i.equals("2")){ // 내용 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_content", i_search);
			resultMap = boardService.getEventPageSearch(paramMap);
		}else if(i.equals("3")){ // 제목 + 내용 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("bd_parent", i_search); // 값이 분산되어 넣기가 불가능해서 부모코드에 임시로 검색량 넣어서 넘김.
			resultMap = boardService.getEventPageSearch(paramMap);
		}else if(i.equals("4")){ // 작성자 검색시
			paramMap.put("bd_kind_id", bd_kind_id);
			paramMap.put("mem_name", i_search);
			resultMap = boardService.getEventPageSearch(paramMap);
		}
		
		model.addAttribute("i", i);
		model.addAttribute("bd_kind_id",bd_kind_id);
		model.addAllAttributes(resultMap);
		
		return "eventList";
	}	
	
	/**
	 * Method : boardEventListView
	 * Method 설명 : 사용자 이벤트&행사 게시판 메인 화면으로 가는 길
	 * 최초작성일 : 2018. 9. 25.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * 조 회 : public String boardEventListView()_사용자 이벤트&행사 게시판 메인 화면으로 가는 길
	 * @return
	 */
	@RequestMapping("/boardEventMain")
	public String boardEventListView(@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize,
								Model model) {
		
		String tempSavePath = "D:/A_TeachingMaterial/7.JspSpring/workspace/LastProject_CVS/src/main/webapp";
		String bd_kind_id="66";
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);

		//게시물 페이징 처리
		Map<String, Object> resultMap = boardService.getBoardPageList1(paramMap);
		
		model.addAllAttributes(resultMap);
		model.addAttribute("bd_kind_id", bd_kind_id);
		model.addAttribute("tempSavePath", tempSavePath);
		
		return "eventList";
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
	@RequestMapping("/view")
	public String postView(@RequestParam(value="id", defaultValue="") String bd_id,
			  			   @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2, Model model){
		
		BoardVo post = boardService.getBoard(bd_id); // 게시판 코드(bd_id)로 게시글 상세조회를 한다.
		List<CommentsVo> commentsList = boardService.getListComments(bd_id); // 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
		List<FiledataVo> FList = fileService.getFiledata(bd_id); // 게시판 코드(bd_id)로 해당 첨부파일 전체를 조회한다.
		model.addAttribute("bd_id", bd_id);
		model.addAttribute("bd_kind_id2", bd_kind_id2);
		model.addAttribute("post", post); // model에 저장한다.
		model.addAttribute("commentsList", commentsList); // model에 저장한다.
		model.addAttribute("FList", FList); // model에 저장한다.
		
		return "viewPost";
	}
	
	/**
	 * Method : postView
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @param bd_kind_id2
	 * @param model
	 * @return
	 * Method 설명 : 이벤트&행사 게시글 상세조회 이동
	 */
	@RequestMapping("/eventView")
	public String eventView(@RequestParam(value="id", defaultValue="") String bd_id,
			  			   @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2, Model model){
		
		BoardVo post = boardService.getBoard(bd_id); // 게시판 코드(bd_id)로 게시글 상세조회를 한다.
		List<CommentsVo> commentsList = boardService.getListComments(bd_id); // 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
		List<FiledataVo> FList = fileService.getFiledata(bd_id); // 게시판 코드(bd_id)로 해당 첨부파일 전체를 조회한다.
		model.addAttribute("bd_id", bd_id);
		model.addAttribute("post", post); // model에 저장한다.
		model.addAttribute("commentsList", commentsList); // model에 저장한다.
		model.addAttribute("FList", FList); // model에 저장한다.
		
		return "eventView";
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
	@RequestMapping(value="/newComment")
	public String newComment(@RequestParam(value="bd_id")String bd_id , CommentsVo commentsVo, Model model){
		
		//댓글 작성 메서드를 실행
		commentsVo.setCm_group("0");
		commentsVo.setCm_id2("");
		int cnt = boardService.setInsertComments(commentsVo);
		
		//리다이렉트해서 필요한 값을 넘겨주기 위함
		model.addAttribute("bd_id",bd_id);
		
		return "redirect:/board/view";
	}
	
//	/**
//	* Method : deleteComment
//	* Method 설명 :댓글 삭제 메서드
//	* 최초작성일 : 2018. 9. 7.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :
//	* @param commentsVo
//	* @param model
//	* @return
//	*/
//	@RequestMapping(value="/deleteComment")
//	public String deleteComment(@RequestParam(value="bd_id")String bd_id, CommentsVo commentsVo, Model model){
//		
//		//댓글 삭제에 필요한 댓글 고유 id를 가져옴
//		String id = commentsVo.getCm_id();
//		logger.debug("id============================"+id);
//		
//		//댓글 삭제 기능 메서드
//		int cnt = boardService.deleteComments(id);
//		logger.debug("cnt============================"+cnt);
//		
//		//리다이렉트해서 필요한 값을 넘겨주기 위함
//		model.addAttribute("bd_id",bd_id);
//		
//		return "redirect:/board/view";
//	}
}