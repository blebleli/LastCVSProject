package kr.or.ddit.admin.cvs_service.service;

import java.util.List;

import kr.or.ddit.model.CvsServiceVo;

public interface CVSServiceInf {
	
	int newCategory(CvsServiceVo cvsServiceVo);
	
	List<CvsServiceVo> getCategoryList();
	
	int updateCategory(CvsServiceVo cvsServiceVo);
	
	int deleteCategody(String service_id);

}
