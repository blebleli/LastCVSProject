package kr.or.ddit.filedata.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.model.FiledataVo;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/file")
@Controller("fileController")
public class FileController {

	private Logger logger  = LoggerFactory.getLogger(FileController.class);
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

	/**
	 * 파일 다운로드
	 * 
	 * @param request
	 * @param postsVo
	 * @param model
	 * @return
	 */
	@RequestMapping("/downloadFile.do")
	public ModelAndView downloadFile(HttpServletRequest request, Model model){
		
		logger.debug("Request URI : {}", request.getRequestURI());

		String file_path = request.getParameter("file_path");
		String file_upname = request.getParameter("file_upname");
		String file_name = request.getParameter("file_name");

		File file = new File(file_path, file_upname);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("downloadFile", file);
		map.put("file_renm", file_name);

		return new ModelAndView("fileDownloadView", map);
	}
	
	/**
	 * 파일 삭제
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException 
	 */
	@RequestMapping("/deleteFile.do")
	public void deleteFile(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException{
		
		logger.debug("Request URI : {}", request.getRequestURI());

		// 파라미터 가져와서 vo에 set ==========================================================================
		String mem_id = request.getParameter("mem_id");
		String bd_id = request.getParameter("bd_id");
		String file_id = request.getParameter("file_id");
		String file_path = request.getParameter("file_path");
		String file_upnm = request.getParameter("file_upname");
		
		FiledataVo filedataVo = new FiledataVo();
		filedataVo.setFile_id(file_id);
		filedataVo.setMem_id(mem_id);
		filedataVo.setBd_id(bd_id);
		
		fileService.deleteFile(filedataVo);
		
		// 파일 삭제
		try {
			FileUtils.forceDelete(new File(file_path, file_upnm));
		} catch (IOException e) {
			logger.error("{}", e);
		}

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().print(1);
		
	}
	
}
