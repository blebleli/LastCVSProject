package kr.or.ddit.barcode.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.BarcodeVo;

@Repository("barcodeDao")
public class BarcodeDao implements BarcodeDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public int setInsertBarcode(BarcodeVo barcodeVo) {
		int result =template.insert("barcode.insertBarcode", barcodeVo);
		template.close();
		return result;
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
