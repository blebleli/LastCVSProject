package kr.or.ddit.barcode.service;

import java.util.List;

import com.google.zxing.WriterException;

import kr.or.ddit.model.BarcodeVo;

public interface BarcodeServiceInf {
	
	int setInsertBarcode(BarcodeVo barcodeVo);

	List<BarcodeVo> getBarcodeList();
	
	int updateBarcode(BarcodeVo barcodeVo);
	
	int deleteBarcode(String bcd_id);

	/**
	 * 
	 * Method   : generateQRCodeImage 
	 * 최초작성일  : 2018. 10. 4. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param text
	 * @param width
	 * @param height
	 * @param filePath 
	 * Method 설명 :  
	 */
	 void generateQRCodeImage(String bcd_id,String kind, String mem_id) throws WriterException;
	
	 /**
	  * 
	  * Method   : makeDir 
	  * 최초작성일  : 2018. 10. 5. 
	  * 작성자 : PC06 
	  * 변경이력 : 
	  * @param filePath 
	  * Method 설명 : mem_id로 폴더가 없을경우 생성
	  */
	 void makeDir(String kind,String mem_id);
}
