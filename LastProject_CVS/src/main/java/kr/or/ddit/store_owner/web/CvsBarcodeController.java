package kr.or.ddit.store_owner.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Base64.Decoder;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/**
 * 담당 -- 한수정
 * CvsBarcodeController.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */

@RequestMapping("/cvs")
@Controller("cvsBarcodeController")
public class CvsBarcodeController {
	
	@RequestMapping("/barcode")
	public String cvsBarcode(Model model){
		return "cvs_barcode_read";
	}
	
	/**
	 * 
	 * Method   : bcdRead 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param file
	 * @param model
	 * @return 
	 * Method 설명 : 바코드 이미지 코드를 읽어 상태반환
	 */
	/*@RequestMapping("/bcdRead")
	 public ResponseEntity<String> bcdRead(@RequestParam("file") String file,
			 				  Model model) {
		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		String found = decode(fileByte);
	
       return new ResponseEntity<>(found, HttpStatus.OK);
	 }*/
	
	
	@RequestMapping("/bcdRead")
	 public ModelAndView bcdRead(@RequestParam("file") String file,Model model) {
		
		ModelAndView mav = new ModelAndView("jsonView");

		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		String found = decode(fileByte);

		mav.addObject("resultMsg", found);
		mav.addObject("list", found);

		return mav;
	 }	 
	 
	
	@RequestMapping("/bcdGenerator")
	 public String bcdGenerator() {

		 return "qrCodeGenerator";
	 }


	/**
	 * 
	 * Method   : decode 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param fileByte
	 * @return 
	 * Method 설명 : 바코드읽은 결과를 boolean 형태로 반환하는 메서드
	 */
	private String decode(byte[] fileByte){
		ByteArrayInputStream by = new ByteArrayInputStream(fileByte);
		try {
	        String decodedText = decodeQRCode(by);
	        if(decodedText == null) {
	            System.out.println("No QR Code found in the image");
	            return "noFound";
	        } else {
	        	System.out.println("Decoded text = " + decodedText);      
	            return decodedText;
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
		return "false";
	}

	/**
	 * 
	 * Method   : decodeQRCode 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param qrCodeimage
	 * @return
	 * @throws IOException 
	 * Method 설명 : 사진에 바코드가 존재하는지 확인 & 바코드를 텍스트로 해석하는 메서드
	 */
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
 


	
}
