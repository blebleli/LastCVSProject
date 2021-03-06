package kr.or.ddit.board.web.userBoard;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/review")
@SessionAttributes({"userInfo"})
public class ReviewController {
	private Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="autoCodeCreate")
	AutoCodeCreate autoCodeCreate;
	
	private Date today = new Date();
	
	//리뷰작성
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView writeReview(BoardVo review, Model model){
		
		logger.debug("writeReview===========================================");
		ModelAndView mav = new ModelAndView();
//
		String bd_id = autoCodeCreate.autoCode("BRE");
		review.setBd_date(today);
		review.setBd_id(bd_id);
		review.setBd_del("N");
		logger.debug("review ==> {} ", review);
		
		boardService.setInsertBoard(review);
		mav.addObject("prod_id", review.getProd_id());
		mav.setViewName("redirect:/userProd/detail");
		return mav;
	}
	
	//리뷰삭제처리
	@RequestMapping("/delete")
	public ModelAndView deleteReview(@RequestParam(value="prod_id")String prod_id, @RequestParam(value="bd_id")String bd_id,Model model){
		ModelAndView mav = new ModelAndView();
		Map modelMap = model.asMap();
		MemberVo userInfo = (MemberVo) modelMap.get("userInfo");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", userInfo.getMem_id());
		paramMap.put("bd_id", bd_id);
		ReviewVo review = boardService.getUserReview(paramMap);
//		review.setBd_del("Y");
		
		
		mav.addObject("prod_id", prod_id);
		mav.addObject("review",review);
		mav.setViewName("redirect:/userProd/detail");
		return mav;
	}
}
