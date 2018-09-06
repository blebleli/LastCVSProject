<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/cuTest.css' />" media="all"></link>

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
/* 			start : function(slider) {
				$('body').removeClass('loading');
			} */
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
<div class="col-sm-6 col-md-4" style="float: left;">
	<table class="table table-striped">
	
	<tr>
		<td>제목입니다.</td>
		<td>날짜</td>
	</tr>
	<tr>
		<th>제목입니다.</th>
		<th>날짜</th>
	</tr>
	<tr>
		<th>제목입니다.</th>
		<th>날짜</th>
	</tr>
	</table>
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
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <h4>
           
                    <span class="label label-info info">
                        <span data-toggle="tooltip" title="viewed">257 <b class="glyphicon glyphicon-eye-open"></b></span>
                        <span data-toggle="tooltip" title="viewed">3 <b class="glyphicon glyphicon-star"></b></span>
                      
                    </span>
                </h4>
                <img src="/images/event1.jpg" alt="...">
                 리뷰가들어갈 공간
                <a href="#reviewBoard" class="btn btn-primary col-xs-12" role="button">View Snippet</a>
                <div class="clearfix"></div>
              
            </div>
        </div>
        
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <h4>
                    
                    <span class="label label-info info">
                        <span data-toggle="tooltip" title="Viewed">433 <i class="glyphicon glyphicon-eye-open"></i></span>
                        <span data-toggle="tooltip" title="Favorited">4 <i class="glyphicon glyphicon-star"></i></span>
                      
                    </span>
                </h4>
                <img src="/images/event2.jpg" alt="...">
                리뷰가들어갈 공간
                <a href="#reviewBoard" class="btn btn-primary col-xs-12" role="button">View Snippet</a>               
                <div class="clearfix"></div>
            </div>
        </div>
        
        <div class="col-sm-6 col-md-4">
            <div class="thumbnail">
                <h4>                 
                    <span class="label label-info info">
                        <span data-toggle="tooltip" title="Viewed">2.1K <b class="glyphicon glyphicon-eye-open"></b></span>
                        <span data-toggle="tooltip" title="Favorited">13 <b class="glyphicon glyphicon-star"></b></span>
                     
                    </span>
                </h4>
                <img src="/images/event3.jpg" alt="...">
                 리뷰가들어갈 공간
                <a href="#reviewBoard" class="btn btn-primary col-xs-12" role="button">View Snippet</a>
                <div class="clearfix"></div>
            </div>
        </div>

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


<!-- top-brands -->
<h3>Best review</h3>
<div class="agile_top_brands_grids">
	
	<c:forEach items="${bestProd}" var="vo">
	<div class="col-md-3 top_brand_left">
		<div class="hover14 column">
			<div class="agile_top_brand_left_grid">
				<div class="tag">
					<img src="/images/tag.png" alt=" " class="img-responsive" />
				</div>
				<div class="agile_top_brand_left_grid1">
					<figure>					
						<div class="snipcart-item block">
							<div class="snipcart-thumb">
								<a href="single.html"><img title=" " alt=" "
									src="/images/1.png" /></a>
								<p>${vo.prod_name}</p>
								<h4>
									${vo.prod_price} <span>${vo.prod_price}</span>
								</h4>
							</div>
							<div class="snipcart-details top_brand_home_details">
								<form action="checkout.html" method="post">
									<fieldset>
										<input type="hidden" name="cmd" value="_cart" /> <input
											type="hidden" name="add" value="1" /> <input type="hidden"
											name="business" value=" " /> <input type="hidden"
											name="item_name" value="Fortune Sunflower Oil" /> <input
											type="hidden" name="amount" value="7.99" /> <input
											type="hidden" name="discount_amount" value="1.00" /> <input
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
	</c:forEach>

</div>

<div class="clearfix"></div>

<!-- //top-brands -->
<!-- fresh-vegetables -->
<div class="fresh-vegetables">
	<h3>Top Products</h3>
	<div class="w3l_fresh_vegetables_grids">
		<div
			class="col-md-3 w3l_fresh_vegetables_grid w3l_fresh_vegetables_grid_left">
			<div class="w3l_fresh_vegetables_grid2">
				<ul>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="products.html">All Brands</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="vegetables.html">Vegetables</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="vegetables.html">Fruits</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="drinks.html">Juices</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="pet.html">Pet Food</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="bread.html">Bread & Bakery</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="household.html">Cleaning</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="products.html">Spices</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="products.html">Dry Fruits</a></li>
					<li><i class="fa fa-check" aria-hidden="true"></i><a
						href="products.html">Dairy Products</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9 w3l_fresh_vegetables_grid_right">
			<div class="col-md-4 w3l_fresh_vegetables_grid">
				<div class="w3l_fresh_vegetables_grid1">
					<img src="/images/8.jpg" alt=" " class="img-responsive" />
				</div>
			</div>
			<div class="col-md-4 w3l_fresh_vegetables_grid">
				<div class="w3l_fresh_vegetables_grid1">
					<div class="w3l_fresh_vegetables_grid1_rel">
						<img src="/images/7.jpg" alt=" " class="img-responsive" />
						<div class="w3l_fresh_vegetables_grid1_rel_pos">
							<div class="more m1">
								<a href="products.html"
									class="button--saqui button--round-l button--text-thick"
									data-text="Shop now">Shop now</a>
							</div>
						</div>
					</div>
				</div>
				<div class="w3l_fresh_vegetables_grid1_bottom">
					<img src="/images/10.jpg" alt=" " class="img-responsive" />
					<div class="w3l_fresh_vegetables_grid1_bottom_pos">
						<h5>Special Offers</h5>
					</div>
				</div>
			</div>
			<div class="col-md-4 w3l_fresh_vegetables_grid">
				<div class="w3l_fresh_vegetables_grid1">
					<img src="/images/9.jpg" alt=" " class="img-responsive" />
				</div>
				<div class="w3l_fresh_vegetables_grid1_bottom">
					<img src="/images/11.jpg" alt=" " class="img-responsive" />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="agileinfo_move_text">
				<div class="agileinfo_marquee">
					<h4>
						get <span class="blink_me">25% off</span> on first order and also
						get gift voucher
					</h4>
				</div>
				<div class="agileinfo_breaking_news">
					<span> </span>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //fresh-vegetables -->