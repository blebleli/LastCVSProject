package kr.or.ddit.admin.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.EventVo;

@Repository("eventDao")
public class EventDao implements EventDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public int setInsertEvnet(EventVo eventVo) {
		return template.insert("event.setEventInsert",eventVo);
	}

	/**
	 * 
	 * Method   : getListEvent 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 *             변경 - getListEvent
	 * 
	 * @return 
	 * Method 설명 : 이벤트 전
	 */
	@Override
	public List<EventVo> getListEvent() {

		return template.selectList("event.getListEvent");
//		return template.selectOne("member.getMember");
	}

	@Override
	public int updateEvent(EventVo eventVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEvent(String event_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
