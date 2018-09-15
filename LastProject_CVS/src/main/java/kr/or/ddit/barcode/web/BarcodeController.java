package kr.or.ddit.barcode.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

@RequestMapping("/barcode")
@Controller("barcodeController")
public class BarcodeController {

	private boolean decode(byte[] fileByte){
		//byte[] fileByte = (byte[])model.get("fileByte");
		ByteArrayInputStream by = new ByteArrayInputStream(fileByte);
		//--- 꼭 파일형태로 저장한다음 코드를 읽어야하는지 --?
		//		Path path = Paths.get("D:\\img\\capture.jpg");
		//		Files.write(path, fileByte);

		try {
	       // File file = new File("D:\\img\\capture.jpg"); //파일경로 //MyQRCode.png");
	        String decodedText = decodeQRCode(by);
	        if(decodedText == null) {
	            System.out.println("No QR Code found in the image");
	            return false;
	        } else {
	            System.out.println("Decoded text = " + decodedText);      
	            return true;
	        }
	    } catch (IOException e) {
	        System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
	    } finally {
			try {
				by.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

    private String decodeQRCode(InputStream  qrCodeimage) throws IOException {
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
 
	@RequestMapping("/bcdRead")
	 public ResponseEntity<Boolean> bcdRead(@RequestParam("file") String file,
			 				  Model model) {
		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		
		//model.addAttribute("fileByte",fileByte);
		boolean found = decode(fileByte);

        return new ResponseEntity<>(
        		found, 
          HttpStatus.OK);
		// return "qrCodeReader";
	 }
	
	@RequestMapping("/bcdGenerator")
	 public String bcdGenerator() {
/*		
		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		
		model.addAttribute("fileByte",fileByte);
		*/
		 return "qrCodeGenerator";
	 }
}
