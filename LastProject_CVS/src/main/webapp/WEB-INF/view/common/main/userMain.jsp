<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/main.css' />" media="all"></link>
<style>
  .col-md-3 {
    width: 16%;
}
   .bestImg{
	 height : 200px;
	}
</style>


<script>
	$(function() {
// 		이미지 클릭
		$("#prodImage").on("click", function(){
			$("#detailFrm").submit();
			console.log(prod_id);
		});
	});
</script>
<script>
function categoryPopup(){
	
	$.ajax({
		url : "/user/speech",
		datatype : "html",
		success:function(responseData){
			console.log("성공");
			 $('#speechDiv').html(responseData);
		}
	});
	
/* 	
    var url="/adprod/categoryPopup";
    window.open("/adprod/categoryPopup","카테고리추가","width=800,height=450,left=500, top=100"); */
}
</script>
<script>
	$(function(){
		$("table tr").on("click", function(){
			$("#prod_id").val($(this).data("id")); // 관리자는 삭제여부 상관없이 모든 게시글 조회 가능
			$("#reviewsDetail").submit();
		});
	});
</script>

<!-- 데이터 전송 -->
<form action="/userProd/detail" method="post" id="detailFrm">
	<input type="hidden" name="prod_id" value="${prod.prod_id }" />
</form>
	
<!-- boader------------------------------------------------------------------------------ -->
<div class="products-breadcrumb">
	<div class="container">
<!-- 		<a><i class="fa fa-microphone" aria-hidden="true"></i></a> -->
	<a data-toggle="modal" data-target=".ctgr-modal-lg" onclick="categoryPopup();"><i class="fa fa-microphone" aria-hidden="true"></i></a>
			<div class="modal fade ctgr-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-lg">
				<div class="modal-content">								  
				  <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title">MIC-Search</h4>
			      </div>										      
			      	<div id="speechDiv" class="modal-content"></div>																			   												
			    </div>
			  </div>
			</div>
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

<!-- 카테고리별 best ------------------------------------------------------------------------------ -->

	<div class="agile_top_brands_grids">
		<div class="container" style="width : 1500px">
			<div class="row">
				<h2 class="text-center">Best Product </h2>
		        <hr/>
			</div>
		    <div class="row">
		    
 		  <c:forEach items="${bestProduct}" var="vo">	
		     
		    	<div class="col-sm-6 col-md-3">
		    		<label>${vo.pr_class_lg}</label>
		            <div class="thumbnail">
		            	<a href="/userProd/detail?prod_id=${vo.prod_id}"	id="prodImage">
		                	<img class="bestImg" src="${vo.file_path}/${vo.file_upname}" alt="..." width="400px" height="200px">
		                </a>
		                <div class="clearfix"></div>		              
		            </div>
		        </div>
		        
		   </c:forEach>   
		    </div>
		</div>
	</div>


<div class="clearfix"></div>

<!-- 행사상품 ---------------------------------------------------------------------------------- -->


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
				tab_list_i.find('>a[href="#"]').click(listTabMenuToggle).focus(listTabMenuToggle);
			});
		});
	//]]>
</script>

<div class="all_wrap prod_wrap" style="background: #ddf5fb; ">
<!-- 상품소개 -->
<div class="prod_tab" style="height: 280px;">
	<ul >
   		<li class="" style="list-style: none">
			<a href="#">
				<span class="tit"><em>1+1</em> 상품</span>
				<span class="txt">행사상품 사면 하나 더</span>
				<span class="tab_arr"></span>
			</a>
			<!-- product list -->
			<!-- <div class="prd_lst"> -->
			<div class="prd_lst" style="display: none;">
				<ul style="list-style: none"  >
					<c:forEach items="${eventProd1}" var="vo">					
					<li>
						<div class="sbbox pro">
							<span class="tip typ1"><span >1+1</span></span>
							<a href="/userProd/detail?prod_id=${vo.prod_id}"	id="prodImage">
								<img src="${vo.file_path}/${vo.file_upname}" alt="${vo.prod_name }"  width="150" height="150"></a>
										<span class="title">
								<em class="mt"> ${vo.prod_name }</em>
								<em>${vo.prod_price }원</em>
								</span>
						</div>
<!-- 						<a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
					</li>
					</c:forEach>
				</ul>
		        <a href="<c:url value='/userProd/view?i=3&page=1&pageSize=32' />" class="btn_more">더보기<span class="glyphicon glyphicon-plus"></span></a>
			</div>
			<!-- //product list -->
		</li>
		
		<li class="" style="list-style: none">
			<a href="#">
				<span class="tit"><em>2+1</em> 상품</span>
				<span class="txt">다양하고 놀라운 +1행사</span>
				<span class="tab_arr"></span>
			</a>
			<!-- product list -->
			<!-- <div class="prd_lst"> -->
			<div class="prd_lst" style="display: none;">
				<ul style="list-style: none"  >
					
					<c:forEach items="${eventProd2}" var="vo">					
					<li>
						<div class="sbbox pro">
							<span class="tip typ1"><span>2+1</span></span>
							<a href="/userProd/detail?prod_id=${vo.prod_id}"	id="prodImage">
								<img src="${vo.file_path}/${vo.file_upname}" alt="${vo.prod_name }"  width="150" height="150"></a>
										<span class="title">
								<em class="mt"> ${vo.prod_name }</em>
								<em>${vo.prod_price }원</em>
								</span>
						</div>
<!-- 						<a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
					</li>
					</c:forEach>
				</ul>
		        <a href="<c:url value='/userProd/view?i=3&page=1&pageSize=32' />" class="btn_more">더보기<span class="glyphicon glyphicon-plus"></span></a> 
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
				<ul style="list-style: none"  >
					
					<c:forEach items="${eventProd3}" var="vo">					
					<li>
						<div class="sbbox pro">
							<span class="tip typ1"><span>할인</span></span>
							<a href="/userProd/detail?prod_id=${vo.prod_id}"	id="prodImage">
								<img src="${vo.file_path}/${vo.file_upname}" alt="${vo.prod_name }"  width="150" height="150"></a>
										<span class="title">
								<em class="mt"> ${vo.prod_name }</em>
								<em>${vo.prod_price }원</em>
								</span>
						</div>
<!-- 						<a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
					</li>
					</c:forEach>
				</ul>
<%-- 		        <a href="<c:url value='/userProd/view?i=3&page=1&pageSize=32' />" class="btn_more">더보기<span class="glyphicon glyphicon-plus"></span></a> --%>
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
			<div class="prd_lst" style="display: none;">
				<ul style="list-style: none"  >
					
					<c:forEach items="${eventProd4}" var="vo">					
					<li>
						<div class="sbbox pro">
							<span class="tip typ1"><span>PB</span></span>
							<a href="/userProd/detail?prod_id=${vo.prod_id}"	id="prodImage">
								<img src="${vo.file_path}/${vo.file_upname}" alt="${vo.prod_name }"  width="150" height="150"></a>
										<span class="title">
								<em class="mt"> ${vo.prod_name }</em>
								<em>${vo.prod_price }원</em>
								</span>
						</div>
<!-- 						<a href="/gscvs/ko/products/event-goods" class="btn_more">더보기<span class="ico_more"></span></a> -->
					</li>
					</c:forEach>
				</ul>
<%-- 		        <a href="<c:url value='/userProd/view?i=3&page=1&pageSize=32' />" class="btn_more">더보기<span class="glyphicon glyphicon-plus"></span></a> --%>
			</div>
			<!-- //product list -->
		</li>
		<!-- //상품소개 -->
		</ul>
	</div>
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
	                <img src="${vo.file_path }/${vo.file_upname}" alt="..." width="200" height="200">
	                 ${vo.bd_content}
	                <a href="/userProd/detail?prod_id=${vo.prod_id }" class="btn btn-primary col-xs-12" role="button">${vo.bd_title }</a>
	                <div class="clearfix"></div>              
	            </div>
	        </div>
	    </c:forEach>
	    
	    </div>
	</div>
</div>


<div class="clearfix"></div>

<!-- 공지사항------------------------------------------------------------------------------ -->
<div class="agile_top_brands_grids">

	<div class="container">
	<div class="col-md-6">
	<h3>CU25 소식 <a href="/board/boardMain" class="btn_more" style="font-size: 15px; color: #777; float: right"> 
		더보기<span class="glyphicon glyphicon-plus"></span></a> </h3>	
		<div class="row">	
			<table class="table table-condensed" >
				 <c:forEach items="${notice}" end="5" var="vo">	
				<tr> 
					<td>${vo.bd_title}</td>
					<td>${vo.bd_date}</td>
					<%-- <fmt:formatDate value="${vo.bd_date}" pattern="yyyy-MM-dd" /> --%>
				</tr>	
				</c:forEach>			
			</table>
		</div>
	</div>
	
	<div class="col-md-6" style="padding-left: 20px">
	<h3>실시간 상품리뷰</h3>	
		<div class="row">	
			<table class="table table-condensed">
				 <c:forEach items="${review}" end="5" var="vo">	
					<c:choose>
						<c:when test="${vo.bd_del=='N'}">
							<tr data-id="${vo.prod_id}" data-id2="${vo.bd_del}">
								<td>${vo.bd_title}</td>
								<td>${vo.bd_date}</td>
							</tr>						
						</c:when>
					</c:choose>
				</c:forEach>			
			</table>
		</div>
	</div>
	
	<form id="reviewsDetail" action="/user/detail" method="get">
		<input type="hidden" name="prod_id" id="prod_id">
		<input type="hidden" name="bd_id" id="bd_id" value="${bd_id}">
	</form>	
	
<!-- 이벤트 게시판 삭제 -->
<!-- 	<div class="col-md-6" style="padding-left: 20px"> -->
<!-- 	<h3>진행중인 이벤트 <a href="/user/eventProducts" class="btn_more" style="font-size: 15px; color: #777; float: right">  -->
<!-- 		더보기<span class="glyphicon glyphicon-plus"></span></a> </h3>	 -->
<!-- 		<div class="row">	 -->
<!-- 			<table class="table table-condensed" > -->
<%-- 				 <c:forEach items="${events}" end="5" var="vo">	 --%>
<!-- 				<tr>  -->
<%-- 					<td>${vo.event_name}</td> --%>
<%-- 					<td><fmt:formatDate value="${vo.event_startday}" pattern="yyyy-MM-dd" /></td> --%>
<!-- 				</tr>	 -->
<%-- 				</c:forEach>			 --%>
<!-- 			</table> -->
<!-- 		</div> -->
<!-- 	</div>	 -->
	
	</div>
</div>
