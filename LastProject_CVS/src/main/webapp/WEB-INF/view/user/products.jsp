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
		var level = $("#level").val;
		var ctgy_id = $("#ctgy_id").val;
// 		var data ={};
// 		pageIndex++;
// 		data["page"]=pageIndex;
// 		data["pageSize"]=32;
// 		data["level"]=$("#level").val;
// 		data["pr_class_id"]=$("#ctgy_id").val;
		$.ajax({
			url :"nextList",
			method :"post",
			contentType :"application/json; charset=UTF-8",
// 			dataType : "json",
// 			data : JSON.stringify(data),
			data : {"page" : pageIndex, "pageSize" : 32, "level" : $("#level").val, "pr_class_id" : $("#ctgy_id").val },
			success : function(responseData){
				$("#nextPage").remove();
				console.log(responseData);
//	 			$(".col-md-3 w3ls_w3l_banner_left").append(responseData);
				
				
			}
		});
	});
});


function nextList(){
	var data ={};
	var pageIndex = $("#index").val();
	pageIndex++;
	data["page"]=pageIndex;
	data["pageSize"]=32;
	data["level"]=$("#level").val;
	data["ctgy_id"]=$("#ctgy_id").val;
	$.ajax({
		url :"/userProd/nextList",
		method :"get",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify({"page" : pageIndex, "pageSize" : 32 , "level" : "${level}", "ctgy_id" : "${ctgy_id}" }),
// 		data : JSON.stringify(data),
		dataType : "json",
		success : function(responseData){
			$("#nextPage").remove();
			console.log(responseData);
// 			$(".col-md-3 w3ls_w3l_banner_left").append(responseData);
			
			
		}
	});
}
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
				<h3>Best 상품<span class="blink_me"></span></h3>
			</div>
			<br>
			<div class="w3ls_w3l_banner_nav_right_grid">
				<h3>${category.ctgy_name}</h3>
				<form action="#">
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
										<td>										
											<div>
												<input type="radio" style="width:5%">1500원 이하 &nbsp;&nbsp;&nbsp;
												<input type="radio" style="width:5%;" >1500원 ~ 3000원  &nbsp;&nbsp;&nbsp;
												<input type="radio" style="width:5%;">5000원 이상  &nbsp;&nbsp;&nbsp;
												
												<input type="text" name="priceText1" style="width:7%">&nbsp;~&nbsp; <input type="text" name="priceText2" style="width:7%">
											
											<button type="submit" name="psBtn" class="btn btn-primary">검색</button>																																		
											<button type="button" class="btn btn-default">초기화</button>		
											</div>
										</td>										
									</tr>
									<tr>
										<th scope="row"><label for="store_name">검색</label></th>
										<td >
											<div class="form-row">
											
      												<form action="#" method="get">
<!--     		  											<span class="input-group-btn"> -->
			   												<input type="text" class="form-control" name="searchProd"  placeholder="Search for..." style="width:90%">
<!-- 		      												<button class="btn btn-default" type="submit">Go!</button> -->
<!-- 	      												</span> -->
      												</form>
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
					<c:forEach items="${ctgyProdList }" var="prod">
					
						<div class="col-md-3 w3ls_w3l_banner_left">
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
					<form  id="nextFrm" >
						<input type="hidden" id="index" value="1">
						<input type="hidden" id="level" value="${level }">
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