package kr.or.ddit.admin.chart.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.admin.chart.service.AdChartServiceInf;
import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adChart")
public class AdChartController {
	private Logger logger = LoggerFactory.getLogger(AdChartController.class);
	
	@Resource(name="adChartService")
	private AdChartServiceInf adChartService;

	@RequestMapping("/chart")
	public ModelAndView cvsCountChart(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ad_chart");
		List<CvsCountVo> list1 = adChartService.getAllCvsCount();
		List<CvsCountVo> list2 = adChartService.getCvsServiceCount();
		List<MonthTopVo> list3 = adChartService.getCvsTop3();
		List<String> color = new ArrayList<String>();
		color.add("#0d259c");
		color.add("#0663b8");
		color.add("#17dbd6");
		color.add("#29dba9");
		color.add("#57d843");
		color.add("#98cbfb");
		color.add("#aefff1");
		color.add("#3b8fa1");
		
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("list3", list3);
		mav.addObject("color", color);
		return mav;
	}
	
	
}
