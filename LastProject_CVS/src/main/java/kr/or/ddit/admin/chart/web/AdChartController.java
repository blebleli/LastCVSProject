package kr.or.ddit.admin.chart.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.admin.chart.service.AdChartServiceInf;
import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
		List<RankVo> list4 = adChartService.getProdTop5();
		List<MonthTopVo> reqList = adChartService.supReqMonthAmount();
		List<MonthTopVo> inList =adChartService.supInMonthAmount();
//		JSONObject object = areachart();
//		logger.debug("------object :"+object);
		
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("list4", list4);
		mav.addObject("reqList", reqList);
		mav.addObject("inList", inList);
		return mav;
	}
	
//	public JSONObject areachart(){
//		JSONObject object = new JSONObject();
//		List<MonthTopVo> list3 = adChartService.getCvsTop3();
//		logger.debug("---list3 : " + list3);
//		
//		JSONArray array = new JSONArray();
//		JSONArray array2 = new JSONArray();
//		JSONArray array3 = new JSONArray();
//		JSONArray array4 = new JSONArray();
//		for(int i = 0; i < list3.size(); i++){
//			if(!array.contains(list3.get(i).getId())){
//				array.add(list3.get(i).getId());
//			}
//			if(i==0){
//				array2.add(list3.get(i).getMonth());
//			}
//			if(i==3){
//				array3.add(list3.get(i).getMonth());
//			}if(i==6){
//				array4.add(list3.get(i).getMonth());
//			}
//		}
//		object.put("cvsname", array);
//		
//		for(int i =0; i < list3.size(); i++){
//			for(int k =0; k < array.size(); i++){
//				
//					if(list3.get(i).getId().equals(array.get(k))){
//						array2.add(list3.get(i).getAmount());
//					}
//				
//				
//			}
//		}
//		
//		object.put("first", array2);
//		object.put("second", array3);
//		return object;
//	}
}
