package kr.or.ddit.commons.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
            String str = "";
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
                str+=inputLine;
            }
            br.close();
            System.out.println(response.toString());
            
            
//            {    "result": {
//            				"total": 1,        "userquery": "대전광역시 중구 대흥동 500-5",        "items": [            
//            				                                                                                   {                "address": "대전광역시 중구 대흥동 500-5",                
//            				                                                                                	   "addrdetail": {                    "country": "대한민국",                    "sido": "대전광역시",                    "sigugun": "중구",                    "dongmyun": "대흥동",                    "ri": "",                    "rest": "500-5"                },                "isRoadAddress": false,                "point": {                    "x": 127.4202953,                    "y": 36.3251973                }            }        ]    }}

            
            // 네이버에서 받은 json 파일 데이터 가공
            
            JSONParser jsonParser = new JSONParser();
            
            //JSON데이터를 넣어 JSON Object 로 만들어 준다.
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
             
            //books의 배열을 추출
            JSONArray pointInfoArray = (JSONArray) jsonObject.get("point");
 
            System.out.println("* point *");
// 
            for(int i=0; i<pointInfoArray.size(); i++){
 
                System.out.println("=BOOK_"+i+" ===========================================");
                 
                //배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
                JSONObject bookObject = (JSONObject) pointInfoArray.get(i);
                 
                //JSON name으로 추출
                System.out.println("pointInfo: x==>"+bookObject.get("x"));
                System.out.println("pointInfo: y==>"+bookObject.get("y"));
            }
 
            JSONArray personInfoArray = (JSONArray) jsonObject.get("persons");
 
            System.out.println("\r\n* PERSONS *");
 
            for(int i=0; i<personInfoArray.size(); i++){
 
                System.out.println("=PERSON_"+i+" ===========================================");
                JSONObject personObject = (JSONObject) personInfoArray.get(i);
                System.out.println("personInfo: name==>"+personObject.get("name"));
                System.out.println("personInfo: age==>"+personObject.get("age"));
                System.out.println("personInfo: gender==>"+personObject.get("gender"));
                System.out.println("personInfo: nickname==>"+personObject.get("nickname"));
 
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
        
        return null;
	}

	

}
