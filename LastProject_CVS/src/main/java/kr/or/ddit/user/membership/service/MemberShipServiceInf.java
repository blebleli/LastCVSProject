package kr.or.ddit.user.membership.service;

import java.util.List;

import kr.or.ddit.model.MemberShipVo;

public interface MemberShipServiceInf {
	
	int newMemberShip(MemberShipVo memberShipVo);
	
	List<MemberShipVo> getMemberShipList();
	
	int updateMemberShip(MemberShipVo memberShipVo);
	
	int deleteMemberShip(String memship_id);

}
