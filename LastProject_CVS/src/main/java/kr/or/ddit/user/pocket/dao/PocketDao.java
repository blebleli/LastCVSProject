package kr.or.ddit.user.pocket.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.PocketVo;
import kr.or.ddit.user.model.PocketProdVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("pocketDao")
public class PocketDao implements PocketDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public int setInsertPocket(PocketVo pocketVo) {
		
		return template.insert("pocket.pocketInsert",pocketVo);
		
	}

	/**
	 * 
	 * Method   : getMyPocket 
	 * 최초작성일  : 2018. 10. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param mem_id
	 * @return 
	 * Method 설명 : mem_id로 주머니 리스트
	 */
	@Override
	public List<PocketProdVo> getMyPocket(String mem_id) {
		return template.selectList("pocket.getMyPocket",mem_id);
	}
	

	@Override
	public PocketProdVo getPocketById(String pocket_id) {
		return template.selectOne("pocket.getPocketById",pocket_id);
	}


	@Override
	public List<PocketVo> getListPocket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePocket(PocketVo pocketVo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
