<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>이벤트</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->
<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_right">
<!-- events -->
		<div class="events">
			<h3>이벤트</h3>
			<div class="w3agile_event_grids">
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-bullhorn" aria-hidden="true"></i>
					</div>
					
					<!-- event 시작-------------------------------------------------------->
					<!-- event 코드 나열 -->
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>cum soluta nobis eligendi</h4>
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
			<div class="w3agile_event_grids">
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-credit-card" aria-hidden="true"></i>
					</div>
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>earum rerum tenetur sapiente</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-eye" aria-hidden="true"></i>
					</div>
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>quibu aut officiis debitis</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="w3agile_event_grids">
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-cog" aria-hidden="true"></i>
					</div>
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>necessitatibus saepe eveniet</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="col-md-6 w3agile_event_grid">
					<div class="col-md-3 w3agile_event_grid_left">
						<i class="fa fa-trophy" aria-hidden="true"></i>
					</div>
					<div class="col-md-9 w3agile_event_grid_right">
						<h4>repudiandae sint et molestiae</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis 
							voluptatibus.</p>
					</div>
					
					<!------ 이벤트  ENd ----------------------->
					
					
					
					
					
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
<!-- //events -->
		</div>
		<div class="clearfix"></div>
	</div>
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