package kr.or.ddit.admin.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.board.model.BoardJoinVo;
import kr.or.ddit.admin.board.service.adBoardServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.CommentsVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"boardpage","pageNavi","bd_kind_id"})
@RequestMapping("/admin")
@Controller("adboardController")
public class AdboardController {
	
	@Resource(name="adboardService")
	private adBoardServiceInf adboardService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Method : boardView
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시판 전체 조회(공지사항, 상품리뷰, 이벤트)
	 */
	@RequestMapping("/boardView")
	public String boardView(@RequestParam(value="page", defaultValue="1") int page,
							@RequestParam(value="pageSize", defaultValue="10") int pageSize,
							Model model){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page); // page 1
		paramMap.put("pageSize", pageSize); // pageSize 10
		String bd_kind_id = "44"; // 공지사항 코드
		paramMap.put("bd_kind_id",bd_kind_id); // 맵에 저장
		
		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
		
		model.addAllAttributes(resultMap);
		model.addAttribute("bd_kind_id", bd_kind_id); // model 저장
		
		return "ad_boardView";
	}
	
	/**
	 * Method : boardNew
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 작성(공지사항, 상품리뷰, 이벤트)
	 */
	@RequestMapping("/boardNew")
	public String boardNew(Model model){
		String mem_id = "admin";
		model.addAttribute("mem_id", mem_id);
		return "ad_boardNew";
	}
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 등록(공지사항, 상품리뷰, 이벤트)
	 */
	@RequestMapping("/boardCreate")
	public String boardCreate(@RequestParam(value="mem_id", defaultValue="") String mem_id,
							  @RequestParam(value="smarteditor", defaultValue="") String bd_content, BoardJoinVo b, Model model){
		
		String bnocode = "BNO"; // 공지사항 코드 생성 준비(임시)
		String bd_id = code.autoCode(bnocode); // 가공
		logger.debug("BNO ===========================>> {} "+bnocode);
		b.setBd_id(bd_id); // Vo에 코드 저장
		b.setBd_group(bd_id); // 첫 글은 첫번째 코드가 그룹코드임.
		b.setBd_content(bd_content); // 내용 저장
		
		logger.debug("b ===================>>>> {} "+b );
		
		int cnt = adboardService.setWriteInsert(b); // 쿼리 실행 후 성공시 cnt 1 반환
		
		String bd_kind_id = b.getBd_kind_id();
			
		if(cnt != 0){
			return "redirect:/admin/boardView?bd_kind_id=" + bd_kind_id;			
		}else{
			System.out.println("실패");
			return "admin/main";
		}
	}
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 상세조회 이동
	 */
	@RequestMapping("/boardDetail")
	public String boardDetail(@RequestParam(value="id", defaultValue="") String bd_id, Model model){
		BoardJoinVo b = adboardService.boardDetail(bd_id); // 게시판 코드(bd_id)로 게시글 상세조회를 한다.
		List<CommentsVo> cList = adboardService.getListComments(bd_id); // 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
		logger.debug("b =====> {}", b);
		logger.debug("cList =====> {}", cList);
		logger.debug("bd_id ////////////////// {}", bd_id);
		model.addAttribute("bd_id", bd_id);
		model.addAttribute("b", b); // model에 저장한다.
		model.addAttribute("cList", cList); // model에 저장한다.
		return "ad_boardDetail";
	}
	
	/**
	 * Method : newComment
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 댓글 작성
	 */
	@RequestMapping("/newComment")
	public String newComment(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
							 @RequestParam(value="cm_opennyY", defaultValue="") String cm_opennyY,
							 @RequestParam(value="cm_opennyN", defaultValue="") String cm_opennyN, CommentsVo commentsVo, Model model){
		
		if(bd_kind_id == "44"){ // 공지사항이면
			String CNOCODE = "CNO"; // 공지사항 코드 생성 준비
			String cm_id = code.autoCode(CNOCODE); // 코드 생성
			logger.debug("CNOCODE ==========> {} ", CNOCODE);			
		} else { // 이벤트이면
			String CEVCODE = "CEV"; // 이벤트 코드 생성 준비
			String cm_id = code.autoCode(CEVCODE); // 코드 생성
			logger.debug("CEVCODE ==========> {} ", CEVCODE);				
		}
		
		if(cm_opennyY==""){ // 댓글 공개를 안하였다면
			commentsVo.setCm_openny(cm_opennyN); // 비공개 체크 저장
		}else{ // 댓글 공개를 하였다면
			commentsVo.setCm_openny(cm_opennyY); // 공개 체크 저장
		}
		
//		commentsVo.set
//
//		
//		INSERT INTO COMMENTS(CM_ID, BD_ID, MEM_ID,cm_content, CM_DATE, CM_DELNY,CM_OPENNY, cm_group, cm_id2) 
//		VALUES (COMMENT_NO.nextval,#{bd_id},'admin',DBMS_LOB.SUBSTR(#{cm_content},4000,1),sysdate,'N',#{cm_openny},#{cm_group}, #{cm_id2})
//		
//		CM_ID
//		CM_DELNY
//		cm_group
//		cm_id2
		
		return "";
	}
	
	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정화면(공지사항, 상품리뷰, 이벤트) 이동
	 */
	@RequestMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){		
		BoardJoinVo boardJoinVo = adboardService.boardDetail(bd_id); // 게시글 코드(bd_id)로 게시글 정보를 조회한다.		
		model.addAttribute("boardJoinVo", boardJoinVo); // model에 저장한다.		
		return "ad_boardUpdate";
	}
	

	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 삭제
	 */
	@RequestMapping("/boardDel")
	public String boardDel(@RequestParam(value="bd_id", defaultValue="") String bd_id,
						   @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id, Model model){
		
		int cnt = adboardService.boardDelete(bd_id); // 게시글 코드를 가지고 게시글을 삭제한다.
		
		if(cnt != 0){
			// 삭제 성공시 해당 구분(ex 공지사항) 리스트 조회화면으로 이동한다.
			return "redirect:/admin/boardView?bd_kind_id=" + bd_kind_id;
		}else{
			// 삭제 실패시 내용을 디버그로 출력하며, 관리자 메인화면으로 이동한다.
			logger.debug("write delete fail ====>>>> {} ", cnt);
			return "admin/main";
		}
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> review(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
								@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize){
		
		logger.debug("bd_kind_id ============> {} " + bd_kind_id);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page); // page 1
		paramMap.put("pageSize", pageSize); // pageSize 10
		paramMap.put("bd_kind_id",bd_kind_id); // 리뷰 코드(55)맵에 저장
		
		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
		
		return resultMap;
	}
}