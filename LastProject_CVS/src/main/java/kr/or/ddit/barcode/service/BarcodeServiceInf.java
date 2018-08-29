package kr.or.ddit.barcode.service;

import java.util.List;

import kr.or.ddit.model.BarcodeVo;

public interface BarcodeServiceInf {
	
	int newBarcode(BarcodeVo barcodeVo);

	List<BarcodeVo> getBarcodeList();
	
	int updateBarcode(BarcodeVo barcodeVo);
	
	int deleteBarcode(String bcd_id);

}
