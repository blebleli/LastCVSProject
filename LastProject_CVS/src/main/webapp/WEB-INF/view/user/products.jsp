<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/normalize.css' />" media="all"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/ion.rangeSlider.css' />" media="all"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/ion.rangeSlider.skinFlat.css' />" media="all"></link>
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/ion.rangeSlider.js' />"></script>

<script>



$(function () {

	// 가격대 검색 바 설정
    $("#range").ionRangeSlider({
        hide_min_max: true,
        keyboard: true,
        min: 0,
        max: 50000,
        from: 1000,
        to: 5000,
        type: 'double',
        step: 2,
        prefix: "￦",
        grid: true
    });
    
	
	// 검색바 변경시 아래 가격 변경
    $("#range").on('change keyup paste', function() {
		
    	var range =  $("#range").val();
    	
    	var rangeSplit = range.split(";");
    	$("#min_price").val(rangeSplit[0]);
    	$("#max_price").val(rangeSplit[1]);
    	
	});
    
	
	// ==;; 적용안됨...
	$("#min_price").on('change', function() {
		
    	var min_price =  $("#min_price").val();
    	var range =  $("#range").val();
    	var rangeSplit = range.split(";");
    	$("#range").val(min_price+";"+rangeSplit[1]);
    	
	});
	// ==;; 적용안됨...	
	$("#max_price").on('change', function() {
		
    	var max_price =  $("#max_price").val();
    	var range =  $("#range").val();
    	var rangeSplit = range.split(";");
    	
    	$("#range").val(rangeSplit[0]+";"+max_price);
	});
});




$(function(){
	
	$("#prodImage").on("click", function(){
		$("#detailFrm").submit();
		console.log(prod_id);
	});
	
	$("#nextPage").on("click", function(){
		var pageIndex = $("#index").val();
		pageIndex++;
		$("#index").val(pageIndex);
		var level = $("#level").val();
		var ctgy_id = $("#ctgy_id").val();
		$.ajax({
			url :"nextList",
			method :"get",
			data : {"page" : pageIndex, "pageSize" : 24, "level" : $("#level").val(), "pr_class_id" : $("#ctgy_id").val(),"i" : $("#i").val() },
			success : function(responseData){
				$("#nextPage").remove();
				console.log(responseData);
				var content = '';
				$.each(responseData, function(index,item){
					content ='<div class="col-md-3 w3ls_w3l_banner_left"><div class="hover14 column"><div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid"><div class="agile_top_brand_left_grid_pos"><img src="/images/offer.png" alt=" " class="img-responsive" /></div><div class="agile_top_brand_left_grid1"><figure><div class="snipcart-item block"><div class="snipcart-thumb">'+'<a href="/userProd/detail?prod_id='+item.prod_id+'" id="prodImage"><img src="/images/5.png" alt=" " class="img-responsive" /></a>' +
									'<p>'+item.prod_name+'</p>'+
									'<h4>'+item.prod_price+'</h4>'+
									'</div>'+
									'<div class="snipcart-details">'+
									'<form action="#" method="post">'+
									'<fieldset>'+
									'<input type="hidden" name="prod_id" value="'+item.prod_id+'" />'+
									'<input type="submit" name="submit" value="Add to cart" class="button" />'+
									'</fieldset>'+
									'</form></div></div></figure></div></div></div></div>';
					$(".list").append(content);
				})
				
			}
		});
	});
	
	$("#searchBtn").on("click", function(){
		alert("검색 버튼");
// 		var page = 1;
// 		var pageSize = 32;
// 		var min =$("#min_price").val();
// 		var max =$("#max_price").val();
// 		var searchName = $("#searchName").val();
		console.log($("#min_price").val(), $("#max_price").val(),  $("#searchName").val()  );
		
		$.ajax({
			url :"search",
			method :"get",
			data : {"page":1, "pageSize":24, "min_price": $("#min_price").val(), "max_price" : $("#max_price").val(), "searchfor" : $("#searchName").val() },
			success : function(responseData){
				alert("성공");
				console.log(responseData);
				
				$("#proList").val("");
				
				var content =
					 '<div class="w3ls_w3l_banner_nav_center_grid1" id="proList"> 	<div class="list" >'
					if (responseData == null) {
						content += '<div class="col-md-3 w3ls_w3l_banner_left liiist" name="liiist" >'
						+'				해당 상품이 없습니다.'
						+'			</div></div></div> ' 
					} else {
						content += 
							 '			<div class="col-md-4 w3ls_w3l_banner_left liiist" name="liiist" >'
							+'				<div class="hover14 column">'
							+'				<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">'
						$.each(responseData, function(index,item){
							content += 
							 '					<div class="agile_top_brand_left_grid_pos">'
							+'						<img src="'item.file_path+'/'+item.file_upname+''" alt=" " class="img-responsive" />'
							+'					</div>'
							+'					<div class="agile_top_brand_left_grid1">'
							+'						<figure>'
							+'							<div class="snipcart-item block">'
							+'								<div class="snipcart-thumb">'
							+'									<a href="/userProd/detail?prod_id='+item.prod_id+'" id="prodImage">'
							+'										<img src="/images/5.png" alt=" " class="img-responsive" />'
							+'									</a>'
							+'									<p>'+item.prod_name+'</p>'
							+'									<h4>'+item.prod_price+'</h4>'
							+'								</div>'
							+'								<div class="snipcart-details">'
							+'									<form action="#" method="post">'
							+'										<fieldset>'
							+'											<input type="hidden" name="prod_id" value="'+item.prod_id+'" />'
							+'											<input type="submit" name="submit" value="Add to cart" class="button" />'
							+'										</fieldset>'
							+'									</form>'
							+'								</div>'
							+'							</div>'
							+'						</figure>'
							+'					</div>'
							+'				</div>'
							
								
						}); //$.each(responseData, function(index,item){
						content += 
						'			</div>'
						+'		</div>'
						+'</div>'
						+'<c:if test="${ctgyProdList != null }">'
						+'	<form  id="nextFrm" >'
						+'		<input type="hidden" id="index" value="1">'
						+'		<input type="hidden" id="i" value="${i }">'
						+'		<input type="hidden" id="level" value="${ctgylevel }">'
						+'		<input type="hidden" id="ctgy_id" value="${ctgy_id }">'
						+'		<input type="button" id="nextPage" value="더보기">'
						+'	</form>'
						+'</c:if>'
						+'<div class="clearfix"> </div>'
						+'</div>';
					} // else {
				$("#proList").val(content);

			} // 	success : function(responseData){
		});	// $.ajax({
	});	 //$("#searchBtn").on("click", function(){
		
		
	
	$("#opoBtn").on("click", function(){
		$("#event_id").val("201");
		alert($("#event_id").val());
		$("#eventCtgyFrm").submit();
	})
	$("#tpoBtn").on("click", function(){
		$("#event_id").val("202");
		$("#eventCtgyFrm").submit();
	})
	$("#discountBtn").on("click", function(){
		$("#event_id").val("203");
		$("#eventCtgyFrm").submit();
	})
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

<!-- banner -->
<div class="banner">
	<form action="/userProd/detail" method="post" id="detailFrm">
		<input type="hidden" name="prod_id" value="${prod.prod_id }" />
	</form>
	
		
		<div class="w3l_banner_nav_right">
			<div class="w3l_banner_nav_right_banner3">
<!-- 				<br> -->
				
			</div>
			<br>
			<div class="w3ls_w3l_banner_nav_right_grid">
				<c:if test="${i =='3' }">
					<form action="/userProd/eventList" method="get" id="eventCtgyFrm">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="opoBtn" value="1+1">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="tpoBtn" value="2+1">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="discountBtn" value="할인">
						<input type="hidden" id="event_id" name="event_id">
						<c:if test="${category != null }">
							<input type="hidden" name="ctgy_id" value="${ctgy_id }" >
							<input type="hidden" name="level" value="${ctgylevel }" >
						</c:if>
					</form>
				</c:if>
				<br>
				<br>
				<br>
				<c:if test="${i =='1' }">
					<h3>상품 소개&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}</h3>
				</c:if>
				<c:if test="${i =='2' }">
					<h3>Best 상품&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}</h3>
				</c:if>
				<c:if test="${i =='3' }">
					<h3>행사 상품&nbsp;<span class="blink_me">|</span>&nbsp;${category.ctgy_name}</h3>
				</c:if>
			<form id="searchFrm">
				<div class="services">
					<div class="w3ls_service_grids">
						<div class="col-md-15 w3ls_service_grid_left">
							<h4>상품 검색</h4>
							<table summary="CU 매장 검색">
<%-- 								<caption></caption> --%>
								<colgroup>
									<col style="width:17%;" />
									<col style="width:69%;" />
									<col style="width:14%;" />
								</colgroup>
								<tbody>
									<tr>
										<th scope="row" rowspan="2">가격대 검색</th>
										<br>
										<td>										
											<div style="position: relative; ">
											    <div>
											       <input type="hidden" id="range" value="" name="range" class="irs-hidden-input" tabindex="-1" >
											       <br/><br/>
											    </div>
											</div>
										</td>
											
									</tr>
									<tr>
										<td>
											<input type="number" id="min_price" style="width:30%">원
											&nbsp; ~ &nbsp; 
											<input type="number" id="max_price" style="width:30%">원
											&nbsp;&nbsp;&nbsp;
										</td>
									</tr>
									<tr>
										<td>
											<br/><br/>
										</td>
									</tr>
									<tr>
										<th scope="row"><label for="store_name">검색</label></th>
										<td id=>
											<div class="form-row">
<!--       												<form action="#" method="get"> -->
<!--     		  											<span class="input-group-btn"> -->
			   												<input type="text" class="form-control" id="searchName"  placeholder="Search for..." style="width:90%">
<!-- 		      												<button class="btn btn-default" type="submit">Go!</button> -->
<!-- 	      												</span> -->
<!--       												</form> -->
   											</div>
											
												
										</td>
										<td>
											<input type="button" id="searchBtn" name="psBtn" class="btn btn-default" value="검색">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>	
				</div>
				</form>
				
				<div class="w3ls_w3l_banner_nav_center_grid1" id="proList">
					<div class="list" >
					<c:if test="${ctgyProdList == null }">
						<div class="col-md-3 w3ls_w3l_banner_left liiist" name="liiist" >
							해당 상품이 없습니다.
						</div>
					</c:if>
					<c:forEach items="${ctgyProdList }" var="prod">
					
						<div class="col-md-4 w3ls_w3l_banner_left liiist" name="liiist" >
							<div class="hover14 column">
							<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid_pos">
									<img src="/images/offer.png" alt=" " class="img-responsive" />
								</div>
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a href="/userProd/detail?prod_id=${prod.prod_id }" id="prodImage">
													<img src="/images/5.png" alt=" " class="img-responsive" />
												</a>
												<p>${prod.prod_name }</p>
												<h4>${prod.prod_price }</h4>
											</div>
											<div class="snipcart-details">
												<form action="#" method="post">
													<fieldset>
														<input type="hidden" name="prod_id" value="${prod.prod_id }" />
														<input type="submit" name="submit" value="Add to cart" class="button" />
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
					<c:if test="${ctgyProdList != null }">
					
						<form  id="nextFrm" >
							<input type="hidden" id="index" value="1">
							<input type="hidden" id="i" value="${i }">
							<input type="hidden" id="level" value="${ctgylevel }">
							<input type="hidden" id="ctgy_id" value="${ctgy_id }">
							<input type="button" id="nextPage" value="더보기">
						</form>
					</c:if>
					<div class="clearfix"> </div>
				</div>
				</div>
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
