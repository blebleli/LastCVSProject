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
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정(공지사항, 상품리뷰, 이벤트)
	 */
	@RequestMapping("/boardUpdate")
	public String boardUpdate(Model model){
		String mem_id = "admin";
		model.addAttribute("mem_id", mem_id);
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
	public String boardDel(@RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){
		
//		model.addAttribute("mem_id", mem_id);
		return "ad_boardUpdate";
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