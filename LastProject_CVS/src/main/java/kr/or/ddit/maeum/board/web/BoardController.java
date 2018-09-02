package kr.or.ddit.maeum.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import kr.or.ddit.maeum.board.service.BoardServiceInf;
import kr.or.ddit.model.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController { // 게시판 Controller
	
	@Resource(name="boardService") // 게시글
	private BoardServiceInf boardService;
	
	@RequestMapping("/list") // 공지사항 페이징 기법
	public String view(@RequestParam(value="page", defaultValue="1") int page,
					   @RequestParam(value="pageSize", defaultValue="10") int pageSize,
					   Model model){
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		List<BoardVo> boardList = boardService.getListBoard(); // 전체 건수 조회
		
		Map<String, Object> resultMap = boardService.getBoardPageList(paramMap);		
		model.addAllAttributes(resultMap);
		model.addAttribute("boardList", boardList);
		
		return "maeum/board";
	}
	
	@RequestMapping("/detail") // 공지사항 게시글 상세 조회
	public String view(@RequestParam("id") String bd_id, Model model){
		System.out.println(bd_id);
		BoardVo boardVo = boardService.getBoard(bd_id); // 게시글 조회

//		List<CommentsVo> commentsVo = commentsService.getComments(w_no); // 댓글 조회
		model.addAttribute("boardVo", boardVo);
		
		return "maeum/writeDetail";
	} // detail	
}