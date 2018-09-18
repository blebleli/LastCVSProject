package kr.or.ddit.admin.file.service;

import javax.annotation.Resource;

import kr.or.ddit.admin.file.dao.adFileDaoInf;

import org.springframework.stereotype.Service;

@Service("adfileService")
public class adFileService implements adFileServiceInf {
	
	@Resource(name="adfileDao")
	private adFileDaoInf adfileDao;
	
	

}
