package kr.or.ddit.admin.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.EventVo;

/**
* @Class Name : EventDaoInf.java
*
* @author 조계환
* @since 2018. 8. 30.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 30. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertEvnet(EventVo eventVo)_편의점에 대한 신규 이벤트 생성 기능(조건 : 이벤트 종류)
	//List<EventVo> getListEvent()_이벤트 목록 전체 출력
	//int updateEvent(EventVo eventVo)_이벤트 수정
	//int deleteEvent(String event_id)_이벤트 삭제(예 : 행사마감날짜로 인한 삭제, 관리자에 의한 임의 삭제)
public interface EventDaoInf {
	
	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<BoardVo> getBoardPageList(Map<String, Object> map)_공지사항 게시판 페이징 처리
	* @param map
	* @return
	*/
	List<BoardVo> getBoardPageList(Map<String, Object> map);
	
	/**
	* Method : totCntBoardList
	* Method 설명 :전체 공지사항 게시글 카운트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int totCntBoardList()_전체 공지사항 게시글 카운트
	* @return
	*/
	int getBoardListTotCnt(String bd_kind_id);
	
	
	/**
	* Method : setInsertEvnet
	* Method 설명 :편의점에 대한 신규 이벤트 생성 기능(조건 : 이벤트 종류)
	* 									EVENT_KIND : 일반 : 200, 1+1행사 : 201, 2+1행사 : 202, 승정 : 203, 할인 : 204
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertEvnet(EventVo eventVo)_편의점에 대한 신규 이벤트 생성 기능(조건 : 이벤트 종류)
	* @param eventVo
	* @return
	*/
	int setInsertEvnet(EventVo eventVo);
	
	/**
	* Method : getListEvent
	* Method 설명 :이벤트 목록 전체 출력
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<EventVo> getListEvent()_이벤트 목록 전체 출력
	* @return
	*/
	List<EventVo> getListEvent();
	
	/**
	* Method : updateEvent
	* Method 설명 :이벤트 수정
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateEvent(EventVo eventVo)_이벤트 수정
	* @param eventVo
	* @return
	*/
	int updateEvent(EventVo eventVo);
	
	/**
	* Method : deleteEvent
	* Method 설명 :이벤트 삭제(예 : 행사마감날짜로 인한 삭제, 관리자에 의한 임의 삭제)
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteEvent(String event_id)_이벤트 삭제(예 : 행사마감날짜로 인한 삭제, 관리자에 의한 임의 삭제)
	* @param event_id
	* @return
	*/
	int deleteEvent(String event_id);
}
