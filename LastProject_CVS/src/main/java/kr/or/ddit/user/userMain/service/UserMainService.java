package kr.or.ddit.user.userMain.service;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.userMain.dao.UserMainDaoInf;

import org.springframework.stereotype.Service;

@Service("userMainService")
public class UserMainService implements UserMainServiceInf {

	@Resource(name="userMainDao")
	private UserMainDaoInf userMainDao;
	
	/**
	 * 
	 * Method   : getMyPage 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param mem_id
	 * @return 
	 * Method 설명 : id로 맴버 정보조회
	 */
	@Override
	public MemberVo getMyPage(String mem_id) {
		return userMainDao.getMyPage(mem_id);
	}

}
