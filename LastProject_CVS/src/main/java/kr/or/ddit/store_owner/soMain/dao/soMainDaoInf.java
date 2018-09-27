package kr.or.ddit.store_owner.soMain.dao;

import java.util.List;

import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.store_owner.model.OnedayChartVo;
import kr.or.ddit.store_owner.model.salelistJoinVo;

/**
* @Class Name : soMainDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. 조계환 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//List<DisposalListVo> getListDisposalList()_폐기 물품 리스트 출력 
	//List<SaleDisVo> getListSaleDis()_판매량 정보 리스트 출력 기능
public interface soMainDaoInf {

	/**
	* Method : getListSaleDis
	* Method 설명 : 판매량 정보 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 : 신규
	* 조 회 : List<salelistJoinVo> getListSaleDis()_판매량 정보 리스트 출력 기능
	* @return
	*/
	List<salelistJoinVo> getListSaleDis(String mem_id);
	
	/**
	* Method : getDisposalList
	* Method 설명 : 폐기 물품 리스트 출력 
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<DisposalListVo> getListDisposalList()_폐기 물품 리스트 출력 
	* @return
	*/
	List<DisposalListVo> getListDisposalList();
	
	/**
	 * Method : getListSaleDays
	 * 최초작성일 : 2018. 9. 14.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : List<salelistJoinVo> getListSaleDays()_통계:날짜별 일간 출력 기능
	 */
	List<salelistJoinVo> getListSaleDays(String mem_id);
	
	/**
	 * Method : getListProdSales
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : List<salelistJoinVo> getListProdSales()_제품 판매량 리스트 출력
	 */
	List<salelistJoinVo> getListProdSales(String mem_id);
	
	/**
	 * Method : cvsOnedayTotalSale
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<OnedayChartVo>
	 * Method 설명 : 편의점의 일매출 
	 */
	List<OnedayChartVo> cvsOnedayTotalSale(String mem_id);
	
	/**
	 * Method : cvsOnedayTotalIncome
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<OnedayChartVo>
	 * Method 설명 : 편의점의 일 순이익(매출-원가) 
	 */
	List<OnedayChartVo> cvsOnedayTotalIncome(String mem_id);
	
	/**
	 * Method : cvsCtgyRank
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<RankVo>
	 * Method 설명 : 편의점의 인기 상품분류 
	 */
	List<RankVo> cvsCtgyRank(String mem_id);
	
	/**
	 * Method : cvsBestProd
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<RankVo>
	 * Method 설명 : 편의점의 인기 상품 
	 */
	List<RankVo> cvsBestProd(String mem_id);
	
	/**
	 * Method : cvsSupReqMonthAvg
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<MonthTopVo>
	 * Method 설명 : 최근 3달간 평균 발주량
	 */
	List<MonthTopVo> cvsSupReqMonthAvg(String place_id);
	
	/**
	 * Method : cvsSupInMonthAvg
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return List<MonthTopVo>
	 * Method 설명 : 최근 3달간 평균 입고량
	 */
	List<MonthTopVo> cvsSupInMonthAvg(String place_id);
}