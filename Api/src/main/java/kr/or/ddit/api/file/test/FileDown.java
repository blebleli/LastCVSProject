package kr.or.ddit.api.file.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/file")
@Controller("fileDown")
public class FileDown {
	
	
	private Logger logger = LoggerFactory.getLogger(FileDown.class);
	
	@RequestMapping("/view")
	public String fileView(){
		return "file/fileS";
	}
	
	@RequestMapping("/down")
	public String rede(@RequestParam(value="filePath" , defaultValue = "0" ) String filePath 
					  , Model model){
		
		logger.debug("filePath   ==> {}",filePath);
		
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();

		List<FileVo> fileList = new ArrayList<FileVo>();
		FileVo vo = null;
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	vo = new FileVo();
		    	vo.setName(file.getName());
		    	vo.setPath(file.getPath());
		    	vo.setSize(0);
		    	logger.debug("fileVo == >> {}",vo);
		    	fileList.add(vo);
		    }
		}
		logger.debug("fileList.size() == >> {}",fileList.size());
//		model.addAllAttributes(fileList);
		model.addAttribute("fileList", fileList);
		return "file/fileR";
	}
	
}
