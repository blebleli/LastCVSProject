package kr.or.ddit.admin.prod.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.board.web.userBoard.AdBoardController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/event")
@Controller("eventController")
public class EventController {
	
	private Logger logger = LoggerFactory.getLogger(AdBoardController.class);

	@Resource(name="eventService")
	private EventServiceInf eventService;
	
	/**
	 * Method : eventView
	 * 최초작성일 : 2018. 9. 24.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 이벤트 메인화면 조회
	 */
	@RequestMapping("/view")
	public String eventView(@RequestParam(value="page", defaultValue="1") int page,
							@RequestParam(value="pageSize", defaultValue="10") int pageSize,
							Model model) {
		
		String bd_kind_id="66"; // 이벤트 게시판 구분
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("bd_kind_id", bd_kind_id);
		
		//게시물 페이징 처리
		Map<String, Object> resultMap = eventService.getBoardPageList(paramMap);
		
		model.addAllAttributes(resultMap);
		
		return "eventList";
	}
}