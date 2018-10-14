<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- /**
* @Class Name : cvsSearch.jsp
*
* @author 조계환
* @since 2018. 9. 03
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일     수정자 수정내용
* ---------- ------ ------------------------
* 2018.09.03 조계환 최초 생성
* 2018.09.05 조종원	지도,상세검색,리스트 추가및수정
*
* </pre>
*/ -->        
<style>

.result_search .service {
	overflow: hidden;
}

.service .result_txt {
	overflow: hidden;
	margin-bottom: 15px;
}

.service .result_txt h4 {
	background: url("../images/icon/bullet_purple.png") no-repeat 0 0;
	float: left;
	font-size: 1.231em;
	font-weight: normal;
	padding-left: 17px;
}

.service .result_txt p {
	float: right;
}

.service .result_txt span {
	color: #782d91;
	text-decoration: underline;
}

.service .list_service {
	overflow: hidden;
	margin-bottom: 25px;
}

.service .list_service ul {
	overflow: hidden;
	border-top: 2px solid #1e1e1e;
	border-bottom: 1px solid #dadada;
	height: 140px;
}

.service .list_service ul li {
	background: url("../images/common/bg_diagonal_228.gif") repeat-x 0 0;
	display: block;
	float: left;
	border-left: 1px solid #dadada;
	height: 140px;
	width: 119px;
}

.service .list_service ul li:first-child {
	border-left: none;
}

.list_service .group_service {
	overflow: hidden;
	margin: 0 auto;
	padding-top: 20px;
	width: 70px;
}

.list_service .group_service a {
	display: block;
	overflow: hidden;
	text-align: center;
}

.list_service .group_service .emblem {
	margin-bottom: 14px;
	height: 65px;
	width: 65px;
}

.list_service .group_service .emblem.on img {
	margin-top: -66px;
}

.list_service .group_service .text {
	letter-spacing: -1px;
	line-height: 1em;
}

</style> 
<script>
var ctgys =[];

function myFunc(e, ctgy) {
	var cvsList =[];
    if(e.className == 'emblem') {
		ctgys.push(ctgy);
		console.log(ctgys);
        e.className = 'emblem on';
			$.ajax({
				url : "/search/cvsServiceSearch",
				method : "post",
   				data : JSON.stringify(ctgys),
   				contentType: "application/json",
   				success : function(data){
   					$("#table > tbody").empty();
   					$.each(data, function(index, item){
	   					$("#table > tbody").append('<tr name="cvsTr">'+
	   												'<td class="nameAndTel">'+
														item.mem_cvs_name+'/'+
														item.mem_cvs_tel+'<br>'+
														'</td>'+
													'<td class="addrAndService">'+
														item.mem_addr+'<br>'+
													'</td>'+
													'<td>'+
														'<input type="hidden" name="mem_x" id="mem_x" class="mem_x" value="'+item.mem_x+'">'+
														'<input type="hidden" name="mem_y" id="mem_y" class="mem_y" value="'+item.mem_y+'">'+
														'<button id ="clickCvs" name="clickCvs" onclick="fn_click(${vo.mem_x}, ${vo.mem_y});">위치</button>'+
													'</td>'+
												'</tr>');
   						
   					});
   				}
			}); //ajax end
    } else {
        e.className = 'emblem';
        ctgys = jQuery.grep(ctgys, function(value){
        	return value != ctgy;
        });
        console.log(ctgys.length);
        $.ajax({
			url : "/search/cvsServiceSearch",
			method : "post",
				data : JSON.stringify(ctgys),
				contentType: "application/json",
				success : function(data){
					$("#table > tbody").empty();
					$.each(data, function(index, item){
   					$("#table > tbody").append('<tr name="cvsTr">'+
   												'<td class="nameAndTel">'+
													item.mem_cvs_name+'/'+
													item.mem_cvs_tel+'<br>'+
													'</td>'+
												'<td class="addrAndService">'+
													item.mem_addr+'<br>'+
												'</td>'+
												'<td>'+
													'<input type="hidden" name="mem_x" id="mem_x" class="mem_x" value="'+item.mem_x+'">'+
													'<input type="hidden" name="mem_y" id="mem_y" class="mem_y" value="'+item.mem_y+'">'+
													'<button id ="clickCvs" name="clickCvs" onclick="fn_click(${vo.mem_x}, ${vo.mem_y});">위치</button>'+
												'</td>'+
											'</tr>');
						
					});
				}
		}); //ajax end
    }
}

function searchList(pageNo){

	$('#pageIndex').val(pageNo);
	$.ajax({
		type:"post",
		url: "/store/list_Ajax.do",
			dataType: 'html',
		data: $('#listForm').serialize(),
		success: function(data){
			$('#dataTable').remove();
			$('#dataTableTop').append(data);
			//searchGugunList();
		},
		error : function(data){
			alert('정보를 가져 오던 중 오류가 발생하였습니다.');
		}
	});
}

</script>

<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i> <a
				href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
			<li>전국 편의점 찾기</li>
		</ul>
	</div>
</div>
<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->

<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			   <!-- Collect the nav links, forms, and other content for toggling -->
		</div>
		<div class="w3l_banner_nav_right">
<!-- services -->
		<div class="services">
<!-- 			<h3>매장찾기</h3> -->
			<div class="w3ls_service_grids">
				<div class="col-md-12 w3ls_service_grid_left">
					<h4>매장 검색</h4>
						<ul>
							<li></li>
						</ul>
				</div>
				<div class="col-md-12 w3ls_service_grid_left">
							<table summary="CU 매장 검색">
								<caption>CU 매장 검색</caption>
								<colgroup>
									<col style="width:17%;" />
									<col style="width:69%;" />
									<col style="width:14%;" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row"><label for="store_name">검색</label></th>
										<td >
											<div class="col-lg-10 input-group">
											<!-- -->
      												<form action="/search/cvsSearchAction" method="get" id="searchFrm">
    		  											<span class="input-group-btn">
			   												<input type="text" class="form-control" name="searchWord" id="searchWord"  placeholder="Search for...">
		      												<button class="btn btn-default" type="submit">Go!</button>
	      												</span>
      												</form>
   											</div>								
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					
					<!--// 매장검색 -->
				<div class="clearfix"> </div>
				<br>
				<br>
			</div>
	
			<div class="col-md-12 w3ls_service_grids2">
				<div id="dataTable">
					<div id="result_search" class="result_search">
						<div class="tit_h3">
							<h3>검색 결과</h3>
						</div>
						<!-- 서비스유형선택 -->
						<div class="service">
							<div class="result_txt">
								<h4>매장 유형 및 서비스</h4>
							</div>
							<div class="list_service">
								<ul>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500001'); return false;"><img src="/images/store/icon_big_01_hour.png" alt=""></a><!-- 선택한a태그 class="on" 추가 -->
											<a class="text" href="#" onclick="myFunc(this); return false;">24시간</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500002'); return false;"><img src="/images/store/icon_big_02_delivery.png" alt=""></a>
											<a class="text" href="#" onclick="myFunc(this); return false;">택배 서비스</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500003'); return false;"><img src="/images/store/icon_big_03_bakery.png" alt=""></a>
											<a class="text" href="#" onclick="myFunc(this); return false;">베이커리 판매</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500004'); return false;"><img src="/images/store/icon_big_04_fried.png" alt=""></a>
											<a class="text" href="#" onclick="myFunc(this); return false;">튀김 판매</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500005'); return false;"><img src="/images/store/icon_big_05_coffee.png" alt=""></a>
											<a class="text" href="#" onclick="myFunc(this); return false;">에스프레소<br>커피 판매</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500006'); return false;" ><img src="/images/store/icon_big_06_lotto.png" alt=""></a>
											<a class="text" href="#"  onclick="myFunc(this); return false;">로또 판매</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500007'); return false;"><img src="/images/store/icon_big_07_toto.png" alt=""></a>
											<a class="text" href="#"   onclick="myFunc(this); return false;">스포츠토토</a>
										</div>
									</li>
									<li>
										<div class="group_service">
											<a class="emblem" href="#" onclick="myFunc(this,'CVS1234500008'); return false;"><img src="/images/store/icon_big_08_cash.png" alt=""></a>
											<a class="text" href="#"   onclick="myFunc(this); return false;">현금지급기</a>
										</div>
									</li>
								</ul>
							</div>
						</div>
				
					</div>
				</div>
			</div>
				



				<div class="clearfix"> </div>
				<div class="col-md-6 w3ls_service_grids3">
				<table class="table" id="table">
					<thead>	
					<tr class="active">										
						<th>매장명 / 연락처	</th>
						<th>주소 / 매장 유형 및 서비스</th>
						<th>지도 찾기</th>
					</tr>						
					</thead>
					<tbody>	
						<c:forEach items="${CvsPageList}" var="vo">
							<tr name="cvsTr">
								<td class="nameAndTel">
									${vo.mem_cvs_name}/
									${vo.mem_cvs_tel}<br>
								</td>
								<td class="addrAndService">
									${vo.mem_addr}<br>
								</td>
								<td>
									<input type="hidden" name="mem_x" id="mem_x" class="mem_x" value="${vo.mem_x}">
									<input type="hidden" name="mem_y" id="mem_y" class="mem_y" value="${vo.mem_y}">
									<button id ="clickCvs" name="clickCvs" onclick="fn_click(${vo.mem_x}, ${vo.mem_y});">위치</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
				
				<div class="col-md-6 w3ls_service_grids3">
				<table class="table">					
					<tr class="active">										
						<th>오시는길	</th>		
					</tr>						
				</table>
				</div>
				
				<div class="col-md-6 w3ls_service_grids3">
					 <div id="map" style="width:100%;height:450px;"></div>
				</div>
				
				<div class="clearfix"> </div>
				<div class="col-md-6 w3ls_service_grid_left">
					<nav>
					  <ul class="pagination">
					    	${pageNavi}
					  </ul>
					</nav>										
				</div>
			</div>
		</div>
	</div>
<!-- //services -->
	
		<div class="clearfix"></div>

<!-- //banner -->

<!-- Bootstrap Core JavaScript -->
<script src="js/common/bootstrap.min.js"></script>

<script>
<!-- 편의점 서비스 카테고리 이벤트 -->
	function fn_usertsearchList(num){
		
	}
	
	// 위치 클릭했을때..
	function fn_click(mem_x, mem_y){
			
		//소수로 형변환
		var pointx = parseFloat(mem_x);
		//소수로 형변환
		var pointy = parseFloat(mem_y);

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
				center: new daum.maps.LatLng(pointy, pointx), // 지도의 중심좌표
		        level: 1 // 지도의 확대 레벨
		    };
		
		var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new daum.maps.LatLng(pointy, pointx); 
		
		// 마커를 생성합니다
		var marker = new daum.maps.Marker({
		    position: markerPosition
		});
		
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	}
	
// 	$(function click(e) {
// 		$('[name="clickCvs"]').on("click",function(){
// 			var mem_x = $('[name="mem_x"]').val();
// 			var mem_y = $('[name="mem_y"]').val();
			
// 			var pointx = parseFloat(mem_x);
// 			var pointy = parseFloat(mem_y);
// 			alert("좌표x"+pointx+"좌표y"+pointy);
// 			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
// 		    mapOption = { 
// 		        center: new daum.maps.LatLng(pointy, pointx), // 지도의 중심좌표
// 		        level: 3 // 지도의 확대 레벨
// 		    };

// 			// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
// 			var map = new daum.maps.Map(mapContainer, mapOption);
// 		});
// 	});
	
</script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->

<!-- //here ends scrolling icon -->
<script src="js/common/minicart.js"></script>


<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>

<!-- kakao map -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=20ef2122f316faf3ee201ff1da312505"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(36.283590305629914, 127.46614533232156), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption); 
</script>
<!-- kakao map -->
