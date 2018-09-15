package kr.or.ddit.saleDisp.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.disposal.dao.DispDaoInf;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.saleDisp.dao.SaleDisDaoInf;
import kr.or.ddit.store_owner.sale.dao.SaleDisDao;


/**
 * 
 * DispService.java 
 * 
 * @author 한수정
 * @since 2018. 9. 14. 
 * @version 1.0 
 * @see pos 에서의 판매, 폐기
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 14.    PC06 최초 생성 
 * 
 * </pre>
 */
@Service("saleDisService")
public class SaleDispService implements SaleDispServiceInf{

	
	@Resource(name="saleDispDao")
	private SaleDisDaoInf saleDispDao;
	
	@Resource(name="dispDao")
	private DispDaoInf DispDao;
	
	
	/**
	 * 
	 * Method   : insertDispList 
	 * 최초작성일  : 2018. 9. 14. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : disposalList에 insert 하는 기능
	 */
	@Override
	public int setInsertSaleDisList(SaleDisVo saleDisVo) {
		return saleDispDao.setInsertSaleDisList(saleDisVo);
	}

	

	/**
	 * 
	 * Method   : insertDispList 
	 * 최초작성일  : 2018. 9. 14. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : disposalList에 insert 하는 기능
	 */
	@Override
	public int setInsertSaleDisList(List<DisposalListVo> dispVoList) {

		int sum = dispVoList.stream().mapToInt(vo -> {
			int price = 1; //bcd_id로 가격 가져오는 db 필요
			return vo.getDisp_amount() * price;
		}).sum();
		
		SaleDisVo saleDisVo = new SaleDisVo();
		saleDisVo.setSd_id("sd_id"); 	  //Autocode 로 생성될 예정
		saleDisVo.setSd_date(new Date()); // 날짜
		saleDisVo.setSd_sum(sum);		  // 위에서 합계로 처리
		saleDisVo.setSale_kind("99");	  // 폐기코드 99
		saleDisVo.setMem_id("mem_id");	  // 편의점 id
		
		saleDispDao.setInsertSaleDisList(saleDisVo);
		
		for (DisposalListVo dispVo : dispVoList) {
			dispVo.setDisp_id("disp_id"); 			//Autocode 로 생성될 예정
			dispVo.setBcd_id("bcd_id"); 			// 이미 존재
			dispVo.setDisp_amount(1); 			    //이미 존재			
			dispVo.setDisp_exdate("disp_exdate");   //bcd_id로 유통기한 가져오는 db 필요
			dispVo.setSd_id(saleDisVo.getSd_id());  //위에서
			DispDao.setInsertDispList(dispVo);
		}
	
		return 0;
	}

}
