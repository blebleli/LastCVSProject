<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.tbl-accordion .tbl-accordion-nested td, .tbl-accordion .tbl-accordion-nested th
	{
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
	$(function() {

		// 첨부파일 추가/삭제 버튼(editor 소스보다 위에 있어야 함)						
		$("#plusfileBtn")
				.on(
						"click",
						function() {
							var fileLen = $("div#addfile input[id=fileList]")
									.size();
							if (fileLen == 5) {
								alert("첨부파일은 5개이상 추가할 수 없습니다.");
								return false;
							}
							$("div#addfile")
									.append(
											$("<input type='file' id='file_name' name='file_name' required='required' class='form-control col-md-5 col-xs-12' onchange='fn_loadImg(this);'>"));
						});

		var isEmpty = function(value) {
			if (value == ""
					|| value == null
					|| value == undefined
					|| (value != null && typeof value == "object" && !Object
							.keys(value).length)) {
				return true
			} else {
				return false
			}
		}

		$("#boardInsert").on("click", function() {
			var mem_id = $("#mem_id").val();

			if (isEmpty(mem_id)) {
				if (confirm("로그인 후 이용 가능합니다. \n 로그인 하시겠습니까?")) {
					location.href = "/login/loginView";
					return;
				} else {

					return;
				}
			}

			var rat = $(":input:radio[name=rat]:checked").val();
			var bd_title = $("#bd_title").val();
			var bd_content = $("#bd_content").val();
			$("#bd_rating").val(rat);

			// 			alert(rat + "\n" + bd_title + "\n" + bd_content + "\n" + $("#bd_rating").val()+ "\n" + $("#prod_id").val()+ "\n" + $("#mem_id").val());

			$("#reFrm").submit();
			alert($("#point_name").val() + "님\n포인트 10점이 적립되었습니다.");			

		});

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
<input type="hidden" id="point_name" value="${sessionScope.userInfo.mem_name}">
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
					    <input id="rating5" type="radio" name="rating" value="5" <c:if test="${prod.bd_rating eq 5 }"> checked="checked" </c:if>>
						<label for="rating5">5</label> 
						<input id="rating4" type="radio" name="rating" value="4" <c:if test="${prod.bd_rating eq 4 }"> checked="checked" </c:if>>
						<label for="rating4">4</label> 
						<input id="rating3" type="radio" name="rating" value="3" <c:if test="${prod.bd_rating eq 3 }"> checked="checked" </c:if>>
						<label for="rating3">3</label> 
						<input id="rating2" type="radio" name="rating" value="2" <c:if test="${prod.bd_rating eq 2 }"> checked="checked" </c:if>>
						<label for="rating2">2</label> 
						<input id="rating1" type="radio" name="rating" value="1" <c:if test="${prod.bd_rating eq 1 }"> checked="checked" </c:if>>
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
						<form action="#" method="post">
							<fieldset>
								<input type="hidden" name="cmd" value="_cart"> 
								<input type="hidden" name="currency_code" value="KRW">
								<input type="hidden" name="prod"   value="${prod.prod_id }">
								<input type="hidden" name="item_name" value="${prod.prod_name}">
								<input type="hidden" name="amount"    value="${prod.prod_price}">
								<input type="hidden" name="add"       value="1">
								<input type="hidden" name="business"  value="">
								<input type="hidden" name="discount_amount" value="0.0">
								<input type="hidden" name="return"    value="">
								<input type="hidden" name="cancel_return" value="">
								<input type="submit" name="submit"    value="장바구니에 담기" class="button">
							</fieldset>
						</form>

						<form action="/userPay/pay" method="post" id="prodDetailFrm">
							<fieldset>
								<input type="hidden" name="prod_id" value="${prod.prod_id }">

<!-- 								<input type="submit" name="submit" value="장바구니에 담기" class="button" />-->
								 <input type="submit" name="submit" value="결제" class="button" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<br>

			<div class="col-md-15 col-sm-10 col-xs-12">
				<div class="" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">

						<li role="presentation" class="active"><a
							href="#tab_content1" id="home-tab" role="tab" data-toggle="tab"
							aria-expanded="false">상품 리뷰(${reviewCnt})</a></li>
						<li role="presentation" class=""><a href="#tab_content2"
							role="tab" id="reviewInsert" data-toggle="tab"
							aria-expanded="false">리뷰작성</a></li>
					</ul>
					<!-- Tab panes -->
					<div id="myTabContent" class="tab-content col-md-15 col-sm-9 col-xs-12" style="width: 100%">
						<!-- 상품리뷰 -------------------------------------------------------------------------------------------------------- -->
						<c:forEach items="${reviewList }" var="review">
							<div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
								<div id="content" class="content_primary forgot_user_information"">
									<div class="col-md-12 w3agile_event_grid">
											<br/>
											<br/>												
									<c:choose>
										<c:when test="${review.bd_del=='N'}">
											<div class="col-md-4 w3agile_event_grid_left">
													<img id="meal" src="${review.src }" width="40px" height="35px"/>
													<label>${review.mem_name } : ${review.bd_date }													
													<c:if test="${userInfo.mem_id == review.mem_id }">
														<a class="btn btn-danger" 
														 href="/review/delete?bd_id=${review.bd_id}&prod_id=${review.prod_id}" aria-label="Delete"> 삭제 </a>
													</c:if>
													</label>
													<br>
													<div style="text-align: center;">
													<!-- 평점 -->
													<div class="rating2" style="float: right;">
														<span class="starRating"> 
															<input id="rating5" type="radio" name="" value="5" <c:if test="${review.bd_rating eq 5 }"> checked="checked" </c:if>>
															<label for="rating5">5</label>
															<input id="rating4" type="radio" name="" value="4" <c:if test="${review.bd_rating eq 4 }"> checked="checked" </c:if>>
															<label for="rating4">4</label>
															<input id="rating3" type="radio" name="" value="3" <c:if test="${review.bd_rating eq 3 }"> checked="checked" </c:if>>
															<label for="rating3">3</label>
															<input id="rating2" type="radio" name="" value="2" <c:if test="${review.bd_rating eq 2 }"> checked="checked" </c:if>>
															<label for="rating2">2</label>
															<input id="rating1" type="radio" name="" value="1" <c:if test="${review.bd_rating eq 1 }"> checked="checked" </c:if>>
															<label for="rating1">1</label>
														</span>
													</div>
													</div>
											</div>
											<br/>
											<div class="col-md-8 w3agile_event_grid_right">
												<h4>${review.bd_title }</h4>
												<p>${review.bd_content }</p>
											</div>
										</c:when>
										<c:otherwise>
											
											<div class="col-md-4 w3agile_event_grid_left">
													<img id="meal" src="" width="40px" height="35px"/>
													<label>***</label>
													<br>
													<div style="text-align: center;">
													<!-- 평점 -->
													<div class="rating2" style="float: right;">
														<span class="starRating"> 
															<input id="rating5" type="radio" name="" value="5" <c:if test="${review.bd_rating eq 5 }"> checked="checked" </c:if>>
															<label for="rating5">5</label>
															<input id="rating4" type="radio" name="" value="4" <c:if test="${review.bd_rating eq 4 }"> checked="checked" </c:if>>
															<label for="rating4">4</label>
															<input id="rating3" type="radio" name="" value="3" <c:if test="${review.bd_rating eq 3 }"> checked="checked" </c:if>>
															<label for="rating3">3</label>
															<input id="rating2" type="radio" name="" value="2" <c:if test="${review.bd_rating eq 2 }"> checked="checked" </c:if>>
															<label for="rating2">2</label>
															<input id="rating1" type="radio" name="" value="1" <c:if test="${review.bd_rating eq 1 }"> checked="checked" </c:if>>
															<label for="rating1">1</label>
														</span>
													</div>
													</div>
											</div>
											<br/>
											<div class="col-md-8 w3agile_event_grid_right">
												<h4>삭제된 리뷰입니다.</h4>
												<p>조회할 수 없는 내용입니다.</p>
											</div>
										</c:otherwise>
									</c:choose>
									</div>
								</div>
							</div>
						</c:forEach>
					<hr />
						<!-- 리뷰작성 -------------------------------------------------------------------------------------------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content2"
							aria-labelledby="reviewInsert">
							<div class="x_content">
								<form id="reFrm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate=""
									method="post" action="/adboard/boardCreate"
									enctype="multipart/form-data">
									<input type="hidden" id="prod_id" name="prod_id"
										value="${prod.prod_id}"> <input type="hidden"
										id="bd_rating" name="bd_rating" value=""> <input
										type="hidden" id="mem_id" name="mem_id"
										value="${userInfo.mem_id}"> <input type="hidden"
										id="bd_kind_id" name="bd_kind_id" value="55"> <input
										type="hidden" id="bd_del" name="bd_del" value="N">

									<div class="form-group">

										<label for="middle-name"
											class="control-label col-md-3 col-sm-3 col-xs-12">평점</label>
										<div class="rating" class="col-md-6 col-sm-6 col-xs-12">
											<span class="rating"> <input id="rating1" type="radio"
												name="rat" value="1"> <label for="rating1">1</label>
												<input id="rating2" type="radio" name="rat" value="2">
												<label for="rating2">2</label> <input id="rating3"
												type="radio" name="rat" value="3"> <label
												for="rating3">3</label> <input id="rating4" type="radio"
												name="rat" value="4"> <label for="rating4">4</label>
												<input id="rating5" type="radio" name="rat" value="5">
												<label for="rating5">5</label>
											</span>
										</div>
									</div>

									<div class="form-group">
										<label for="middle-name"
											class="control-label col-md-3 col-sm-3 col-xs-12">제목</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<input id="bd_title" class="form-control col-md-7 col-xs-12"
												type="text" name="bd_title" data-parsley-id="9"
												value="${prodVo.prod_cost }">
										</div>
									</div>

									<div class="form-group">
										<label for="middle-name"
											class="control-label col-md-3 col-sm-3 col-xs-12">내용</label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<textarea rows="" cols="" id="bd_content" name="bd_content"
												data-parsley-id="9" class="form-control col-md-7 col-xs-12"></textarea>
										</div>
									</div>

<!-- 									              <div class="form-group"> -->
<!-- 									                <label for="file_name" class="control-label col-md-3 col-sm-3 col-xs-12">사진</label> -->
<!-- 									                <div class="col-md-5 col-sm-5 col-xs-12" id="addfile" > -->
<!-- 									                	<input type="file" id="file_name" name="file_name" required="required" class="form-control col-md-5 col-xs-12" onchange="fn_loadImg(this);"> -->
<!-- 									                </div> -->
<!-- 									                <div class="col-md-1 col-sm-2 col-xs-12"> -->
<!-- 									                	<button type="button" class="fa fa-plus-square" name="plusfileBtn" id="plusfileBtn" ></button> -->
<!-- 									                </div> -->
<!-- 									              </div> -->

									<div class="ln_solid"></div>
									<div class="form-group">
										<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
											<button class="btn btn-primary" type="reset">초기화</button>
											<button type="button" id="boardInsert"
												class="btn btn-success">등록</button>
										</div>
									</div>

								</form>
							</div>
						</div>
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