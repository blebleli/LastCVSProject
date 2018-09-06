<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/* main : S */

.main_wrap{position:relative;}
.main_ban,
.prod_tab{position:relative;width:960px;margin:auto}
.colwrap{}
.colwrap:after{content:''; display:block; visibility:hidden; clear:both;}
.bg_gray{background: #f6f6f6}
.mlb_ani,
.gnb_bg{display: none}

/* section_slide */
.main_ban{height:430px;}
.main_slide {width:720px; position:relative;}
.right_banner {width:238px; height:430px; border-left:1px solid #e8e8e8; border-right:1px solid #e8e8e8; float:left; background:#f0f9f9;}
.right_banner .banner_slide {width:238px; height:379px;}
/* /////////////////  MAIN KV  ///////////////////// */
.main_kv { width:720px; height:430px; position:relative;}
.main_kv ul {position:absolute; width:720px; left:0px; bottom:0px; border-top:1px solid #dfdfdf; text-align:center;}
.main_kv ul li {display:inline-block; width:160px; font-size:16px; text-align:center;}
.main_kv ul li .mb_img{position:absolute;top:-380px;left:0;}
.main_kv ul li .mb_img img{width:720px;height:379px;}
.main_kv ul li a span {display:none}
.main_kv ul li.active a {color:#397ca8; position:relative;font-weight: bold}
.main_kv ul li.active a span {display:block; width:15px;height:8px; position:absolute; top:-8px; left:50%; margin-left:-7px; text-indent:-999em; background:url(/_ui/desktop/common/images/gscvs/main/ico_evt_menu.png) no-repeat;z-index:99;}
.main_kv ul li a {display:block; height:50px; line-height:50px;color:#444;}
.main_kv ul li .mb_img a {height:auto;} /* 20150817 add */

.main_slide .btn {width:26px;height:26px; background:url(/_ui/desktop/common/images/gscvs/main/btn_kv.png) no-repeat 0 0; text-indent:-999em; position:absolute; z-index:10;}
.main_slide .prv {background-position:0px -52px; left:10px; bottom:13px;}
.main_slide .nxt {background-position:0px -78px; right:10px; bottom:13px;}
.main_slide .play {background-position:0px -26px; left:0px; bottom:64px;}
.main_slide .stop {background-position:0px 0px; left:0px; bottom:64px;}

.main_wrap .all_wrap{background:#cbeef3;}
.sub_menu{position:relative;width:960px;margin:auto;overflow:hidden;}

/* products info */
.prod_wrap{height:290px;}
.prod_tab > ul{background: #ddf5fb;}
.prod_tab{position:relative;background: #ddf5fb;}
.prod_tab > ul > li > a{position:relative;display: block;width:240px;height:53px;line-height:53px;border-top:1px solid #29a8e9;background:#0091df ;}
.prod_tab > ul > li > a .tab_arr{position:absolute;top:20px;right:20px;width:11px;height:19px;text-indent:-999em;background:url("/_ui/desktop/common/images/gscvs/main/ico_main.png") 2px -107px no-repeat;}
.prod_tab > ul > li:first-child a{border:0;}
.prod_tab li .tit{display:block;padding:0 28px;font-size: 20px;color:#a8e5ff;}
.prod_tab li .txt{display:none;padding:0 10px 0 28px;font-size: 13px;color:#a8e5ff;}

/* active */
.prod_tab > ul > li.active > a{height:128px;line-height: 20px}
.prod_tab li.active .tit{display:block;padding:28px 10px 13px 28px;font-size: 24px;font-weight: bold;color:#fff;}
.prod_tab li.active .tit em{font-size: 30px;}
.prod_tab li.active .txt{display:block;font-size: 13px;color:#fff;}
.prod_tab li.active > a .tab_arr{position:absolute;top:23px;right:-11px;width:11px;height:19px;text-indent:-999em;background:url("/_ui/desktop/common/images/gscvs/main/ico_main.png") -49px -102px no-repeat;}
.prod_tab .prd_lst{position:absolute;top:0;left:240px;width:720px;}
.prod_tab .btn_more{display:inline-block;width:51px;height:20px;position: absolute;top:10px;right:0;padding-right:20px;background:url("/_ui/desktop/common/images/gscvs/main/ico_main.png") 36px -53px no-repeat;}

.sb_wrap{position:absolute;top:50px;left:0;width:720px;height:240px;z-index:99;}
.sbbox{float:left;width:180px;height:240px}
.pro{position:relative;top:30px;background:url(/_ui/desktop/common/images/gscvs/main/gs25_probg.png) no-repeat 25px 20px;}
.pro img{margin:40px 0 0 45px;width:95px;height:92px;}
.pro a{height:175px;display:block}
.pro .tip{display:table;position:absolute;top:15px;right:10px;width:46px;height:46px;color:#fff;font-size:18px;text-align:center;background:url(/_ui/desktop/common/images/gscvs/main/flag_bg.png) no-repeat;font-weight: bold}
.pro .tip.typ1{background-position: 0 0}
.pro .tip.typ2{background-position: -65px 0}
.pro .tip.typ3{background-position: 0 -55px;font-size: 16px}
.pro .tip span{display:table-cell;padding:3px 1px 0 0;vertical-align: middle;line-height: 16px}
.pro .tip.typ3 span{padding:3px 4px 0 0;font-size: 14px}
.pro .title{color:#222;text-align:center;display:block;position: absolute;top: 175px;left: 50%;margin-left: -90px;width: 100%;}
.pro .title .mt{font-size:13px;display:block;background:url(/_ui/desktop/common/images/gscvs/main/gs25_tline.png) no-repeat 92% 1px;}
.pro .title em{margin-top:5px;font-size:22px;display:block;}

.sns_sect{overflow:hidden;margin-top:45px;position:relative;}
.sns_sect .fb_box,
.sns_sect .instar_box,/* 2015-10-26 수정 */
.sns_sect .nvb_box{position:relative;float:left;width:307px;margin-left:19px;}
.sns_sect .fb_box:first-child{margin-left:0;}
.sns_sect h3{margin-bottom:16px;color:#222;font-weight: bold;font-size: 22px}
.sns_sect .fb_box{border-top:2px solid #3c599b;}
.sns_sect .instar_box{border-top:2px solid #9e2f9e;} /* 2017-07-05 수정 */
.sns_sect .nvb_box{border-top:2px solid #2db400;}
.sns_sect .box_tit{position:absolute;top:0;left:0;width:305px;height: 70px;line-height: 70px;border:1px solid #dfdfdf;border-top:0;background-color: #fff;}
.sns_sect .box_tit h4{padding-left:67px;font-size: 16px;font-weight: bold;background: url("/_ui/desktop/common/images/gscvs/main/ico_sns.gif") no-repeat;}
.sns_sect .box_tit .like_btn{position: absolute;top:23px;right:5px;}
.sns_sect .fb_box h4{background-position: 20px 13px;}
.sns_sect .instar_box h4{ width:0; background-position: 20px -48px; text-indent: -99999px; float:left; padding-left:78px; padding-left:68px\9;} /* 2015-11-13 수정 */
.sns_sect .instar_box span { display:inline-block; margin-left:-12px; _margin-left:0; margin-left:-2px \9;}
.sns_sect .instar_box span img { display:inline-block; height:22px; padding-top:25px; }  /* 2015-11-13 수정 */
.sns_sect .nvb_box h4{background-position: 20px -107px;}
.sns_sect .fb_box h4{color:#3c599b;}
.sns_sect .instar_box h4{color:#00b1f1;} /* 2015-10-26 수정 */
.sns_sect .instar_box .cnts_box { overflow-x: hidden; overflow-y: scroll;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner { width:90%; padding:10px 0; margin:0 auto;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .line { border-bottom:1px solid #eeefef; padding:20px 0;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .line.first { padding-top:0}
.sns_sect .instar_box .cnts_box .inner .top { overflow:hidden; padding-bottom:11px;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .top > a { float:left; }/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .top .right { float:left; padding-left:7px; font-size:12px; padding-top:4px; }/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .top .right .order01 a { display:block; font-size:13px; font-weight:bold; color:#0074be; padding-bottom:4px;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner .top .right .order02 a { font-size:11px; color:#9197a3}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner ul li { line-height:20px; }/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner ul li p { padding-bottom:6px 0;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner ul li p strong { font-weight:bold;}/* 2015-10-26 추가 */
.sns_sect .instar_box .cnts_box .inner ul li img { width:100%; padding-top:6px;}/* 2015-10-26 추가 */
.sns_sect .nvb_box h4{color:#2db400;}
.sns_sect .cnts_box{height: 430px;border:1px solid #dfdfdf;border-top:0;margin-top: 70px;}/* 2015-10-26 수정 */
.sns_sect .nvb_box .cnts_box{float:left;width:305px;margin-top:70px;height:430px;overflow-y:scroll}
.sns_sect .nvb_box .cnts_box ul{width:90%;margin:auto;}
.sns_sect .nvb_box .cnts_box ul li{padding:10px 0 10px 0;overflow:hidden;border-bottom:1px solid #dfdfdf;}
.sns_sect .nvb_box .cnts_box ul li a{position:relative;color:#444;line-height:20px;display:block;}
.sns_sect .nvb_box .cnts_box ul li .date{padding:5px 10px 0 0;color:#666;display:block;}


.link_sect{margin-top:20px;}
.link_sect .box{float:left;margin-left:20px;width:223px;border:1px solid #e8e8e8;text-align: center}
.link_sect .box img{width:223px;height:338px;}
.link_sect .box:first-child{margin-left:0;}
.link_sect .box.popcard{margin-left:0;padding:0;width:223px;}
.link_sect .box.drc{padding:0;width:223px;}
.link_sect .box.gstv{padding:20px 0;width:223px;}
.link_sect .box.gstv img{width:183px;height:242px;}
.link_sect a span{display: block}
.link_sect a .tit{padding-top:8px;font-size: 22px;font-weight: bold;color:#222;}
.link_sect a .tit em{color:#397ca8;}
.link_sect a .img{margin:37px 0;}
.link_sect a .stit{padding-bottom:20px;font-size: 16px;font-weight: bold;color:#222;}
.link_sect a .txt{padding-top:20px;background: url("/_ui/desktop/common/images/gscvs/main/ico_main.png") 82px -547px no-repeat;line-height: 20px;color:#666;}
.link_sect .gstv .tit{padding-top:14px;color:#222;font-size:16px;font-weight: bold}
.link_sect .gstv .txt{padding-top:8px;color:#666;}

.etc_sect > div{float:left;width:470px;margin-top:20px;}
.etc_sect > div:first-child{margin-right:20px;}
.etc_sect .store_src,
.etc_sect .frnch_call{overflow:hidden;border:1px solid #dfdfdf;}
.etc_sect .store_src{padding:19px 30px;height:80px;margin-bottom: 20px}
.etc_sect .store_src .form_search{margin-top:19px;overflow: hidden}
.etc_sect .store_src .form_search input[type=text]{width:309px;}
.etc_sect .store_src .form_search input[type=button]{background:#0074be;}
@-moz-document url-prefix(){
	.etc_sect .store_src .form_search input[type=button]{padding:6px 20px 7px;}/* firefox hack : padding  */
}
.etc_sect .frnch_call{padding: 26px 19px}
.etc_sect .store_src h4,
.etc_sect .frnch_call h4{display:table;font-size: 16px;font-weight: bold;color:#222;}
.etc_sect .store_src span,
.etc_sect .store_src label,
.etc_sect .frnch_call span{display:table-cell;vertical-align: middle;}
.etc_sect .store_src .ico_store{width:30px;height:22px;background: url("/_ui/desktop/common/images/gscvs/main/ico_main.png") 0 -248px no-repeat}
.etc_sect .frnch_call .ico_call{width:30px;background: url("/_ui/desktop/common/images/gscvs/main/ico_main.png") -36px -250px no-repeat}
.etc_sect .frnch_call p{margin-top:10px;font-size:22px;color:#d04001}
.etc_sect .frnch_call > div,
.etc_sect .frnch_call ul{float:left;}
.etc_sect .frnch_call div:first-child{margin-top: 5px}
.etc_sect .frnch_call ul{padding-left:29px;}
.etc_sect .frnch_call ul li{padding-left:8px;background: url("/_ui/desktop/common/images/gscvs/main/ico_main.png") 0 -77px no-repeat;line-height: 22px;color:#666;}
.etc_sect .frnch_call ul li.lst{background: none}

.etc_sect .qsvs_box{overflow:hidden;border-top:1px solid #dfdfdf;border-left:1px solid #dfdfdf;width:468px;}
.etc_sect .qsvs_box li{float:left;}
.etc_sect .qsvs_box a{display:block;padding:32px 13px 0 20px;width:200px;height:97px;border-right:1px solid #dfdfdf;border-bottom:1px solid #dfdfdf;}
.etc_sect .qsvs_box span{padding-left:65px;min-height:50px;color:#666;display:block;line-height:18px;background:url(/_ui/desktop/common/images/gscvs/main/ico_main.png) 0 -280px no-repeat;line-height: 20px}
.etc_sect .qsvs_box strong{padding-bottom:5px;color:#222;font-size:16px;line-height:21px;display:block;}
.etc_sect .qsvs_box .sv2{background-position:0 -345px;}
.etc_sect .qsvs_box .sv3{background-position:0 -405px;}
.etc_sect .qsvs_box .sv4{background-position:0 -470px;}
.etc_sect .qsvs_box .sv3 strong,
.etc_sect .qsvs_box .sv4 strong{padding:0 0 5px 0;}

/* 나만의 냉장고 */
.main_ban .fridge_sect{position:absolute;top:0;right:0;padding:27px 9px 0 27px;width:208px;height:401px;background:url("/_ui/desktop/common/images/gscvs/main/fridge_img1.gif") 0 0 no-repeat;} /* 2016-09-05 수정 */
.fridge_sect .top{padding-top:10px;}
.fridge_sect .fridge_box{ display:block; position:relative; width:208px;height:342px; padding:24px 0 0 1px;background:url("/_ui/desktop/common/images/gscvs/main/fridge_img4.gif") 3px 78px no-repeat;} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .point{position:absolute;top:125px;left:22px;width:70px;font-size: 18px;font-weight: bold;text-align: right;background: none;color:#222;padding: 0;} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .product{position:absolute;top:172px;left:10px;width:184px;text-align: center} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .product span{display:block;padding-top:6px;color:#5b737a;} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .date{position:absolute;top:287px;left:10px;width:184px;text-align: center} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .date span{padding-left:22px;background:url("/_ui/desktop/common/images/gscvs/main/ico_clock.png") 0 2px no-repeat;font-size: 20px;color:#00857c;font-weight: bold;}
.fridge_sect .fridge_box .gift{position:absolute;bottom:0;left:1px;width:208px;height:40px;background: #f25822;color:#fff;line-height: 40px;text-align: center;} /* 2016-09-05 수정 */
.fridge_sect .fridge_box .gift em{font-size: 18px}
/* .fridge_sect .fridge_box .btn{background: none} 2016-09-05 삭제 */
/* .fridge_sect .fridge_box .btn a{position: absolute;bottom:0;right:0;} 2016-09-05 삭제 */
/* .fridge_sect .fridge_box .btn a:first-child{position: absolute;bottom:0;left:-98px;} 2016-09-05 삭제 */
.fridge_sect .fridge_box .fridge_btn { overflow:hidden; position:absolute; bottom:0;} /* 2016-09-05 추가 */
.fridge_sect .fridge_box .fridge_btn a{ display:inline-block;} /* 2016-09-05 추가 */
.fridge_sect .fridge_box .fridge_btn a:first-child{ float:left;} /* 2016-09-05 추가 */
.fridge_sect .login_on{cursor:pointer;}
.fridge_sect .login_on .fridge_btm_new { position:absolute; left:1px; bottom:0;} /* 2016-09-05 추가 */
/* .fridge_sect .login_off{background:url("/_ui/desktop/common/images/gscvs/main/fridge_img3.gif") 0 0 no-repeat;} 2016-09-05 삭제 */
.fridge_sect .login_off .txt1{font-size: 18px;height:42px;text-align: center;padding:10px 0;line-height: 22px}
.fridge_sect .login_off .qrcode{padding:16px 0;text-align: center;padding-right:4px;}
.fridge_sect .login_off .txt2{color:#444;line-height: 18px;padding:0 10px 0 15px;margin-top: 32px;font-size: 12px}

/* 2016-09-05 추가 */
.fridge_box .fridge_inner .my_list { background:#fff; text-align:center; padding:8px 0; color:#505050; height:52px;}
.fridge_box .fridge_inner .my_list .txt01 { font-size:14px; color:#dd5928; font-weight:bold; padding-bottom:6px; }

/* main : E */

/* Notice 추가 */
.sub_menu .nt_wrap{margin-top:20px;overflow:hidden; position:relative;} /* 2017-01-24 수정 */
.sub_menu .nt_wrap > a {float:left;} /* 2016-09-07 추가 */
.sub_menu .nt_wrap img{float:left;margin-right:20px;}
/* 2017-01-24 추가 */
.sub_menu .nt_wrap .tip_voice { position:absolute; left:0; top:72px; background:url('/_ui/desktop/common/images/gsretail/main/ico_tip_voice.gif') no-repeat 15px 6px; height:60px; width:224px; border:1px solid #dfdfdf;}
.sub_menu .nt_wrap .tip_voice a { display:block; font-size:15px; font-weight:bold; color:#525252; }
.sub_menu .nt_wrap .tip_voice .tip { position:absolute; left:93px; top:13px;}
.sub_menu .nt_wrap .tip_voice .tip a { width:93px; background:url('/_ui/desktop/common/images/gsretail/main/ico_top_arrow.gif') no-repeat right 2px; height:14px;}
.sub_menu .nt_wrap .tip_voice .voice { position:absolute; left:93px; top:33px;}
.sub_menu .nt_wrap .tip_voice .voice a { width:110px; background:url('/_ui/desktop/common/images/gsretail/main/ico_top_arrow.gif') no-repeat right 3px; height:14px;}
/* //2017-01-24 추가 */
.sub_menu .nt_box{position:relative;float:left;padding:20px;width:305px;height:92px;border:1px solid #dfdfdf;} /* 2016-05-18 수정 */
.sub_menu .nt_box.first { margin-right:17px;} /* 2016-05-18 추가 */
.sub_menu .nt_box strong{font-size:16px;}
.sub_menu .nt_box ul{margin-top:12px;height:70px;overflow:hidden} /* 2016-05-18 수정 */
.sub_menu .nt_box ul li{padding-left:10px;height:23px;background:url(/_ui/desktop/common/images/gsretail/main/ico_main.png) no-repeat -5px -80px; }
.sub_menu .nt_box ul li a{color:#666; width:300px;display:block; width:290px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap; }/* 2016-05-18 수정 */
.sub_menu .nt_box span{float:right}
.sub_menu .nt_box .btn_more{position:absolute;top:20px;right:20px;height:20px;padding-right:20px;background:url(/_ui/desktop/common/images/gsretail/main/ico_main.png) no-repeat 100% -53px; }
 /* 2016-05-18 추가 */
.sub_menu .nt_box .news { padding-top:10px;}
.sub_menu .nt_box .news .news_visual img { margin-right:10px; width:100px; overflow:hidden;}
.sub_menu .nt_box .news .desc { padding-left:110px; font-size:12px !important; color:#666;}
.sub_menu .nt_box .news .desc p a { display:block; color:#666; height:56px; overflow:hidden;} 
.sub_menu .nt_box .news .desc .date { padding-top:5px;} 
/* //2016-05-18 추가 */



</style>
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

<div class="col-sm-12 col-md-12">
	<div class="all_wrap prod_wrap">
						<!-- 상품소개 -->
						<div class="prod_tab" style="height: 280px;">
							<ul>
					    		<li class="">
	<a href="#">
		<span class="tit"><em>1+1</em> 상품</span>
		<span class="txt">행사상품 사면 하나 더</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul>
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
<li class="">
	<a href="#">
		<span class="tit"><em>2+1</em> 상품</span>
		<span class="txt">다양하고 놀라운 +1헹사</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul>
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
<li class="">
	<a href="#">
		<span class="tit"><em>덤증정</em> 상품</span>
		<span class="txt">덤상품과 함께 즐기는 혜택</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: none;">
		<ul>
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
<li class="active">
	<a href="#">
		<span class="tit"><em>유어스(PB)</em> 상품</span>
		<span class="txt">CU25에만 있는 브랜드상품</span>
		<span class="tab_arr"></span>
	</a>
	<!-- product list -->
	<!-- <div class="prd_lst"> -->
	<div class="prd_lst" style="display: block;">
		<ul>
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