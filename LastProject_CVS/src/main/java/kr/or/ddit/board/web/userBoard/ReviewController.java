package kr.or.ddit.board.web.userBoard;

import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/review")
@SessionAttributes({"user"})
public class ReviewController {
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView writeReview(@RequestParam(value="prod_id")String prod_id, @RequestParam(value="reviewCont")String reviewCont, @RequestParam(value="rating")int rating, Model model){
		ModelAndView mav = new ModelAndView();
		BoardVo review = new BoardVo();
		String title = reviewCont.substring(0, 3);
		Map modelMap = model.asMap();
		MemberVo user = (MemberVo) modelMap.get("user");
		review.setBd_title(title);
		review.setBd_content(reviewCont);
		review.setProd_id(prod_id);
		review.setBd_del("N");
		review.setBd_rating(rating);
		review.setMem_id(user.getMem_id());
		boardService.insertReview(review);
		mav.addObject("prod_id", prod_id);
		mav.setViewName("redirect:/userProd/detail");
		return mav;
	}
}
