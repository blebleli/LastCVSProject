package kr.or.ddit.admin.board.web;

import java.util.List;
import javax.annotation.Resource;
import kr.or.ddit.admin.board.model.BoardJoinVo;
import kr.or.ddit.admin.board.service.adBoardServiceInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String boardView(Model model){
		
		List<BoardJoinVo> boardList = adboardService.adBoardViewList(); // List에 담기
		
		model.addAttribute("boardList", boardList); // model 저장
		
		logger.debug(" boardList ===============> {} " + boardList);
		
		return "adboard/ad_boardView";
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
		return "adboard/ad_boardNew";
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
	public String boardDel(Model model){
		String mem_id = "admin";
		model.addAttribute("mem_id", mem_id);
		return "adboard/ad_boardUpdate";
	}
}