package kr.or.ddit.commons.model;

/**
 * 메일보내기
 * @author KongEunByeol
 *
 */
public class MailVo {

	/** 보내는 메일 주소 */
	private String mailAddr;
	/** 인증URL */
	private String authUrl;
	/** ServerURL */
	private String serverPath;
	/** 메일본문html경로 */
	private String contentFilePath;
	/** 메일제목 */
	private String subject;
	
	public MailVo() {
	}
	
	public MailVo(String mailAddr, String serverPath, String authUrl, String contentFilePath, String subject) {
		this.mailAddr = mailAddr;
		this.serverPath = serverPath;
		this.authUrl = authUrl;
		this.contentFilePath = contentFilePath;
		this.subject = subject;
	}
	
	public String getMailAddr() {
		return mailAddr;
	}
	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}
	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	public String getServerPath() {
		return serverPath;
	}
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}
	public String getContentFilePath() {
		return contentFilePath;
	}
	public void setContentFilePath(String contentFilePath) {
		this.contentFilePath = contentFilePath;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
