<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<button id="btn">카카오 업로드 버튼</button>
<input type="file" id="file" multiple>

<a id="uploadUrl">uploadUrl</a>
    <script type='text/javascript'>

        Kakao.init('20ef2122f316faf3ee201ff1da312505');

        //카카오링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
        var kakaoImg = '';
        var btn = document.getElementById('btn');

        btn.onclick = function() {
         //var files = document.getElementById('file').files;
         //var arr = new ArrayBuffer(512);
         var view = new Uint8Array(${length});
     	
    	 <%
    		byte[] fc = (byte[])request.getAttribute("fileContent");
    		for(int i = 0; i < fc.length ; i++){
    			out.println("view[" + i + "] = " + fc[i]);
    		} 
    	 %>
         
     	  
         var files = [new File([view], 'asdf.jpg',{type: "image/jpeg"})];

         Kakao.Link.uploadImage({
             file: files
           }).then(function(res){
             document.getElementById('uploadUrl').value = res.infos.original.url;
             console.log(res.infos.original.url);
             kakaoImg = res.infos.original.url;
             console.log('kakaoImg-->'+kakaoImg);
             sendLink(kakaoImg);
           });
    	};
        
        function sendLink(kakaoImg){
          Kakao.Link.sendCustom({

      	        templateId: 12634,
      	        templateArgs: {
      	          'title': "${sessionScope.userInfo.mem_name}"+'고객님 // 구매한 상품 : '+${length},
      	          'content': '가격 : '+${length}+'유효기간 :'+'자세히 보기 : '+kakaoImg+'',
      	          'bcdImg' : document.getElementById('uploadUrl').value
      	        }
       		 });
         }



    </script>


     
	