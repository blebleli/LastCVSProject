package kr.or.ddit.barcode.dao;

import java.util.List;

import kr.or.ddit.model.BarcodeVo;

public class BarcodeDao implements BarcodeDaoInf {

	@Override
	public int setInsertBarcode(BarcodeVo barcodeVo) {
		return 0;
	}

	@Override
	public List<BarcodeVo> getListBarcode() {
		return null;
	}

	@Override
	public int updateBarcode(BarcodeVo barcodeVo) {
		return 0;
	}

	@Override
	public int deleteBarcode(String bcd_id) {
		return 0;
	}

}
