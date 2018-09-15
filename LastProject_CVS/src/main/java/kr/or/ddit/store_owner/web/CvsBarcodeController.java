package kr.or.ddit.store_owner.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@Resource(name="stockService")
	private StockServiceInf stockService;
	
	
	@RequestMapping("/barcode")
	public String cvsBarcode(Model model){
		return "cvs_barcode_read";
	}
	
	/**
	* Method : barcodeScan
	* Method 설명 :입고 바코드를 스캔하거나 직접입력했을 때 입고리스트 정보 출력 메서드
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param barcodeValue
	* @param model
	* @return
	*/
	@RequestMapping(value="/barcodeScan", method={RequestMethod.GET,RequestMethod.POST})
	public String barcodeScan(@RequestParam(value="barcodeValue",defaultValue="")String barcodeValue,
							  Model model){
		
		//입고스캐너나 직접 입력을 통한 수불 바코드가 잘 가져오는지 확인 logger
		logger.debug("barcodeValue : {}   ",  barcodeValue);
		
		//받아온 수불 바코드로 그에 대한 제품 정보들을 List형태로 가져온다
		List<SupplyScanInfoVo>getSupplyScanInfoList = supplyService.getSupplyScanInfoList(barcodeValue);
		
		for (SupplyScanInfoVo supplyScanInfoVo : getSupplyScanInfoList) {
			logger.debug("supplyProdVo.getProd_name() : {}",supplyScanInfoVo.getProd_name());
			logger.debug("supplyScanInfoVo.getSupply_state() : {}",supplyScanInfoVo.getSupply_state());
		}
		
		model.addAttribute("state",getSupplyScanInfoList.get(0).getSupply_state());
		model.addAttribute("scanList",getSupplyScanInfoList);
		
		return "cvs_barcode_read";
	}
	
	@RequestMapping(value="/confirmed")
	public String supplyConfirmed(Model model){
		
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
		
		//받아온 img 데이타를 해석
		String[] stringPart = file.split(",");	
		Decoder decoder = Base64.getDecoder();
		byte[] fileByte = decoder.decode(stringPart[1]);
		
		Map<String, String> found = decode(fileByte);
		
		//메세지
		String returnMsg =found.get("returnMsg");
		
		//메세지 add
		logger.debug("returnMsg ------"+returnMsg);	
		mav.addObject("returnMsg", returnMsg);		
			
		//해석코드 add
		if(returnMsg.equals("decodedText")){
			String decoded = found.get("decodedText"); 
			
			//코드확인용
			mav.addObject("decodedText", decoded);				

	    	//입고리스트일때
	    	List<SupplyListVo> supplyList = supplyService.getListSupplyList(decoded);
 			mav.addObject("supplyList", supplyList);
	    	
	    	//상품바코드일때 처리(결제,주머니, 폐기)
 			PresentStockListVo prodVo = stockService.getBarcodeProd(decoded);
 			mav.addObject("prodVo", prodVo);
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
	 * Method 설명 : 바코드읽은 결과메세지를 map 형태로 반환하는 메서드
	 */
	private HashMap<String, String> decode(byte[] fileByte){
		
		HashMap<String, String> map = new HashMap<String, String>();
		ByteArrayInputStream by = new ByteArrayInputStream(fileByte);
		
		try {					//qr코드를 찾지 못한경우
	        String decodedText = decodeQRCode(by);
	        if(decodedText == null) {	        	
	        	logger.debug("No QR Code found in the image");
	            map.put("returnMsg", "noFound");
	            return map;	            
	        } else { 			//코드 해석한경우	        	
	        	logger.debug("Decoded text = " + decodedText);	
	        	map.put("returnMsg", "decodedText");
	        	map.put("decodedText", decodedText);	        	
          return map;
	        }
	    } catch (IOException e) { //코드를 해석하지 못했을경우 & 기타
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
