<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/css/custom.min.css" rel="stylesheet">
    
    <style>
		.tbl-accordion {
		  margin: 0 auto;
		  width: 900px;
		  border: 1px solid #d9d9d9;
		}
		.tbl-accordion thead {
		  background: #d9d9d9;
		}
		.tbl-accordion .tbl-accordion-nested {
		  width: 100%;
		}
		.tbl-accordion .tbl-accordion-nested tr:nth-child(even) {
		  background-color: #eeeeee;
		}
		.tbl-accordion .tbl-accordion-nested td, .tbl-accordion .tbl-accordion-nested th {
		  padding: 10px;
		  border-bottom: 1px solid #d9d9d9;
		}
		.tbl-accordion .tbl-accordion-nested .tbl-accordion-section {
		  background: #1E90FF;
		  color: #fff;
		  cursor: pointer;
		}
    </style>
    
    <script>
    $(function(){
    	$(".tbl-accordion-nested").each(function() {
    		  var thead = $(this).find("thead");
    		  var tbody = $(this).find("tbody");

    		  tbody.hide();
    		  thead.click(function() {
    		    tbody.slideToggle();
    		  });
    		});
    });
    
    </script>

<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i> <a
				href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
			<li>상품 정보 &nbsp; ▷ ${prod.pr_class_lg } ▷ ${prod.pr_class_md } ▷
				${prod.prod_name }</li>
		</ul>
	</div>
</div>
<!-- top 이랑 구분 해주면서 현재 창의 카테고리 출력 -->


<!-- banner -->
<div class="banner">
	<div class="w3l_banner_nav_right">
		<div class="agileinfo_single">
			<h5>${prod.prod_name }</h5>
			<div class="col-md-4 agileinfo_single_left">
				<img id="example" src="${prod.file_path }/${prod.file_upname}"
					alt=" " class="img-responsive" />
			</div>

			<div class="col-md-8 agileinfo_single_right">
				<div class="rating1">
					<span class="starRating">
						<input id="rating5" type="radio" name="rating" value="5" >
						<label for="rating5">5</label>
						<input id="rating4" type="radio" name="rating" value="4"> 
						<label for="rating4">4</label>
						<input id="rating3" type="radio" name="rating" value="3" checked>
						<label for="rating3">3</label>
						<input id="rating2" type="radio" name="rating" value="2">
						<label for="rating2">2</label> 
						<input id="rating1" type="radio" name="rating" value="1">
						<label for="rating1">1</label>
					</span>
				</div>


				<div class="w3agile_description">
					<h3>상품 정보</h3>
					<p>${prod.prod_intro }</p>
				</div>
				<div class="snipcart-item block">
					<div class="snipcart-thumb agileinfo_single_right_snipcart">
						<h3>${prod.prod_price }원</h3>
					</div>
					<div class="snipcart-details agileinfo_single_right_details">
						<%-- 							<c:if test="${user == null }"> --%>
						<!-- 								<form -->
						<%-- 							</c:if> --%>
						<form action="/userPay/pay" method="post" id="prodDetailFrm">
							<fieldset>

								<input type="hidden" name="prod_id" value="${prod.prod_id }">
								<input type="submit" name="submit" value="장바구니에 담기"
									class="button" /> <input type="submit" name="submit"
									value="결제" class="button" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<br>


			<div class="col-md-15 col-sm-10 col-xs-12">

				<div class="" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">

						<li role="presentation" class="active">
							<a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="false">상품 리뷰(개수)</a>
						</li>
						<li role="presentation" class="">
							<a href="#tab_content2" role="tab" id="reviewInsert" data-toggle="tab" aria-expanded="false">리뷰작성</a>
						</li>
					</ul>

					<!-- Tab panes -->
					<div id="myTabContent"  class="tab-content col-md-15 col-sm-9 col-xs-12" style="width: 100%">

						<!-- 상품리뷰 -------------------------------------------------------------------------------------------------------- -->

							<c:forEach items="${reviewList }" var="review">
							<div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
								<div id="content" class="content_primary forgot_user_information" ">
									<!-- 이미지 3장은 보여지고 최대 10장 까지 좌우로 이동 할수 있도록-->
									<!-- 슬라이드 -->
									
									<!-- 슬라이드 -->
									
<!-- 										<div class="col-md-10 w3agile_event_grid_left"> -->
<!-- 											이미지 -->
<!-- 										</div> -->
<!-- 										<div class="col-md-2 w3agile_event_grid_right" style="float: right;"> -->
<!-- 											이미지  -->
<%-- 												<br /> 좋아요 : ${review.bd_views } --%>
<!-- 										</div> -->


									<div>
										<div class="col-md-12 w3agile_event_grid" >
											<div class="col-md-4 w3agile_event_grid_left">
											<br/><br/>
												<img id="meal" src="/images/category/ca_meal.png" width="40px" height="35px" />
												<br/> 회원정보사진
												<br/>
												<label>${review.mem_name } : ${review.bd_date }</label>
												<c:if test="${userInfo.mem_id == review.mem_id }">
													<a class="btn btn-danger" href="/review/delete?bd_id=${review.bd_id }" aria-label="Delete"> 
														삭제
													</a>
												</c:if>
											</div>
											<br />
											<div class="col-md-8 w3agile_event_grid_right">
												<!-- 평점 -->
												<div class="rating2" style="float: right;">
													<span class="starRating"> 
														<input id="rating5" type="radio" name="rating2" value="5">
														<label for="rating5">5</label>
														<input id="rating4" type="radio" name="rating2" value="4">
														<label for="rating4">4</label>
														<input id="rating3" type="radio" name="rating2" value="3" checked>
														<label for="rating3">3</label>
														<input id="rating2" type="radio" name="rating2" value="2">
														<label for="rating2">2</label>
														<input id="rating1" type="radio" name="rating2" value="1">
														<label for="rating1">1</label>
													</span>
												</div>
												<h4>${review.bd_title }(제목)</h4>
												<p>(내용)${review.bd_content }</p>
											</div>
											
											
										</div>
									</div>
								</div>
								
								</div>
								<hr/>
								<br/><br/>
							</c:forEach>
						

						<!-- 리뷰작성 -------------------------------------------------------------------------------------------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="reviewInsert">
								<div class="rating3" style="float: right;">
									<span class="starRating"> 
										<input id="rating5" type="radio" name="rating" value="5">
										<label for="rating5">5</label>
										<input id="rating4" type="radio"name="rating" value="4">
										<label for="rating4">4</label>
										<input id="rating3" type="radio" name="rating" value="3" checked>
										<label for="rating3">3</label>
										<input id="rating2" type="radio" name="rating" value="2">
										<label for="rating2">2</label>
										<input id="rating1" type="radio" name="rating" value="1">
										<label for="rating1">1</label>
									</span>
								</div>
								<!-- 게시판에 insert -->
								<form action="/review/write" method="POST">
								
								<input type="hidden" name="bd_rating">
								<input type="hidden" name="mem_id">

								<label>제목 : </label> <br/>
								<input type="text" id="boardTitle" name="boardTitle"> 
								
								<label>내용 : </label> <br/>
								<textarea name="reviewCont" rows="" cols=""></textarea>
									
								<input type="file">
								
								<input type="submit">
														
								</form>				
									
						</div>
					</div>
						
						
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</div>

<br>






</body>
</html>
