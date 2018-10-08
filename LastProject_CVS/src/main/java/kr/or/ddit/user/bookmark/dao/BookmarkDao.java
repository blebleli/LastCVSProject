package kr.or.ddit.user.bookmark.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.BookmarkVo;

@Repository("bookmarkDao")
public class BookmarkDao implements BookmarkDaoInf {
	

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int setInsertBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	/**
	 * 
	 * Method : getProdBookmarkList
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param mem_id
	 * @return List<BookmarkVo>
	 * Method 설명 : 회원이 즐겨찾기한 제품 리스트
	 */
	@Override
	public List<BookmarkVo> getProdBookmarkList(Map<String, Object> paramMap) {
		return template.selectList("bookmark.getProdBookmarkList", paramMap);
	}

	
	/**
	 * 
	 * Method : getCvsBookmarkList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 회원이 즐겨찾기한 편의점 리스트
	 */
	@Override
	public List<BookmarkVo> getCvsBookmarkList(Map<String, Object> paramMap) {
		return template.selectList("bookmark.getCvsBookmarkList", paramMap);
	}

	
	@Override
	public int updateBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookmark(String star_id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int insertProdBookmark(BookmarkVo bmkProd) {
		return template.insert("bookmark.insertProdBookmark", bmkProd);
	}


	@Override
	public BookmarkVo getBmkProd(Map<String, String> map) {
		return template.selectOne("bookmark.getBmkProd", map);
	}


	@Override
	public int deleteBmkProd(String prod_id) {
		return template.delete("bookmark.deleteBmkProd", prod_id);
	}




}
