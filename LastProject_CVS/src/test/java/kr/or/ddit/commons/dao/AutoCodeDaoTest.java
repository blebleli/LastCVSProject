package kr.or.ddit.commons.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.model.ProdVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class AutoCodeDaoTest {

	
	@Resource(name="tableInsert")
	private TableInsertInf tableInsert;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test() {
		List<ProdVo> prod = tableInsert.getgetget();
		Map<String, String> map = null ;
		int  result  = 0;
		String str = "";
		String str2 = "";
		int su1 = 1;
		int su2 = 1; 
		int su3 = 1;
		int su4 = 1;
		int su5 = 1;
		int su6 = 1;
		
		for (int i = 0 ; i < prod.size(); i++) {
			map = new HashMap<String, String>();
			str = prod.get(i).getProd_id();
			str2= prod.get(i).getProd_info();
			
			map.put("prod_id", str);
			
			if (str2.equals("biscuit-")) {
				
				int ranLength = (int)(Math.log10(su1)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su1);
				su1++;
			} else if (str2.equals("food-")) {
				
				int ranLength = (int)(Math.log10(su2)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su2);
				su2++;
			} else if (str2.equals("drink-")) {
				
				int ranLength = (int)(Math.log10(su3)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su3);
				su3++;
			} else if (str2.equals("ice-")) {

				int ranLength = (int)(Math.log10(su4)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su4);
				su4++;
			} else if (str2.equals("meal-")) {	
				
				int ranLength = (int)(Math.log10(su5)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su5);
				su5++;
			} else if (str2.equals("necessities-")) {	

				int ranLength = (int)(Math.log10(su6)+1);
				
				for (int j = 0 ; j < 5 - ranLength ; j++) {
					 str2 += "0";
				}
				map.put("id", str2+su6);
				su6++;
			}
			
			result += tableInsert.upupup(map);
		}
		logger.debug("result===> {}", result);
//		logger.debug("prod===> {}", prod);
//		
//		int result = 0;
//		int su1 = 1;
//		int su2 = 1; 
//		int su3 = 1;
//		int su4 = 1;
//		int su5 = 1;
//		int su6 = 1;
//		for (int i = 0 ; i < prod.size(); i++)  {
//			
//			String codeStr = "";
//			
//			map.put("prod_id", str);
//			if (str.contains("biscuit")) {
//				codeStr = "biscuit-";
//				int kk = (int) (Math.log10(su1)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su1++;
//				
//			} else if (str.contains("drink")) {
//				codeStr = "drink-";
//				int kk = (int) (Math.log10(su2)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su2++;
//				
//			} else if (str.contains("food")) {
//				codeStr = "food-";
//				int kk = (int) (Math.log10(su3)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su3++;
//				
//			} else if (str.contains("ice")) {
//				codeStr = "ice-";
//				int kk = (int) (Math.log10(su4)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su4++;
//				
//			} else if (str.contains("meal")) {
//				codeStr = "meal-";
//				int kk = (int) (Math.log10(su5)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su5++;
//				
//			} else if (str.contains("necessities")) {
//				codeStr = "necessities-";
//				int kk = (int) (Math.log10(su6)+1);
//				for (int j = 0 ; i < 5-kk ; j++) {
//					codeStr += "0";
//				}
//				codeStr += su6++;
//			}
			
//			map.put("id", codeStr);
			
//			
//			logger.debug("\n ======================>",map.get("id"));
//		}
		
	}
	@Test
	public void Test2 () {

		
//		List<String> sung = Arrays.asList("김","이","박","최","정","강","조","윤","장","림","한","오","서","신","권","황","안","송","전"
//					  ,"홍","류","고","문","량","손","배","조","백","허","류","남","심","로","정","하","곽","성","차"
//					  ,"주","우","구","신","임","전","민","유","류","나","진","지","엄","채","원","천","방","공","강"
//					  ,"현","함","변","염","양","변","여","추","노","도","소","신","석","선","설","마","길","주","연"
//					  ,"위","표","명","기","반","라","왕","금","옥","육","인","맹","제","모","장","남","탁","국","여"
//					  ,"진","어","은","편" );
//		
//		List<String> name = Arrays.asList(
//							 "가","나","다","라","마","바","사","아","자","차","카","타","파","하"
//							,"갸","냐","댜","랴","먀","뱌","샤","야","쟈","챠","캬","탸","퍄","햐"
//							,"거","너","더","러","머","버","서","어","저","처","커","터","퍼","허" 
//							,"겨","녀","뎌","려","며","벼","셔","여","져","쳐","켜","텨","펴","혀"
//							,"고","노","도","로","모","보","소","오","조","초","코","토","포","호" 
//							,"교","뇨","됴","료","묘","뵤","쇼","요","죠","쵸","쿄","됴","표","효"
//							,"구","누","두","루","무","부","수","우","주","추","쿠","투","푸","후"
//							,"규","뉴","듀","류","뮤","뷰","슈","유","쥬","츄","큐","튜","퓨","휴"
//							,"그","느","드","르","므","브","스","으","즈","츠","크","트","프","흐"
//							,"기","니","디","리","미","비","시","이","지","치","키","티","피","히" 
//						
//					  );
//
//		List<String> full  = new  ArrayList<String>();
//		
//		for (int  i = 0 ; i < 15842; i++) {
//			Collections.shuffle(sung);
//			String name1 = sung.get(0);
//			Collections.shuffle(name);
//			String name2 = name.get(0);
//			Collections.shuffle(name);
//			String name3 = name.get(0);
//			String fullName = name1+name2+name3;
//			System.out.println(fullName);
//			full.add(fullName);
//		}
//		
//		System.out.println("=========================");
//		System.out.println(full.size());
		
		
		
		
		String str = "";
		
		for (int i = 0 ; i < 1-1 ; i++) {
			str += "9";
		}
		System.out.println(str);
	
	}

}
