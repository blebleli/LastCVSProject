package kr.or.ddit.commons.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class PageNavi {

	public int page = 1;
	
	public int pageSize = 10;
	
	public int totCnt = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}
	
	public PageNavi() {
	}
	
	public PageNavi(int page, int pageSize, int totCnt) {
		this.page = page;
		this.pageSize = pageSize;
		this.totCnt = totCnt;
	}
	
	public String getPageNavi(HttpServletRequest request, Object objVo){
		return getPageNavi(request, objVo, null);
	}
	
	/**
	 * Method : pageNavi
	 * 최초작성일 : 2018. 7. 25.
	 * 작성자 : PC07
	 * 변경이력 :
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @param board_no
	 * @param std_id
	 * @return
	 * Method 설명 : 페이징 처리
	 */
	public String getPageNavi(HttpServletRequest request, Object objVo, String path){
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		totCnt = (totCnt == 0) ? 1 : totCnt;
		
		int cnt = totCnt / pageSize;	// 몫
		int mod = totCnt % pageSize;	// 나머지

		if (mod > 0) {
			cnt++;
		}
		
		int prevPage = page == 1 ? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		
		String url = StringUtils.defaultString(path, request.getRequestURL().toString());
		String paramStr = url.indexOf("?") > -1 ? "" : "?p=x";
		paramStr += getParam(objVo);
		
		// 시작태그
		pageNaviStr.append("<ul class=\"pagination\">");
		
		// 맨처음으로
		pageNaviStr.append(" <li> <a href=\"").append(url+paramStr)
				   .append("&page=1&pageSize=").append(pageSize)
				   .append("\" aria-label=\"Previous\"> <span aria-hidden=\"true\">◁◁</span> </a> </li>");
		
		// 이전으로 1칸씩  &laquo;
		pageNaviStr.append(" <li> <a href=\"").append(url+paramStr)
				   .append("&page=").append(prevPage).append("&pageSize=").append(pageSize)
				   .append("\" aria-label=\"Previous\"> <span aria-hidden=\"true\">◁</span> </a> </li>");
		
		// 가운데 페이징 처리 되는 로직
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if (i == page) 
				activeClass = "class = \"active\"";
			
			pageNaviStr.append("<li ").append(activeClass).append("><a href=\"").append(url+paramStr)
					   .append("&page=").append(i).append("&pageSize=").append(pageSize).append("\">").append(i).append("</a></li>");
		}
		
		// 다음 페이지로 1칸씩 &raquo;
		pageNaviStr.append("<li> <a href=\"").append(url+paramStr)
		           .append("&page=").append(nextPage).append("&pageSize=").append(pageSize)
		           .append("\" aria-label=\"Next\"> <span aria-hidden=\"true\">▷</span> </a> </li>");
		
		// 마지막으로  
		pageNaviStr.append("<li> <a href=\"").append(url+paramStr)
        		   .append("&page=").append(cnt).append("&pageSize=").append(pageSize)
		           .append("\" aria-label=\"Next\"> <span aria-hidden=\"true\">▷▷</span> </a> </li>");
		
		// 끝태그
		pageNaviStr.append("</ul>");
		
		return pageNaviStr.toString();
	}
	
	/**
	 * Vo의 속성값으로 parameter 셋팅
	 * @param obj
	 * @return
	 */
	private String getParam(Object obj) {
		
		StringBuffer buf = new StringBuffer();
		
		if(obj instanceof Map<?, ?>) {
			for(Map.Entry<?, ?> entry : ((Map<?, ?>) obj).entrySet()) {
				buf.append("&").append(entry.getKey()).append("=").append(entry.getValue());
			}
		}
		else {
			Field[] declaredFields = obj.getClass().getDeclaredFields();
			for(Field field : declaredFields) {
				try {
					Method m = obj.getClass().getMethod("get" + StringUtils.capitalize(field.getName()), null);
					Object val = m.invoke(obj, null);
//					if(val != null && !m.getGenericReturnType().getTypeName().contains("List")) {
					if(val != null && !m.getReturnType().getName().contains("List")) {
						buf.append("&").append(field.getName()).append("=").append(val.toString());
					}
				} catch (NoSuchMethodException 
						| SecurityException 
						| IllegalAccessException 
						| IllegalArgumentException 
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		return buf.toString();
	}
	
}
