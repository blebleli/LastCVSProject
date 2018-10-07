<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
<div class="col-md-3 left_col">
  <div class="left_col scroll-view">
    <div class="navbar nav_title" style="border: 0;">
      <a href="#" class="site_title"><i class="fa fa-user-secret" aria-hidden="true"></i> <span>GOGOCVS</span></a>
    </div>

    <div class="clearfix"></div>

    <!-- menu profile quick info -->
    <div class="profile clearfix">
      <div class="profile_pic">
        <img src="/images/logo-admin-png-4.png" alt="..." class="img-circle profile_img">
      </div>
      <div class="profile_info">
        <span>Welcome,<br><strong>Administrator</strong></span>
        <h2>${userInfo.mem_id}</h2>
      </div>
    </div>
    <!-- /menu profile quick info -->

    <br />
    
    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
      <div class="menu_section">
        <ul class="nav side-menu">
          <li><a href="/admin/main"><i class="fa fa-home"></i> Home </a>
          </li> 
          
          <!-- 조계환 -->
          <li><a href="/admin/lookup"><i class="fa fa-table"></i> 수주 처리</a>
          </li>
          <!-- 조계환 -->
           
          <!-- 공은별 -->
   <!--   <li><a><i class="fa fa-table"></i> 회원관리 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="#">조회</a></li>
               <li><a href="#">수정</a></li>
            </ul>
          </li>
          
          <li><a><i class="fa fa-table"></i> 점포관리 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="#">조회</a></li>
               <li><a href="#">생성</a></li>
               <li><a href="#">수정</a></li>
            </ul>
          </li> -->
          <li><a><i class="fa fa-edit"></i> 등록관리 <span class="fa fa-chevron-down"></span></a>
			<ul class="nav child_menu">
				<li><a href="<c:url value='${pageContext.request.contextPath}/admin/cvsMemberList' />">사업장(지점)관리</a></li>
				<li><a href="<c:url value='${pageContext.request.contextPath}/admin/userMemberList' />">사용자(회원)관리</a></li>
				<li><a href="/adprod/adprodView">상품등록관리</a></li>
				<li><a href="/event/add">행사제품/이벤트관리</a></li>
			</ul>
		  </li>
        
          
          <!-- 김마음 -->
          <li><a href="/adboard/boardView">
          	<i class="fa fa-table"></i>
          	 게시판관리</a>
          </li>
          <!-- 김마음 -->
          
          <!-- 김현경 통계 -  메인으로 변경 -->
<!--            	   
           <li><a href="setting"><i class="fa fa fa-gears"></i> setting </a> -->
                      
        </ul>
      </div>

    </div>
  </div>
  
</div>