<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<script>


function nextList(){
	var pageIndex = $("#index").val();
	pageIndex++;
	var levelStr = $("#level").val;
	var id = $("#ctgy_id").val;
	$.ajax({
		url :"/userProd/nextList",
		type :"get",
		data : {"page" : pageIndex, "pageSize" : 32 , "level" : "${level}", "ctgy_id" : "${ctgy_id}" },
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
												<a href="/userProd/detail" id="prodImage"><img src="/images/5.png" alt=" " class="img-responsive" /></a>
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
					<form action="/userProd/nextList" method="post" id="nextFrm" >
						<input type="hidden" id="index" value="1">
						<input type="hidden" id="level" value="${level }">
						<input type="hidden" id="ctgy_id" value="${ctgy_id }">
						<input type="button" id="nextPage" value="더보기" onclick="nextList()">
					</form>
					
					
					<div class="clearfix"> </div>
				</div>
				</div>
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->

</html>