package kr.or.ddit.commons.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.model.MemberVo;

public class SessionUtil {

	public static MemberVo getMemberSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session == null) {
			return null;
		}
		return (MemberVo) session.getAttribute("userInfo");
	}
	
	public static String getSessionMemberId(HttpServletRequest request) {
		return getMemberSession(request).getMem_id();
	}
	
	public static boolean checkMember(HttpServletRequest request) {
		MemberVo sessionVo = getMemberSession(request);
		return sessionVo != null 
				&& sessionVo.getMem_id() != null 
				&& sessionVo.getMem_id().equals("");
	}
	
}
