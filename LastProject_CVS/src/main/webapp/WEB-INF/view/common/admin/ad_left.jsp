<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        
<div class="col-md-3 left_col">
  <div class="left_col scroll-view">
    <div class="navbar nav_title" style="border: 0;">
      <a href="cvs_index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
    </div>

    <div class="clearfix"></div>

    <!-- menu profile quick info -->
    <div class="profile clearfix">
      <div class="profile_pic">
        <img src="../production/images/img.jpg" alt="..." class="img-circle profile_img">
      </div>
      <div class="profile_info">
        <span>관리자</span>
        <h2>이름?</h2>
      </div>
    </div>
    <!-- /menu profile quick info -->

    <br />
    
    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
      <div class="menu_section">
        <h3>General</h3>
        <ul class="nav side-menu">
          <li><a href="main"><i class="fa fa-home"></i> Home </a>
          </li> 
           <!-- 조종원 -->
           <li><a><i class="fa fa-table"></i> 상품관리 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="/adprod/adprodView">상품 조회/삭제</a></li>
               <li><a href="#">상품 등록</a></li>
               <li><a href="#">상품 수정</a></li>
            </ul>
          </li>
          <!-- 조종원 -->
          
          <!-- 조계환 -->
          <li><a><i class="fa fa-table"></i> 수주 처리 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="lookup">조회</a></li>
               <li><a href="#">결제</a></li>
               <li><a href="#">수정</a></li>
            </ul>
          </li>
          <!-- 조계환 -->
           
          <!-- 공은별 -->
          <li><a><i class="fa fa-table"></i> 회원관리 <span class="fa fa-chevron-down"></span></a>
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
          </li>
          <!-- 공은별 -->
          
          <!-- 김마음 -->
          <li><a><i class="fa fa-table"></i> 게시판관리 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="boardView">조회/삭제</a></li>
               <li><a href="boardNew">생성</a></li>
               <li><a href="boardUpdate">수정</a></li>
            </ul>
          </li>
          <!-- 김마음 -->
          
          <!-- 김현경 -->
          <li><a><i class="fa fa-bar-chart-o"></i> 통계 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="#">무슨통계?</a></li>
           	   <li><a href="#">무슨통계?</a></li>
           	   <li><a href="#">무슨통계?</a></li>
           	   <li><a href="#">무슨통계?</a></li>
           	   <li><a href="#">무슨통계?</a></li>
            </ul>
          </li>
          <!-- 김현경 -->
           	   
           <li><a href="setting"><i class="fa fa fa-gears"></i> setting </a>
          </li>                  
        </ul>
      </div>

    </div>
    <!-- /sidebar menu -->

    <!-- /menu footer buttons -->
    <div class="sidebar-footer hidden-small">
      <a data-toggle="tooltip" data-placement="top" title="Settings">
        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="FullScreen">
        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="Lock">
        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
      </a>
      <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
      </a>
    </div>
    <!-- /menu footer buttons -->
  </div>
  
</div>