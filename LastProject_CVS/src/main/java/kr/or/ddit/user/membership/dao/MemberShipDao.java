package kr.or.ddit.user.membership.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.prod.dao.ProdDao;

@Repository("memberShipDao")
public class MemberShipDao implements MemberShipDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public int setInsertMemberShip(MemberShipVo memberShipVo) {

		return session.insert("memberShip.memberShipInsert", memberShipVo);
	}

	@Override
	public MemberShipVo getVoMemberShip(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberShipVo> getListMemberShip() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMemberShip(MemberShipVo memberShipVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMemberShip(String memship_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
