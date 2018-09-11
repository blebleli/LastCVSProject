<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/normalize.css' />" media="all"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/ion.rangeSlider.css' />" media="all"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/ion.rangeSlider.skinFlat.css' />" media="all"></link>
<script type="text/javascript"
	src="<c:url value='/js/jquery-1.12.3.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/js/ion.rangeSlider.js' />"></script>

<script> 
	$(function() {

		// 가격대 검색 바 설정
		$("#range").ionRangeSlider({
			hide_min_max : true,
			keyboard : true,
			min : 0,
			max : 50000,
			from : 1000,
			to : 5000,
			type : 'double',
			step : 2,
			prefix : "￦",
			grid : true
		});
		
		//category
		// 검색바 변경시 아래 가격 변경
		$("#range").on('change keyup paste', function() {

			var range = $("#range").val();

			var rangeSplit = range.split(";");
			$("#min_price").val(rangeSplit[0]);
			$("#max_price").val(rangeSplit[1]);

		});

		// ==;; 적용안됨...
		$("#min_price").on('change', function() {

			var min_price = $("#min_price").val();
			var range = $("#range").val();
			var rangeSplit = range.split(";");
			$("#range").val(min_price + ";" + rangeSplit[1]);

		});
		// ==;; 적용안됨...	
		$("#max_price").on('change', function() {

			var max_price = $("#max_price").val();
			var range = $("#range").val();
			var rangeSplit = range.split(";");

			$("#range").val(rangeSplit[0] + ";" + max_price);
		});
	});

	$(function() {

// 		이미지 클릭
		$("#prodImage").on("click", function(){
			$("#detailFrm").submit();
			console.log(prod_id);
		});

// 		더보기
		$("#nextPage").on("click", function(){
			
			// 카테고리
			var mealChk        =   $("#mealChk").val();
			var biscuitChk     =   $("#biscuitChk").val();
			var iceChk         =   $("#iceChk").val();
			var foodChk        =   $("#foodChk").val();
			var drinkChk       =   $("#drinkChk").val();
			var necessitiesChk =   $("#necessitiesChk").val();
			
			// 가격
			var min_price   = $("#min_price").val();
			var max_price   = $("#max_price").val();
			
			// 상품명
			var searchName  = $("#searchName").val();
			
			// 페이지
			var page = $("#page").val();
			if (page == 0) {
				page = 2; 
			}
			
			
			var pageSize = 24;
			// 페이지 종류
			var iKind = $("#iKind").val();
			
			$.ajax({
				url :"search",
				method :"get",
				data : {
					 "mealChk"        :   mealChk          		
			        ,"biscuitChk"     :   biscuitChk    
			        ,"iceChk"         :   iceChk        
			        ,"foodChk"        :   foodChk       
			        ,"drinkChk"       :   drinkChk      
			        ,"necessitiesChk" :   necessitiesChk
			
			        ,"min_price"      :   min_price
			        ,"max_price" 	  :   max_price
			        ,"searchName" 	  :   searchName
			        
			        ,"page"			  :   page
			        ,"pageSize"		  :	  pageSize
			        
			        , "iKind"         :   iKind
			 
			}, 
					
				success : function(responseData){
					
					
					console.log(responseData);
					var content = '';
					$.each(responseData, function(index,item){
						content += '		<div class="col-md-4 w3ls_w3l_banner_left liiist" name="liiist">'
							+'			<div class="hover14 column">'
							+'				<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">'
							+'					<div class="agile_top_brand_left_grid_pos">'
							+'					</div>'
							+'					<div class="agile_top_brand_left_grid1">'
							+'	<figure>'
							+'		<div class="snipcart-item block">'
							+'			<div class="snipcart-thumb">'
							+'				<a href="/userProd/detail?prod_id='+item.prod_id+'"	id="prodImage">'
							+'					 <img src="'+item.file_path+'/'+item.file_upname+'" alt=" " class="img-responsive" width="200px" height="150px" />'
							+'				</a>'
							+'				<p>' +item.prod_name +'</p>'
							+'				<h4>'+item.prod_price +'</h4>'
							+'			</div>'
							+'			<div class="snipcart-details">'
							+'				<form action="#" method="post">'
							+'					<fieldset>'
							+'						<input type="hidden" name="prod_id" value="'+item.prod_id+'" />'
							+'						<input type="submit" name="submit" value="Add to cart" class="button" />'
							+'					</fieldset>'
							+'				</form>'
							+'			</div>'
							+'		</div>'
							+'	</figure>'
							+'					</div>'
							+'				</div>'
							+'			</div>'
							+'		</div>';
					}); //$.each(responseData, function(index,item){
						$(".list").append(content);
						
					
	
					$("#page").val(parseInt(page) + 1);		
				} // success : function(responseData){
			});
		}); 

		//  검색
		$("#searchBtn").on("click", function(){
			
			// 카테고리
			var mealChk        =   $("#mealChk").val();
			var biscuitChk     =   $("#biscuitChk").val();
			var iceChk         =   $("#iceChk").val();
			var foodChk        =   $("#foodChk").val();
			var drinkChk       =   $("#drinkChk").val();
			var necessitiesChk =   $("#necessitiesChk").val();
			
			// 가격
			var min_price   = $("#min_price").val();
			var max_price   = $("#max_price").val();
			
			// 상품명
			var searchName  = $("#searchName").val();
			
			// 페이지
			var page = 1;
			var pageSize = 24;
			
			// 페이지 종류
			var iKind = $("#iKind").val();

			$.ajax({
				url :"search",
				method :"get",
				data : {
							 "mealChk"        :   mealChk          		
					        ,"biscuitChk"     :   biscuitChk    
					        ,"iceChk"         :   iceChk        
					        ,"foodChk"        :   foodChk       
					        ,"drinkChk"       :   drinkChk      
					        ,"necessitiesChk" :   necessitiesChk
					
					        ,"min_price"      :   min_price
					        ,"max_price" 	  :   max_price
					        ,"searchName" 	  :   searchName
					        
					        ,"page"			  :   page
					        ,"pageSize"		  :	  pageSize
					        
					        , "iKind"         :   iKind
					 
				},
				
				success : function(data){
					// 성공시 기존 내용 삭제
					$("#proList").html("");
					
					// 새로운 내용 담을 변수
					var content = '<div class="w3ls_w3l_banner_nav_center_grid1" id="proList"> <div class="list">';
					
					if (data == null) {
						content += '<div class="col-md-3 w3ls_w3l_banner_left liiist" name="liiist">'
						+'해당 상품이 없습니다.</div></div></div>';
					} else {
						
						$.each(data,function(index,item){
						content += '		<div class="col-md-4 w3ls_w3l_banner_left liiist" name="liiist">'
								+'			<div class="hover14 column">'
								+'				<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">'
								+'					<div class="agile_top_brand_left_grid_pos">'
								+'					</div>'
								+'					<div class="agile_top_brand_left_grid1">'
								+'	<figure>'
								+'		<div class="snipcart-item block">'
								+'			<div class="snipcart-thumb">'
								+'				<a href="/userProd/detail?prod_id='+item.prod_id+'"	id="prodImage">'
								+'					 <img src="'+item.file_path+'/'+item.file_upname+'" alt=" " class="img-responsive" width="200px" height="150px" />'
								+'				</a>'
								+'				<p>' +item.prod_name +'</p>'
								+'				<h4>'+item.prod_price +'</h4>'
								+'			</div>'
								+'			<div class="snipcart-details">'
								+'				<form action="#" method="post">'
								+'					<fieldset>'
								+'						<input type="hidden" name="prod_id" value="'+item.prod_id+'" />'
								+'						<input type="submit" name="submit" value="Add to cart" class="button" />'
								+'					</fieldset>'
								+'				</form>'
								+'			</div>'
								+'		</div>'
								+'	</figure>'
								+'					</div>'
								+'				</div>'
								+'			</div>'
								+'		</div>';
								
						});	// $.each(data,function(index,item){
							
						content += '</div>'
								+'<div class="clearfix"></div>'
								+'</div>';	
					}	// } else {
					$("#page").val("2");
					$("#proList").html(content);
				} // 	success : function(responseData){
			});	// $.ajax({
		});	 //$("#searchBtn").on("click", function(){

		$("#opoBtn").on("click", function() {
			$("#event_id").val("201");
			alert($("#event_id").val());
			$("#eventCtgyFrm").submit();
		})
		$("#tpoBtn").on("click", function() {
			$("#event_id").val("202");
			$("#eventCtgyFrm").submit();
		})
		$("#discountBtn").on("click", function() {
			$("#event_id").val("203");
			$("#eventCtgyFrm").submit();
		})
	});
		

// 카테고리 클릭 이벤트
$(document).ready(function(){
	
 	// 간편식사
 	$("#meal").on("click",function(){ 
// 		alert("간편식사");
		if( $("#mealLb").css("display") != "none" ) {
		    $("#mealLb").hide();
		    $("#mealChk").val("");
		} else {
		    $("#mealLb").show();
			$("#mealChk").val("간편식사");
		}
 	});
 	
 	// 과자류
 	$("#biscuit").on("click",function(){ 
//  		alert("과자류");
		if( $("#biscuitLb").css("display") != "none" ) {
		    $("#biscuitLb").hide();
		    $("#biscuitChk").val("");
		} else {
		    $("#biscuitLb").show();
	 		$("#biscuitChk").val("과자류");
		}
 	});
 	
 	// 음료
 	$("#drink").on("click",function(){
//  		alert("음료");
		if( $("#drinkLb").css("display") != "none" ) {
		    $("#drinkLb").hide();
		    $("#drinkChk").val("");
		} else {
		    $("#drinkLb").show();
	 		$("#drinkChk").val("음료");
		}
 	 });
 	
 	// 식품
 	$("#food").on("click",function(){ 
//  		alert("식품");
		if( $("#foodLb").css("display") != "none" ) {
		    $("#foodLb").hide();
		    $("#foodChk").val("");
		} else {
		    $("#foodLb").show();
	 		$("#foodChk").val("식품");
		}
 	});
 	
 	// 아이스크림
 	$("#ice").on("click",function(){ 
//  		alert("아이스크림");
		if( $("#iceLb").css("display") != "none" ) {
		    $("#iceLb").hide();
		    $("#iceChk").val("");
		} else {
		    $("#iceLb").show();
 			$("#iceChk").val("아이스크림");
		}
 	});
 	
 	// 생활용품
 	$("#necessities").on("click",function(){ 
//  		alert("생활용품");
		if( $("#necessitiesLb").css("display") != "none" ) {
		    $("#necessitiesLb").hide();
		    $("#necessitiesChk").val("");
		} else {
		    $("#necessitiesLb").show();
	 		$("#necessitiesChk").val("생활용품");
		}
 	});
  
});
		
		
</script>



<!-- products-breadcrumb -->
<!-- 	<div class="products-breadcrumb"> -->
<!-- 		<div class="container"> -->
<!-- 			<ul> -->
<!-- 				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li> -->
<!-- 				<li>상품</li> -->
<!-- 				<li>간편조리</li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- //products-breadcrumb -->

<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a
				href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
			<c:if test="${i =='1' }">
				<li>상품 소개 &nbsp; ▷ ${category.ctgy_name}</li>
			</c:if>
			<c:if test="${i =='2' }">
				<li>Best 상품 &nbsp; ▷ ${category.ctgy_name}</li>
			</c:if>
			<c:if test="${i =='3' }">
				<li>행사 상품 &nbsp; ▷ ${category.ctgy_name}</li>
			</c:if>
		</ul>
	</div>
</div>
<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->

<!-- 데이터 전송 -->
<form action="/userProd/detail" method="post" id="detailFrm">
	<input type="hidden" name="prod_id" value="${prod.prod_id }" />
</form>

<!-- 카테고리 & 더보기-->
<form>
	<input type="hidden" id="mealChk" value="">
	<input type="hidden" id="biscuitChk" value="">
	<input type="hidden" id="iceChk" value="">
	<input type="hidden" id="foodChk" value="">
	<input type="hidden" id="drinkChk" value="">
	<input type="hidden" id="necessitiesChk" value="">
	<input type="hidden" id="iKind" value="${i }">
	
	<input type="hidden" id="page" value="">
	
	<input type="hidden" id="index" value="1"> 
	<input type="hidden" id="i" value="${i }"> 
	<input type="hidden" id="level" value="${ctgylevel }">
	<input type="hidden" id="ctgy_id" value="${ctgy_id }">
	
</form>

<!-- 상단 배너 -->
<div class="agile_top_brands_grids">
	<div class="container">
				<!-- 이미지 부분 삭제 - jw -->
<!-- 			<div class="w3l_banner_nav_right_banner3"> -->
<!-- 								<br> -->
<!-- 			</div> -->
			<br>
			<div class="w3ls_w3l_banner_nav_right_grid">
				<!-- 이벤트 상품 관련 -->
				<c:if test="${i =='3' }">
					<form action="/userProd/eventList" method="get" id="eventCtgyFrm">
						<input type="button" class="col-md-4 btn btn-primary" name="event"
							id="opoBtn" value="1+1"> <input type="button"
							class="col-md-4 btn btn-primary" name="event" id="tpoBtn"
							value="2+1"> <input type="button"
							class="col-md-4 btn btn-primary" name="event" id="discountBtn"
							value="할인"> <input type="hidden" id="event_id"
							name="event_id">
						<c:if test="${category != null }">
							<input type="hidden" name="ctgy_id" value="${ctgy_id }">
							<input type="hidden" name="level" value="${ctgylevel }">
						</c:if>
					</form>
				</c:if>
				<!-- 이벤트 상품 관련 -->

				<br> <br> <br>
				<c:if test="${i =='1' }">
					<h3>
						상품 소개&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}
					</h3>
				</c:if>
				<c:if test="${i =='2' }">
					<h3>
						Best 상품&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}
					</h3>
				</c:if>
				<c:if test="${i =='3' }">
					<h3>
						행사 상품&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}
					</h3>
				</c:if>
				<!-- 상단 배너 -->



				<form id="searchFrm">
						<div class="w3ls_service_grids">
							<div class="col-md-15 w3ls_service_grid_left">
								<h4>상품 검색</h4>
								<table summary="CU 매장 검색">
									<%-- 								<caption></caption> --%>
									<colgroup>
										<col style="width: 27%;" />
										<col style="width: 79%;" />
										<col style="width: 24%;" />
									</colgroup>
									<tbody>

									<!-- 카테고리 -->
										<tr>
											<th scope="row" rowspan="2" align="center">카테고리</th>
											<td>
												<div>
												<!-- 간편식사 -->
													<div style="float: left; width: 16%;">
														<img id="meal" 	  src="/images/category/ca_meal.png"         width ="60px" height ="55px" /><br/>
														<label id="mealLb"  hidden="true">[간편식사]</label>
													</div>
												<!-- 과자류 -->
													<div style="float: left; width: 16%;">
														<img id="biscuit" src="/images/category/ca_biscuit.jpg"	     width ="60px" height ="55px" /><br/>
														<label id="biscuitLb"   hidden="true">[과자류]</label>
													</div>
												<!-- 아이스크림 -->
													<div style="float: left; width: 16%;"> 
														<img id="ice"     src="/images/category/ca_ice.jpg"		     width ="60px" height ="55px" /><br/>
														<label id="iceLb"   hidden="true">[아이스크림]</label>
													</div>
												<!-- 식품 -->
													<div style="float: left; width: 16%;">                                                            
														<img id="food"    src="/images/category/ca_food.jpg"		 width ="60px" height ="55px" /><br/>
														<label id="foodLb"  hidden="true">[식품]</label>
													</div>
												<!-- 음료 -->
													<div style="float: left; width: 16%;">                                                               
														<img id="drink"   src="/images/category/ca_drink.jpg"		 width ="60px" height ="55px" /><br/>
														<label id="drinkLb"  hidden="true">[음료]</label>
													</div>
												<!-- 생활용품 -->
													<div style="float: left; width: 16%;">
														<img id="necessities"  src="/images/category/ca_necessities.png"	width ="55px" height ="55px" /><br/>
														<label id="necessitiesLb"  hidden="true">[생활용품]</label>
													</div>
												</div>
											</td>
										</tr>
										<tr>
											<td>
											<br><br>
											</td>
											
										</tr>
										<!-- 가격 -->									
										<tr>
											<th scope="row" rowspan="2" align="center">금액</th>
											<br>
											<td>
												<div style="position: relative;">
													<div>
														<input type="hidden" id="range" value="" name="range"
															class="irs-hidden-input" tabindex="-1"> <br /> <br />
													</div>
												</div>
											</td>

										</tr>
										<tr>
											<td><input type="number" id="min_price" style="width: 30%">원 &nbsp; ~ &nbsp; 
											<input type="number" id="max_price" style="width: 30%">원 &nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td><br /> <br /></td>
										</tr>
										
										<!-- 상품명 -->
										<tr>
											<th scope="row"><label for="store_name">상품명</label></th>
											<td >
												<div class="form-row">
													<!--       												<form action="#" method="get"> -->
													<!--     		  											<span class="input-group-btn"> -->
													<input type="text" class="form-control" id="searchName" placeholder="Search for..." style="width: 90%">
													<!-- 		      												<button class="btn btn-default" type="submit">Go!</button> -->
													<!-- 	      												</span> -->
													<!--       												</form> -->
												</div>


											</td>
											<td><input type="button" id="searchBtn" name="psBtn" class="btn btn-default" value="검색"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
				</form>

				<!-- ========================================================================================================================= -->
				<div class="w3ls_w3l_banner_nav_center_grid1" id="proList">
					<div class="list">
						<c:if test="${ctgyProdList == null }">
							<div class="col-md-3 w3ls_w3l_banner_left liiist" name="liiist">
								해당 상품이 없습니다.</div>
						</c:if>
						<c:forEach items="${ctgyProdList }" var="prod">

							<div class="col-md-4 w3ls_w3l_banner_left liiist" name="liiist">
								<div class="hover14 column">
									<div
										class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
										<div class="agile_top_brand_left_grid_pos">
											<%-- 									<img src="${prod.file_path }/${ prod.file_upname }" alt=" " class="img-responsive" width="300px" height="200px" align="middle"/> --%>
										</div>
										<div class="agile_top_brand_left_grid1">
											<figure>
												<div class="snipcart-item block">
													<div class="snipcart-thumb">
														<a href="/userProd/detail?prod_id=${prod.prod_id }"
															id="prodImage"> <img
															src="${prod.file_path }/${ prod.file_upname }" alt=" "
															class="img-responsive" width="200px" height="150px" />
														</a>
														<p>${prod.prod_name }</p>
														<h4>${prod.prod_price }</h4>
													</div>
													<div class="snipcart-details">
														<form action="#" method="post">
															<fieldset>
																<input type="hidden" name="prod_id"
																	value="${prod.prod_id }" /> <input type="submit"
																	name="submit" value="Add to cart" class="button" />
															</fieldset>
														</form>
													</div>
												</div>
											</figure>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					
					<div class="clearfix"></div>
				</div>
				<!-- ========================================================================================================================= -->
						<input type="button" id="nextPage" value="더보기">
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //banner -->
