package kr.or.ddit.user.membership.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.user.membership.dao.MemberShipDaoInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("memberShipService")
public class MemberShipService implements MemberShipServiceInf {

	@Resource(name="memberShipDao")
	private MemberShipDaoInf memberShipDao;

	private  Logger logger = LoggerFactory.getLogger(ProdService.class);
		
	@Override
	public int newMemberShip(MemberShipVo memberShipVo) {
		return memberShipDao.setInsertMemberShip(memberShipVo);
	}

	@Override
	public List<MemberShipVo> getMemberShipList() {
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
