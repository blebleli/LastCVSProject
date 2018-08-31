package kr.or.ddit.api.barcode.test;

import java.io.File;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;


public class TestCreateeBarCodeImage {

	public static void main(String[] args) {
		
		String str = "htm";
		
		try {
			
			Barcode barcode  = BarcodeFactory.createCode128(str);
			File file = new  File("D:\\Image\\barcode.png");
			
			BarcodeImageHandler.savePNG(barcode, file);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
