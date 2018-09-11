package kr.or.ddit.filedata;

public class FileUtil {
	
	// 파일 업로드 경로
	public final static String fileUploadPath = "C:/W/A_TeachingMaterial/7.JspSrpgin/fileUpload";
	// 사용자 사진 업로드 경로
	public final static String memberPicUploadPath = "C:/W/A_TeachingMaterial/7.JspSrpgin/fileUpload";
	

	/**
	 * Method : getFileName
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : PC24
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : part의 Content-Disposition header로 부터
	 * 				 업로드 파일명을 리턴한다.
	 * 
	 * ex : form-data; name="upLoadFile"; filename="하트_라이언.gif"
	 * return : 하트_라이언.gif
	 */
	public static String getFileName(String contentDisposition){
		
//		String[] fileData = contentDisposition.replace("form-data;", "").split(";");
		String[] fileData = contentDisposition.replace("\"","").split(";");
		String result = "";
		System.out.println("fileData.length == > " + fileData.length);
		
		for (String file : fileData) {
			String[] fileNameValue = file.split("=");
			
			if (fileNameValue.length >= 2) {
				System.out.println("fileNameValue.length == > " +  fileNameValue.length);
				String fileName =  fileNameValue[0].trim();
				String fileValue = fileNameValue[1].trim();
				if (fileName.equals("filename")) {
					result =  fileValue;
					break;
				}
			}
		}
		
		return result;
	}

}
