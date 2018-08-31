package kr.or.ddit.api.member;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaWebCrawler_etc {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\restInfoExcel.xlsx"); // 파일 불러오기
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		XSSFSheet sheet = workbook.getSheetAt(0); // 시트 수 (첫번째에만 존재하므로 0을 준다) 시트를 읽기 위해서 for문을 한번 더 돌려준다
		int rows = sheet.getPhysicalNumberOfRows(); // 행의 수
		for (rowindex = 1; rowindex < rows; rowindex++) {			
			// 행을읽는다
			XSSFRow row = sheet.getRow(rowindex);
			
			if (row != null) {
				// 셀의 수
				int cells = row.getPhysicalNumberOfCells();				
				for (columnindex = 0; columnindex <= 14; columnindex++) { // 5 : x좌표, 6 : y좌표
					// 셀값을 읽는다
					XSSFCell cell = row.getCell(columnindex); // 1 row의 5, 6셀 값들
					
				    row = sheet.createRow(0);
				    cell = row.createCell(0);
				    cell.setCellValue("mem_pw"); // 비밀번호
				    cell = row.createCell(1);
				    cell.setCellValue("mem_name"); // 점주이름
				    cell = row.createCell(2);
				    cell.setCellValue("mem_tel"); // 점주 연락처
				    cell = row.createCell(3);
				    cell.setCellValue("mem_birth"); // 점주 생년월일
				    cell = row.createCell(4);
				    cell.setCellValue("mem_gen"); // 점수 성별
				    
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
					}
					System.out.println("각 셀 내용 :" + value);
				}
			}
		}
	}
}