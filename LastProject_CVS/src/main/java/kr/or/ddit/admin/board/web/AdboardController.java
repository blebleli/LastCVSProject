package kr.or.ddit.admin.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.board.service.adBoardServiceInf;
import kr.or.ddit.store_owner.model.salelistJoinVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"boardpage","pageNavi"})
@RequestMapping("/admin")
@Controller("adboardController")
public class AdboardController {
	
	@Resource(name="adboardService")
	private adBoardServiceInf adboardService;
	
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
		String BD_KIND_ID = "44"; // 공지사항 코드
		paramMap.put("BD_KIND_ID",BD_KIND_ID); // 맵에 저장
		
		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
		
		model.addAllAttributes(resultMap);
		model.addAttribute("BD_KIND_ID", BD_KIND_ID); // model 저장
		
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
		System.out.println("작성으로 들어왔어요~~");
		model.addAttribute("mem_id", mem_id);
		return "ad_boardNew";
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
	public String boardDel(Model model){
		String mem_id = "admin";
		model.addAttribute("mem_id", mem_id);
		System.out.println("삭제로 들어왔어요~~");
		return "ad_boardUpdate";
	}
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> review(@RequestParam(value="BD_KIND_ID", defaultValue="") String BD_KIND_ID,
								@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize){
		System.out.println(BD_KIND_ID);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page); // page 1
		paramMap.put("pageSize", pageSize); // pageSize 10
		paramMap.put("BD_KIND_ID",BD_KIND_ID); // 리뷰 코드(55)맵에 저장
		
		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
		
		return resultMap;
	}
}