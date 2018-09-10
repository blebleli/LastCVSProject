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
	
	@RequestMapping("/chartDay") // 통계 (날짜별)
	public String chartDay(Model model){
		String mem_id = "hsj";
//		String sd_date = "2018-09-10";
//		String sd_date2 = "2018-09-24";
//		salelistJoinVo saleVo = new salelistJoinVo();
//		saleVo.setMem_id(mem_id);
//		saleVo.setSd_date(sd_date);
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		model.addAttribute("saleList", saleList);
		logger.debug("{}",saleList);
		
//		kr.or.ddit.store_owner.web.CvsChartController.chartDay:53]
//				- [salelistJoinVo [prod_name=씨앤)블루투스이어폰로즈
//				, sale_amount=0
//				, sale_sum=39800
//				, mem_id=hsj
//				, sd_sum=74000
//				, sd_date=Mon Sep 10 11:23:48 KST 2018]
//						
//						
//				, salelistJoinVo [prod_name=씨앤)블루투스이어폰블랙
//				, sale_amount=0
//				, sale_sum=19900
//				, mem_id=hsj
//				, sd_sum=74000
//				, sd_date=Mon Sep 10 11:23:48 KST 2018]

		return "cvs_chart_day";
	}
	
	@RequestMapping("/chartProd") // 통계 (제품별)
	public String chartProd(Model model){
		String mem_id = "hsj";
		List<salelistJoinVo> saleList = somainService.getListSaleDis(mem_id);
		model.addAttribute("saleList", saleList);
		return "cvs_chart_prod";
	}	
}
