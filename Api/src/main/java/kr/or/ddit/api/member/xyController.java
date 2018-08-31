package kr.or.ddit.api.member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.hyosang.coordinate.CoordPoint;
import kr.hyosang.coordinate.TransCoord;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xyController {
	public static void main(String[] args) throws IOException {
		
		List<MemberVo> memberList =  mb();

		CoordPoint pt = null;
		
		for (int i = 0 ; i < memberList.size(); i++) {
		
			// 변환변 vo
			System.out.println(memberList.get(i));
			 pt = new CoordPoint(memberList.get(i).getMem_x(), memberList.get(i).getMem_y()); // 변환해야할 좌표
			 CoordPoint wgs84 = TransCoord.getTransCoord(pt, TransCoord.COORD_TYPE_WTM, TransCoord.COORD_TYPE_WGS84);
			 memberList.get(i).setMem_x(wgs84.x);			 
			 memberList.get(i).setMem_y(wgs84.y);
			 
			// 변환후 vo
			 System.out.println("변환=================");
			 System.out.println(memberList.get(i));
			 System.out.println("================================");
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
		
		for (rowindex = 1; rowindex < 2; rowindex++) {
//		for (rowindex = 1; rowindex < rows; rowindex++) {
			memberVo = new MemberVo();
			
			// 행을읽는다
			XSSFRow row = sheet.getRow(rowindex);
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
					
//					System.out.println("각 셀 내용 :" + value);
				}
				mvo.add(memberVo);		
			}
		}
		
//		System.out.println(mvo);
	return mvo;
	}
}  