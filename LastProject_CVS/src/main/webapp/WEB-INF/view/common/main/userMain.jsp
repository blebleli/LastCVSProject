<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>

<style>

</style>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css' />" media="all"></link>

<script type="text/javascript">
	//<![CDATA[
		$(document).ready(function(){
			jQuery(function($){
				// List Tab Navigation
				var tab_list = $('.prod_tab');
				var tab_list_i = tab_list.find('>ul>li');
				tab_list.removeClass('jx');
				tab_list_i.find('>div').hide();
				tab_list.find('>ul>li').eq(0).addClass("active");
				tab_list.find('>ul>li[class=active]').find('>div').show();
				tab_list.css('height', tab_list.find('>ul>li.active>div').height()+40);
				function listTabMenuToggle(event){
					var t = $(this);
					tab_list_i.find('>div').hide();
					t.next('div').show();
					tab_list_i.removeClass('active');
					t.parent('li').addClass('active');
					tab_list.css('height', t.next('div').height()+40);
					return false;
				}
				tab_list_i.find('>a[href=#]').click(listTabMenuToggle).focus(listTabMenuToggle);
			});
		});
	//]]>
</script>
	
	
<!-- boader------------------------------------------------------------------------------ -->
<div class="products-breadcrumb">
	<div class="container">

	</div>
</div>


<!-- flexslider ------------------------------------------------------------------------------ -->
<div class="flex-viewport" style="overflow: hidden; position: relative;">
<section class="slider">
	<div class="flexslider">
		
		  <ul class="slides">
		    <li>
		      <img src="/images/event1.jpg" />
		    </li>
		    <li>
		      <img src="/images/event2.jpg" />
		    </li>
		    <li>
		      <img src="/images/event3.jpg" />
		    </li>
		    <li>
		      <img src="/images/event4.jpg" />
		    </li>
		  </ul>
		<!-- <div class="flex-viewport" style="overflow: hidden; position: relative;">
			<ul class="slides" style="width: 1000%; transition-duration: 0.6s; transform: translate3d(-1492px, 0px, 0px);">
				
				<li class="clone" style="width: 746px; float: left; display: block;">
					<div class="w3l_banner_nav_right_banner2">
						<h3>
							이미지 옆 문구  
							 해당 <i>이벤트 내용_1</i>간략히  
						</h3>
						<div class="more">
							자세히 클릭
							<a href="#" class="button--saqui button--round-l button--text-thick" data-text="Shop now">자세히</a>
						</div>
					</div>
				</li>
				
				<li style="width: 746px; float: left; display: block;" class="">
					<div class="w3l_banner_nav_right_banner">
						<h3>
							해당 <span>이벤트 내용_2</span>간략히
						</h3>
						<div class="more">
							<a href="#"
								class="button--saqui button--round-l button--text-thick"
								data-text="Shop now">자세히</a>
						</div>
					</div>
				</li>
				<li style="width: 746px; float: left; display: block;"
					class="flex-active-slide">
					<div class="w3l_banner_nav_right_banner1">
						<h3>
							Make your <span>food</span> with Spicy.
						</h3>
						<div class="more">
							<a href="#"
								class="button--saqui button--round-l button--text-thick"
								data-text="Shop now">자세히</a>
						</div>
					</div>
				</li>
				<li style="width: 746px; float: left; display: block;" class="">
					<div class="w3l_banner_nav_right_banner2">
						<h3>
							upto <i>50%</i> off.
						</h3>
						<div class="more">
							<a href="#"
								class="button--saqui button--round-l button--text-thick"
								data-text="Shop now">자세히</a>
						</div>
					</div>
				</li>
				<li style="width: 746px; float: left; display: block;" class="clone">
					<div class="w3l_banner_nav_right_banner">
						<h3>
							Make your <span>food</span> with Spicy.
						</h3>
						<div class="more">
							<a href="#"
								class="button--saqui button--round-l button--text-thick"
								data-text="Shop now">자세히</a>
						</div>
					</div>
				</li>
			</ul>
		</div> -->
	</div>
</section>
</div>


<!-- flexSlider js ------------------------------------------------------------------ -->
<link rel="stylesheet" href="/css/flexslider.css" type="text/css" media="screen">
<script src="/js/common/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			itemWidth: 746,
			itemMargin: 5,
			maxItems: 2
		});
	});
</script>
<!-- //flexSlider -->

<div class="clearfix"></div>

<br><br>

<!-- best review------------------------------------------------------------------------------ -->

	<div class="agile_top_brands_grids">
		<div class="container">
			<div class="row">
				<h2 class="text-center">Best Product </h2>
		        <hr/>
			</div>
		    <div class="row">
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">		          
		                <img src="/images/event1.jpg" alt="...">              
		                <div class="clearfix"></div>		              
		            </div>
		        </div>
		        
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">
		                <img src="/images/event2.jpg" alt="...">                             
		                <div class="clearfix"></div>
		            </div>
		        </div>
		        
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">
		                <img src="/images/event3.jpg" alt="...">              
		                <div class="clearfix"></div>
		            </div>
		        </div>
		        
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">
		                <img src="/images/event3.jpg" alt="...">              
		                <div class="clearfix"></div>
		            </div>
		        </div>	
		        
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">
		                <img src="/images/event3.jpg" alt="...">              
		                <div class="clearfix"></div>
		            </div>
		        </div>
		        
		        <div class="col-sm-6 col-md-4">
		            <div class="thumbnail">
		                <img src="/images/event3.jpg" alt="...">              
		                <div class="clearfix"></div>
		            </div>
		        </div>			
		    </div>
		</div>
	</div>


<div class="clearfix"></div>

<!-- 행사상품 TEST------------------------------------------------------------------------------ -->

<div class="all_wrap prod_wrap" style="background: #ddf5fb; ">
<!-- 상품소개 -->
<div class="prod_tab" style="height: 280px;">
	<ul>
   		<li class="" style="list-style: none">
	<a href="#">
		<span class="tit"><em>1+1</em> 상품</span>
		<span class="txt">행사상품 사면 하나 더</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul style="list-style: none">
			<li>
								<div class="sbbox pro">
									<span class="tip typ1"><span>1+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8809329050015_016.jpg" alt="천지개벽숙취 상품"></a>
												<span class="title">
										<em class="mt">
                                          천지개벽)숙취해소음료</em>
										<em>5,000원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ1"><span>1+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8809443210548_001.jpg" alt="디즈니카페베네 상품"></a>
												<span class="title">
										<em class="mt">
                                          Y)디즈니썸썸카페베네아...
                                              </em>
										<em>2,900원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ1"><span>1+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801045640471_001.jpg" alt="Y)진짬뽕참치 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스)진짬뽕참치150...
                                              </em>
										<em>3,200원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ1"><span>1+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801069185330_004.jpg" alt="Y)스와이스라임 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스)스와이스라임탄산...
                                              </em>
										<em>1,500원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						</ul>
        <a href="/user/eventProducts" class="btn_more">더보기<span class="ico_more"></span></a>
	        </div>
	<!-- //product list -->
</li>
<li class="" style="list-style: none">
	<a href="#">
		<span class="tit"><em>2+1</em> 상품</span>
		<span class="txt">다양하고 놀라운 +1헹사</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul style="list-style: none">
			<li>
								<div class="sbbox pro">
									<span class="tip typ2"><span>2+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8809594420605_001.jpg" alt="Y)고사리소시지 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스)제주흑돼지고사리...
                                              </em>
										<em>2,200원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ2"><span>2+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801047289999_001.jpg" alt="Y(P)하동녹차 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스(P)지리산하동녹...
                                              </em>
										<em>2,000원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ2"><span>2+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8809344666079_001.jpg" alt="럭키사이다350 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스)럭키사이다350...
                                              </em>
										<em>1,000원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ2"><span>2+1</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801045892757_001.jpg" alt="기장미역국밥 상품"></a>
												<span class="title">
										<em class="mt">
                                          유어스(P)기장미역국밥...
                                              </em>
										<em>3,500원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						</ul>
        <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a>
	        </div>
	<!-- //product list -->
</li>
<li class="" style="list-style: none">
	<a href="#">
		<span class="tit"><em>할인</em> 상품</span>
		<span class="txt">할인상품과 함께 즐기는 혜택</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul style="list-style: none">
			<li>
								<div class="sbbox pro">
									<span class="tip typ3"><span>덤<br>증정</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801007672601_001.jpg" alt="비비고한입떡갈 상품"></a>
												<span class="title">
										<em class="mt">
                                          CJ)비비고한입떡갈비1...
                                              </em>
										<em>3,500원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ3"><span>덤<br>증정</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801007627441_001.jpg" alt="비비고한섬만두 상품"></a>
												<span class="title">
										<em class="mt">
                                          CJ)비비고한섬만두38...
                                              </em>
										<em>4,800원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ3"><span>덤<br>증정</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/" alt="동원)리챔340G 상품"></a>
												<span class="title">
										<em class="mt">
                                          동원)리챔340G</em>
										<em>6,800원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<span class="tip typ3"><span>덤<br>증정</span></span>
									<a href="/gscvs/ko/products/event-goods"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801008002094_001.jpg" alt="뉴)핸드크림56G 상품"></a>
												<span class="title">
										<em class="mt">
                                          뉴트로지나)핸드크림56...
                                              </em>
										<em>8,900원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						</ul>
        <a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a>
	        </div>
	<!-- //product list -->
</li>
<li class="" style="list-style: none">
	<a href="#">
		<span class="tit"><em>CU25(PB)</em> 상품</span>
		<span class="txt">CU25에만 있는 브랜드상품</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: block;">
		<ul style="list-style: none">
			<li>
								<div class="sbbox pro">
									<a href="/gscvs/ko/products/youus-main"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801128280068_001.jpg" alt="그랜드 리프레 상품"></a>
											<span class="title">
										<em class="mt">
                                          유어스)야쿠르트그랜드리...
										      </em>
										<em>1,500원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/pb-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<a href="/gscvs/ko/products/youus-main"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8809422010343_001.jpg" alt="Y)스노우초코칩 상품"></a>
											<span class="title">
										<em class="mt">
                                          유어스)스노우초코칩</em>
										<em>1,000원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/pb-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<a href="/gscvs/ko/products/youus-main"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801062001576_001.jpg" alt="Y(P)크런키녹차 상품"></a>
											<span class="title">
										<em class="mt">
                                          유어스(P)크런키녹차2...
										      </em>
										<em>2,500원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/pb-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						<li>
								<div class="sbbox pro">
									<a href="/gscvs/ko/products/youus-main"><img src="http://gs25appimg.gsretail.com/imgsvr/item/GD_8801047289999_001.jpg" alt="Y(P)하동녹차 상품"></a>
											<span class="title">
										<em class="mt">
                                          유어스(P)지리산하동녹...
										      </em>
										<em>2,000원</em>
										</span>
								</div>
								<!-- <a href="/gscvs/ko/products/pb-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
							</li>
						</ul>
        <a href="/gscvs/ko/products/youus-main" class="btn_more">더보기<span class="ico_more"></span></a>
	        </div>
	<!-- //product list -->
	</li>
	</ul>
</div>
						<!-- //상품소개 -->
					</div>

<div class="clearfix"></div>

<!-- best review------------------------------------------------------------------------------ -->

<div class="agile_top_brands_grids">
	<div class="container">
	<div class="row">
		<h2 class="text-center">Best Review </h2>
        <hr/>
	</div>
    <div class="row">
    
    
    <c:forEach items="${bestReview}" var="vo">	
        <div class="col-sm-6 col-md-4" >
            <div class="thumbnail">
                <h4>          
                    <span class="label label-info info">
                        <span data-toggle="tooltip" title="viewed">${vo.bd_views} <b class="glyphicon glyphicon-eye-open"></b></span>
                        <span data-toggle="tooltip" title="viewed">${vo.bd_rating} <b class="glyphicon glyphicon-star"></b></span>
                      
                    </span>
                </h4>
                <img src="/images/event1.jpg" alt="...">
                 리뷰가들어갈 공간
                <a href="#reviewBoard" class="btn btn-primary col-xs-12" role="button">View Snippet</a>
                <div class="clearfix"></div>
              
            </div>
        </div>
    </c:forEach>

        
  

    </div>
</div>
	


<!-- 		<div class="wthree_banner_bottom_left_grid">
			<img src="/images/4.jpg" alt=" " class="img-responsive" />
			<div class="wthree_banner_bottom_left_grid_pos">
				<h4>
					Discount Offer <span>25%</span>
				</h4>
			</div>
		</div>
	</div>
	<div class="col-md-4 wthree_banner_bottom_left">
		<div class="wthree_banner_bottom_left_grid">
			<img src="/images/5.jpg" alt=" " class="img-responsive" />
			<div class="wthree_banner_btm_pos">
				<h3>
					introducing <span>best store</span> for <i>groceries</i>
				</h3>
			</div>
		</div>
	</div>
	<div class="col-md-4 wthree_banner_bottom_left">
		<div class="wthree_banner_bottom_left_grid">
			<img src="/images/6.jpg" alt=" " class="img-responsive" />
			<div class="wthree_banner_btm_pos1">
				<h3>
					Save <span>Upto</span> $10
				</h3>
			</div> -->
	

</div>


<div class="clearfix"></div>

<!-- 공지사항------------------------------------------------------------------------------ -->

<div class="fresh-vegetables">
	<h3>공지사항</h3>
	<div class="w3l_fresh_vegetables_grids">		
		<div class="col-md-9 w3l_fresh_vegetables_grid_right">	
				<table class="table"    style="text-align: center;">
				<tr> 
					<th>ddddddd</th>
					<th>ddddddd</th>
				</tr>
				<tr> 
					<td>ddddddd</td>
					<td>ddddddd</td>
				</tr>
					
				</table>
	
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //fresh-vegetables -->