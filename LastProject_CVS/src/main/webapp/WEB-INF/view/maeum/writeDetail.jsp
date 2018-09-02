<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- <head profile="http://www.w3.org/2005/10/profile"> -->
<!-- <link rel="icon" type="image/png" href="http://example.com/myicon.png"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Store a Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Events :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="/js/common/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="/js/common/move-top.js"></script>
<script type="text/javascript" src="/js/common/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
	
<body>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="products.html">Today's special Offers !</a>
		</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}" required="">
				<input type="submit" value=" ">
			</form>
		</div>
		<div class="product_list_header">  
			<form action="#" method="post" class="last">
                <fieldset>
                    <input type="hidden" name="cmd" value="_cart" />
                    <input type="hidden" name="display" value="1" />
                    <input type="submit" name="submit" value="View your cart" class="button" />
                </fieldset>
            </form>
		</div>
		<div class="w3l_header_right">
			<ul>
				<li class="dropdown profile_details_drop">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
					<div class="mega-dropdown-menu">
						<div class="w3ls_vegetables">
							<ul class="dropdown-menu drp-mnu">
								<li><a href="login.html">Login</a></li> 
								<li><a href="login.html">Sign Up</a></li>
							</ul>
						</div>                  
					</div>	
				</li>
			</ul>
		</div>
		<div class="w3l_header_right1">
			<h2><a href="mail.html">Contact Us</a></h2>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="index.html"><span>Grocery</span> Store</a></h1>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="events.html">Events</a><i>/</i></li>
					<li><a href="about.html">About Us</a><i>/</i></li>
					<li><a href="products.html">Best Deals</a><i>/</i></li>
					<li><a href="services.html">Services</a></li>
				</ul>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">store@grocery.com</a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>Events</li>
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
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="products.html">Branded Foods</a></li>
						<li><a href="household.html">Households</a></li>
						<li class="dropdown mega-dropdown active">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Veggies & Fruits<span class="caret"></span></a>				
							<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
								<div class="w3ls_vegetables">
									<ul>	
										<li><a href="vegetables.html">Vegetables</a></li>
										<li><a href="vegetables.html">Fruits</a></li>
									</ul>
								</div>                  
							</div>				
						</li>
						<li><a href="kitchen.html">Kitchen</a></li>
						<li><a href="short-codes.html">Short Codes</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Beverages<span class="caret"></span></a>
							<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
								<div class="w3ls_vegetables">
									<ul>
										<li><a href="drinks.html">Soft Drinks</a></li>
										<li><a href="drinks.html">Juices</a></li>
									</ul>
								</div>                  
							</div>	
						</li>
						<li><a href="pet.html">Pet Food</a></li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">Frozen Foods<span class="caret"></span></a>
							<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
								<div class="w3ls_vegetables">
									<ul>
										<li><a href="frozen.html">Frozen Snacks</a></li>
										<li><a href="frozen.html">Frozen Nonveg</a></li>
									</ul>
								</div>                  
							</div>	
						</li>
						<li><a href="bread.html">Bread & Bakery</a></li>
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
<!-- events -->
		<div class="events">
			<h3>게시글 상세조회</h3>
			
			
			<!------------------------------------- 공지사항 게시글 상세조회 ----------------------------------->		
		
				
				<div class="form-group">
					<div id="mem_idLabel" class="col-sm-10">
					<label for="mem_id" class="col-sm-2 control-label">작성자 : </label>
					<label class="control-label">${boardVo.mem_id}</label>
					<input id="mem_id" type="hidden" name="mem_id" value="${boardVo.mem_id }">
					</div>
				</div>	
							
				<div class="form-group">
					<div id="w_nameLabel" class="col-sm-10">
					<label for="bd_date" class="col-sm-2 control-label">작성일 : </label>
					<label class="control-label">${boardVo.bd_date}</label>
					<input type="hidden" name="bd_id" value="${boardVo.bd_id}">	
					</div>
				</div>	
							
				<div class="form-group">
					<div id="w_titleLabel" class="col-sm-10">
					<label for="bd_title" class="col-sm-2 control-label">제목 : </label>
					<label class="control-label">${boardVo.bd_title}</label>
					<input type="hidden" name="bd_title" value="${boardVo.bd_title}">	
					</div>
				</div>	
																	
				<div class="form-group">
					<div id="w_cntLabel" class="col-sm-10">
					<label for="bd_content" class="col-sm-2 control-label">내용 : </label>
					<label class="control-label">${boardVo.bd_content}</label>
					<input type="hidden" name="bd_content" value="${boardVo.bd_content}">	
					</div>
				</div>	
				
				<!-- write update, delete -->				
<!-- 수정버튼 미작성입니다.
				<div class="form-group">					　        
				<form id="updatefrm" action="/write/updateWrite" method="get">
					<div class="col-sm-10">
					<label class="col-sm-2 control-label"></label>					
					${studentVo.std_id==writeVo.w_name?
					'<button type="submit" id="updatebtn" class="btn btn-default">수정</button>':""}
					<input type="hidden" name="w_no" value="${boardVo.w_no}">
					<input type="hidden" name="b_no" value="${boardVo.b_no}">					
					</div>	
				</form>
				</div>
-->
				
<!-- 삭제버튼 미작성입니다.				
				<div class="form-group">
				<form id="deletefrm" action="/write/deleteWrite" method="get">
					<div class="col-sm-10">
					<label class="col-sm-2 control-label"></label>						　					
					${studentVo.std_id==writeVo.w_name?
					'<button type="submit" id="deletebtn" class="btn btn-default">삭제</button>':""}
					<input type="hidden" name="w_no" value="${boardVo.w_no}">
					<input type="hidden" name="w_dlt" value="y">
					<input type="hidden" name="b_no" value="${boardVo.b_no}">
					</div>
				</form>
				</div>
				
				<div class="form-group">	
				</div>	
-->						
				<!-- reply -->
<!-- 답글 미작성입니다.				
				<div class="form-group">							
				<form id="replyfrm" action="/write/replyWrite" method="get">
					<div class="col-sm-10">
					<label class="col-sm-2 control-label"></label>			
						${studentVo.std_id==boardVo.bd_name?"":
						'<button type="submit" id="replybtn" class="btn btn-default">답글</button>'}
						<input type="hidden" name="w_no" value="${boardVo.w_no}">
						<input type="hidden" name="b_no" value="${boardVo.b_no}">
						<input type="hidden" name="w_gno" value="${boardVo.w_gno}">
					</div>
				</form>	
				</div>
-->
				
<!--  파일첨부 미작성입니다.				
				<div class="form-group">
					<div class="col-sm-10">
					<label for="name" class="col-sm-2 control-label">첨부 파일 : </label>
						<c:if test="${filesVo != null}">
							<c:forEach items="${filesVo }" var="vo">
								<c:if test="${vo.f_dlt == 'n'}">
								[ <a href="javascript:fn_fileDownload('${vo.f_picpath}', '${vo.f_name}', '${vo.f_picname}');">
								<label class="control-label">${vo.f_picname}</label></a> ]
								</c:if>
							</c:forEach><br><hr>						
						</c:if>
					</div>
				</div>
-->				
				<!-- Comments insert, delete -->
<!-- 댓글조회 미작성입니다.					
				<div class="form-group">
				<form id="deleteC1" action="/comments/deleteCnt" method="get">
					<div class="col-sm-10">
					<c:forEach items="${commentsVo}" var="vo">
					<label for="name" class="col-sm-2 control-label"></label>*  
						<c:choose>
							<c:when test="${vo.c_dlt=='y'}">
							[  삭제된 댓글입니다. ]
							</c:when>
						</c:choose>
						<c:choose>
							<c:when test="${vo.c_dlt=='n'}">
							${vo.c_cnt}   [  작성자 : ${vo.c_name}  /  <fmt:formatDate value="${vo.c_date}" pattern="yyyy/MM/dd HH:MM:ss" />  ]
							</c:when>
						</c:choose>				  	
					<c:if test="${studentVo.std_id==vo.c_name && vo.c_dlt=='n'}">
						<button type="submit" id="deleteCntBtn" name="c_no" value="${vo.c_no}" class="btn btn-default">삭제</button>
					</c:if><br><hr>
					</c:forEach><br>
					<input type="hidden" name="w_no" value="${writeVo.w_no}">
					</div>							
				</form>
				<form id="insertC1" action="/comments/insertCnt" method="get">
					<div class="col-sm-10">
						<div id="w_cntLabel" class="col-sm-6">
						<input type="text" id="c_cnt" name="c_cnt" class="form-control">
						</div>
						<input type="hidden" name="w_no" value="${writeVo.w_no}">
						<input type="hidden" name="id" value="${studentVo.id}">
						<input type="hidden" name="c_name" value="${studentVo.std_id}">
						<button type="submit" id="insertCntBtn" class="btn btn-default">추가</button>
					</div>
				</form>					
			</div>		
-->		
			
			
			
			
			
			
											<!-- 공지사항 게시글 상세조회 끝입니다. -->			
			
			
			
			
			
			
			
			
			
			
			
			
			
			<!------------------------------------- sample ----------------------------------->
			
			<div class="w3agile_event_grids">
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-bullhorn" aria-hidden="true"></i>
					</div>					
					<!-- event 코드 나열 -->
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>board</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-bullseye" aria-hidden="true"></i>
					</div>
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>rerum hic tenetur a sapiente</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
			
			<!------------------------------------- sample ----------------------------------->
			
			<div class="events-bottom">
				<div class="col-md-6 events_bottom_left">
					<div class="col-md-4 events_bottom_left1">
						<div class="events_bottom_left1_grid">
							<h4>20</h4>
							<p>July, 2016</p>
						</div>
					</div>
					<div class="col-md-8 events_bottom_left2">	
						<img src="/images/login/15.jpg" alt=" " class="img-responsive" />
						<h4>ut aut reiciendis facere possimus</h4>
						<ul>
							<li><i class="fa fa-clock-o" aria-hidden="true"></i>3:00 PM</li>
							<li><i class="fa fa-user" aria-hidden="true"></i><a href="#">Admin</a></li>
						</ul>
						<p>Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil 
							impedit quo minus id quod maxime placeat facere possimus, omnis voluptas 
							assumenda est.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-6 events_bottom_left">
					<div class="col-md-4 events_bottom_left1">
						<div class="events_bottom_left1_grid">
							<h4>21</h4>
							<p>July, 2016</p>
						</div>
					</div>
					<div class="col-md-8 events_bottom_left2">	
						<img src="/images/login/19.jpg" alt=" " class="img-responsive" />
						<h4>maxime placeat facere possimus</h4>
						<ul>
							<li><i class="fa fa-clock-o" aria-hidden="true"></i>3:30 PM</li>
							<li><i class="fa fa-user" aria-hidden="true"></i><a href="#">Admin</a></li>
						</ul>
						<p>Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil 
							impedit quo minus id quod maxime placeat facere possimus, omnis voluptas 
							assumenda est.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
<!-- //events -->
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
<!-- newsletter -->
	<div class="newsletter">
		<div class="container">
			<div class="w3agile_newsletter_left">
				<h3>sign up for our newsletter</h3>
			</div>
			<div class="w3agile_newsletter_right">
				<form action="#" method="post">
					<input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
					<input type="submit" value="subscribe now">
				</form>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //newsletter -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="col-md-3 w3_footer_grid">
				<h3>information</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="events.html">Events</a></li>
					<li><a href="about.html">About Us</a></li>
					<li><a href="products.html">Best Deals</a></li>
					<li><a href="services.html">Services</a></li>
					<li><a href="short-codes.html">Short Codes</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>policy info</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="faqs.html">FAQ</a></li>
					<li><a href="privacy.html">privacy policy</a></li>
					<li><a href="privacy.html">terms of use</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>what in stores</h3>
				<ul class="w3_footer_grid_list">
					<li><a href="pet.html">Pet Food</a></li>
					<li><a href="frozen.html">Frozen Snacks</a></li>
					<li><a href="kitchen.html">Kitchen</a></li>
					<li><a href="products.html">Branded Foods</a></li>
					<li><a href="household.html">Households</a></li>
				</ul>
			</div>
			<div class="col-md-3 w3_footer_grid">
				<h3>twitter posts</h3>
				<ul class="w3_footer_grid_list1">
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i>01 day ago</i><span>Non numquam <a href="#">http://sd.ds/13jklf#</a>
						eius modi tempora incidunt ut labore et
						<a href="#">http://sd.ds/1389kjklf#</a>quo nulla.</span></li>
					<li><label class="fa fa-twitter" aria-hidden="true"></label><i>02 day ago</i><span>Con numquam <a href="#">http://fd.uf/56hfg#</a>
						eius modi tempora incidunt ut labore et
						<a href="#">http://fd.uf/56hfg#</a>quo nulla.</span></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
			<div class="agile_footer_grids">
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h4>100% secure payments</h4>
						<img src="/images/login/card.png" alt=" " class="img-responsive" />
					</div>
				</div>
				<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
					<div class="w3_footer_grid_bottom">
						<h5>connect with us</h5>
						<ul class="agileits_social_icons">
							<li><a href="#" class="facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
							<li><a href="#" class="twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
							<li><a href="#" class="google"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
							<li><a href="#" class="instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
							<li><a href="#" class="dribbble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="wthree_footer_copy">
				<p>© 2016 Grocery Store. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
			</div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="/js/common/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="/js/common/minicart.js"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

	</script>
</body>
</html>