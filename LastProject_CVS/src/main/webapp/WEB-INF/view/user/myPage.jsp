<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Bootstrap -->
<!-- <link href="/css/bootstrap.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="/css/font-awesome.css" rel="stylesheet"> -->
<!-- Custom Theme Style -->
<!-- <link href="/build/css/custom.css" rel="stylesheet">
 -->
<!-- products-breadcrumb -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a
				href="index.html">Home</a><span>|</span></li>
			<li>My Page</li>
		</ul>
	</div>
</div>
<!-- //products-breadcrumb -->

<!-- banner -->
<div class="banner">
	<div class="w3l_banner_nav_left">
		<nav class="navbar nav_bottom">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header nav_2">
				<button type="button" class="navbar-toggle collapsed navbar-toggle1"
					data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				<ul class="nav navbar-nav nav_1">
					<li><a href="products.html">간편식사</a></li>
					<li><a href="household.html">즉석조리</a></li>
					<li><a href="kitchen.html">과자류</a></li>
					<li><a href="short-codes.html">아이스크림</a></li>
					<li><a href="pet.html">식품</a></li>
					<li><a href="bread.html">음료</a></li>
					<li><a href="bread.html">생활용품</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>

	<div class="w3l_banner_nav_right">
		<!-- about -->
		<div class="privacy about">
			<h3>
				My<span>Page</span>
			</h3>
			<br> <br>
			<div class="col-md-10 col-sm-7 col-xs-12 profile_details">
				<div class="well profile_view">
					<div class="col-md-15 col-sm-12">
						<div class="left col-xs-5 text-center">
							<img src="/images/img.jpg" alt=""
								class="img-circle img-responsive">
						</div>
						<div class="right col-xs-6">
							<h3>${member.mem_name}</h3>
							<p>
								<strong>About: </strong> Web Designer / UX / Graphic Artist /
								Coffee Lover
							</p>
							<ul class="list-unstyled">
								<li><i class="fa fa-building"></i> Address: ${member.mem_add}</li>
								<li><i class="fa fa-phone"></i> Phone #: ${member.mem_tel}</li>
							</ul>
						</div>
					</div>
					<div class=" col-md-15 col-xs-12 bottom text-center">
						<div class="col-xs-12 col-sm-6 emphasis">
							<p class="ratings">
								<a>4.0</a> <a href="#"><span class="fa fa-star"></span></a> 
								<a href="#"><span class="fa fa-star"></span></a> 
								<a href="#"><span class="fa fa-star"></span></a> 
								<a href="#"><span class="fa fa-star"></span></a> 
								<a href="#"><span class="fa fa-star-o"></span></a>
							</p>
						</div>
						<div class="col-xs-12 col-sm-6 emphasis">
							<button type="button" class="btn btn-success btn-xs">
								2180 P <i class="fa fa-user"> </i> <i class="fa fa-comments-o"></i>
							</button>
							<button type="button" class="btn btn-primary btn-xs">
								<i class="fa fa-user"> </i> 사용내역
							</button>
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
												<label class="control-label col-md-3 col-sm-3 col-xs-12">이름
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly="readonly"
														placeholder="${member.mem_name}">
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-md-3 col-sm-3 col-xs-12">E-Mail
													: </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly="readonly"
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
												<label class="control-label col-md-3 col-sm-3 col-xs-12">생년
													월일 : </label>
												<div class="col-md-9 col-sm-9 col-xs-12">
													<input type="text" class="form-control" readonly="readonly"
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
									<c:forEach items="${starList}" var="vo">
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
															<c:forEach items="${starList}" var="vo">
																<c:if test="${vo.star_kind eq '111'}">
																<div class="snipcart-thumb">
																	<a href="/userProd/detail?prod_id=${vo.prod_id}">
																	<img src="/images/5.png" alt=" " class="img-responsive" /></a>
																	<p>상품이름</p>
																	<h4>가격</h4>
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
						<div role="tabpanel" class="tab-pane fade" id="tab_content5"
							aria-labelledby="profile-tab">
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
										<tr>
											<td>${vo.pay_id}</td>
											<td>${vo.pay_date}의 결제내역</td>
											<td>총수량예정</td>											
											<td>총합계예정</td>
											<td>${vo.pay_date}</td>
										</tr> 
								    </c:forEach>								
								</tbody>							
							</table>
							3. 페이징처리 필요
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- //about -->
</div>
<div class="clearfix"></div>

<!-- //banner -->
