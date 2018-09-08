
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
                          <th>상품명</th>
                          <th>입고일</th>
                          <th>유통기한만료일</th>
                          <th>가격</th>
                          <th>재고</th>
                          <th>이벤트상태</th>    
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
