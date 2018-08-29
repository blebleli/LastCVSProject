package kr.or.ddit.user.membership.dao;

import java.util.List;

import kr.or.ddit.model.MemberShipVo;

public interface MemberShipDaoInf {
	
	int newMemberShip(MemberShipVo memberShipVo);
	
	List<MemberShipVo> getMemberShipList();
	
	int updateMemberShip(MemberShipVo memberShipVo);
	
	int deleteMemberShip(String memship_id);

}
