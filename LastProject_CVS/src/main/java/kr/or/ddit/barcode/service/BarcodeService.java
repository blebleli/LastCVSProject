package kr.or.ddit.barcode.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

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

	@Override
	public void generateQRCodeImage(String text, String filePath) throws WriterException {		    	
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath(filePath);
        try {
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeDir(String kind,String mem_id) {
		String patt = "D:\\A_TeachingMaterial\\8.LastProject\\workspace\\LastProject_CVS\\src\\main\\webapp\\barcode\\"+kind+"\\"+mem_id;
		File filee = new File(patt);
		if (!filee.exists()) {
			try{filee.mkdir();} 
		    catch(SecurityException se){}        
		}
	}


}
