package kr.or.ddit.commons.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.ProdVo;

public interface AutoCodeInf {

	
	List<ProdVo> getgetget();
	
	int upupup(Map<String, String> map);
	
	String autoCode(Map code);
	
	// 받아오는 매개변수(테이블명_소문자)
	
	// 맴버십코드(membership)
	
	// 폐기상세리스트(disposal_list)
	
	// 즐겨찾기(bookmark)
	
	// 맴버십사용내역(memuse)
	
	// 판매/폐기 sale_dis
	
	// 판매상세리스트(sale_list)
	
	// 상품주머니(pocket)
	
	// 바코드(barcode)
	
	// 결제 (pay)
	
	// 회원 (member)
	
	// 편의점서비스(cvs_service)
	
	// 카테고리(category)
	
	// 재고 (stock)
	
	// 재고/마감리스트(stock_list)
	
	// 제품(prod)
	
	// 게시판(board)
	// 'NOTICE00000000001' -- 코드 (공지사항 : notice + 카운트11자리)
	

	
	// 댓글(comments)
	// CM000000000001  = CM + 11자리 카운트
	
	// 행사제품(event)
	
	// 자료(fileData)
	
	// 예약(reserve)
	
}
