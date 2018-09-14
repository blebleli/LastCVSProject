package kr.or.ddit.saleDisp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.saleDisp.dao.SaleDisDaoInf;


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

}
