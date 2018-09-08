<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>이메일 인증 회원가입 > 정보입력</title>

<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/scom.css' />"></link> --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user//main.css' />"></link>  --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/layout.css' />"></link> --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/common_layout.css' />"></link> --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user//mem.css' />"></link> --%>

<%-- <script type="text/javascript" src="<c:url value='/web/js/jquery-1.11.1.min.js' />"></script> --%>

</head>
<body class="body_wide">
    <div id="skip">
        <h2>스킵 네비게이션</h2>
        <ul>
            <li><a href="#content" onclick="document.getElementById('content').tabIndex = -1;document.getElementById('content').focus();return false;">본문바로가기</a></li>
        </ul>
    </div>

    <script type="text/javascript">
//<![CDATA[
	var settings = {
		localDomain : location.hostname,
		domain : {
			isHttpFlag:'false' == 'true' ? true : false,
			context:'',
			protocol:'https://',
	
			domain:'member.ssg.com',
		
			sfcDomain:'member.sfcmall.com',
			ssg:'www.ssg.com',
			mallac : 'auto.ssglog.com:9095',
			mallshrt : 'auto.ssglog.com:9094',
			ssgac : 'auto.ssglog.com:9095',
			ssgshrt : 'auto.ssglog.com:9094',
			advertise : '',
			trace : '',
			event : '',
			howdy : 'howdy.ssg.com',
			thehowdy : 'thehowdy.ssg.com',
			sfc : {
				pay : 'pay.sfcmall.com',
				emart : 'sfcmall.emart.com',
				ssg : 'www.sfcmall.com',
				small : 'www.sfcmall.com',
				sdept : 'dept.sfcmall.com',
				ssl : 'member.sfcmall.com',
				customer :  'customer.sfcmall.com',
				emartCustomer :  'customer.sfcmall.emart.com',
				member : 'member.sfcmall.com',
				emartMember : 'member.sfcmall.emart.com',
				event : '',
				emartEvent : ''
			},
			clip : ''
		},
		cdn : {
			
			imgPath : 'https://sstatic.ssgcdn.com/ui/ssg/img',
			
		    trans : 'http://img.ssgcdn.com/trans.ssg',
		    noImg : {
				50  : '/ui/ssg/img/common/img_ready_500x500.jpg',
				70  : '/ui/ssg/img/common/img_ready_500x500.jpg',
				93  : '/ui/ssg/img/common/img_ready_500x500.jpg',
				110 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				140 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				168 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				202 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				210 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				240 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				253 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				290 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				300 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				400 : '/ui/ssg/img/common/img_ready_500x500.jpg',
				500 : '/ui/ssg/img/common/img_ready_500x500.jpg'
		    },
			itemPath : 'http://item.ssgcdn.com',
			uccPath : '',
			uploadDefaultUrl: '/temp_up/',
			cdnDomain : 'http://static.ssgcdn.com' != '' ?
					'http://static.ssgcdn.com' : '',
			jsPath : '//sstatic.ssgcdn.com/ui/ssg/js'
		},
		siteno : {
			emall : '6001',
			traders : '6002',
			boons : '6003',
			boots : '6003',
			small : '6004',
			scom : '6005',
			sdept : '6009',
			howdy : '6100',
			thehowdy : '6101',
			tv : '6200',
			sivillage : '6300',
			starfield : '6400',
			clip : '6005'
		},
        curr_siteno : '6005',
        mediaCd : '10',
		loginPath : 'http://dev-member.ssg.com/member/login.ssg',
		// 모바일 여부
		isMobile : '10' == '20',
		isSfc : false,
		isThehowdy : false,
		// 회원 관련 객체
		UserInfo : {
			isLoginYn        : 'false' == 'true' ? 'Y' : 'N',
			mbrTypeCd        : '',
			mbrType          : 'B2C',
			mbrLoginId       : '',
			mbrLoginId2      : '',
			mbrcoId          : '000000',
            ckWhere          : 'direct_ssg',
			dmId             : '',
			emSaleStrNo      : '2034',
			trSaleStrNo      : '2154',
			bnSaleStrNo      : '2451',
			emRsvtShppPsblYn : 'Y',
			ga : '00',
			sessionId : '',
			ip : ''
		},
		imgPath : '//sstatic.ssgcdn.com/ui/ssg/img',
        key : {
            kakao : {
	            mssgmall : '927ad12793fd2d6e0ce1874f65eaf415',
	            msmall : '633a9d661ae116ef826a2d39da20c369',
	            memall : 'b402eae75d631a84dfb7e8848e20b7ff',
	            mtraders : '5a5e9ed8d1d331d6e88296bf59211e8b',
	            mboons : '250cf9a33ae8acd6a6a782478403c953',
	            shopat : 'a67cc0b036fff91c3c17a7372de34128'
            }
        },
		mobilAppNo : '',
        zone : 'prod'
	};
	//]]>
</script><script type="text/javascript">
//<![CDATA[
    

	//IE7용 JSON 추가
	var JSON;if(!JSON){JSON={}}(function(){"use strict";function f(e){return e<10?"0"+e:e}function quote(e){escapable.lastIndex=0;return escapable.test(e)?'"'+e.replace(escapable,function(e){var t=meta[e];return typeof t==="string"?t:"\\u"+("0000"+e.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+e+'"'}function str(e,t){var n,r,i,s,o=gap,u,a=t[e];if(a&&typeof a==="object"&&typeof a.toJSON==="function"){a=a.toJSON(e)}if(typeof rep==="function"){a=rep.call(t,e,a)}switch(typeof a){case"string":return quote(a);case"number":return isFinite(a)?String(a):"null";case"boolean":case"null":return String(a);case"object":if(!a){return"null"}gap+=indent;u=[];if(Object.prototype.toString.apply(a)==="[object Array]"){s=a.length;for(n=0;n<s;n+=1){u[n]=str(n,a)||"null"}i=u.length===0?"[]":gap?"[\n"+gap+u.join(",\n"+gap)+"\n"+o+"]":"["+u.join(",")+"]";gap=o;return i}if(rep&&typeof rep==="object"){s=rep.length;for(n=0;n<s;n+=1){if(typeof rep[n]==="string"){r=rep[n];i=str(r,a);if(i){u.push(quote(r)+(gap?": ":":")+i)}}}}else{for(r in a){if(Object.prototype.hasOwnProperty.call(a,r)){i=str(r,a);if(i){u.push(quote(r)+(gap?": ":":")+i)}}}}i=u.length===0?"{}":gap?"{\n"+gap+u.join(",\n"+gap)+"\n"+o+"}":"{"+u.join(",")+"}";gap=o;return i}}if(typeof Date.prototype.toJSON!=="function"){Date.prototype.toJSON=function(e){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null};String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(e){return this.valueOf()}}var cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,gap,indent,meta={"\b":"\\b","   ":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},rep;if(typeof JSON.stringify!=="function"){JSON.stringify=function(e,t,n){var r;gap="";indent="";if(typeof n==="number"){for(r=0;r<n;r+=1){indent+=" "}}else if(typeof n==="string"){indent=n}rep=t;if(t&&typeof t!=="function"&&(typeof t!=="object"||typeof t.length!=="number")){throw new Error("JSON.stringify")}return str("",{"":e})}}if(typeof JSON.parse!=="function"){JSON.parse=function(text,reviver){function walk(e,t){var n,r,i=e[t];if(i&&typeof i==="object"){for(n in i){if(Object.prototype.hasOwnProperty.call(i,n)){r=walk(i,n);if(r!==undefined){i[n]=r}else{delete i[n]}}}}return reviver.call(e,t,i)}var j;text=String(text);cx.lastIndex=0;if(cx.test(text)){text=text.replace(cx,function(e){return"\\u"+("0000"+e.charCodeAt(0).toString(16)).slice(-4)})}if(/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,""))){j=eval("("+text+")");return typeof reviver==="function"?walk({"":j},""):j}throw new SyntaxError("JSON.parse")}}})();

	// GLOBAL 설정 정보들...
	var ssg = {
	    domain : {
	        emart   : 'emart.ssg.com',
	        traders : 'traders.ssg.com',
	        boons   : 'boons.ssg.com',
	        boots   : 'boots.ssg.com',
	        small   : 'shinsegaemall.ssg.com',
	        ssg     : 'www.ssg.com',
	        sdept   : 'department.ssg.com',
	        howdy   : 'howdy.ssg.com',
	        thehowdy: 'thehowdy.ssg.com',
	        tv   : 'tv.ssg.com',
	        sivillage   : 'sivillage.ssg.com',
	        starfield   : 'starfield.ssg.com',
	        pay : 'pay.ssg.com',
	        sfc :{
	        	pay 	: 'pay.sfcmall.com',
	        	emart 	: 'sfcmall.emart.com',
	        	ssg 	: 'www.sfcmall.com',
	        	small   : 'www.sfcmall.com',
		        sdept   : 'dept.sfcmall.com',
	        	ssl : 'https://member.sfcmall.com',
	        	customer : 'customer.sfcmall.com'
	        }
	    },
	    cdn : {
	        item    : 'http://item.ssgcdn.com'
	    },
	    trans : 'http://img.ssgcdn.com/trans.ssg',
	    noImg : {
			50  : '/ui/ssg/img/common/img_ready_500x500.jpg',
			70  : '/ui/ssg/img/common/img_ready_500x500.jpg',
			93  : '/ui/ssg/img/common/img_ready_500x500.jpg',
			110 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			140 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			168 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			202 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			210 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			240 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			253 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			290 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			300 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			400 : '/ui/ssg/img/common/img_ready_500x500.jpg',
			500 : '/ui/ssg/img/common/img_ready_500x500.jpg'
	    },
	    itemDetail : '/item/itemView01.ssg',
	    title : '회원가입 &gt; 정보입력, 신세계적 쇼핑포털 SSG.COM'
	};

	// 회원 관련 객체, 사용하지 말 것.
	var UserInfo = {
		isLoginYn : 'false'=='true'?'Y':'N',
		mbrTypeCd : '',
		ckWhere : 'direct_ssg'
	};

	var mobile = {
			customUrl : {
			    prefix : '',
			    scheme : '' || '',
				popup : 'null',
				popup_out : 'null',
				appmain : 'null'
			}
	}

	// Emart & Boons & Traders 용
	var EmallEnv = {
        templId : '',
        saleSubDispCtgId : '',
        boonsBrandDispCtgId : '',
        imgPath : '//sstatic.ssgcdn.com/ui/ssg/img'
    };

	var EmallMessage = {
		qtyOver:'???emall.qty.over???',
		qtyNone:'???emall.qty.none???',
		mltQtyInvalid:'???validate.mlt.rule.break???',
		payNodelivery:'???emall.pay.nodelivery???',
		payDeliveryNotuser:'???emall.pay.delivery.notuser???',
		payDeliveryUser:'???emall.pay.delivery.user???',
		payDeliveryCartOk:'???emall.pay.delivery.cart.ok???',
		payNoitem:'???emall.pay.noitem???',
		payCartOk:'???emall.pay.cart.ok???'
	};
	// Emart & Boons & Traders 용 End

	// 업로드 이미지
	var uploadImgPath = 'https://sstatic.ssgcdn.com';
	// 모바일 여부
	var isMobile = '10' == '20';
	// app 여부
	var isApp = '' != '' ? 'Y' : 'N';

	// pad 여부
	var isPad = '' == 'true' ? true : false;

	// sfc 여부
	var isSfc = false;

	// sfc 앱 여부
	var isSfcApp = "N";

	var ssgDomain = 'https://www.ssg.com';
	var imgPath   = '';
	if ( settings.domain.isHttpFlag == true ) {
		imgPath = '//sstatic.ssgcdn.com/ui/ssg/img';
	} else {
		imgPath = '//sstatic.ssgcdn.com/ui/ssg/img';
	}
	var itemPath  = '';
	var localDomain = "http://"+location.hostname;
	var skipForJoinPage = '' == '' ? 'N' : '';
	var isProd = !(location.href.indexOf('local-') > -1 || location.href.indexOf('dev-') > -1 || location.href.indexOf('qa-') > -1) ;
//]]>
</script>
<script type="text/javascript" src="//sstatic.ssgcdn.com/ui/ssg/js/netfunnel.js"></script>
    <div id="wrap">

<div id="category" class="category"></div>
	<div id="container">

		<div id="content" class="content_primary enter_information">
			<div class="content_intro">
				<h3><span class="tt">────── 회원가입 ──────</span></h3>
			</div>
			<div class="section_wrap">
				<div class="section welcome_section">
					<h3 class="tit tit_v">GoGo CVS에 오신 것을 환영합니다!</h3>
				<div class="section email_attestation simple">
					<h3 class="blind">간편인증</h3>
					<div class="content">
						<form id="emailAuthForm" method="post" action="/member/join/sendEmail.ssg">
						<input type="hidden" name="mbrTypeCd" value="60"/>
						<div class="medium_bx">
							<h4>사용자 이메일인증으로 회원 가입</h4>
							<fieldset class="fieldset">
								<legend>이메일 인증</legend>
								<div class="field">
									<label for="emailIdNmStr" class="label">이메일 아이디</label>
									<div class="insert">
										<input type="text" id="emailIdNmStr" name="emailIdNmStr" title="이메일 아이디 입력" value="" class="input_text small" style="width:105px">
										<span>@</span>
										<input type="text" id="emailDomNm" name="emailDomNm" title="이메일 도메인 입력" value="" class="input_text small" style="width:105px">
										<select id="emailDomNmSB" title="이메일 도메인 선택" class="select small">
										<option class="select" value="">직접 입력</option>
										<option value="001" addtOptnVal1="" addtOptnVal2="">naver.com</option><option value="002" addtOptnVal1="" addtOptnVal2="">gmail.com</option><option value="003" addtOptnVal1="" addtOptnVal2="">nate.com</option><option value="004" addtOptnVal1="" addtOptnVal2="">yahoo.co.kr</option><option value="005" addtOptnVal1="" addtOptnVal2="">hanmail.net</option><option value="006" addtOptnVal1="" addtOptnVal2="">daum.net</option><option value="007" addtOptnVal1="" addtOptnVal2="">dreamwiz.com</option><option value="008" addtOptnVal1="" addtOptnVal2="">lycos.co.kr</option><option value="009" addtOptnVal1="" addtOptnVal2="">empal.com</option><option value="010" addtOptnVal1="" addtOptnVal2="">korea.com</option><option value="011" addtOptnVal1="" addtOptnVal2="">paran.com</option><option value="012" addtOptnVal1="" addtOptnVal2="">freechal.com</option><option value="013" addtOptnVal1="" addtOptnVal2="">hitel.net</option><option value="014" addtOptnVal1="" addtOptnVal2="">hanmir.com</option><option value="015" addtOptnVal1="" addtOptnVal2="">hotmail.com</option>
										</select>
									</div>
								</div>
							</fieldset>
							<ul class="data_list small">
							<li>정보입력은 인증 메일을 통한 인증 후 가능합니다.</li>
							</ul>
							<div class="bn_ar">
								<a id="btnEmailAuth" href="javascript:;" class="bn medium color1">인증하기</a>
							</div>
							<p class="email_msg" style="display:none;">
								<strong class="text">이미 사용중인 이메일입니다. 다른 이메일을 입력 하시거나 로그인 또는 비밀번호 찾기를 선택해주세요.</strong>
							</p>
							<div id="btnFindIdPwWrap" class="bn_ar" style="display:none">
								<a href="//member.ssg.com/member/login.ssg" class="bn color1">로그인 하기</a>
								<a href="//member.ssg.com/member/findIdPw.ssg?tabType=pw" class="bn color2">비밀번호 찾기</a>
							</div>
						</div>
						</form>

						<form id="snsJoin" method="post" action="/member/join/simpleJoinGuide.ssg">
							<input type="hidden" name="mbrId">
							<input type="hidden" name="email">
							<input type="hidden" name="snsTypeCd">
							<input type="hidden" name="accessToken">
						</form>
					</div>
				</div>
			</div>
		</div>

		</div>
	</div>
</div>
</body>
</html>