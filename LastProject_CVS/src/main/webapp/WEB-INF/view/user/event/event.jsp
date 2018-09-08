<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /**
* @Class Name : board.jsp
*
* @author 조계환
* @since 2018. 9. 05
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
*
* </pre>
*/ -->
<style>
.result_search .service {
	overflow: hidden;
}

.service .result_txt {
	overflow: hidden;
	margin-bottom: 15px;
}

.service .result_txt h4 {
	background: url("../images/icon/bullet_purple.png") no-repeat 0 0;
	float: left;
	font-size: 1.231em;
	font-weight: normal;
	padding-left: 17px;
}

.service .result_txt p {
	float: right;
}

.service .result_txt span {
	color: #782d91;
	text-decoration: underline;
}

.service .list_service {
	overflow: hidden;
	margin-bottom: 25px;
}

.service .list_service ul {
	overflow: hidden;
	border-top: 2px solid #1e1e1e;
	border-bottom: 1px solid #dadada;
	height: 140px;
}

.service .list_service ul li {
	background: url("../images/common/bg_diagonal_228.gif") repeat-x 0 0;
	display: block;
	float: left;
	border-left: 1px solid #dadada;
	height: 140px;
	width: 119px;
}

.service .list_service ul li:first-child {
	border-left: none;
}

.list_service .group_service {
	overflow: hidden;
	margin: 0 auto;
	padding-top: 20px;
	width: 70px;
}

.list_service .group_service a {
	display: block;
	overflow: hidden;
	text-align: center;
}

.list_service .group_service .emblem {
	margin-bottom: 14px;
	height: 65px;
	width: 65px;
}

.list_service .group_service .emblem.on img {
	margin-top: -66px;
}

.list_service .group_service .text {
	letter-spacing: -1px;
	line-height: 1em;
}

#demoFont {
	font-family: "Arial Black", Gadget, sans-serif;
	font-size: 15px;
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
}

.services{

	text-align: center;
}

.
</style>

<link href="/css/login/common/JKH.css" rel="stylesheet">

<script>
	$(function() {
		$("#click").on("click", function() {
			$("#bd_id").val($(this).data("no"));
			$("#frm").submit();
		});
	});
	$(function() {
		$("#eventDetali").on("click",function(){
			$()
		});
	});	
</script>

<!-- products-breadcrumb -->
<!-- //products-breadcrumb -->
<!-- banner -->

<form action="/board/view" method="post" id="frm">
	<input type="hidden" name="bd_id" id="bd_id">
</form>



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
					<div class="col-md-9 w3agile_event_grid_right" id="eventDetali">
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
<!-- //services -->
<div class="clearfix"></div>
