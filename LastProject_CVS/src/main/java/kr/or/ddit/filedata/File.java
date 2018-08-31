package kr.or.ddit.filedata;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
* @Class Name : File.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. 조계환 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
public class File {
	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}
