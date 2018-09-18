package kr.or.ddit.store_owner.disposal_list.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.DisposalListVo;

@Repository("dispDao")
public class DisposalListDao implements DisposalListDaoInf {

	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	 * 
	 * Method   : setInsertDispList 
	 * 최초작성일  : 2018. 9. 14. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : 폐기리스트 추가
	 */
	@Override
	public int setInsertDispList(DisposalListVo disposalListVo) {
		return template.insert("disp.setInsertDispList", disposalListVo);
	}

	@Override
	public List<DisposalListVo> getListDisp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDisp(DisposalListVo dispVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDisp(String disp_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
