package kr.or.ddit.store_owner.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
		String mem_id = "hsj";		
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		
		System.out.println("saleList ================> " + saleList.size());
			for (int i = 0; i < saleList.size(); i++){
			model.addAttribute("week"+(i+1), saleList.get(i).getSd_sum());
			System.out.println("week"+(i+1) + saleList.get(i).getSd_sum());				
			}	
		
		model.addAttribute("saleList", saleList);
		model.addAttribute("mem_id", mem_id);
		logger.debug("{}",saleList);
		logger.debug("{}",mem_id);		
		return "cvs_chart_day";
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
	public List<salelistJoinVo> days(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		
		System.out.println("saleList ================> " + saleList.size());
		logger.debug("saleList ==> {}",saleList);
		return saleList;
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
		
//		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);

//		for (int i = 0; i < saleList.size(); i++){
//		model.addAttribute("week"+(i+1), saleList.get(i).getSd_sum());
//		System.out.println("week"+(i+1) + saleList.get(i).getSd_sum());
//		}		
		
		salelistJoinVo sale = new salelistJoinVo(); // Vo 오픈
		
		sale.setWeek1(1000); // 임의 값
		sale.setWeek2(2400);
		sale.setWeek3(900);
		sale.setWeek4(3400);
		sale.setMem_id("hsj");		
		
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
	public List<salelistJoinVo> month(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		
		System.out.println("saleList ================> " + saleList.size());
		logger.debug("saleList ==> {}",saleList);
		return saleList;
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
	public List<salelistJoinVo> years(@RequestParam(value="mem_id", defaultValue="") String mem_id){
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		
		System.out.println("saleList ================> " + saleList.size());
		logger.debug("saleList ==> {}",saleList);
		return saleList;
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
		String mem_id = "hsj";
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		model.addAttribute("saleList", saleList);
		return "cvs_chart_prod";
	}	
}