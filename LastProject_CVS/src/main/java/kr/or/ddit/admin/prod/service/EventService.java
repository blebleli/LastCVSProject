package kr.or.ddit.admin.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.prod.dao.EventDaoInf;
import kr.or.ddit.model.EventVo;

@Service("eventService")
public class EventService implements EventServiceInf {

	@Resource(name="eventDao")
	EventDaoInf dao;
	
	@Override
	public int setInsertEvnet(EventVo eventVo) {
		return dao.setInsertEvnet(eventVo);
	}

	@Override
	public List<EventVo> getListEvent() {
		return dao.getListEvent();
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
