package kr.or.ddit.commons.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.CvsServiceVo;
import kr.or.ddit.model.MemberVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
		 "classpath:kr/or/ddit/config/spring/transaction.xml",
		 "classpath:kr/or/ddit/config/spring/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class tableInsertTest {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Test
//	public void bean(){
//		assertNotNull(dao);
//	}
	
	// 편의점 5690000-104-2017-00140
	
	@Test
	public void memberInsertTest() {
		
		// 데이터
		// 일반사용자
		MemberVo m = new MemberVo(
				  "rlaakdma@hanmail.net"	//mem_id          -- 아이디
				, "test"					//mem_pw          -- 비밀번호                        
				, "02"						//mem_kind        -- 구분  : 관리자(00), 점주(01), 일반(02)
				, "김마음"					//mem_name        -- 이름                          
				, "010-4434-2174"			//mem_tel         -- 연락처                         
				, "19920507"				//mem_birth       -- 생년월일                        
				, "M"						//mem_gen         -- 성별(M:남자, F:여자)              
				, 12345						//mem_zip         -- 우편번호                        
				, "대전광역시"					//mem_add         -- 주소                          
				, "한밭대로 1130번길"					//mem_addr        -- 상세주소                        
				, ""						//mem_cvs_name    -- 편의점명                        
				, ""						//mem_cvs_tel     -- 편의점연락처                      
				, ""						//mem_intro       -- 소개                          
				, "123.0"					//mem_x           -- x 좌표 (별도로 구해야 함)            
				, "23.0"					//mem_y           -- y 좌표 (별도로 구해야 함)            
				, 0							//mem_point       -- 포인트                         
				, null						//pic_name
				, null						//fileList
		);
		
		// 실행
		int result = dao.insert("tableInsert.memberInsert",m);
		logger.debug("result == > {}",result);
	}
	
	@Test
	public void cvs_serviceTest() {
		
		List<CvsServiceVo> l = new  ArrayList<CvsServiceVo>();
//		CvsServiceVo c = new CvsServiceVo(
//							    //service_id
//							  , //ctgy_id
//							  , //place_id
//							 );
//		l.add(c);
		
//		int result = dao.insert("tableInsert.cvs_service",c);
//		logger.debug("result == > {}",result);
	}
	

}
