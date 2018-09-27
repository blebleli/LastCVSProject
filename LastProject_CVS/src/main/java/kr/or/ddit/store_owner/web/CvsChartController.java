package kr.or.ddit.store_owner.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.store_owner.model.OnedayChartVo;
import kr.or.ddit.store_owner.model.salelistJoinVo;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 담당 --김마음
 * CvsChartController.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */
@RequestMapping("/cvs")
@Controller("cvsChartController")
public class CvsChartController {
	
	@Resource(name="somainService")
	private soMainServiceInf somainService;
	
	private Logger logger = LoggerFactory.getLogger(CvsChartController.class);
	
	/**
	 * Method : chartDay
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 점주가 통계 - 날짜별 조회 할 수 있다.
	 */
	@RequestMapping("/chartDay") // 통계 (날짜별)
	public String chartDay(Model model){
		
		String mem_id = "hsj"; // 임의 편의점 아이디		
		List<salelistJoinVo> saleList = somainService.getListSaleDays(mem_id); // 쿼리 돌림
		
		logger.debug("sd_sum ===================>> {} ", saleList); // 디버깅		
		model.addAttribute("saleList", saleList); // List 저장
		model.addAttribute("mem_id", mem_id); // mem_id 저장
		
		return "cvs_chart_day"; // 날짜별 화면 이동
	}
	
	/**
	 * Method : days
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 일간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/days", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo days(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+4314); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+31333);
		sale.setWeek3(saleList.get(2).getSd_sum());
		sale.setWeek4(saleList.get(3).getSd_sum()+15333);	
		sale.setMem_id(mem_id);	
		
		return sale;
	}
	
	/**
	 * Method : week
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 주간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/week", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo week(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+3333); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+3333);
		sale.setWeek3(saleList.get(2).getSd_sum()+11111);
		sale.setWeek4(saleList.get(3).getSd_sum()+3333);
		sale.setMem_id(mem_id);		
		
		return sale;
	}
	
	/**
	 * Method : month
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 월간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/month", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo month(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+22214); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+34313);
		sale.setWeek3(saleList.get(2).getSd_sum()-34153);
		sale.setWeek4(saleList.get(3).getSd_sum()+15334);	
		sale.setMem_id(mem_id);	
		
		return sale;
	}
	
	/**
	 * Method : years
	 * 최초작성일 : 2018. 9. 12.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : 통계 - 연간별 페이지 이동 ajax 처리
	 */
	@RequestMapping(value="/years", method=RequestMethod.GET)
	@ResponseBody
	public salelistJoinVo years(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id); // 쿼리 돌리기
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(saleList.get(0).getSd_sum()+3333); // 임의 값
		sale.setWeek2(saleList.get(1).getSd_sum()+25341);
		sale.setWeek3(saleList.get(2).getSd_sum()-1300);
		sale.setWeek4(saleList.get(3).getSd_sum()+14333);	
		sale.setMem_id(mem_id);
		
		return sale;
	}
	
	/**
	 * Method : chartProd
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 점주가 통계 - 제품별 조회 할 수 있다.
	 */
	@RequestMapping("/chartProd") // 통계 (제품별)
	public String chartProd(Model model){
		String mem_id = "hsj"; // 임의 편의점 아이디
		List<salelistJoinVo> saleList = somainService.getListProdSales(mem_id);
		
		for(int i = 0; i < 5; i++){ // TOP5 for
			model.addAttribute("Top"+(i+1), saleList.get(i).getProd_name()); // model 저장
			System.out.println("Top"+(i+1) + saleList.get(i).getProd_name());
		}		
		model.addAttribute("saleList", saleList);
		model.addAttribute("mem_id", mem_id);
		return "cvs_chart_prod";
	}
	
//	@RequestMapping("/chart")
//	public ModelAndView storeOwnerChart(Model model){
//		Map modelMap = model.asMap();
//		MemberVo user = (MemberVo) modelMap.get("userInfo");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("cvs_chart");
//		
////		List<OnedayChartVo> saleList = somainService.cvsOnedayTotalSale(user.getMem_id());
//		List<OnedayChartVo> saleList = somainService.cvsOnedayTotalSale("6510000-104-2015-00153");
////		List<OnedayChartVo> incomeList = somainService.cvsOnedayTotalIncome(user.getMem_id());
//		List<OnedayChartVo> incomeList = somainService.cvsOnedayTotalIncome("6510000-104-2015-00153");
////		List<RankVo> ctgyList = somainService.cvsCtgyRank(user.getMem_id());
//		List<RankVo> ctgyList = somainService.cvsCtgyRank("6510000-104-2015-00153");
////		List<RankVo> prodList = somainService.cvsBestProd(user.getMem_id());
//		List<RankVo> prodList = somainService.cvsBestProd("6510000-104-2015-00153");
////		List<MonthTopVo> reqList = somainService.cvsSupReqMonthAvg(user.getMem_id());
//		List<MonthTopVo> reqList = somainService.cvsSupReqMonthAvg("5560000-104-2016-00010");
////		List<MonthTopVo> inList = somainService.cvsSupInMonthAvg(user.getMem_id());
//		List<MonthTopVo> inList = somainService.cvsSupInMonthAvg("5560000-104-2016-00010");
//		
//		logger.debug("---reqList : "+reqList);
//		
//		
//		mav.addObject("saleList", saleList);
//		mav.addObject("incomeList", incomeList);
//		mav.addObject("ctgyList", ctgyList);
//		mav.addObject("prodList", prodList);
//		mav.addObject("reqList", reqList);
//		mav.addObject("inList", inList);
//		return mav;
//		
//	}
	
	@RequestMapping("/saleTotal")
	@ResponseBody
	public List<OnedayChartVo> saleTotal(){
		List<OnedayChartVo> saleList = somainService.cvsOnedayTotalSale("6510000-104-2015-00153");
		return saleList;
	}
	@RequestMapping("/incomeTotal")
	@ResponseBody
	public List<OnedayChartVo> incomeTotal(){
		List<OnedayChartVo> incomeList = somainService.cvsOnedayTotalIncome("6510000-104-2015-00153");
		return incomeList;
	}
}