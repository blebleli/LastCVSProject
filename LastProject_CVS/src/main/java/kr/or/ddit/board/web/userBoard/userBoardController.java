package kr.or.ddit.board.web.userBoard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @Class Name : userBoardController.java
 *
 * @author 조계환
 * @since 2018. 9. 4.
 * @version 1.1
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 9. 4. 조계환 최초 생성
 * 2018. 9. 28. 김마음 컨트롤러명 수정
 * </pre>
 */
@SessionAttributes({"userInfo"})
@RequestMapping("/board")
@Controller("userBoardController")
public class userBoardController {
	
	private Logger logger = LoggerFactory.getLogger(userBoardController.class);

	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	private Date today = new Date();
	
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
		logger.debug("pageNavi ===> {} ", resultMap.get("pageNavi"));
		model.addAttribute("i", i);
		model.addAttribute("i_search", i_search);		
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
								@RequestParam(value="i_h", defaultValue="") String i,
								@RequestParam(value="i_search_h", defaultValue="") String i_search,								
								Model model) {
		
		logger.debug("i ====> {} ", i);
		logger.debug("i_search ====> {} ", i_search);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = null;
		
		String bd_kind_id="44";
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);
		
		if(!(i.equals(""))){ // 검색한 카테고리 값이 있다면
			if(i.equals("1")){ // 제목 검색시
				paramMap.put("i", i);
				paramMap.put("bd_kind_id", bd_kind_id);
				paramMap.put("bd_title", i_search);
				resultMap = boardService.getBoardPageSearch(paramMap); //게시물 페이징 처리
			}else if(i.equals("2")){ // 내용 검색시
				paramMap.put("i", i);
				paramMap.put("bd_kind_id", bd_kind_id);
				paramMap.put("bd_content", i_search);
				resultMap = boardService.getBoardPageSearch(paramMap);
			}else if(i.equals("3")){ // 제목 + 내용 검색시
				paramMap.put("i", i);
				paramMap.put("bd_kind_id", bd_kind_id);
				paramMap.put("bd_parent", i_search); // 값이 분산되어 넣기가 불가능해서 부모코드에 임시로 검색량 넣어서 넘김.
				resultMap = boardService.getBoardPageSearch(paramMap);
			}else if(i.equals("4")){ // 작성자 검색시
				paramMap.put("i", i);
				paramMap.put("bd_kind_id", bd_kind_id);
				paramMap.put("mem_name", i_search);
				resultMap = boardService.getBoardPageSearch(paramMap);
			}
		}else{ // 검색한 카데고리 값이 없다면 빠져나오고 기본 페이징 처리기법 Service로 넘어간다.
			paramMap.put("i", i);
			paramMap.put("mem_name", i_search);			
			resultMap = boardService.getBoardPageList(paramMap);
		}
		
		logger.debug("pageNavi ===> {} ", resultMap.get("pageNavi"));
		
		model.addAttribute("i", i);
		model.addAttribute("i_search", i_search);
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
		
		String tempSavePath = "D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/Image/board/";
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
		model.addAttribute("cList", commentsList); // model에 저장한다.
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
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 내 댓글 작성 C
	 */
	@RequestMapping("/newComment")
	public String newComment(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
							 @RequestParam(value="cm_RadioCkeck", defaultValue="") String cm_RadioCkeck, CommentsVo cList, Model model){
				
		if(cm_RadioCkeck.equals("Y")){ // 댓글 공개하였다면
			cList.setCm_openny(cm_RadioCkeck); // 공개 체크 저장
			System.out.println("공개함");
		}else{ // 댓글 비공개를 하였다면
			cList.setCm_openny(cm_RadioCkeck); // 비공개 체크 저장
			System.out.println("비공개함");
		}
		
		if(bd_kind_id.equals("44")){ // 공지사항이면
			String CNOCODE = "CNO"; // 공지사항 코드 생성 준비
			String cm_id = code.autoCode(CNOCODE); // 코드 생성
			cList.setCm_id(cm_id); // 댓글코드 저장
			System.out.println("공지사항 입니다. ========================>>>>");
		} else { // 이벤트이면
			String CEVCODE = "CEV"; // 이벤트 코드 생성 준비
			String cm_id = code.autoCode(CEVCODE); // 코드 생성
			cList.setCm_id(cm_id); // 댓글코드 저장
			System.out.println("이벤트 입니다 =========================>>>>>");
		}		
		String cm_group = cList.getBd_id(); // 게시글 코드를
		cList.setCm_group(cm_group); // 그룹코드에 저장(첫 댓글은 자기 자신이 그룹코드이다.)
		
		int cnt = boardService.setInsertComments(cList);
		model.addAttribute("cList", cList);
		
		if(cnt != 0){
			return "redirect:/board/view?id=" + cList.getBd_id();	// id가 상세조회 id이름과 동일해야함.		
		}else{
			return "ad_index";
		}
	}
	
	/**
	 * Method : commentsDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 내 댓글 삭제 D
	 */
	@RequestMapping("/commentsDel")
	public String commentsDelete(@RequestParam(value="cm_id", defaultValue="") String cm_id,
								 @RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){		
		int cnt = boardService.commentsDelete(cm_id); // 댓글코드로 댓글을 삭제한다.
		
		if(cnt != 0){ // 댓글 삭제 성공시
			return "redirect:/board/view?id=" + bd_id; // 게시글 상세화면으로 이동한다.
		}else{ // 댓글 삭제 실패시
			return "ad_index"; // 관리자 메인으로 돌아간다.
		}
	}
}