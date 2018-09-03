package kr.or.ddit.user.search.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;

import org.springframework.stereotype.Service;

/** 
 * UserSearchService.java 
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
@Service("cvsSearchService")
public class CvsSearchService implements CvsSearchServiceInf{

	@Resource(name="userSearchService")
	private CvsSearchServiceInf userSearchService;
	/** 
	 * Method   : getListMember 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 :조계환 
	 * 변경이력 : 신규
	 * @param word
	 * @return 
	 * Method 설명 :매개 변수로 가져온 검색어를 DB상에 포함 검색 (예:대흥점 검색하면 대흥점 포함한 편의점 이름 검색) 
	 */
	@Override
	public List<MemberVo> getListMember(String word) {
		return userSearchService.getListMember(word);
	}
	
	

}
