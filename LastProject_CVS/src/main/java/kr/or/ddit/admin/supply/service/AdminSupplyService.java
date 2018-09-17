package kr.or.ddit.admin.supply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.model.AdminApplyVo;
import kr.or.ddit.admin.supply.dao.AdminSupplyDaoInf;

@Service("adminSupplyService")
public class AdminSupplyService implements AdminSupplyServiceInf{

	@Resource(name="adminSupplyDao")
	private AdminSupplyDaoInf adminSupplyDao;
	
	@Override
	public List<AdminApplyVo> adminApplyList() {
		return adminSupplyDao.adminApplyList();
	}

}
