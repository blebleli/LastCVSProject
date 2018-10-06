<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Login Demo - Kakao JavaScript SDK</title>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

<a id="kakao-link-btn" href="javascript:sendLink()">
<img src="//developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
</a>
<a href="http://developers.kakao.com/logout">로그아웃</a>
<script type='text/javascript'>

  //<![CDATA[

    Kakao.init('20ef2122f316faf3ee201ff1da312505');

    function sendLink() {
      Kakao.Link.sendCustom({
        templateId: 12634,
        templateArgs: {
          'title': "${sessionScope.userInfo.mem_name}"+' 고객님',
          'content': '바코드 : BCD-22e7cf9c-df06-45dc-b523-586ad9c5d5ee',
          'bcdImg' : 'http://172.30.1.36:8180/barcode/stock/BCD-22e7cf9c-df06-45dc-b523-586ad9c5d5ee.jpg'
        }
      });
    }
  //]]>

  
  
  
  function callbackFunc(respData){
  	console.log("콜백확인--> "+respData.access_token);
  	
  	$.ajax({
  		beforeSend: function(xhr) { 
  			console.log("발송test"+respData.access_token);
        xhr.setRequestHeader("Authorization", "Bearer "+respData.access_token+"");
    },
    contentType: "application/json;charset=UTF-8",
    Authorization: "Bearer "+respData.access_token,
	url : "https://kapi.kakao.com/v2/api/talk/memo/send",
	method : "POST",
	
	data: {
		
		  "object_type": "feed",
		  "content": {
		    "title": "카카오톡 링크 4.0",
		    "description": "디폴트 템플릿 FEED",
		    "image_url": "http://k.kakaocdn.net/dn/RY8ZN/btqgOGzITp3/uCM1x2xu7GNfr7NS9QvEs0/kakaolink40_original.png",
		    "link": {
		    "web_url": "https://developers.kakao.com",
		    "mobile_web_url": "https://developers.kakao.com"
		    }
		  },
		  "button_title": "바로 확인"
		},

	success:function(responseData){
		console.log("성공");
	}
	
});	    	
  };
        

    </script>
    
   <title> CVStore_owner| cvsStock </title> 
  

     
	