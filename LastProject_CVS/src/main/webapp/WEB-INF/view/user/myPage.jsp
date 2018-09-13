<%@ page import="java.io.IOException"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.BufferedOutputStream"%>
<%@ page import="java.io.BufferedInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- =======<tiles: ="content" /> ============> 마이페이지  myPage.jsp  -->
<!-- login css  -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/login.css' />"></link>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/mem.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/common_layout.css' />"></link>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/font-awesome.css' />" media="all"></link>	<!-- font-awesome icons -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css' />" media="all"></link>	<!-- //for-mobile-apps -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />" media="all"></link>


<!-- js -->
<script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/move-top.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/easing.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/bootstrap.min.js' />"></script>	<!--// Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value='/js/common/calendar.js' />"></script> <!-- 달력 : 별 09.07 -->


<style>
/* .col-lg-3 { */
/*     width: 20%; */
/* } */

.label {
	display: inline;
	padding: .2em .6em .3em;
	font-size: 75%;
	font-weight: bold;
	line-height: 1;
	color: #fff;
	text-align: left;
	white-space: nowrap;
	vertical-align: baseline;
	border-radius: .25em;
}
span.error_txt.small{display:inline;color:#ff9933;font-size:10px;}
</style>


<script type="text/javascript">

$(document).ready(function() {

		// 	 $('#myTabContent div').hide();

		// 	 $("#myTab li a").click(function (e) {
		// 		  e.preventDefault();
		// 		  $(this).tab('show');
		// 		  $("#myTabContent div").show();

		// 		})
		/** 
		 * 초기 탭 클릭
		 */
		if ("${!empty tab}") {
			$("ul#myTab > li > a[href=#${tab}]").trigger(
					"click");
			// focus 안먹네
			//$("div#${tab}").next().attr("tabindex", -1).focus();
		}

		
		/**
		 * ∴ 사용자한테 입력 받을 때 확인 
		 * 사용자 전화번호 중복 조회
		 */
		$("#mem_tel_3").on("blur",function() {
			// 전화번호가 모두 입력이 되었을때 중복 체크 시작
			if ($("#mem_tel_1").val() != '' && $("#mem_tel_2").val() && $("#mem_tel_3").val()) {
				var mem_tel = $("#mem_tel_1").val()+ '-'+ $("#mem_tel_2").val()	+ '-'+ $("#mem_tel_3").val();

				$.ajax({
						type : "POST",
						url : "<c:url value='/login/chkMemTelDupli' />",
						dataType : "text",
						data : {
							mem_tel : mem_tel
						},
						success : function(data) {
							if (Number(data) > 0) {
								fn_errMessage($("#mem_tel"),"이미 등록된 전화번호 입니다.");
								$("#mem_tel_2").val("");
								$("#mem_tel_3").val("");
							}
						},
						error : function(
								request,
								status,
								error) {
							alert(error);
						}
					   });

			}
		});

			
		// 사용자 저장버튼
		$("#btnRegist").on("click", function() {

				var isSuccess = true;

				// 비밀번호
				if ($("#mem_pw").val() == '') {
					fn_errMessage($("#mem_pw"),"비밀번호는 필수 입력사항입니다.");
					$("#mem_pw").focus();
					isSuccess = false;
				} else {
					if ($("#mem_pw_confirm").val() != $("#mem_pw").val()) {
						fn_errMessage($("#mem_pw_confirm"),"비밀번호가 일치하지 않습니다.");
						$("#mem_pw").focus();
						isSuccess = false;
					}
				}

				// 휴대전화
				if ($("#mem_tel").val() == '') {
					fn_errMessage($("#mem_tel"),"휴대폰 번호는 필수 입력사항입니다.");
					$("#mem_tel").focus();
					isSuccess = false;
				}

				// 우편번호
				if ($("#mem_zip").val() == '') {
					fn_errMessage($("#mem_zip"),"우편번호는 필수 입력사항입니다.");
					$("#mem_zip").focus();
					isSuccess = false;
				}

				// 상세주소
				if ($("#mem_addr").val() == '') {
					fn_errMessage($("#mem_addr"),"상세주소는 필수 입력사항입니다.");
					$("#mem_addr").focus();
					isSuccess = false;
				}

				if (!isSuccess) {
					return false;
				}

				if (!confirm("회원정보가 수정 완료된 후 로그인화면으로 이동합니다.\n저장하시겠습니까?")) {
					return false;
				}

				$('#registForm').submit();

	   }); /*//$("#btnRegist").on("click", function()  */

				  
				  
		/**
		 * 비밀번호 유효성 검증
		 */
		$("#mem_pw").on("blur",function() {
				if ($("#mem_pw").val() != '') {
					var reg_pwd = /^.*(?=.{6,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
					if (!reg_pwd.test($("#mem_pw").val())) {
						fn_errMessage($("#mem_pw"),"비밀번호는 영문,숫자를 혼합하여 6~12자 이내로 입력하시기 바랍니다.");
						$("#mem_pw").val("");
						$("#mem_pw").focus();
						return false;
					} else {
						fn_errMessage($("#mem_pw"),"");
					}
				}
		});

		/**
		 * 비밀번호 확인
		 */
		$("#mem_pw_confirm").on("blur", function() {
			if ($("#mem_pw").val() != '') {
				if ($(this).val() != $("#mem_pw").val()) {
					fn_errMessage($(this), "비밀번호가 일치하지 않습니다.");
					$("#mem_pw_confirm").focus();
				} else {
					fn_errMessage($(this), "");
				}
			}
		});

		// 휴대폰번호 셋팅
		$("*[id^=mem_tel_]").on("change",function() {
					if ($("#mem_tel_1").val() != ''
							&& $("#mem_tel_2").val()
							&& $("#mem_tel_3").val()) {
						var mem_tel = $("#mem_tel_1").val()
								+ '-' + $("#mem_tel_2").val()
								+ '-' + $("#mem_tel_3").val();
						$("input[name=mem_tel]").val(mem_tel);
					} else {
						$("input[name=mem_tel]").val("");
					}
		});

		
		/**
		 * 오류메시지 초기화
		 */
		$("input,select").on("change", function() {
			fn_errMessage($(this), "");
		});

		
		
		/** 
		 *	daum 주소검색 api
		 */
		$("#btnOpenSearchZip").on("click",function() {

			 new daum.Postcode( {oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
						// 예제를 참고하여 다양한 활용법을 확인해 보세요.
		
						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수
		
						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;
		
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}
		
						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName
										: data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' ('
									 + extraAddr
									 + ')'
									 : '');
						}
		
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('mem_zip').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('mem_add').value = fullAddr;
		
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('mem_addr').focus();
						}
			 }).open();
		});

						/**
						 * 구매내역 행 클릭
						 */
						$("tr.paytr").bind("click",function() {

								// 상세tr 삭제
								if ($(this).next().hasClass("subPaytr")) {
									$(this).next().remove();
								} else {
									// 상세tr 전체삭제
									$(this).parent().find('tr.subPaytr').each(function() {
														$(this).hide("slow",function() {
																			$(this).remove();
														});
									});
									// 상세tr 보여주기
									var $subTr = $("_$tag___________________________________________________$tag___________뭘보여줘야지_$tag_$tag");
									$(this).after($($subTr));
									$($subTr).show('slow');
								}

						});

});

	/**
	 * 오류메시지
	 */
	function fn_errMessage(_obj, _text) {
		if (_text != null && _text != '') {
			_obj.closest("div.field").find(".msg_wrap").show();
		} else {
			_obj.closest("div.field").find(".msg_wrap").hide();
		}
		_obj.closest("div.field").find(".msg_wrap").find(".error_txt").text(
				_text);
	}
</script>


<!-- products-breadcrumb -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/user/main' />">Home</a><span>|</span></li>
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
						
							<div class="col-md-3 col-lg-3 hidden-xs hidden-sm"> <!-- hidden-xs hidden-sm : 폰,태블릿사이즈에서 안보임 : 데스크탑용 -->
								<!-- 
								<img class="img-circle"
									src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=100"
									alt="User Pic">
							    -->
								<img class="img-circle" src="<c:url value='/images/userpic/${member.pic_name}' />" alt="User Pic" width="130px;" height="130px;" />
							</div>
							
							<div class="col-xs-2 col-sm-2 hidden-md hidden-lg">  <!-- 데스크탑에서 안보임 : 모바일용-->
								<img class="img-circle" src="<c:url value='/images/userpic/${member.pic_name}' />" alt="User Pic">
							</div>
							
							<div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <!-- 모바일사이즈용  -->
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

								<p>Web developers use these languages when they create a site:</p>
								<dl>
									<dt>HTML</dt>
									<dd>
										<em>HyperText Markup Language</em> describes the structure of the page and its contents.
									</dd>
									<dt>CSS</dt>
									<dd>
										<em>Cascading Style Sheets</em>
							</div>
							
							<div class=" col-md-9 col-lg-9 hidden-xs hidden-sm">  <!-- 데스크탑 사이즈에서 보임  -->
								<strong><h4>이름 : ${member.mem_name}</h4></strong><br />
								<table class="table table-user-information">
									<tbody id="userInfoBody" style="font-size:17px;">
										<tr>
											<td>ID/Email : ${member.mem_id} </td>
											<td>
												<c:choose>
													<c:when test="${member.mem_gen == 'F'}">
														성별 : 여성
													</c:when>
													<c:otherwise>
														성별 : 남성
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
										<tr>
											<td>생년월일 : ${member.mem_birth}</td>
											<td>연락처 : ${member.mem_tel}</td>
										</tr>
										<tr>
											<td>우편번호 : (${member.mem_zip}) </td>
											<td></td>
										</tr>
										<tr>
											<td>주    소  : ${member.mem_add}</td>
											<td>${member.mem_addr}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
<!-- 					<div class="panel-footer"> -->
<!-- 						<button class="btn btn-sm btn-primary" type="button" data-toggle="tooltip" data-original-title="Send message to user"> -->
<!-- 							<i class="glyphicon glyphicon-envelope"></i> -->
<!-- 						</button> -->
<!-- 						<span class="pull-right"> -->
<!-- 							<button class="btn btn-sm btn-warning" type="button" data-toggle="tooltip" data-original-title="Edit this user"> -->
<!-- 								<i class="glyphicon glyphicon-edit"></i> -->
<!-- 							</button> -->
<!-- 							<button class="btn btn-sm btn-danger" type="button" data-toggle="tooltip" data-original-title="Remove this user"> -->
<!-- 								<i class="glyphicon glyphicon-remove"></i> -->
<!-- 							</button> -->
<!-- 						</span> -->
<!-- 					</div> -->
				</div>
			</div>
		</div>
		
		 <!-- Nav tabs -->
		<!-- 탭메뉴 -------------------------------------------------------------------------------------------------------- -->
		<div class="col-md-15 col-sm-10 col-xs-12">

			<div class="" role="tabpanel" data-example-id="togglable-tabs">
				<ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
				
					<li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="false"> 나의정보</a></li>
					<li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-mypocket" data-toggle="tab" aria-expanded="false">나의 주머니</a></li>
					<li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-FavoriCVS" data-toggle="tab" aria-expanded="false">자주가는 편의점</a></li>
					<li role="presentation" class=""><a href="#tab_content4" role="tab" id="profile-bookmarkProd" data-toggle="tab" aria-expanded="false">즐겨찾는 상품</a></li>
					<li role="presentation" class=""><a href="#tab_content5" role="tab" id="profile-buyHistory" data-toggle="tab" aria-expanded="false">구매 내역</a></li>
				</ul>
				
				<!-- Tab panes -->
				<div id="myTabContent" class="tab-content col-md-15 col-sm-9 col-xs-12" style="width: 100%">

					<!-- 나의정보 -------------------------------------------------------------------------------------------------------- -->
					<div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
						
		<div id="content" class="content_primary forgot_user_information">
			 
			<div class="section_wrap">
				<form id="registForm" action="<c:url value='/login/loginView' />" method="post" enctype="multipart/form-data">
					
					<div class="section email_info">
							<h3>나의정보 수정</h3><br />
						<div class="section">
							<h3 class="blind">항목입력</h3>
							<div class="content">
								<fieldset class="fieldset medium">
									
									<div class="field">
										<span class="label">이메일 아이디</span>
										<div>
<%-- 										<input type="text" id="mem_id" name="mem_id" title="아이디(이메일) 입력" value="${memberVo.mem_id}" readonly="readonly" class="input_text small" style="width:337px" /> --%>
											<label id="mem_id" name="mem_id" title="아이디(이메일) 입력"  class="label" style="width:337px" >${member.mem_id}</label>
											<input type="hidden" id="chkMemId" value="" />
											<input type="hidden" id="mem_id" value="${member.mem_id}" />
										</div>
									</div>
									
									<div class="field">
										<label for="mem_pw" class="label">비밀번호</label>
										<div>
											<input type="password" id="mem_pw" name="mem_pw" title="비밀번호 입력" value="${member.mem_pw}" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									
									<div class="field">
										<label for="mem_pw_confirm" class="label">비밀번호확인 </label>
										<div>
											<input type="password" id="mem_pw_confirm" title="비밀번호 재입력" value="${member.mem_pw}" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									
									<div class="field">
										<label for="mem_name" class="label">이름 </label>
										<div>
<!-- 										<input type="text" id="mem_name" name="mem_name" title="이름 입력" value="" class="input_text small" style="width:234px" /> -->
											<label id="mem_name" name="mem_name" title="이름 입력"  class="label" style="width:234px" > ${member.mem_name}</label>
											<input type="hidden" id="mem_name" value="${member.mem_name}" />
										</div>
									</div>
									
									<div class="field">
										<label for="mem_tel" class="label">휴대폰 번호 </label>
										<div>
											<div>
												<select id="mem_tel_1" title="휴대폰 첫자리 선택" class="select small" style="width:86px">
													<option value="010" selected="selected">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="017">017</option>
													<option value="018">018</option>
													<option value="019">019</option>
												</select>
												<span>-</span>
												<input type="text" title="휴대폰 중간자리 입력" id="mem_tel_2" value="" class="input_text small" style="width:100px" maxlength="4" />
												<span>-</span>
												<input type="text" title="휴대폰 마지막자리 입력" id="mem_tel_3" value="" class="input_text small" style="width:100px" maxlength="4" />
												<span id="errorTxtCnts" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												<input type="hidden" id="mem_tel" name="mem_tel" value="" />
											</div>
										</div>
									</div>
									
									<div class="field">
										<label for="mem_birth" class="label">생년월일 </label>
										<div>
<!-- 											<input type="text" id="mem_birth" name="mem_birth" title="생년월일 입력" value="" class="input_text small" style="width:234px" /> -->
											<label id="mem_birth" name="mem_birth" title="생년월일 입력"  class="label" style="width:234px" >${member.mem_birth}</label>
											<input type="hidden" id="mem_tel" name="mem_tel" value="${member.mem_birth}" />
										</div>
									</div>
									
									<div class="field">
										<label for="zipcd" class="label">주소</label>
										<div>
											<div>
												<input type="text" id="mem_zip" name="mem_zip" title="우편번호 입력" value="${member.mem_zip}" class="input_text small" style="width:60px" readonly="readonly" />
												<a href="javascript:void(0);" id="btnOpenSearchZip" class="btn txt small" title="새창열림"><span>우편번호찾기</span></a>
												<input type="text" id="mem_add" name="mem_add" title="기본주소" value="${member.mem_add}" class="input_text small" style="width:440px" readonly="readonly" />
												<br />
												<input type="text" id="mem_addr" name="mem_addr" title="상세주소" value="${member.mem_addr}" class="input_text small" style="width:600px;" />
											</div>
			                                <div id="errorTxtAddr" class="msg_wrap">
												<div class="error_txt small"></div>
											</div>
										</div>
									</div>
									
									<div class="field">
										<label for="mem_pic" class="label">프로필 사진</label>
										<div>
											<input type="file" id="upload_file" name="upload_file" title="사진등록" value="${member.pic_name}" class="" style="width:234px" />
										</div>
									</div>
									
								
								</fieldset>
							</div>
						</div>
						
						<div class="bn_ar">
							<a id="btnRegist" href="javascript:void(0);" class="bn medium color1">수정 하기</a>
						</div>
						
					</div>
				
				</form>
			</div>
		</div>
						
					</div> 
					
					<!-- 나의주머니 -------------------------------------------------------------------------------------------------------- -->
					<div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-mypocket">

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
											<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
												<div class="agile_top_brand_left_grid_pos">
													주머니 생성된 바코드 사진 <img src="/images/offer.png" alt=" " class="img-responsive" />
												</div>
												<div class="agile_top_brand_left_grid1 ">
													<figure>
														<div class="snipcart-item block">
															<div class="snipcart-thumb">
																<a href="/user/productDetail"> <img src="/images/5.png" alt=" " class="img-responsive" /></a>
																<p>상품이름</p>
																<h4>가격</h4>
															</div>
															<div class="snipcart-details">
																<form action="#" method="post">
																	<fieldset>
																		<input type="hidden" name="cmd" value="_cart" /> <input type="hidden" name="add" value="1" /> <input type="hidden" name="business" value=" " /> <input type="hidden"
																			name="item_name" value="knorr instant soup" /> <input type="hidden" name="amount" value="3.00" /> <input type="hidden" name="discount_amount" value="1.00" /> <input type="hidden"
																			name="currency_code" value="USD" /> <input type="hidden" name="return" value=" " /> <input type="hidden" name="cancel_return" value=" " /> <input type="submit" name="submit"
																			value="Add to cart" class="button" />
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
					<div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-FavoriCVS">

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
											<td>${vo.star_id}</td>
											<td>${vo.place_id}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<!-- 즐겨찾는 상품----------------------------------------------------------------------------------------------------------- -->
					<div role="tabpanel" class="tab-pane fade" id="tab_content4" aria-labelledby="profile-bookmarkProd">
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
											<div class="agile_top_brand_left_grid w3l_agile_top_brand_left_grid">
												<div class="agile_top_brand_left_grid_pos">
													<img src="/images/offer.png" alt=" " class="img-responsive" />
												</div>
												<div class="agile_top_brand_left_grid1 ">
													<figure>
														<div class="snipcart-item block">
															<c:forEach items="${bookmarkList}" var="vo">
																<c:if test="${vo.star_kind eq '111'}">
																	<div class="snipcart-thumb">
																		<a href="/userProd/detail?prod_id=${vo.prod_id}"> <img src="/images/5.png" alt=" " class="img-responsive" />
																		</a>
																		<p align="center">${vo.prod_name}</p>
																		<h4 align="center">${vo.prod_price}원</h4>
																	</div>
																	<div class="snipcart-details">
																		<form action="#" method="post">
																			<fieldset>
																				<input type="hidden" name="cmd" value="_cart" /> <input type="hidden" name="add" value="1" /> <input type="hidden" name="business" value=" " /> <input type="hidden"
																					name="item_name" value="knorr instant soup" /> <input type="hidden" name="amount" value="3.00" /> <input type="hidden" name="discount_amount" value="1.00" /> <input
																					type="hidden" name="currency_code" value="USD" /> <input type="hidden" name="return" value=" " /> <input type="hidden" name="cancel_return" value=" " /> <input type="submit"
																					name="submit" value="Add to cart" class="button" />
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
					<div role="tabpanel" class="tab-pane fade" id="tab_content5" aria-labelledby="profile-buyHistory">
						1. 구매내역이 보여진 후 클릭하면, 2. 상세 구매내역이 보여지도록 해야됨 --상세구매내역 아코디언으로
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
										<td>${vo.pay_date}의결제내역</td>
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

<!-- =======<tiles: ="content" /> ============> 마이페이지  myPage.jsp 끝  -->
