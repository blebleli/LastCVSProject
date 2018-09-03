<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 9. 03 조계환 최초 생성
*
* </pre>
*/ -->        
<style>

input[name='uImage'] {
  width :  110px;
  height : 140px;
}
</style> 

<!-- products-breadcrumb -->
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			   <!-- Collect the nav links, forms, and other content for toggling -->
		</div>
		<div class="w3l_banner_nav_right">
<!-- services -->
		<div class="services">
			<h3>매장찾기</h3>
			<div class="w3ls_service_grids">
				<div class="col-md-12 w3ls_service_grid_left">
					<h4>매장찾기</h4>
						<ul>
							<li>지역 별 매장 검색 또는 매장명 검색을 통하여 CU 매장 정보를 확인하실 수 있습니다.</li>
							<li>매장 유형 및 서비스 별 정보도 확인하실 수 있습니다.</li>
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
										<th scope="row">지역으로 검색</th>
										<td>										
												<select id="sido" name="sido" style="width:130px;" class="select" onchange="searchGugunList(this);">
												<option value="">선택</option>											
												<option value="경기도">경기도</option>													
												<option value="서울특별시">서울특별시</option>													
												<option value="경상남도">경상남도</option>													
												<option value="부산광역시">부산광역시</option>												
												<option value="인천광역시">인천광역시</option>													
												<option value="충청남도">충청남도</option>													
												<option value="강원도">강원도</option>													
												<option value="경상북도">경상북도</option>													
												<option value="충청북도">충청북도</option>													
												<option value="제주특별자치도">제주특별자치도</option>													
												<option value="대구광역시">대구광역시</option>												
												<option value="전라북도">전라북도</option>													
												<option value="대전광역시">대전광역시</option>													
												<option value="전라남도">전라남도</option>												
												<option value="광주광역시">광주광역시</option>													
												<option value="울산광역시">울산광역시</option>													
												<option value="세종특별자치시">세종특별자치시</option>
												
												</select>
												<!-- <input type="image" src="/images/store/btn_choice.png" title="선택" onClick="searchGugunList(); return false;"/> -->
										
												<span id="gugunSpan">
												<select id="Gugun" name="Gugun" style="width:180px;" class="select" onchange="selectedGugun(this);">
													<option value="">선택</option>
												</select>
												</span>
											
												<span id="dongSpan">
												<select id="Dong" class="select" style="width:180px;" onchange="selectedDong(this);">
													<option value="">선택</option>
												</select>
												</span>
											
											<button type="button" class="btn btn-primary">검색</button>																																		
											<button type="button" class="btn btn-default">초기화</button>		
										</td>										
									</tr>
									<tr>
										<th scope="row"><label for="store_name">매장명으로 검색</label></th>
										<td >
											<div class="col-lg-10 input-group">
											<!-- -->
      												<form action="/search/cvsSearchAction" method="post">
    		  											<span class="input-group-btn">
			   												<input type="text" class="form-control" name="searchWord"  placeholder="Search for...">
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
				<div class="col-md-12 w3ls_service_grid_left">
								<h4>검색결과</h4>
									<ul>
										<li>매장 유형 및 서비스</li>
									
									</ul>
					</div>
				</div>
	
				<div class="col-md-12 w3ls_service_grids2">
					<input type="image" name="uImage" src="/userImages/service_(9).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(10).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(11).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(12).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(13).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(14).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(15).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(16).png" alt="검색" onClick="usertsearchList(1); return false;" />
					<input type="image" name="uImage" src="/userImages/service_(17).png" alt="검색" onClick="usertsearchList(1); return false;" />
				</div>
				<div class="clearfix"> </div>
				<div class="col-md-6 w3ls_service_grids3">
				<table class="table">
					<thead>	
					<tr class="active">										
						<th>매장명 / 연락처	</th>
						<th>주소 / 매장 유형 및 서비스</th>
					</tr>						
					</thead>
					<tbody>									
						<c:forEach items="${searchCvsList }" var="vo">
							<tr>
								<td>
									${vo.mem_cvs_name}
									${vo.mem_cvs_tel }<br>
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
					    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
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
<script src="js/bootstrap.min.js"></script>
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
<script src="js/minicart.js"></script>
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
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new daum.maps.Map(mapContainer, mapOption); 
</script>
<!-- kakao map -->
