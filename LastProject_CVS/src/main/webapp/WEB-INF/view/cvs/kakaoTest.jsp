<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Login Demo - Kakao JavaScript SDK</title>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>

    <a id="kakao-login-btn"></a>
    <a href="http://developers.kakao.com/logout">로그아웃</a>
    
    <script type='text/javascript'>
    
	 

      //<![CDATA[
        // 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('20ef2122f316faf3ee201ff1da312505');
        // 카카오 로그인 버튼을 생성합니다.
        Kakao.Auth.createLoginButton({
          container: '#kakao-login-btn',
          success: function(authObj) {

                    Kakao.API.request({
                    	  url: '/v2/api/talk/memo/send',
                   		  data : {
                   			'template_id': 12634,
                   			'template_args':{ }
                   		  
                   		  },
                           success: function(res) {
                             alert(JSON.stringify(res));
                             //callbackFunc(res);
                           },
                           fail: function(error) {
                             alert(JSON.stringify(error));
                           }
                    })
          },
          
        
          fail: function(err) {
             alert(JSON.stringify(err));
          }
        });

        
        
    
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
        
        
      //]]>
    </script>
    
   <title> CVStore_owner| cvsStock </title> 
  

     
	