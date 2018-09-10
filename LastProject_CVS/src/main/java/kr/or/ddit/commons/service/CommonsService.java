package kr.or.ddit.commons.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.dao.CommonsDaoInf;
import kr.or.ddit.model.CategoryVo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service(value="commonService")
public class CommonsService implements CommonsServiceInf {
	
	@Resource(name="commonsDao")
	private CommonsDaoInf commonsDao;

	@Override
	public String getdataFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryVo> prodCtgyList() {
		return commonsDao.prodCtgyList();
	}
	
	/** 
	 * Method   : transformationAddr 
	 * 최초작성일  : 2018. 9. 8. 
	 * 작성자 : 조종원 
	 * 변경이력 : 신규
	 * @param 좌표로변경할 주소
	 * @return 주소에 해당하는 x, y 값
	 *         map.put("x","127.1231")
	 *         map.put("y","37.1231")
	 * Method 설명 : 현 한글 주소를 입력하면 그에 해당하는 x,y 좌표 반환
	 */
	@Override
	public Map<String, String > transformationAddr(String add){

		// 네이버 인증
		String clientId = "fcthGRlB7Lr5CweLuxjW";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "redlWMIaNo";//애플리케이션 클라이언트 시크릿값";
        Map<String, String> coordinate = new HashMap<String, String>();
        
        try {
//            String addr = URLEncoder.encode("대전광역시 중구 대흥동 500-5", "UTF-8");
            String addr = URLEncoder.encode(add, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/map/geocode?query=" + addr; //json
//            String apiURL = "https://openapi.naver.com/v1/map/geocode.xml?query=" + addr; // xml
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            String x = "";
            String y = "";
            while ((inputLine = br.readLine()) != null) {
            	
            	if (inputLine.contains("\"x\":")) {
            		coordinate.put("x",inputLine.replace("\"x\":", "").replace(",", "").trim() );
            	}
            	if (inputLine.contains("\"y\":")) {
            		coordinate.put("y",inputLine.replace("\"y\":", "").replace(",", "").trim() );
            	}
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return coordinate;
	}

}
