package kr.or.ddit.admin.member.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class MemberMgtServiceTest {
	
	@Resource(name="memberMgtService")
	private MemberMgtServiceInf memberMgtService;
	
	/**
	 * Method : binTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : memberMgtService가 비어있는지 확인
	 */	
	@Test
	public void bintest() {
		assertNotNull("memberMgtService");
	}
	
	/**
	 * Method : getMemberPageListTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 일반사용자(회원) 전체 리스트 조회
	 */
	@Test
	public void getMemberPageListTest(){
		/***Given***/
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_kind("01");
		memberVo.setMem_name("노호려");
		List<MemberVo> memberList = memberMgtService.getMemberPageList(memberVo);

		/***When***/
		int cnt = memberList.size();
		
		/***Then***/
		assertEquals(cnt, 1);
	}	

	/**
	 * Method : deleteCvsMemberTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 편의점삭제시 해당편의점 사용안함 04로 업데이트 처리
	 */
	@Test
	public void deleteCvsMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo();
		memberVo.setMem_kind("04");
		memberVo.setMem_id("5600000-104-2017-00012");
		memberMgtService.deleteCvsMember(memberVo);
		
		/***When***/
		
		/***Then***/
		assertEquals("04", memberVo.getMem_kind());
	}
}