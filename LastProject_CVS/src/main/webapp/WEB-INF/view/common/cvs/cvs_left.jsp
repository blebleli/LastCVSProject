<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
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
        <span>Welcome,</span>
        <h2>John Doe</h2>
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
                                                              
          <li><a><i class="fa fa-desktop"></i> POS <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	  <li><a href="/cvs/POS">POS</a></li>
               <li><a href="/cvs/requestIN">입고하기</a></li>
            </ul>               
          </li>

          <li><a><i class="fa fa-table"></i> 내역서 <span class="fa fa-chevron-down"></span></a>
            <ul class="nav child_menu">
           	   <li><a href="/cvs/stock">현재재고</a></li>
               <li><a href="/cvs/supplyIn">입고내역</a></li>
               <li><a href="#">발주<span class="fa fa-chevron-down"></span></a>
                  <ul class="nav child_menu">
                    <li class="sub_menu"><a href="/cvs/supplyReqest?page=1&pageSize=15">발주 신청</a>
                    </li>
                    <li><a href="/cvs/reqList">발주 내역</a>
                    </li>
                  </ul>
               </li>
                <li><a href="dayend">마감</a></li>
            </ul>
          </li>  
          <li><a href="/cvs/main"><i class="fa fa-bar-chart-o"></i> 통계</a>
          </li>         
          <li><a href="/cvs/setting"><i class="fa fa fa-gears"></i> setting </a>
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