package kr.or.ddit.admin.prod.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.EventVo;

@Repository("eventDao")
public class EventDao implements EventDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	*/
	@Override
	public List<BoardVo> getBoardPageList(Map<String, Object> map) {
		return template.selectList("board.getBoardPageList",map);
	}
	
	/**
	* Method : getBoardListTotCnt
	* Method 설명 :전체 공지사항 게시글 카운트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int getBoardListTotCnt(String bd_kind_id) {
		return template.selectOne("board.getWriteTotCnt",bd_kind_id);
	}
		
	
	@Override
	public int setInsertEvnet(EventVo eventVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * Method   : getListEvent 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 이벤트 전
	 */
	@Override
	public List<EventVo> getListEvent() {

		return template.selectOne("member.getMember");
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
