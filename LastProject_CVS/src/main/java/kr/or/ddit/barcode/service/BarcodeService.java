package kr.or.ddit.barcode.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.barcode.dao.BarcodeDaoInf;
import kr.or.ddit.model.BarcodeVo;

@Service("barcodeService")
public class BarcodeService implements BarcodeServiceInf {

	@Resource(name="barcodeDao")
	private BarcodeDaoInf barcodeDao;
	@Override
	public int setInsertBarcode(BarcodeVo barcodeVo) {
		return barcodeDao.setInsertBarcode(barcodeVo);
	}

	@Override
	public List<BarcodeVo> getBarcodeList() {
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
