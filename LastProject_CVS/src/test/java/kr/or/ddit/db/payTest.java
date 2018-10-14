package kr.or.ddit.db;

import java.util.Random;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BookmarkVo;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class payTest {
		
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Test
	public void Test(){
		BookmarkVo bookmarkVo = null;
		String[] mem_id = { "kmk@ddit.or.kr", "kbk@ddit.or.kr",
							"ysy@ddit.or.kr", "ldj@ddit.or.kr", "lsb@ddit.or.kr",
							"ljh@ddit.or.kr", "cdl@ddit.or.kr", "bsa@ddit.or.kr",
							"ykm@ddit.or.kr", "syj@ddit.or.kr", "ysh@ddit.or.kr",
							"kjs@ddit.or.kr" };
		String kind = "111";
		String[] prod_id = { "necessities-00207", "necessities-00357",
							 "necessities-00431", "necessities-00456", "necessities-00946",
							 "necessities-00849" };
		
		for(int j = 0; j < prod_id.length; j++){
			
			bookmarkVo = new BookmarkVo();
			bookmarkVo.setProd_id(prod_id[j]);
			
			for(int i = 0; i < mem_id.length; i++){	
				
				bookmarkVo.setStar_kind(kind);
				bookmarkVo.setStar_id(code.autoCode("BOOKP", mem_id[i])); // 즐겨찾기 코드
				bookmarkVo.setMem_id(mem_id[i]);
				template.insert("bookmark.insertProdBookmark", bookmarkVo); // 즐겨찾기 제품 등록	
				
			}			
		}		
	}
	
	// 즐겨찾기 편의점
	@Test
	public void PlaceTest(){
		Random random = new Random();
		BookmarkVo bookmarkVo = null;
		String[] place_id = { "4930000-104-2015-00011",
				  "3380000-104-2014-00017", "3670000-104-2012-00104",
				  "3150000-104-2015-00104", "3680000-104-2016-00025"};
//		String[] place_id = { "4930000-104-2015-00011",
//				  "3380000-104-2014-00017", "3670000-104-2012-00104",
//				  "3150000-104-2015-00104", "3680000-104-2016-00025",
//				  "4180000-104-2016-00010" };
		String[] mem_id = { "kjy@ddit.or.kr"};
//		String[] mem_id = { "kmk@ddit.or.kr", "kbk@ddit.or.kr",
//				"lh@ddit.or.kr", "ysy@ddit.or.kr", "ldj@ddit.or.kr",
//				"lsb@ddit.or.kr", "ljh@ddit.or.kr", "cdl@ddit.or.kr",
//				"bsa@ddit.or.kr", "ykm@ddit.or.kr", "syj@ddit.or.kr",
//				"ysh@ddit.or.kr", "kjs@ddit.or.kr", "kys@ddit.or.kr",
//				"nms@ddit.or.kr", "kyb@ddit.or.kr", "hsh@ddit.or.kr",
//				"kjy@ddit.or.kr" };
//		int ran = random.nextInt(10)+1;
			
			for(int j = 0; j < place_id.length; j++){
				bookmarkVo = new BookmarkVo();
				bookmarkVo.setPlace_id(place_id[j]);
				for(int i = 0; i < mem_id.length; i++){ // 
					
					bookmarkVo.setStar_id(code.autoCode("BOOKM", mem_id[i]));
					bookmarkVo.setMem_id(mem_id[i]);
					bookmarkVo.setStar_kind("222");
					template.insert("bookmark.insertCvsBookmark", bookmarkVo);
			}
		}		
	}
}