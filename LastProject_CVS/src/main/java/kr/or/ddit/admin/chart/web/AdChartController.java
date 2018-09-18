package kr.or.ddit.admin.chart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adChart")
public class AdChartController {

	@RequestMapping("/chart")
	public ModelAndView cvsCountChart(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ad_chart");
		return mav;
	}
}
