package kr.or.ddit.admin.supply.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.model.AdminApplyVo;

@Repository("adminSupplyDao")
public class AdminSupplyDao implements AdminSupplyDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<AdminApplyVo> adminApplyList() {
		return template.selectList("supply.adminApplyList");
	}

}
