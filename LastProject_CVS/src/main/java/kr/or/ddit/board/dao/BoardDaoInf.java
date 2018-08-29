package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.model.BoardVo;

public interface BoardDaoInf {
	
	int newBoard(BoardVo boardVo);

	List<BoardVo> getBoardList();
	
	int updateBoard(BoardVo boardVo);
	
	int deleteBoard(String bd_id);
}
