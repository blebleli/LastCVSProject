package kr.or.ddit.user.search.dao;

import java.util.List;

import kr.or.ddit.model.MemberVo;

/** 
 * UserSearchDaoInf.java 
 * 
 * @author 조계환 
 * @since 2018. 9. 3. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 3.    조계환 최초 생성 
 * 
 * </pre>
 */
public interface UserSearchDaoInf {
	
	List<MemberVo> getListMember();
 	
	

}
