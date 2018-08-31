<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WTM 좌표를 WGS84 좌표로 변환하기</title>
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1a86c13675d3569a4fd7deb5ce9531b8&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption);

var geocoder = new daum.maps.services.Geocoder(), // 좌표계 변환 객체를 생성합니다
    wtmX = 160082.538257218, // 변환할 WTM X 좌표 입니다
    wtmY = -4680.975749087054; // 변환할 WTM Y 좌표 입니다

// WTM 좌표를 WGS84 좌표계의 좌표로 변환합니다
geocoder.transCoord(wtmX, wtmY, transCoordCB, {
    input_coord: daum.maps.services.Coords.WTM, // 변환을 위해 입력한 좌표계 입니다
    output_coord: daum.maps.services.Coords.WGS84 // 변환 결과로 받을 좌표계 입니다 
});

// 좌표 변환 결과를 받아서 처리할 콜백함수 입니다.
function transCoordCB(result, status) {

    // 정상적으로 검색이 완료됐으면 
    if (status === daum.maps.services.Status.OK) {

        // 마커를 변환된 위치에 표시합니다
        var marker = new daum.maps.Marker({
            position: new daum.maps.LatLng(result[0].y, result[0].x), // 마커를 표시할 위치입니다
            map: map // 마커를 표시할 지도객체입니다
        })
    }
}
</script>
<button id="xy">버튼 클릭</button>
</body>
</html>