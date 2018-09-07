<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:500px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}

.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
.wrap * {padding: 0;margin: 0;}
.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
.info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
.info .close:hover {cursor: pointer;}
.info .body {position: relative;overflow: hidden;}
.info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.info .link {color: #5085BB;}
</style>



<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form action="/search/prodSearch">
                    키워드 : <input type="text" value="" id="prodSearch" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <!-- 제품으로 변경  -->

<!--         <ul id="placesList"> -->
        <ul id="searchList">
        	<c:forEach items="${searchList }" var="vo">
        		<li>
			    <div class="body"> 
			           <div class="img">
			           <!-- 임시주석 -->
<%-- 		                	<img src="${vo.file_path +'/'+vo.file_name   }" width="73" height="70"/> --%>
			           </div> 
			           <div class="desc"> 
			               <div class="ellipsis">제품 : ${vo.prod_name }</div> 
			               <div class="jibun ellipsis">${vo.prod_intro }</div> 
			           </div>
	   		    </div>
	   		    <input type="hidden" name="prod_id" value="${vo.prod_id }">
        		</li>
         	</c:forEach>
        </ul>
        
        
        <ul id="searchList"></ul>
        <div id="pagination"></div>
    </div>
</div>
 ${memList }


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20ef2122f316faf3ee201ff1da312505&libraries=services"></script>

<script>

var MARKER_WIDTH = 33, // 기본, 클릭 마커의 너비
MARKER_HEIGHT = 36, // 기본, 클릭 마커의 높이
OFFSET_X = 12, // 기본, 클릭 마커의 기준 X좌표
OFFSET_Y = MARKER_HEIGHT, // 기본, 클릭 마커의 기준 Y좌표
OVER_MARKER_WIDTH = 40, // 오버 마커의 너비
OVER_MARKER_HEIGHT = 42, // 오버 마커의 높이
OVER_OFFSET_X = 13, // 오버 마커의 기준 X좌표
OVER_OFFSET_Y = OVER_MARKER_HEIGHT, // 오버 마커의 기준 Y좌표
SPRITE_MARKER_URL = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markers_sprites2.png', // 스프라이트 마커 이미지 URL
SPRITE_WIDTH = 126, // 스프라이트 이미지 너비
SPRITE_HEIGHT = 146, // 스프라이트 이미지 높이
SPRITE_GAP = 10; // 스프라이트 이미지에서 마커간 간격

var markerSize = new daum.maps.Size(MARKER_WIDTH, MARKER_HEIGHT), // 기본, 클릭 마커의 크기
markerOffset = new daum.maps.Point(OFFSET_X, OFFSET_Y), // 기본, 클릭 마커의 기준좌표
overMarkerSize = new daum.maps.Size(OVER_MARKER_WIDTH, OVER_MARKER_HEIGHT), // 오버 마커의 크기
overMarkerOffset = new daum.maps.Point(OVER_OFFSET_X, OVER_OFFSET_Y), // 오버 마커의 기준 좌표
spriteImageSize = new daum.maps.Size(SPRITE_WIDTH, SPRITE_HEIGHT); // 스프라이트 이미지의 크기

var positions = [  // 마커의 위치
//     new daum.maps.LatLng(126.82453038844578, 35.20188756879909),
//     new daum.maps.LatLng(33.450579, 126.56956),
//     new daum.maps.LatLng(33.4506468, 126.5707)
],
selectedMarker = null; // 클릭한 마커를 담을 변수

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
mapOption = { 
    center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
};

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

//지도 위에 마커를 표시합니다
// for (var i = 0, len = positions.length; i < len; i++) {
// var gapX = (MARKER_WIDTH + SPRITE_GAP), // 스프라이트 이미지에서 마커로 사용할 이미지 X좌표 간격 값
//     originY = (MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 기본, 클릭 마커로 사용할 Y좌표 값
//     overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 오버 마커로 사용할 Y좌표 값
//     normalOrigin = new daum.maps.Point(0, originY), // 스프라이트 이미지에서 기본 마커로 사용할 영역의 좌상단 좌표
//     clickOrigin = new daum.maps.Point(gapX, originY), // 스프라이트 이미지에서 마우스오버 마커로 사용할 영역의 좌상단 좌표
//     overOrigin = new daum.maps.Point(gapX * 2, overOriginY); // 스프라이트 이미지에서 클릭 마커로 사용할 영역의 좌상단 좌표
    
// // 마커를 생성하고 지도위에 표시합니다
// addMarker(positions[i], normalOrigin, overOrigin, clickOrigin);
// }

//마커를 생성하고 지도 위에 표시하고, 마커에 mouseover, mouseout, click 이벤트를 등록하는 함수입니다
function addMarker(position, normalOrigin, overOrigin, clickOrigin) {
// alert("마커를 생성하고 지도 위에 표시하고, 마커에 mouseover, mouseout, click 이벤트를 등록하는 함수입니다");
// 기본 마커이미지, 오버 마커이미지, 클릭 마커이미지를 생성합니다
var normalImage = createMarkerImage(markerSize, markerOffset, normalOrigin),
    overImage = createMarkerImage(overMarkerSize, overMarkerOffset, overOrigin),
    clickImage = createMarkerImage(markerSize, markerOffset, clickOrigin);

// 마커를 생성하고 이미지는 기본 마커 이미지를 사용합니다
var marker = new daum.maps.Marker({
    map: map,
    position: position,
    image: normalImage
});

// 마커 객체에 마커아이디와 마커의 기본 이미지를 추가합니다
marker.normalImage = normalImage;

// 마커에 mouseover 이벤트를 등록합니다
daum.maps.event.addListener(marker, 'mouseover', function() {

    // 클릭된 마커가 없고, mouseover된 마커가 클릭된 마커가 아니면
    // 마커의 이미지를 오버 이미지로 변경합니다
    if (!selectedMarker || selectedMarker !== marker) {
        marker.setImage(overImage);
    }
});

// 마커에 mouseout 이벤트를 등록합니다
daum.maps.event.addListener(marker, 'mouseout', function() {

    // 클릭된 마커가 없고, mouseout된 마커가 클릭된 마커가 아니면
    // 마커의 이미지를 기본 이미지로 변경합니다
    if (!selectedMarker || selectedMarker !== marker) {
        marker.setImage(normalImage);
    }
});

// 마커에 click 이벤트를 등록합니다
daum.maps.event.addListener(marker, 'click', function() {

    // 클릭된 마커가 없고, click 마커가 클릭된 마커가 아니면
    // 마커의 이미지를 클릭 이미지로 변경합니다
    if (!selectedMarker || selectedMarker !== marker) {

        // 클릭된 마커 객체가 null이 아니면
        // 클릭된 마커의 이미지를 기본 이미지로 변경하고
        !!selectedMarker && selectedMarker.setImage(selectedMarker.normalImage);

        // 현재 클릭된 마커의 이미지는 클릭 이미지로 변경합니다
        marker.setImage(clickImage);
    }

    // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
    selectedMarker = marker;
});

//마커 위에 커스텀오버레이를 표시합니다
//마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay = new daum.maps.CustomOverlay({
 content: content,
 map: map,
 position: marker.getPosition()       
});

//마커를 클릭했을 때 커스텀 오버레이를 표시합니다
daum.maps.event.addListener(marker, 'click', function() {
 overlay.setMap(map);
});
}

//MakrerImage 객체를 생성하여 반환하는 함수입니다
function createMarkerImage(markerSize, offset, spriteOrigin) {
// 	alert("MakrerImage 객체를 생성하여 반환하는 함수입니다");
var markerImage = new daum.maps.MarkerImage(
    SPRITE_MARKER_URL, // 스프라이트 마커 이미지 URL
    markerSize, // 마커의 크기
    {
        offset: offset, // 마커 이미지에서의 기준 좌표
        spriteOrigin: spriteOrigin, // 스트라이프 이미지 중 사용할 영역의 좌상단 좌표
        spriteSize: spriteImageSize // 스프라이트 이미지의 크기
    }
);

return markerImage;
}

var content="";

	$(document).ready(function(){
		// 제품 리스트 클릭 했을때
		$("#searchList li").on("click",function(){
			// 해당 제품 id 가져옴
			var prod_id = $("#searchList li [name=prod_id]").val();
			
		    $.ajax({
		        type:"get",
		        url:"search/storeSearch",
		        data : {"prod":prod_id},
		        dataType : "json",
		        success: function(data){
		        	
// 		        	alert("성공"+data);
		        	 $.each(data,function(index,item){
						// 리턴 받은 값 (좌표) set
						positions.push(new daum.maps.LatLng(item.mem_y,item.mem_x));
						alert(item.mem_x + " : " + item.mem_y);
						// 커스텀 오버레이에 표시할 컨텐츠 입니다
						// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
						// 별도의 이벤트 메소드를 제공하지 않습니다 
						content = '<div class="wrap">' + 
						            '    <div class="info">' + 
						            '        <div class="title">' + 
						            '            '+item.mem_cvs_name +
						            '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' + 
						            '        </div>' + 
						            '        <div class="body">' + 
						            '            <div class="img">' +
						            '                <img src="'+item.file_path+'/'+file_upname+'.'+file_dot+'" width="73" height="70">' +
// 						            '                <img src="http://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">' +
						            '            </div>' + 
						            '            <div class="desc">' + 
						            '                <div class="ellipsis">수량 : '+item.stcklist_amount+'</div>' + 
						            '                <div class="jibun ellipsis">(우)'+item.mem_zip+'(지번) '+item.mem_add+'</div>' + 
// 						            '                <div><a href="http://www.kakaocorp.com/main" target="_blank" class="link">상세보기? 링크</a></div>' + 
						            '            </div>' + 
						            '        </div>' + 
						            '    </div>' +    
						            '</div>';
		        	 });
		        	 
		        	 
// 		        	 alert(positions.length);
		        	//지도 위에 마커를 표시합니다
		        	 for (var i = 0, len = positions.length; i < len; i++) {
// 		        	     alert("지도 위에 마커를 표시합니다");
		        	 var gapX = (MARKER_WIDTH + SPRITE_GAP), // 스프라이트 이미지에서 마커로 사용할 이미지 X좌표 간격 값
		        	     originY = (MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 기본, 클릭 마커로 사용할 Y좌표 값
		        	     overOriginY = (OVER_MARKER_HEIGHT + SPRITE_GAP) * i, // 스프라이트 이미지에서 오버 마커로 사용할 Y좌표 값
		        	     normalOrigin = new daum.maps.Point(0, originY), // 스프라이트 이미지에서 기본 마커로 사용할 영역의 좌상단 좌표
		        	     clickOrigin = new daum.maps.Point(gapX, originY), // 스프라이트 이미지에서 마우스오버 마커로 사용할 영역의 좌상단 좌표
		        	     overOrigin = new daum.maps.Point(gapX * 2, overOriginY); // 스프라이트 이미지에서 클릭 마커로 사용할 영역의 좌상단 좌표
			        	 // 마커를 생성하고 지도위에 표시합니다
			        	 addMarker(positions[i], normalOrigin, overOrigin, clickOrigin);
		        	 }

		        	
		        }
			    ,error:function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력

			    	alert("실패");

			    }

		    });
		});
	});

</script>
