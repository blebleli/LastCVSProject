package kr.or.ddit.user.bookmark.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.bookmark.service.BookmarkServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/userBookmark")
@SessionAttributes({"userInfo"})
public class BookmarkController {
	private Logger logger = LoggerFactory.getLogger(BookmarkController.class);
	
	@Resource(name="bookmarkService")
	private BookmarkServiceInf bmkService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autocode;

	@RequestMapping("/likeProd")
	@ResponseBody
	public ResponseEntity<String> likeProd(@RequestParam(value="prod_id")String prod_id, Model model){
		logger.debug("prod_id============{}", prod_id);
		Map modelMap = model.asMap();
		MemberVo user = (MemberVo) modelMap.get("userInfo");
		//즐겨찾기 등록한 제품인지 확인
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", user.getMem_id());
		map.put("prod_id", prod_id);
		BookmarkVo getbmk = bmkService.getBmkProd(map);
		if(getbmk == null){
			BookmarkVo bookProd = new BookmarkVo();
			bookProd.setMem_id(user.getMem_id());
			bookProd.setStar_kind("111");
			bookProd.setProd_id(prod_id);
			bookProd.setStar_id(autocode.autoCode("BOOKP", user.getMem_id()));
			bmkService.insertProdBookmark(bookProd);
			
		}else{
			bmkService.deleteBmkProd(prod_id);
		}
		
		return new ResponseEntity<>( "Custom header set", HttpStatus.OK);
	}
}
