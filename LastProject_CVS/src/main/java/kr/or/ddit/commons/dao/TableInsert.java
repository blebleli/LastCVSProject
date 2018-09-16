package kr.or.ddit.commons.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("tableInsert")
public class TableInsert implements TableInsertInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<ProdVo> getgetget(){
		
		return dao.selectList("tableCode.getgetget");
	}
	
	public int upupup(Map<String, String> map){
		
		return dao.update("tableCode.upupup", map);
	}
	
	public int memberInsert(MemberVo vo){
		logger.debug("memberInsert");
		logger.debug("vo ==> {}",vo);
		return dao.insert("tableInsert.memberInsert", vo);
	}
	
}
