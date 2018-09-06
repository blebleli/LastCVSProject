<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script>
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
			data : {"page" : pageIndex, "pageSize" : 32, "level" : $("#level").val(), "pr_class_id" : $("#ctgy_id").val(),"i" : $("#i").val() },
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
// 		var page = 1;
// 		var pageSize = 32;
// 		var min =$("#min_price").val();
// 		var max =$("#max_price").val();
// 		var searchName = $("#searchName").val();
		console.log($("#min_price").val(), $("#max_price").val(),  $("#searchName").val()  );
		
		$.ajax({
			url :"search",
			method :"get",
			data : {"page":1, "pageSize":32, "min_price": $("#min_price").val(), "max_price" : $("#max_price").val(), "searchfor" : $("#searchName").val() },
			success : function(responseData){
				console.log(responseData);
				$(".liiist").remove();
				var content ='';
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
	
	$("#opoBtn").on("click", function(){
		$("#event_id").val("201");
		$("#eventCtgyFrm").submit;
	})
	$("#tpoBtn").on("click", function(){
		$("#event_id").val("202");
		$("#eventCtgyFrm").submit;
	})
	$("#discountBtn").on("click", function(){
		$("#event_id").val("203");
		$("#eventCtgyFrm").submit;
	})
});



</script>
</head>
<html>

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
				<br>
				<c:if test="${i =='1' }">
					<h3>상품 소개<span class="blink_me"></span></h3>
				</c:if>
				<c:if test="${i =='2' }">
					<h3>Best 상품<span class="blink_me"></span></h3>
				</c:if>
				<c:if test="${i =='3' }">
					<h3>행사 상품<span class="blink_me"></span></h3>
				</c:if>
			</div>
			<br>
			<div class="w3ls_w3l_banner_nav_right_grid">
				<c:if test="${i =='3' }">
					<form action="/userProd/eventList" method="get" id="eventCtgyFrm">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="opoBtn" value="1+1">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="tpoBtn" value="2+1">
						<input type="button" class="col-md-4 btn btn-primary" name="event" id="discountBtn" value="할인">
						<input type="hidden" id="event_id" name="event_id">
					</form>
				</c:if>
				<br>
				<br>
				<br>
				<h3>${category.ctgy_name}</h3>
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
										<th scope="row">가격대 검색</th>
										<br>
										<td>										
											<div>
												<input type="text" id="min_price" style="width:10%">&nbsp; ~ &nbsp; <input type="text" id="max_price" style="width:10%">&nbsp;&nbsp;&nbsp;
												<input type="button" id="searchBtn" name="psBtn" class="btn btn-primary" value="검색">																																		
<!-- 												<button type="button" class="btn btn-default">초기화</button>		 -->
											</div>
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
									</tr>
								</tbody>
							</table>
						</div>
					</div>	
				</div>
				</form>
				<div class="w3ls_w3l_banner_nav_right_grid1">
					<div class="list">
					<c:forEach items="${ctgyProdList }" var="prod">
					
						<div class="col-md-3 w3ls_w3l_banner_left liiist" name="liiist" >
							<div class="hover14 column">
							<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid_pos">
									<img src="/images/offer.png" alt=" " class="img-responsive" />
								</div>
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<a href="/userProd/detail?prod_id=${prod.prod_id }" id="prodImage"><img src="/images/5.png" alt=" " class="img-responsive" /></a>
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
					<form  id="nextFrm" >
						<input type="hidden" id="index" value="1">
						<input type="hidden" id="i" value="${i }">
						<input type="hidden" id="level" value="${ctgylevel }">
						<input type="hidden" id="ctgy_id" value="${ctgy_id }">
						<input type="button" id="nextPage" value="더보기">
					</form>
					
					
					<div class="clearfix"> </div>
				</div>
				</div>
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->

</html>