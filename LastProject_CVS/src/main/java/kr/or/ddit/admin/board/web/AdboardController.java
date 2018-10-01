package kr.or.ddit.admin.board.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.internet.ContentDisposition;
import javax.servlet.ServletException;

import kr.or.ddit.admin.prod.service.AdminProdServiceInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.filedata.FileUtil;
import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.model.FiledataVo;



import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@SessionAttributes({"userInfo"})
@RequestMapping("/adboard")
@Controller("adboardController")
public class AdboardController {
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Resource(name="adminProdService")
	private AdminProdServiceInf adminProdService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/boardSearch")
	public String boardSearch(@RequestParam(value="i", defaultValue="") String i,
							  @RequestParam(value="i_search", defaultValue="") String i_search,
							  @RequestParam(value="btnChk", defaultValue="") String bd_kind_id1,
							  @RequestParam(value="bd_kind_id3", defaultValue="") String bd_kind_id, Model model){

		BoardVo boardVo = new BoardVo();
		List<BoardVo> boardList = null;
		
		if(i.equals("1")){ // 제목 검색시
			boardVo.setBd_kind_id(bd_kind_id);
			boardVo.setBd_title(i_search);
			boardList = boardService.boardSearch(boardVo);
		}else if(i.equals("2")){ // 내용 검색시
			boardVo.setBd_kind_id(bd_kind_id);
			boardVo.setBd_content(i_search);
			boardList = boardService.boardSearch(boardVo);
		}else if(i.equals("3")){ // 제목 + 내용 검색시
			boardVo.setBd_kind_id(bd_kind_id);
			boardVo.setBd_parent(i_search); // 값이 분산되어 넣기가 불가능해서 부모코드에 임시로 검색량 넣어서 넘김.
			boardList = boardService.boardSearch(boardVo);
		}else if(i.equals("4")){ // 작성자 검색시
			boardVo.setBd_kind_id(bd_kind_id);
			boardVo.setMem_name(i_search);
			boardList = boardService.boardSearch(boardVo);
		}

		model.addAttribute("i", i);
		model.addAttribute("boardList", boardList);
		model.addAttribute("bd_kind_id",bd_kind_id);
		
		return "ad_boardView";
	}
	
	/**
	 * Method : boardView
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시판 조회(전체, 공지사항, 상품리뷰, 이벤트) List - C
	 */	
	@RequestMapping("/boardView")
	public String boardView(@RequestParam(value="btnChk", defaultValue="") String bd_kind_id,
							@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2,
							CategoryVo categoryVo, Model model){
		
		String ctgy_kind = "301"; // 카테고리 제품 코드
		String ctgy_parent = "";
		categoryVo.setCtgy_kind(ctgy_kind);
		categoryVo.setCtgy_parent(ctgy_parent);
		List<CategoryVo> categoryList = adminProdService.getProdCategory(categoryVo);

		List<BoardVo> boardList = boardService.getBoardPageList2(bd_kind_id);

//		logger.debug("boardList ===========>>> {} ", boardList);
		// 카테고리 전체 조회
		model.addAttribute("bd_kind_id", bd_kind_id);
		model.addAttribute("bd_kind_id2", bd_kind_id2);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("boardList", boardList);
		return "ad_boardView";
	}
	
	/**
	 * Method : boardNew
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 등록 화면 이동(공지사항, 이벤트) C - GO
	 */
	@RequestMapping("/boardNew")
	public String boardNew(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
						   @RequestParam(value="bd_kind_id3", defaultValue="") String bd_kind_id3,Model model){
		
//		logger.debug("bd_kind_id ==================================>> {} ", bd_kind_id);
		BoardVo boardVo = new BoardVo();
		boardVo.setBd_kind_id(bd_kind_id3);
		System.out.println("bd_kind_id3 : "+bd_kind_id3);
		
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("bd_kind_id3", bd_kind_id3);
		
		return "ad_boardNew";
	}
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 및 첨부파일 등록 완료(공지사항, 이벤트, 리뷰) C
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/boardCreate")
	public String boardCreate(@RequestParam(value="file_name", defaultValue="") List<MultipartFile> multipartFile, BoardVo boardVo, Model model) throws ServletException, IOException{
		
		// 리턴 페이지 
		String returnPage = "";
		
		// 파일 물리 저장 기본 경로
		String tempSavePath = "D:/A_TeachingMaterial/7.JspSpring/workspace/LastProject_CVS/src/main/webapp/Image/board/";
		// 파일 DB 저장 기본 경로
		String path = "/Image/board/";
		
		// 그룹코드
		String groupCode = "";
		
		// 답글일 경우
		if (boardVo.getBd_id() != null) {
			
//			logger.debug("답글일 경우 bd_id & bd_parent==> {}",boardVo.getBd_id());
			// 받아오는 bd_id ==> bd_parent set
			boardVo.setBd_parent(boardVo.getBd_id());
			
			// 그룹코드 받아 오기
			groupCode = boardVo.getBd_group();
			
		}else{
			boardVo.setBd_parent("");
		}
		
		logger.debug("boardVo.getProd_id()==> {}", boardVo.getProd_id());
		
		// 새글 쓰기
		if(boardVo.getBd_kind_id().equals("44")){ // 공지사항
			boardVo.setBd_id(code.autoCode("BNO"));
			// 리뷰가 아닐시.. BoardVo 나머지 값 null 
			boardVo.setProd_id("");
			boardVo.setBd_rating(0);
			tempSavePath += "/BNO";
			path+= "/BNO";
			returnPage = "redirect:/adboard/boardView?btnChk=" + boardVo.getBd_kind_id();
			
		}else if(boardVo.getBd_kind_id().equals("55")){ // 리뷰
			boardVo.setBd_id(code.autoCode("BRE"));
			tempSavePath += "/BRE";
			path+= "/BRE";
			returnPage = "redirect:/userProd/detail";
			
		}else if(boardVo.getBd_kind_id().equals("66")){ // 이벤트
			boardVo.setBd_id(code.autoCode("BEV"));
			tempSavePath += "/BEV";
			path+= "/BEV";
			// 리뷰가 아닐시.. BoardVo 나머지 값 null 
			boardVo.setProd_id("");
			boardVo.setBd_rating(0);
			returnPage = "redirect:/adboard/boardView?btnChk=" + boardVo.getBd_kind_id();
		}
		
//		logger.debug("boardVo ==> {}" , boardVo);
		
		// 게시글 그룹코드 저장 (첫 글은 첫 글의 게시글 코드가 그룹코드임.)
//		logger.debug("groupCode ==> {} ", groupCode);
		groupCode = (groupCode.equals("")) ? boardVo.getBd_id(): groupCode ;
//		logger.debug("groupCode ==> {} ", groupCode);
		boardVo.setBd_group(groupCode);
		
		int cnt = boardService.setInsertBoard(boardVo); // 게시글 저장
		
//		logger.debug("cnt==> {}" , cnt);
		
		int fileResult = 0;
		if (cnt != 0){		
			for (MultipartFile m : multipartFile) {		
				
				FiledataVo fileVo = new FiledataVo();
				
				String ext = FilenameUtils.getExtension(m.getOriginalFilename());
				
				if(m.isEmpty()==false){
				fileVo.setBd_id(boardVo.getBd_id()); // 게시글 코드
				fileVo.setFile_path(path); // 파일 경로
				fileVo.setFile_name(m.getOriginalFilename()); // 파일 업로드명
				fileVo.setFile_upname(UUID.randomUUID().toString()+"."+ext); // 파일명
				fileVo.setMem_id(boardVo.getMem_id());
				
//				logger.debug("경로저장 =>> {}", tempSavePath+fileVo.getFile_path() + File.separator + fileVo.getFile_upname());
				
				// 디렉토리 없을 경우 생성
				if(!new File(tempSavePath).exists()) {
					new File(tempSavePath).mkdirs();
				}
				
				//파일    (공지사항 : NO, 리뷰 : RE, 이벤트 : EV, 회원프로필 : MP, 편의점프로필 : CP)
				// 만약에 공지사항 혹은 이벤트 구분 인식할 경우
				if(boardVo.getBd_kind_id().equals("44")){	 	// 공지사항
					fileVo.setFile_id(code.autoCode("NO")); 	// 파일 코드
				}else if(boardVo.getBd_kind_id().equals("55")){ // 이벤트
					fileVo.setFile_id(code.autoCode("RE"));		// 파일 코드
				}else if(boardVo.getBd_kind_id().equals("66")){ // 이벤트
					fileVo.setFile_id(code.autoCode("EV"));		// 파일 코드
				}
				
//				logger.debug("fileVo.getFile_id() ==> {}", fileVo.getFile_id());
				
				fileResult += fileService.insertFileBoard(fileVo);

				// 실제 물리경로에 파일 저장
				File saveFile = new File(tempSavePath + File.separator + fileVo.getFile_upname());
					m.transferTo(saveFile);
				
				}
			} // for
			
//			logger.debug("fileResult ==> {}" ,fileResult);
			
			model.addAttribute("prod_id", boardVo.getProd_id());
			
			return returnPage;
			
		}else{		// insert 실패시
			
			return "ad_index"; // 실패시 관리자 메인화면으로 이동
		}
	}
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 상세조회 화면 이동 R, 게시글 댓글 화면 이동 R
	 */
	@RequestMapping("/boardDetail")
	public String boardDetail(@RequestParam(value="id", defaultValue="") String bd_id, 
							  @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id2, Model model){
		BoardVo b = boardService.getBoard(bd_id); // 게시판 코드(bd_id)로 게시글 상세조회를 한다.
		List<CommentsVo> cList = boardService.getListComments(bd_id); // 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
		List<FiledataVo> FList = fileService.getFiledata(bd_id); // 게시판 코드(bd_id)로 해당 첨부파일 전체를 조회한다.
		model.addAttribute("bd_id", bd_id);
		model.addAttribute("bd_kind_id2", bd_kind_id2);
		model.addAttribute("b", b); // model에 저장한다.
		model.addAttribute("cList", cList); // model에 저장한다.
		model.addAttribute("FList", FList); // model에 저장한다.		
		return "ad_boardDetail";
	}
	
	/**
	 * Method : boardUpdateGo
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정화면 이동 U - GO
	 */
	@RequestMapping("/boardUpdateGo")
	public String boardUpdateGo(@RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){		
		BoardVo boardVo = boardService.getBoard(bd_id); // 게시코드로 게시글 정보 조회
		List<FiledataVo> FList = fileService.getFiledata(bd_id);
		model.addAttribute("FList", FList);
		model.addAttribute("boardVo", boardVo); // model에 저장한다.		
		return "ad_boardUpdate"; // 게시글 수정화면으로 이동
	}
	
	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 수정, 첨부파일 추가(수정)완료 U
	 */
	@RequestMapping("/boardUpdate")
	public String boardUpdate(@RequestParam(value="file_name", defaultValue="") List<MultipartFile> multipartFile,
							  BoardVo b, Model model) throws ServletException, IOException {
		
		String tempSavePath = "D:/A_TeachingMaterial/7.JspSpring/workspace/LastProject_CVS/src/main/webapp";
		int cnt = boardService.boardUpdate(b); // 게시글 저장
		
		if (cnt != 0){		
			for (MultipartFile m : multipartFile) {
				
				FiledataVo fileVo = new FiledataVo();
				String ext = FilenameUtils.getExtension(m.getOriginalFilename());
				
				if(m.isEmpty()==false){
				fileVo.setBd_id(b.getBd_id()); // 게시글 코드
				fileVo.setFile_path(FileUtil.Path); // 파일 경로
				fileVo.setFile_name(m.getOriginalFilename()); // 파일 업로드명
				fileVo.setFile_upname(UUID.randomUUID().toString()+"."+ext); // 파일명
				fileVo.setMem_id(b.getMem_id());
				
//				logger.debug("경로저장 =>> {}", tempSavePath+fileVo.getFile_path() + File.separator + fileVo.getFile_upname());
				
				// 디렉토리 없을 경우 생성
				if(!new File(tempSavePath+FileUtil.Path).exists()) {
					new File(tempSavePath+FileUtil.Path).mkdirs();
				}
				
				// 만약에 공지사항 혹은 이벤트 구분 인식할 경우
				if(b.getBd_kind_id().equals("44")){ // 공지사항 구분
					String NO = code.autoCode("NO"); // 공지시항 파일코드
					fileVo.setFile_id(NO); // 파일 코드 생성
				}else if(b.getBd_kind_id().equals("66")){ // 이벤트 구분
					String EV = code.autoCode("EV"); // 이벤트 파일코드
					fileVo.setFile_id(EV);
				}
				
				fileService.insertFileBoard(fileVo);
				
				// 실제 물리경로에 파일 저장
				File saveFile = new File(tempSavePath+fileVo.getFile_path() + File.separator + fileVo.getFile_upname());
				m.transferTo(saveFile);				
				
				}
			} // for
			return "redirect:/adboard/boardDetail?id="+b.getBd_id(); // 게시글 상세조회 화면으로 이동
		}else{
			return "ad_index"; // 실패시 관리자 메인화면으로 이동
		}
	}

	/**
	 * Method : deleteFiles
	 * 최초작성일 : 2018. 9. 30.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @param file_id
	 * @param fvo
	 * @param model
	 * @return
	 * Method 설명 : 게시글 내 파일 삭제
	 */
	@RequestMapping("/deleteFiles") // 게시글 내 파일 삭제..
	public String deleteFiles(@RequestParam("bd_id") String bd_id,
							  FiledataVo fvo, Model model){
		
		BoardVo boardVo = boardService.getBoard(bd_id);
		List<FiledataVo> filesVo = fileService.getFiledata(bd_id); // 첨부파일 조회
		System.out.println(fvo.getFile_id());
		
		model.addAttribute("bd_id",bd_id);
		model.addAttribute("boardVo", boardVo);
		model.addAttribute("filesVo", filesVo);
		
		int cnt = fileService.deleteFileBoard(fvo);
		
		if(cnt > 0){
			System.out.println("파일 삭제 완료");
			return "redirect:/adboard/boardUpdateGo?bd_id="+bd_id;
		}else{
			System.out.println("파일 삭제 실패");
			return "redirect:/adboard/boardDetail?bd_id="+bd_id;
		}
	} // deleteFiles
	
	/**
	 * Method : boardDel
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param model
	 * @return
	 * Method 설명 : 게시글 삭제 D
	 */
	@RequestMapping("/boardDel")
	public String boardDel(@RequestParam(value="bd_id", defaultValue="") String bd_id,
						   @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id, Model model){
		
		int cnt = boardService.boardDelete(bd_id); // 게시글 코드를 가지고 게시글을 삭제한다.
		
		if(cnt != 0){
			// 삭제 성공시 해당 구분(ex 공지사항) 리스트 조회화면으로 이동한다.
			return "redirect:/adboard/boardView?bd_kind_id=" + bd_kind_id;
		}else{
			// 삭제 실패시 내용을 디버그로 출력하며, 관리자 메인화면으로 이동한다.
//			logger.debug("write delete fail ====>>>> {} ", cnt);
			return "admin/main";
		}
	}
	
	/**
	 * Method : boardReply
	 * 최초작성일 : 2018. 9. 25.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @param bd_group
	 * @param bd_kind_id
	 * @param model
	 * @return
	 * Method 설명 : 답글 등록 화면으로 이동(해당 게시물 그룹아이디, 부모아이디, 구분 값을 가져간다)
	 */
	@RequestMapping("/boardReply")
	public String boardReply(@RequestParam(value="bd_id", defaultValue="") String bd_id,
							 @RequestParam(value="bd_group", defaultValue="") String bd_group,
							 @RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
							 Model model){
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBd_group(bd_group); // 그룹아이디
		boardVo.setBd_parent(bd_id); // 부모아이디
		boardVo.setBd_id(bd_id); // 아이디
		boardVo.setBd_kind_id(bd_kind_id);
		System.out.println("bd_group : "+bd_group+", bd_parent : "+bd_id);
		
		model.addAttribute("boardVo", boardVo);
		
		return "ad_boardReply";
	}
	
	
	/**
	 * Method : newComment
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 내 댓글 작성 C
	 */
	@RequestMapping("/newComment")
	public String newComment(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
							 @RequestParam(value="cm_RadioCkeck", defaultValue="") String cm_RadioCkeck, CommentsVo cList, Model model){
		
//		logger.debug("cm_RadioCkeck =====>> {}", cm_RadioCkeck);
		System.out.println(bd_kind_id);
				
		if(cm_RadioCkeck.equals("Y")){ // 댓글 공개하였다면
			cList.setCm_openny(cm_RadioCkeck); // 공개 체크 저장
			System.out.println("공개함");
		}else{ // 댓글 비공개를 하였다면
			cList.setCm_openny(cm_RadioCkeck); // 비공개 체크 저장
			System.out.println("비공개함");
		}
		
		if(bd_kind_id.equals("44")){ // 공지사항이면
			String CNOCODE = "CNO"; // 공지사항 코드 생성 준비
			String cm_id = code.autoCode(CNOCODE); // 코드 생성
			cList.setCm_id(cm_id); // 댓글코드 저장
//			logger.debug("cm_id ==========> {} ", cm_id);
			System.out.println("공지사항 입니다. ========================>>>>");
		} else { // 이벤트이면
			String CEVCODE = "CEV"; // 이벤트 코드 생성 준비
			String cm_id = code.autoCode(CEVCODE); // 코드 생성
			cList.setCm_id(cm_id); // 댓글코드 저장
//			logger.debug("cm_id ==========> {} ", cm_id);
			System.out.println("이벤트 입니다 =========================>>>>>");
		}
		
		String cm_group = cList.getBd_id(); // 게시글 코드를
		cList.setCm_group(cm_group); // 그룹코드에 저장(첫 댓글은 자기 자신이 그룹코드이다.)
		
		int cnt = boardService.setInsertComments(cList);
		model.addAttribute("cList", cList);
		
		if(cnt != 0){
			return "redirect:/adboard/boardDetail?id=" + cList.getBd_id();	// id가 상세조회 id이름과 동일해야함.		
		}else{
			System.out.println("실패");
			return "ad_index";
		}
	}
	
	/**
	 * Method : commentsDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 내 댓글 삭제 D
	 */
	@RequestMapping("/commentsDel")
	public String commentsDelete(@RequestParam(value="cm_id", defaultValue="") String cm_id,
								 @RequestParam(value="bd_id", defaultValue="") String bd_id, Model model){		
		int cnt = boardService.commentsDelete(cm_id); // 댓글코드로 댓글을 삭제한다.
		
		if(cnt != 0){ // 댓글 삭제 성공시
			return "redirect:/adboard/boardDetail?id=" + bd_id; // 게시글 상세화면으로 이동한다.
		}else{ // 댓글 삭제 실패시
			return "ad_index"; // 관리자 메인으로 돌아간다.
		}
	}
	
//	@RequestMapping(value="/review", method=RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> review(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
//								@RequestParam(value="page", defaultValue="1") int page,
//								@RequestParam(value="pageSize", defaultValue="10") int pageSize){
//		
//		logger.debug("bd_kind_id ============> {} " + bd_kind_id);
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		
//		paramMap.put("page", page); // page 1
//		paramMap.put("pageSize", pageSize); // pageSize 10
//		paramMap.put("bd_kind_id",bd_kind_id); // 리뷰 코드(55)맵에 저장
//		
//		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
//		
//		return resultMap;
//	}
	
//	@RequestMapping(value="/ctgy_parent", method=RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> review(@RequestParam(value="bd_kind_id", defaultValue="") String bd_kind_id,
//								@RequestParam(value="page", defaultValue="1") int page,
//								@RequestParam(value="pageSize", defaultValue="10") int pageSize){
//		
//		logger.debug("bd_kind_id ============> {} " + bd_kind_id);
//		
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		
//		paramMap.put("page", page); // page 1
//		paramMap.put("pageSize", pageSize); // pageSize 10
//		paramMap.put("bd_kind_id",bd_kind_id); // 리뷰 코드(55)맵에 저장
//		
//		Map<String, Object> resultMap = adboardService.adBoardViewList(paramMap); // 게시판 초기화면 출력
//		
//		return resultMap;
//	}
}