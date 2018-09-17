package kr.or.ddit.admin.supply.web;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.dao.CommonsDaoInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller("adminSupplyController")
public class AdminSupplyController {
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService; 
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
	@RequestMapping("/lookup")
	public String adminSupplyLookup(){
		
//		String kind = "SUP10";
//		String mem_id = "3240000-104-2015-00075";
//		String barcode = autoCodeCreate.autoCode(kind, mem_id);
//		
//		BarcodeVo barcodeVo = new BarcodeVo();
//		
//		barcodeVo.setBcd_id(barcode);
//		barcodeVo.setBcd_content("수불바코드");
//		barcodeVo.setBcd_kind("102");
//		barcodeVo.setBcd_path("D:\\최종프\\barcodeImg\\");
//		
//		barcodeService.setInsertBarcode(barcodeVo);
//		
		return "ad_supplyLookup";
	}
	
	@RequestMapping("/lookupView")
	public String adminSupplyLookupView(){
		
		return "";
	}
}
