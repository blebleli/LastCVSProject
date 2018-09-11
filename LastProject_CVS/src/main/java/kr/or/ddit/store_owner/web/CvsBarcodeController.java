package kr.or.ddit.store_owner.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import kr.or.ddit.commons.dao.AutoCodeInf;
import kr.or.ddit.commons.dao.CommonsDaoInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	private Logger logger = LoggerFactory.getLogger(CvsBarcodeController.class);
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	
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
	@RequestMapping("/bcdRead")
	@ResponseBody
	 public ModelAndView bcdRead(@RequestParam("file") String file,Model model) {
		
		ModelAndView mav = new ModelAndView("jsonView");

		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		Map<String, Object> found = decode(fileByte);
		logger.debug("returnMsg ------"+found.get("returnMsg"));	
		mav.addObject("returnMsg", found.get("returnMsg"));		
	
		if(found.get("returnMsg")!= null){
			mav.addObject("supplyList", found.get("supplyList"));	
		}
		
		return mav;
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
	private HashMap<String, Object> decode(byte[] fileByte){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		ByteArrayInputStream by = new ByteArrayInputStream(fileByte);
		
		try {
	        String decodedText = decodeQRCode(by);
	        if(decodedText == null) {
	        	
	        	logger.debug("No QR Code found in the image");
	            map.put("returnMsg", "noFound");
	            return map;
	            
	        } else {
	        	
	        	logger.debug("Decoded text = " + decodedText);	
	        	map.put("returnMsg", decodedText);
	        	
	        	//입고리스트일때 처리
	        	List<SupplyListVo> supplyList = supplyService.getListSupplyList(decodedText);
	        	map.put("supplyList", supplyList);
	        	
	        	//상품바코드일때 처리
	        	
          return map;
	        }
	    } catch (IOException e) {
	    	logger.debug("Could not decode QR Code, IOException :: " + e.getMessage());
	    	map.put("returnMsg", "CouldNotDecode");
	    	
	    } finally {
			try {
				by.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		map.put("returnMsg", "fail");
		
		return map;
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
    
    
    /**
     * 
     * Method   : bcdGenerator 
     * 최초작성일  : 2018. 9. 10. 
     * 작성자 : PC06 
     * 변경이력 : 
     * @return 
     * Method 설명 : 바코드 생성 예정
     */
	@RequestMapping("/bcdGenerator")
	 public String bcdGenerator() {
		 return "qrCodeGenerator";
	 }


	
}
