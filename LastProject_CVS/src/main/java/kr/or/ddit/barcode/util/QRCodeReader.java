package kr.or.ddit.barcode.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRCodeReader implements View {

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		byte[] fileByte = (byte[])model.get("fileByte");
		ByteArrayInputStream by = new ByteArrayInputStream(fileByte);
		//--- 꼭 파일형태로 저장한다음 코드를 읽어야하는지 --?
		//		Path path = Paths.get("D:\\img\\capture.jpg");
		//		Files.write(path, fileByte);

		try {
	       // File file = new File("D:\\img\\capture.jpg"); //파일경로 //MyQRCode.png");
	        String decodedText = decodeQRCode(by);
	        if(decodedText == null) {
	            System.out.println("No QR Code found in the image");
	        } else {
	            System.out.println("Decoded text = " + decodedText);                
	        }
	    } catch (IOException e) {
	        System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
	    } finally {
			by.close();
		}
	
	}	
	
    private static String decodeQRCode(InputStream  qrCodeimage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }

}