package kr.or.ddit.commons.service;

import java.util.Map;

import javax.mail.MessagingException;

public interface SendMailServiceInf {

	// 인 메일정보 파일 저장 경로
	public final String AUTH_REQUEST_INFO_FILE_PATH = "C:\\W\\mailauth\\";	
	
	/*=======================
	 * 보내는 사람 메일 정보
	 */
	public final String HOST = "smtp.naver.com";
	public final String PROTOCOL = "smtp";
	public final String USER_NAME = "ddit_junit";	// 보내는 메일 계정 아이디
	public final String USER_PWD = "ddit_junit1";	// 보내는 메일 계정 비번
	
	public final int PORT = 465;
	public final String FROM = "ddit_junit@naver.com";	// 보내는 메일 주소 (mail@mail.com)
	
	public final boolean AUTH = true;
	public final boolean SSL_ENABLE = true;
	public final String SSL_TRUST = "smtp.naver.com";
	
	/**
	 * 메일 보내기
	 * @param to
	 * @param type
	 * @throws MessagingException
	 * @throws Exception 
	 */
	public void sendMail(String to, String authUrl, String contentFilePath) throws MessagingException, Exception;
	
	/**
	 * 이메일 인증 확인
	 * @param encAuthVal
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> validateMailAuth(String encAuthVal) throws Exception;
	
}
