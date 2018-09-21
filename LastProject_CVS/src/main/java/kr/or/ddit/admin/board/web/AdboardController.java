package kr.or.ddit.admin.board.web;

import java.util.List;
import javax.annotation.Resource;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes({"userInfo"})
@SessionAttributes({"userInfo","boardList","pageNavi"})
@RequestMapping("/adboard")
@Controller("adboardController")
public class AdboardController {
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Method : boardView
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시판 조회(전체, 공지사항, 상품리뷰, 이벤트) List - C
	 */	
	@RequestMapping("/boardView")
	public String boardView(@RequestParam(value="btnChk", defaultValue="") String bd_kind_id,
			@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2,
							Model model){		

//		logger.debug("bd_kind_id =========> {} ", "게시판 분류코드는 "+bd_kind_id+" 입니다.");
		logger.debug("bd_kind_id =========> {} ", "게시판 분류코드는 "+bd_kind_id2+" 입니다.");
		List<BoardVo> boardList = boardService.getBoardPageList2(bd_kind_id);
		model.addAttribute("bd_kind_id", bd_kind_id);
		model.addAttribute("bd_kind_id2", bd_kind_id2);
		model.addAttribute("boardList", boardList);
		return "ad_boardView";
	}
	
	/**
	 * Method : boardNew
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 등록 화면 이동(공지사항, 이벤트) C - GO
	 */
	@RequestMapping("/boardNew")
	public String boardNew(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
						   @RequestParam(value="bd_kind_id3", defaultValue="") String bd_kind_id3,Model model){
		logger.debug("bd_kind_id ==================================>> {} ", bd_kind_id);
		model.addAttribute("bd_kind_id", bd_kind_id);
		model.addAttribute("bd_kind_id3", bd_kind_id3);
		return "ad_boardNew";
	}
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 등록 완료(공지사항, 이벤트) C
	 */
	@RequestMapping("/boardCreate")
	public String boardCreate(BoardVo b, Model model){		
		String bnocode = "BNO"; // 공지사항 코드 생성 준비(임시)
		String bd_id = code.autoCode(bnocode); // 가공
		b.setBd_id(bd_id); // Vo에 코드 저장
		b.setBd_group(bd_id); // 첫 글은 첫번째 코드가 그룹코드임.		
		int cnt = boardService.setInsertBoard(b); // 쿼리 실행 후 성공시 cnt 1 반환		
		String bd_kind_id = b.getBd_kind_id();			
		if(cnt != 0){
			return "redirect:/adboard/boardView?btnChk=" + bd_kind_id;		
		}else{
			return "ad_index";
		}
	}
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 상세조회 화면 이동 R, 게시글 댓글 화면 이동 R
	 */
	@RequestMapping("/boardDetail")
	public String boardDetail(@RequestParam(value="id", defaultValue="") String bd_id, 
							  @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2, Model model){
		BoardVo b = boardService.getBoard(bd_id); // 게시판 코드(bd_id)로 게시글 상세조회를 한다.
		List<CommentsVo> cList = boardService.getListComments(bd_id); // 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
		logger.debug("cList =====> {}", cList);
		logger.debug("bd_id =====> {}", bd_id);
		model.addAttribute("bd_id", bd_id);
		model.addAttribute("bd_kind_id2", bd_kind_id2);
		model.addAttribute("b", b); // model에 저장한다.
		model.addAttribute("cList", cList); // model에 저장한다.
		return "ad_boardDetail";
	}
	
	/**
	 * Method : boardUpdateGo
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정화면 이동 U - GO
	 */
	@RequestMapping("/boardUpdateGo")
	public String boardUpdateGo(@RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){		
		BoardVo boardVo = boardService.getBoard(bd_id); // 게시코드로 게시글 정보 조회	
		model.addAttribute("boardVo", boardVo); // model에 저장한다.		
		return "ad_boardUpdate"; // 게시글 수정화면으로 이동
	}
	
	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정 완료 U
	 */
	@RequestMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(value="smarteditor", defaultValue="") String bd_content,
							  BoardVo boardVo, Model model){	
		boardVo.setBd_content(bd_content);
		int cnt = boardService.boardUpdate(boardVo); // 게시글 정보 통해 게시글 수정 후 cnt 생성	
		if(cnt != 0){ // cnt가 0이 아닐시
			model.addAttribute("boardVo", boardVo); // model에 저장한다.		
			return "redirect:/adboard/boardDetail?id="+boardVo.getBd_id(); // 게시글 상세조회 화면으로 이동
		}else{ // 게시글 수정 실패시
			return "/admin/main"; // 관리자 메인화면으로 이동
		}
	}
	
	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 삭제 D
	 */
	@RequestMapping("/boardDel")
	public String boardDel(@RequestParam(value="bd_id", defaultValue="") String bd_id,
						   @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id, Model model){
		
		int cnt = boardService.boardDelete(bd_id); // 게시글 코드를 가지고 게시글을 삭제한다.
		
		if(cnt != 0){
			// 삭제 성공시 해당 구분(ex 공지사항) 리스트 조회화면으로 이동한다.
			return "redirect:/adboard/boardView?bd_kind_id=" + bd_kind_id;
		}else{
			// 삭제 실패시 내용을 디버그로 출력하며, 관리자 메인화면으로 이동한다.
			logger.debug("write delete fail ====>>>> {} ", cnt);
			return "admin/main";
		}
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
		
		logger.debug("cm_RadioCkeck =====>> {}", cm_RadioCkeck);
		System.out.println(bd_kind_id);
				
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
			logger.debug("cm_id ==========> {} ", cm_id);
			System.out.println("공지사항 입니다. ========================>>>>");
		} else { // 이벤트이면
			String CEVCODE = "CEV"; // 이벤트 코드 생성 준비
			String cm_id = code.autoCode(CEVCODE); // 코드 생성
			cList.setCm_id(cm_id); // 댓글코드 저장
			logger.debug("cm_id ==========> {} ", cm_id);
			System.out.println("이벤트 입니다 =========================>>>>>");
		}
		
		String cm_group = cList.getBd_id(); // 게시글 코드를
		cList.setCm_group(cm_group); // 그룹코드에 저장(첫 댓글은 자기 자신이 그룹코드이다.)
		
		int cnt = boardService.setInsertComments(cList);
		model.addAttribute("cList", cList);
		
		if(cnt != 0){
			return "redirect:/adboard/boardDetail?id=" + cList.getBd_id();	// id가 상세조회 id이름과 동일해야함.		
		}else{
			System.out.println("실패");
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
			return "redirect:/adboard/boardDetail?id=" + bd_id; // 게시글 상세화면으로 이동한다.
		}else{ // 댓글 삭제 실패시
			return "ad_index"; // 관리자 메인으로 돌아간다.
		}
	}
	
//	@RequestMapping(value="/review", method=RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> review(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
//								@RequestParam(value="page", defaultValue="1") int page,
//								@RequestParam(value="pageSize", defaultValue="10") int pageSize){
//		
//		logger.debug("bd_kind_id ============> {} " + bd_kind_id);
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		
//		paramMap.put("page", page); // page 1
//		paramMap.put("pageSize", pageSize); // pageSize 10
//		paramMap.put("bd_kind_id",bd_kind_id); // 리뷰 코드(55)맵에 저장
//		
//		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
//		
//		return resultMap;
//	}
}