<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
  </head>
  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="cvs_index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/img.jpg" alt="..." class="img-circle profile_img">
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
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="cvs_index.html">Dashboard</a></li>
                    </ul>
                  </li> 
                                                                      
                  <li><a><i class="fa fa-desktop"></i> POS <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                   	  <li><a href="general_elements.html">POS</a></li>
                      <li><a href="general_elements.html">ì¸ì</a></li>
                    </ul>               
                  </li>
                  
                  <li><a><i class="fa fa-table"></i> ë´ì­ì <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                   	   <li><a href="cvs_table_stock.html">íì¬ì¬ê³ </a></li>
                       <li><a href="cvs_table_in_supply.html">ìê³ ë´ì­</a></li>
                       <li><a href="cvs_table_request_supply.html">ë°ì£¼ë´ì­</a></li>
                    </ul>
                  </li>  
                  <li><a><i class="fa fa-bar-chart-o"></i> íµê³ <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="cvs_echarts.html">ì íë³</a></li>
                      <li><a href="chartjs.html">ë ì§ë³</a></li>                 
                    </ul>
                  </li>
                  
                   <li><a><i class="fa fa fa-gears"></i> setting <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="cvs_form.html">setting</a></li>
                    </ul>
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

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="images/img.jpg" alt="">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Users <small>Some examples to get you started</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
       
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Button Example <small>Users</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      The Buttons extension for DataTables provides a common set of options, API methods and styling to display buttons on a page that will interact with a DataTable. The core library provides the based framework upon which plug-ins can built.
                    </p>
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ìíëª</th>
                          <th>ìê³ ì¼</th>
                          <th>ì íµê¸°íë§ë£ì¼</th>
                          <th>ê°ê²©</th>
                          <th>ì¬ê³ </th>
                          <th>ì´ë²¤í¸ìí</th>
                          <th>Action</th>                   
                        </tr>
                  
                      </thead>
						<tr><td>	Jenette 		</td><td>  2011-09-03</td> <td>	2011-09-03</td><td>	345,000	</td><td>30</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Yuri Berry		</td><td>  2009-06-25</td> <td>	2009-06-25</td><td>	675,000	</td><td>40</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Caesar Vance	</td><td>  2011-12-12</td> <td>	2011-12-12</td><td>	106,450	</td><td>21</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Doris Wilder	</td><td>  2010-09-20</td> <td>	2010-09-20</td><td>	85,600	</td><td>23</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Angelica Ramos	</td><td>  2009-10-09</td> <td>	2009-10-09</td><td>	1,200	</td><td>47</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Gavin Joyce		</td><td>  2010-12-22</td> <td>	2010-12-22</td><td>	92,575	</td><td>42</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Jennifer Chang	</td><td>  2010-11-14</td> <td>	2010-11-14</td><td>	357,650	</td><td>28</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Brenden Wagner	</td><td>  2011-06-07</td> <td>	2011-06-07</td><td>	206,850	</td><td>28</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Fiona Green		</td><td>  2010-03-11</td> <td>	2010-03-11</td><td>	850,000	</td><td>48</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Shou Itou		</td><td>  2011-08-14</td> <td>	2011-08-14</td><td>	163,000	</td><td>20</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Michelle House	</td><td>  2011-06-02</td> <td>	2011-06-02</td><td>	95,400	</td><td>37</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Suki Burks		</td><td>  2009-10-22</td> <td>	2009-10-22</td><td>	114,500	</td><td>53</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Prescott 		</td><td>  2011-05-07</td> <td>	2011-05-07</td><td>	145,000	</td><td>27</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Gavin Cortez	</td><td>  2008-10-26</td> <td>	2008-10-26</td><td>	235,500	</td><td>22</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Martena Mccray	</td><td>  2011-03-09</td> <td>	2011-03-09</td><td>	324,050	</td><td>46</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Unity Butler	</td><td>  2009-12-09</td> <td>	2009-12-09</td><td>	85,675	</td><td>47</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Howard Hatfield	</td><td>  2008-12-16</td> <td>	2008-12-16</td><td>	164,500	</td><td>51</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Hope Fuentes	</td><td>  2010-02-12</td> <td>	2010-02-12</td><td>	109,850	</td><td>41</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Vivian Harrell	</td><td>  2009-02-14</td> <td>	2009-02-14</td><td>	452,500	</td><td>62</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Timothy Mooney	</td><td>  2008-12-11</td> <td>	2008-12-11</td><td>	136,200	</td><td>37</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Jackson 		</td><td>  2008-09-26</td> <td>	2008-09-26</td><td>	645,750	</td><td>65</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Olivia Liang	</td><td>  2011-02-03</td> <td>	2011-02-03</td><td>	234,500	</td><td>64</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Bruno Nash		</td><td>  2011-05-03</td> <td>	2011-05-03</td><td>	163,500	</td><td>38</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Sakura Yamamoto	</td><td>  2009-08-19</td> <td>	2009-08-19</td><td>	139,575	</td><td>37</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Thor Walton		</td><td>  2013-08-11</td> <td>	2013-08-11</td><td>	98,540	</td><td>61</td><td>200</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Finn Camacho	</td><td>  2009-07-07</td> <td>	2009-07-07</td><td>	87,500	</td><td>47</td><td>201</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Serge Baldwin	</td><td>  2012-04-09</td> <td>	2012-04-09</td><td>	138,575	</td><td>64</td><td>201</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Zenaida Frank	</td><td>  2010-01-04</td> <td>	2010-01-04</td><td>	125,250	</td><td>63</td><td>201</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Zorita Serrano	</td><td>  2012-06-01</td> <td>	2012-06-01</td><td>	115,000	</td><td>56</td><td>201</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Jennifer Acosta	</td><td>  2013-02-01</td> <td>	2013-02-01</td><td>	75,650	</td><td>43</td><td>202</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Cara Stevens	</td><td>  2011-12-06</td> <td>	2011-12-06</td><td>	145,600	</td><td>46</td><td>202</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Hermione Butler	</td><td>  2011-03-21</td> <td>	2011-03-21</td><td>	356,250	</td><td>47</td><td>202</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Lael Greer		</td><td>  2009-02-27</td> <td>	2009-02-27</td><td>	103,500	</td><td>21</td><td>202</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Jonas Alexander	</td><td>  2010-07-14</td> <td>	2010-07-14</td><td>	86,500	</td><td>30</td><td>202</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Shad Decker		</td><td>  2008-11-13</td> <td>	2008-11-13</td><td>	183,000	</td><td>51</td><td>203</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Michael Bruce	</td><td>  2011-06-27</td> <td>	2011-06-27</td><td>	183,000	</td><td>29</td><td>203</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
						<tr><td>	Donna Snider	</td><td>  2011-01-25</td> <td>	2011-01-25</td><td>	112,000	</td><td>27</td><td>203</td><td>  <a href="cvs_invoice.html">View</a> </td>	</tr>
                      <tbody>
 
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>

  </body>
</html>