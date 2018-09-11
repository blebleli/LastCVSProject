package kr.or.ddit.store_owner.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.store_owner.model.salelistJoinVo;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
//	@RequestMapping(value="/chartDay",method=RequestMethod.GET) // 통계 (날짜별)	
//	@ResponseBody
//	public String chartDay(@RequestParam(value="mem_id") String mem_id, Model model){
	
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