package kr.or.ddit.admin.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.member.dao.MemberMgtDaoInf;
import kr.or.ddit.filedata.dao.FileDaoInf;
import kr.or.ddit.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @Class Name : MemberMgtService
 *
 * @author  공은별
 * @since   2018. 9. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * @<< 개정이력(Modification Information) >>
 * @
 * @   수정일         수정자        수정내용
 * @ -------------   -------   ------------------------
 * @ 2018. 9. 17.      pc24      최초 생성
 *
 * </pre>
 */
@Service("memberMgtService")
public class MemberMgtService implements MemberMgtServiceInf {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="memberMgtDao")
	private MemberMgtDaoInf memberMgtDao;
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	
	/** 
	 * Method : getMemberPageList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 	공은별
	 * 변경이력 :	신규
	 * @param   : MemberVo
	 * @return  : List<MemberVo>
	 * Method 설명 : 일반사용자(회원) 전체 리스트 조회
	 */
	public List<MemberVo> getMemberPageList(MemberVo paramMemberVo) {
		return memberMgtDao.getMemberPageList(paramMemberVo);
	}

	/**
	 * 편의점 삭제
	 * Method : deleteCvsMember
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 : 공은별
	 * 변경이력 :
	 * @param paramMemberVo
	 * @return
	 * Method 설명 :
	 */
	@Override
	public int deleteCvsMember(MemberVo paramMemberVo) {
		
		return memberMgtDao.deleteCvsMember(paramMemberVo); 
	}

	@Override
	public int updateCvsInfo(MemberVo cvs) {
		return memberMgtDao.updateCvsInfo(cvs);
	}
	
	/**
	 * Method : pointPlus
	 * 최초작성일 : 2018. 10. 5.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param memberVo
	 * @return
	 * Method 설명 : 상품리뷰 작성시 포인트 획득
	 */
	@Override
	public int pointPlus(MemberVo memberVo) {
		return memberMgtDao.pointPlus(memberVo);
	}

	@Override
	public Map<Object, Object> cvsTotalPageList(Map<Object, Object> map) {
		Map<Object, Object> resultMap = new HashMap<Object, Object>();
		List<MemberVo> cvsPageList = memberMgtDao.cvsTotalPageList(map);
		int totalCnt = totalCvsCnt();
		resultMap.put("cvsPageList", cvsPageList);
		resultMap.put("paging", page((int)map.get("page"), (int)map.get("pageSize"),totalCnt));
		return resultMap;
	}

	@Override
	public int totalCvsCnt() {
		return memberMgtDao.totalCvsCnt();
	}
	
	public List<String> page(int page, int pageSize, int totalCnt){
		int cnt = totalCnt / pageSize;
		int left = totalCnt % pageSize;
		if(left > 0){
			cnt++;
		}
		int prev = page == 1? 1: page-1;
		int next = cnt;
		List<String> pages = new ArrayList<String>();
		
		for(int i = 1; i <cnt+1; i++){
			String p = "<button class=\"btn btn-success\" name=\"pageBtn\" type=\"button\" value=\""+i+"\">"+i+"</button>";
			pages.add(p);
		}
		logger.debug("page---{}", pages);
		return pages;
	}
}