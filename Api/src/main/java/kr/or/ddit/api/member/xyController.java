package kr.or.ddit.api.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.hyosang.coordinate.CoordPoint;
import kr.hyosang.coordinate.TransCoord;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xyController {
	public static void main(String[] args) throws IOException {		
		List<MemberVo> memberList =  mb(); // 엑셀 파일을 가져옴
		CoordPoint pt = null;		
		for (int i = 0 ; i < memberList.size(); i++) {
			 pt = new CoordPoint(memberList.get(i).getMem_x(), memberList.get(i).getMem_y()); // 변환해야할 좌표
			 CoordPoint wgs84 = TransCoord.getTransCoord(pt, TransCoord.COORD_TYPE_WTM, TransCoord.COORD_TYPE_WGS84);
			 memberList.get(i).setMem_x(wgs84.x);			 
			 memberList.get(i).setMem_y(wgs84.y);			 
		}
		excel(memberList);
	}
	
	public static void excel(List<MemberVo> mvo) throws IOException{		
		
	    Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하 생성
	    
	    Row row = null; // 기본값
	    Cell cell = null; // 기본값
	    
	    Sheet sheet1 = xlsWb.createSheet("rest"); // 시트 생성  
	    // 테이블 속성 줄
	    row = sheet1.createRow(0);
	    cell = row.createCell(0);
	    cell.setCellValue("mem_pw");            		
	    cell = row.createCell(1);
	    cell.setCellValue("mem_name");
	    cell = row.createCell(2);
	    cell.setCellValue("mem_tel");
	    cell = row.createCell(3);
	    cell.setCellValue("mem_birth");
	    cell = row.createCell(4);
	    cell.setCellValue("mem_gen");
	    cell = row.createCell(5);
	    cell.setCellValue("mem_kind");
	    cell = row.createCell(6);
	    cell.setCellValue("mem_intro");
	    cell = row.createCell(7);
	    cell.setCellValue("mem_cvs_name");
	    cell = row.createCell(8);
	    cell.setCellValue("mem_add");
	    cell = row.createCell(9);
	    cell.setCellValue("mem_addr");
	    cell = row.createCell(10);
	    cell.setCellValue("mem_zip");
	    cell = row.createCell(11);
	    cell.setCellValue("mem_cvs_tel");
	    cell = row.createCell(12);
	    cell.setCellValue("mem_x");
	    cell = row.createCell(13);
	    cell.setCellValue("mem_y");
	    cell = row.createCell(14);
	    cell.setCellValue("mem_id");	    
	    
	    for(int m = 0; m < mvo.size(); m++){ // 저장한 List 돌리기
	    	row = sheet1.createRow(m+1);
	    	cell = row.createCell(0);
	    	cell.setCellValue(mvo.get(m).getMem_pw());
	    	cell = row.createCell(1);
	    	cell.setCellValue(mvo.get(m).getMem_name());
	    	cell = row.createCell(2);
	    	cell.setCellValue(mvo.get(m).getMem_tel());
	    	cell = row.createCell(3);
	    	cell.setCellValue(mvo.get(m).getMem_birth());
	    	cell = row.createCell(4);
	    	cell.setCellValue(mvo.get(m).getMem_gen());
	    	cell = row.createCell(5);
	    	cell.setCellValue(mvo.get(m).getMem_kind());
	    	cell = row.createCell(6);
	    	cell.setCellValue(mvo.get(m).getMem_intro());
	    	cell = row.createCell(7);
	    	cell.setCellValue(mvo.get(m).getMem_cvs_name());
	    	cell = row.createCell(8);
	    	cell.setCellValue(mvo.get(m).getMem_add());
	    	cell = row.createCell(9);
	    	cell.setCellValue(mvo.get(m).getMem_addr());
	    	cell = row.createCell(10);
	    	cell.setCellValue(mvo.get(m).getMem_zip());
	    	cell = row.createCell(11);
	    	cell.setCellValue(mvo.get(m).getMem_cvs_tel());
	    	cell = row.createCell(12);
	    	cell.setCellValue(mvo.get(m).getMem_x());
	    	cell = row.createCell(13);
	    	cell.setCellValue(mvo.get(m).getMem_y());
	    	cell = row.createCell(14);
	    	cell.setCellValue(mvo.get(m).getMem_id());
	    } //for
	    
	    // 해당 파일 없음 생성
		File xlsFile = new File("D:\\restInfoFinal.xls");
		if (!xlsFile.exists()) {
			xlsFile.createNewFile();
		}
           
		// excel 파일 저장
		try {
			FileOutputStream fileOut = new FileOutputStream(xlsFile);
			xlsWb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<MemberVo> mb () throws IOException {

		List<MemberVo> mvo = new ArrayList<MemberVo>();
		MemberVo memberVo = null;
		
		FileInputStream fis = new FileInputStream("D:\\restInfoExcel.xlsx"); // 파일 불러오기
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		XSSFSheet sheet = workbook.getSheetAt(0); // 시트 수 (첫번째에만 존재하므로 0을 준다) 시트를 읽기 위해서 for문을 한번 더 돌려준다
		int rows = sheet.getPhysicalNumberOfRows(); // 행의 수
		
		for (rowindex = 0; rowindex < 10; rowindex++) {
//		for (rowindex = 1; rowindex < rows; rowindex++) {
			memberVo = new MemberVo();
			
			// 행을읽는다
			XSSFRow row = sheet.getRow(rowindex+1);
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();
				
				for (columnindex = 0; columnindex <= 14; columnindex++) {
					// 셀값을 읽는다
					XSSFCell cell = row.getCell(columnindex); // 1 row의 5, 6셀 값들					
					
					String value = "";
					// 셀이 빈값일경우를 위한 널체크
					if (cell == null) {
						continue;
					} else {
						// 타입별로 내용 읽기
						switch (cell.getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
						
						switch (columnindex) {
                        case 0: // 아이디
                        	memberVo.setMem_pw(value); break;
                        case 1:
                        	memberVo.setMem_name(value); break;                            
                        case 2: // 나이
                        	memberVo.setMem_tel(value); break;                            
                        case 3: // 이메일
                        	memberVo.setMem_birth(value); break;                            
                        case 4: // 이메일
                        	memberVo.setMem_gen(value); break;                            
                        case 5: // 이메일
                        	memberVo.setMem_kind(value); break;                            
                        case 6: // 이메일
                        	memberVo.setMem_intro(value); break;                            
                        case 7: // 이메일
                        	memberVo.setMem_cvs_name(value); break;                            
                        case 8: // 이메일
                        	memberVo.setMem_add(value); break;
                        case 9: // 이메일
                        	memberVo.setMem_addr(value); break;
                        case 10: // 이메일
                        	int zip = Integer.parseInt(value);
                        	memberVo.setMem_zip(zip); break;                        	
                        case 11: // 이메일
                        	memberVo.setMem_cvs_tel(value); break;
                        case 12: // 이메일                       		
	                        memberVo.setMem_x(Double.parseDouble(value)); break;
                        case 13: // 이메일                     		
	                        memberVo.setMem_y(Double.parseDouble(value)); break;
                        case 14: // 이메일
                        	memberVo.setMem_id(value); break;
                        default:
                            break;
                        } // switch						
					} //else
				} // columnindex for
				mvo.add(memberVo);
			} // if
		} // for
		
		return mvo;
	}
}  