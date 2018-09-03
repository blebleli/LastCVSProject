package kr.or.ddit.commons.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.dao.CommonsDaoInf;
import kr.or.ddit.model.CategoryVo;

@Service(value="commonService")
public class CommonsService implements CommonsServiceInf {
	
	@Resource(name="commonsDao")
	private CommonsDaoInf commonsDao;

	@Override
	public String getdataFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryVo> prodCtgyList() {
		return commonsDao.prodCtgyList();
	}

}
