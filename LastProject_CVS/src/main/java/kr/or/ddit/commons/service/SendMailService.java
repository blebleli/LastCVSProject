package kr.or.ddit.commons.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import kr.or.ddit.commons.model.MailVo;
import kr.or.ddit.commons.util.AES256Util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("sendMailService")
public class SendMailService implements SendMailServiceInf {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String mailAddr;
	private String authUrl;
	private String serverPath;
	private String contentFilePath;
	private String subject;

	public void setParam(MailVo mailVo) {
		this.mailAddr = mailVo.getMailAddr();
		this.serverPath = mailVo.getServerPath();
		this.authUrl = mailVo.getServerPath() + mailVo.getAuthUrl();
		this.contentFilePath = mailVo.getContentFilePath();
		this.subject = mailVo.getSubject();
	}

	/**
	 * 
	 * Method : sendMail
	 * 최초작성일 : 2018. 9. 3.
	 * 작성자 : pc24
	 * 변경이력 :
	 * @param to
	 * @param authUrl
	 * @param contentFilePath
	 * @throws Exception
	 * Method 설명 : 인증메일 전송
	 */
	public void sendMail(MailVo mailVo) throws Exception {
		setParam(mailVo);
		
		logger.debug("Sending mail...");

		Properties props = System.getProperties();
		props.put("mail.transport.protocol", PROTOCOL);
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", PORT);
		props.put("mail.smtp.auth", AUTH);
		props.put("mail.smtp.ssl.enable", SSL_ENABLE);
		props.put("mail.smtp.ssl.trust", HOST);

		//Session 생성
		Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			String un = USER_NAME; 
			String pw = USER_PWD; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
			} 
		}); 
//		mailSession.setDebug(true); //for debug

		Transport transport = mailSession.getTransport();

		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject, "UTF-8");	// 메일제목
		message.setFrom(new InternetAddress(FROM, "CVS", "UTF-8"));	//보내는사람메일주소, 보내는사람명
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailAddr));

		// This HTML mail have to 2 part, the BODY and the embedded image
		MimeMultipart multipart = new MimeMultipart("related");

		// first part  (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = getMailContent();
		messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");

		// add it
		multipart.addBodyPart(messageBodyPart);

		// 이미지 첨부
		//		if(StringUtils.isNotEmpty(filePath)) {
		//			messageBodyPart = new MimeBodyPart();
		//			DataSource fds = new FileDataSource(filePath);
		//			messageBodyPart .setDataHandler(new DataHandler(fds));
		//			messageBodyPart .setHeader("Content-ID","<my-image>");
		//			multipart.addBodyPart(messageBodyPart );
		//			// put everything together
		//		}
		message.setContent(multipart, "text/html; charset=UTF-8");

		transport.connect();
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
	
	private String getEncryptAuthVal(String mailAddr) throws Exception {
		// Random 문자열 발생시켜 AES256 으로 암호화
		String authVal = randomStr();
		AES256Util encUtil = new AES256Util(AES256Util.AES256_KEY);
		String encAuthVal = encUtil.aesEncode(mailAddr + "|" + authVal);
		// URL에 + 가 있으면 space로 바껴버려서 + 없을때까지 재귀호출함
		if(encAuthVal.contains("+")) {
			return getEncryptAuthVal(mailAddr);
		}
		return authVal + "|" + encAuthVal;
	}

	/**
	 * 메일 본문 가져오기
	 */
	public String getMailContent() throws Exception {

		String content = "";
		try {
			content = FileUtils.readFileToString(new File(contentFilePath), "UTF-8");
			// Random 문자열 발생시켜 AES256 으로 암호화
//			String authVal = randomStr();
//			AES256Util encUtil = new AES256Util(AES256Util.AES256_KEY);
//			String encAuthVal = encUtil.aesEncode(mailAddr + "|" + authVal);
			
			String encryptAuthVal = getEncryptAuthVal(mailAddr);
			String authVal = StringUtils.substringBeforeLast(encryptAuthVal, "|");
			String encAuthVal = StringUtils.substringAfter(encryptAuthVal, "|");

			// 인증 유효 시간
			String validDateTimeStr = validDateTime();

			String validDateTime = validDateTimeStr.substring(0, 4) + "년 "
									+ validDateTimeStr.substring(4, 6) + "월 "
									+ validDateTimeStr.substring(6, 8) + "일 "
									+ validDateTimeStr.substring(8, 10) + "시 "
									+ validDateTimeStr.substring(10, 12) + "분 "
									+ validDateTimeStr.substring(12, 14) + "초 ";
			
			// 메일본문에 암호화된 Random 문자열 적용
			content = StringUtils.replace(content, "%mailAuthUrl%", authUrl + "?authVal=" + encAuthVal);
			content = StringUtils.replace(content, "%validDateTime%", validDateTime);
			content = StringUtils.replace(content, "#serverPath", serverPath);
			

			// 메일인증 요청정보 저장
			saveMailAuthRequestInfo(mailAddr, authVal, validDateTimeStr);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	/**
	 * 메일 인증 요청 정보 저장 TODO 파일 또는 DB에 저장
	 * @param mailAddr
	 * @param authVal
	 */
	public void saveMailAuthRequestInfo(String mailAddr, String authVal, String validDateTimeStr) {

		// 요청정보 파일 경로
		String savePath = AUTH_REQUEST_INFO_FILE_PATH;
		// 요청정보 파일 명 : 메일주소
		String saveName = mailAddr;

		File filePath = new File(AUTH_REQUEST_INFO_FILE_PATH);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		try {
			FileUtils.writeStringToFile(new File(savePath, saveName), authVal + "," + validDateTimeStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 암호화할 문자열 발생 random
	 * @return
	 * @throws Exception
	 */
	public String randomStr() throws Exception {

		Random rnd = new Random();

		StringBuffer buf = new StringBuffer();

		for(int i = 0; i < 20; i++){
			// rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
			if(rnd.nextBoolean()){
				buf.append((char)((int)(rnd.nextInt(26))+97));
			}else{
				buf.append((rnd.nextInt(10)));
			}
		}
		return buf.toString();
	}

	/**
	 * 인증 검증
	 * @param mailAddr
	 * @param encAuthVal
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> validateMailAuth(String encStr) throws Exception {

		// 암호화된 인증문자열 복호화
		AES256Util decUtil = new AES256Util(AES256Util.AES256_KEY);
		String decStr = decUtil.aesDecode(encStr);

		// 메일주소 추출
		String mailAddr = StringUtils.substringBefore(decStr, "|");
		String authVal = StringUtils.substringAfter(decStr, "|");

		// 원본 인증문자열과  복호화된 문자열 비교
		File filePath = new File(AUTH_REQUEST_INFO_FILE_PATH);
		if(!filePath.exists()) {
			filePath.mkdirs();
		}
		String authRequestInfo = FileUtils.readFileToString(new File(AUTH_REQUEST_INFO_FILE_PATH, mailAddr));
		String oriAuthVal = StringUtils.substringBefore(authRequestInfo, ",");
		String reqDtmStr = StringUtils.substringAfter(authRequestInfo, ",");

		System.out.println("메일주소 : " + mailAddr);
		System.out.println("인증요청시간 : " + reqDtmStr);
		System.out.println("암호화된 문자열 : " + encStr);
		System.out.println("복호화된 문자열 : " + decStr);
		System.out.println("원본 인증문자열 : " + oriAuthVal);

		boolean checkValidDateTime = checkValidDateTime(reqDtmStr);
		System.out.println("문자열 비교 : " + StringUtils.equals(authVal, oriAuthVal));
		System.out.println("시간 비교 : " + checkValidDateTime);

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("mailAddr", mailAddr);

		if(StringUtils.equals(authVal, oriAuthVal) && checkValidDateTime) {
			resultMap.put("result", "SUCCESS");
			resultMap.put("resultMessage", "이메일 인증되었습니다.");
		}
		else {
			resultMap.put("result", "FAIL");
			if(!checkValidDateTime) {
				resultMap.put("resultMessage", "인증 유효시간이 경과하였습니다.\n재인증요청 하시기 바랍니다.");
			}
			else {
				resultMap.put("resultMessage", "이메일 인증 시 오류가 발생하였습니다.\n관리자에게 문의하시기 바랍니다.");
			}
		}

		return resultMap;
	}

	/**
	 * 인증 유효시간 (현재시간 + 10분)
	 * @return
	 */
	public String validDateTime() {
		Date currDtm = new Date();	// 현재시간
		currDtm.setMinutes(currDtm.getMinutes() + 10);

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		return format.format(currDtm);
	}

	public String todayToString() {
		String pattern = "yyyyMMddhhmmss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}

	/**
	 * 인증요청 유효시간 체크
	 * @param dateTimeStr
	 * @return
	 */
	public boolean checkValidDateTime(String validDateTimeStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss"); 
		String currentDateTime = format.format(new Date());

		System.out.println("인증유효시간/현재시간 : " + validDateTimeStr + " / " + currentDateTime);
		// 현재시간이 인증유효시간 이후면 FALSE
		if(Long.valueOf(currentDateTime) > Long.valueOf(validDateTimeStr)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {

		// 보낼사람 mail 주소, 타입(/webapp/타입.html 찾기)
		//		MailServiceImpl.mailSend("metal0201@gmail.com", "mailAuth");

		SendMailServiceInf mailService = new SendMailService();
		// param : 받는사람 메일주소, /webapp/mail/ 폴더에 있는 메일 본문 html 파일명;
		//		mailService.mailSend("ㅇㅇㅇㅇㅇㅇ@gmail.com", "mailAuth");

//		String dateStr = "20180822121825";
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMddhhmmss"); 
//		Date reqDtm = dt.parse(dateStr);	// 인증요청 시간
//		Date currDtm = new Date();	// 현재시간
//		
//		System.out.println(reqDtm.compareTo(currDtm));
//		System.out.println(currDtm.compareTo(reqDtm));

//		String path = SendMailServiceInf.class.getResource("").getPath();
//		String webapps = StringUtils.substringBefore(path, "target");
//		System.out.println(path);
		
		String validDateTimeStr = "20180910005851";
		String validDateTime = validDateTimeStr.substring(0, 4) + "년 "
								+ validDateTimeStr.substring(4, 6) + "월 "
								+ validDateTimeStr.substring(6, 8) + "일 "
								+ validDateTimeStr.substring(8, 10) + "시 "
								+ validDateTimeStr.substring(10, 12) + "분 "
								+ validDateTimeStr.substring(12, 14) + "초 ";
		
		System.out.println(validDateTime);
	}

}
