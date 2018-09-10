'<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Bootstrap -->
<!-- <link href="/css/bootstrap.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="/css/font-awesome.css" rel="stylesheet"> -->
<!-- Custom Theme Style -->
<!-- <link href="/build/css/custom.css" rel="stylesheet">
 -->
<style>

</style>

<script type="text/javascript">

$(document).ready(function() {

	/** 
	 * 초기 탭 클릭
	 */ 
	if("${!empty tab}") {
		$("ul#myTab > li > a[href=#${tab}]").trigger("click");
		// focus 안먹네
		$("div#${tab}").next().attr("tabindex", -1).focus();
	}
	
	/**
	 * 구매내역 행 클릭
	 */
	$("tr.paytr").bind("click", function() {
		
		// 상세tr 삭제
		if($(this).next().hasClass("subPaytr")) {
			$(this).next().remove();
		}
		else {
			// 상세tr 전체삭제
			$(this).parent().find('tr.subPaytr').each(function() {
				$(this).remove();
			});
			// 상세tr 보여주기
			var $subTr = $("<tr style='height:20px;' class='subPaytr'><td colspan='5'>뭘보여줘야지</td></tr>");
			$(this).after($($subTr));
		}
		
	});
});

</script>

<div class="products-breadcrumb">
	<div class="container"></div>
</div>

<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
				<li>마이페이지</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->



<!-- banner -->

	
	<div class="w3l_banner_nav_right">
		<!-- about -->
		<div class="privacy about">
		<!-- 	<h3>
				My<span>Page</span>
			</h3>
			<br><br> -->
			<div class="col-md-9 col-sm-7 col-xs-12 profile_details">
				<div class="row user-infos user3">
					<div class="panel panel-primary">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">User information</h3>
	                    </div>
	                    <div class="panel-body">
	                        <div class="row">
	                            <div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
	                                <img class="img-circle"
	                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
	                                     alt="User Pic">
	                            </div>
	                            <div class="col-xs-2 col-sm-2 hidden-md hidden-lg">
	                                <img class="img-circle"
	                                     src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=50"
	                                     alt="User Pic">
	                            </div>
	                            <div class="col-xs-10 col-sm-10 hidden-md hidden-lg">
	                                <strong>Cyruxx</strong><br>
	                                <dl>
	                                    <dt>User level:</dt>
	                                    <dd>Administrator</dd>
	                                    <dt>Registered since:</dt>
	                                    <dd>11/12/2013</dd>
	                                    <dt>Topics</dt>
	                                    <dd>15</dd>
	                                    <dt>Warnings</dt>
	                                    <dd>0</dd>
	                                </dl>
	                            </div>
	                            <div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">
	                                <strong>Cyruxx</strong><br>
	                                <table class="table table-user-information">
	                                    <tbody>
	                                    <tr>
	                                        <td>User level:</td>
	                                        <td>Administrator</td>
	                                    </tr>
	                                    <tr>
	                                        <td>Registered since:</td>
	                                        <td>11/12/2013</td>
	                                    </tr>
	                                    <tr>
	                                        <td>Topics</td>
	                                        <td>15</td>
	                                    </tr>
	                                    <tr>
	                                        <td>Warnings</td>
	                                        <td>0</td>
	                                    </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="panel-footer">
	                        <button class="btn btn-sm btn-primary" type="button"
	                                data-toggle="tooltip"
	                                data-original-title="Send message to user"><i class="glyphicon glyphicon-envelope"></i></button>
	                        <span class="pull-right">
	                            <button class="btn btn-sm btn-warning" type="button"
	                                    data-toggle="tooltip"
	                                    data-original-title="Edit this user"><i class="glyphicon glyphicon-edit"></i></button>
	                            <button class="btn btn-sm btn-danger" type="button"
	                                    data-toggle="tooltip"
	                                    data-original-title="Remove this user"><i class="glyphicon glyphicon-remove"></i></button>
	                        </span>
	                    </div>
	               </div>
	           </div>
	       </div>

<!-- 탭메뉴 -------------------------------------------------------------------------------------------------------- -->
			<div class="col-md-15 col-sm-10 col-xs-12">

				<div class="" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
						<li role="presentation" class="active"><a
							href="#tab_content1" id="home-tab" role="tab" data-toggle="tab"
							aria-expanded="true">나의 정보</a></li>
						<li role="presentation" class=""><a href="#tab_content2"
							role="tab" id="profile-tab" data-toggle="tab"
							aria-expanded="false">나의 주머니</a></li>
						<li role="presentation" class=""><a href="#tab_content3"
							role="tab" id="profile-tab2" data-toggle="tab"
							aria-expanded="false">자주가는 편의점</a></li>
						<li role="presentation" class=""><a href="#tab_content4"
							role="tab" id="profile-tab2" data-toggle="tab"
							aria-expanded="false">즐겨찾는 상품</a></li>
						<li role="presentation" class=""><a href="#tab_content5"
							role="tab" id="profile-tab2" data-toggle="tab"
							aria-expanded="false">구매 내역</a></li>
					</ul>
					<div id="myTabContent" class="tab-content col-md-15 col-sm-9 col-xs-12"
						style="width: 100%">
						
					<div role="tabpanel" class="tab-pane fade active in"
							id="tab_content1" aria-labelledby="home-tab">
<!-- 나의정보 -------------------------------------------------------------------------------------------------------- -->
						<div class="col-md-15 col-sm-10 col-xs-12">
							<div class="x_panel">
									<div class="x_title">
										<h2>나의 정보</h2>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">				
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12" >이름
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly
														placeholder="${member.mem_name}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12" >E-Mail
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly
														placeholder="${member.mem_id}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">비밀번호
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="password" class="form-control"
														value="passwordonetwo">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">비밀번호 확인
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="password" class="form-control"
														value="passwordonetwo">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">생년
													월일 : </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly
														placeholder="${member.mem_birth}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">연락처
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control"
														placeholder="${member.mem_tel}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">우편번호
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" placeholder="우편번호어떻게">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">주소
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control"
														placeholder="${member.mem_add}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">상세주소
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control"
														placeholder="상세주소문제있네">
												</div>
											</div>

											<div class="ln_solid"></div>
											<div class="form-group">
												<div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
													<button type="button" class="btn btn-success">변경</button>
												</div>
											</div>
									</div>
								</div>
							</div>
						</div>
<!-- 나의주머니 -------------------------------------------------------------------------------------------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content2"
							aria-labelledby="profile-tab">

							<div class="col-md-10 col-sm-10 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>나의 주머니</h2>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<br />

										<div class="col-md-5 w3ls_w3l_banner_left">
											<div class="hover14 column">
												<div
													class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
													<div class="agile_top_brand_left_grid_pos">
														주머니 생성된 바코드 사진
														<img src="/images/offer.png" alt=" " class="img-responsive" />
													</div>
													<div class="agile_top_brand_left_grid1 ">
														<figure>
															<div class="snipcart-item block">
																<div class="snipcart-thumb">
																	<a href="/user/productDetail">
																	<img src="/images/5.png" alt=" " class="img-responsive" /></a>
																	<p>상품이름</p>
																	<h4>가격</h4>
																</div>
																<div class="snipcart-details">
																	<form action="#" method="post">
																		<fieldset>
																			<input type="hidden" name="cmd" value="_cart" /> <input
																				type="hidden" name="add" value="1" /> <input
																				type="hidden" name="business" value=" " /> <input
																				type="hidden" name="item_name"
																				value="knorr instant soup" /> <input type="hidden"
																				name="amount" value="3.00" /> <input type="hidden"
																				name="discount_amount" value="1.00" /> <input
																				type="hidden" name="currency_code" value="USD" /> <input
																				type="hidden" name="return" value=" " /> <input
																				type="hidden" name="cancel_return" value=" " /> <input
																				type="submit" name="submit" value="Add to cart"
																				class="button" />
																		</fieldset>
																	</form>
																</div>
															</div>
														</figure>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>

						</div>
						
						
<!-- 자주가는 편의점-------------------------------------------------------------------------------------------------------- -->						
						<div role="tabpanel" class="tab-pane fade" id="tab_content3"
							aria-labelledby="profile-tab">
							
							<table class="data table table-striped no-margin">
								<thead>
									<tr>
										<th>지점명</th>
										<th>주소</th>
									</tr>
								</thead>
								<tbody>									
									<c:forEach items="${bookmarkList}" var="vo">
										<c:if test="${vo.star_kind eq '222'}">
											<tr>
												<td>${vo.star_id} </td>
												<td>${vo.place_id}</td>
											</tr>										
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>

<!-- 즐겨찾는 상품----------------------------------------------------------------------------------------------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content4"
							aria-labelledby="profile-tab">
							<div class="col-md-10 col-sm-10 col-xs-12">
								<div class="x_panel">
									<div class="x_title">
										<h2>즐겨찾는 상품</h2>
										<div class="clearfix"></div>
									</div>
									<div class="x_content">
										<br />

										<div class="col-md-5 w3ls_w3l_banner_left">
											<div class="hover14 column">
												<div
													class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
													<div class="agile_top_brand_left_grid_pos">
														<img src="/images/offer.png" alt=" "
															class="img-responsive" />
													</div>
													<div class="agile_top_brand_left_grid1 ">
														<figure>
															<div class="snipcart-item block">
															<c:forEach items="${bookmarkList}" var="vo">
																<c:if test="${vo.star_kind eq '111'}">
																<div class="snipcart-thumb">
																	<a href="/userProd/detail?prod_id=${vo.prod_id}">
																	<img src="/images/5.png" alt=" " class="img-responsive" /></a>
																	<p align="center">${vo.prod_name}</p>
																	<h4 align="center">${vo.prod_price} 원</h4>
																</div>
																<div class="snipcart-details">
																	<form action="#" method="post">
																		<fieldset>
																			<input type="hidden" name="cmd" value="_cart" /> 
																			<input type="hidden" name="add" value="1" /> 
																			<input type="hidden" name="business" value=" " /> 
																			<input type="hidden" name="item_name" value="knorr instant soup" /> 
																			<input type="hidden" name="amount" value="3.00" /> 
																			<input type="hidden" name="discount_amount" value="1.00" /> 
																			<input type="hidden" name="currency_code" value="USD" /> 
																			<input type="hidden" name="return" value=" " /> 
																			<input type="hidden" name="cancel_return" value=" " /> 
																			<input type="submit" name="submit" value="Add to cart" class="button" />
																	</fieldset>
																	</form>
																</div> 
																</c:if>
															</c:forEach>	
															</div>
														</figure>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
<!-- 구매내역----------------------------------------------------------------------------------------------------------- -->
						<div role="tabpanel" class="tab-pane fade" id="tab_content5" aria-labelledby="profile-tab">
							1. 구매내역이 보여진 후 클릭하면, 2. 상세 구매내역이 보여지도록 해야됨
							--상세구매내역 아코디언으로
							<table class="table table-hover">
								<thead>
									<tr>
										<th>결제번호</th>
										<th>제목</th>
										<th>총수량</th>
										<th>총합계</th>
										<th>결제날짜</th>																			
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${myPayList}" var="vo">
										<tr class="paytr" style="cursor: pointer;">
											<td>${vo.pay_id}</td>
											<td>${vo.pay_date}의 결제내역</td>
											<td>총수량예정</td>
											<td>총합계예정</td>
											<td>${vo.pay_date}</td>
										</tr> 
								    </c:forEach>								
								</tbody>							
							</table>
							<div class="text-center" id="page">
								<ul class="pagination">${pageNaviPayList}</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //about -->
</div>
<div class="clearfix"></div>
<div style="margin-bottom: 100px;"></div>
<!-- //banner -->
