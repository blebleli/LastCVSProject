package kr.or.ddit.commons.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.dao.CommonsDaoInf;
import kr.or.ddit.model.CategoryVo;

@Service(value="commonService")
public class CommonsService implements CommonsServiceInf {
	
	@Resource(name="commonsDao")
	private CommonsDaoInf commonsDao;

	@Override
	public String getdataFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryVo> prodCtgyList() {
		return commonsDao.prodCtgyList();
	}

	/** 
	 * Method   : autoCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
	 * @return 
	 * Method 설명 : 원하는 테이블에 컬럼명 입력시 해당 테이블의 pk 다음값
	 * 				map.put("table", "테이블명");
	 * 				map.put("codeId", "컬럼명");
	 * 				map.put("기타")
	 */
	@Override
	public String autoCode(Map code) {
		
		String codeStr = "";
		 int makr=0;
		String str = commonsDao.autoCode(code);
		
		// 게시판  NOTICE0000000000 (10)
		  if(str.contains("NOTICE")){
			  codeStr = "NOTICE";
			  makr = Integer.parseInt(str.replace(codeStr, ""));
		  }
		
		// 댓글 CM000000000001  
		  if (str.contains("CM")){
			  codeStr = "CM";
			  makr = Integer.parseInt(str.replace(codeStr, ""));
		  }
		  
		  int length = (int)(Math.log10(makr)+1);
		  
		  switch (makr) {
				case 1  : codeStr += "000000000"+makr;    break;
				case 2  : codeStr += "00000000"+makr;    break;
				case 3  : codeStr += "0000000"+makr;    break;
				case 4  : codeStr += "000000"+makr;    break;
				case 5  : codeStr += "00000"+makr;    break;
				case 6  : codeStr += "0000"+ makr;    break;
				case 7  : codeStr += "000"+makr;    break;
				case 8  : codeStr += "00"+makr;    break;
				case 9  : codeStr += "0"+makr;    break;
				case 10 : codeStr += makr;    break;
		}
		return codeStr;
	}

}
