<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Gentelella Alela! |</title>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="../build/css/custom.min.css" rel="stylesheet">

<!-- page content -->
<div class="right_col" role="main">
	<div class="">
		<!--             <div class="page-title">
              <div class="title_left">
                <h3>Invoice <small>Some examples to get you started</small></h3>
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
            </div> -->

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							입고 리스트 내역 <small>현재 선택한 입고 리스트의 상세 내역 페이지 입니다.</small>
						</h2>
						<!--                     <ul class="nav navbar-right panel_toolbox">
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
                    </ul> -->
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<section class="content invoice">
							<!-- title row -->
							<div class="row">
								<div class="col-xs-12 invoice-header">
									<h1>
										<i class="fa fa-globe">입고 상품</i> 
										<small class="pull-right">
											Date:${supply_date}
										</small>
									</h1>
								</div>
								<!-- /.col -->
							</div>
							<!-- info row -->
							<div class="row invoice-info">
								<div class="col-sm-4 invoice-col">
									From
									<address>
										<strong>gogoCVS</strong>
										<br>관리자(본사)
										<br>${place_id}
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									To
									<address>
										<strong>GS25대흥나이스점</strong> <br>대전 중구 중교로9, 101호 <br>대흥동
										504-5 <br>Phone: 1 (804) 123-9876 <br>Email:
										jon@ironadmin.com
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									<b>수불바코드 : ${supply_bcd}</b> <br> <br> <br>

									<br>

								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							<!-- Table row -->
							<div class="row">
								<div class="col-xs-12 table">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>수량</th>
												<th>상품이름</th>
												<th>상품코드</th>
												<th style="width: 50%">비고</th>
												<th>합계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${prodList}" var="vo">
												<tr>
													<td>${vo.splylist_sum}</td>
													<td>${vo.prod_name}</td>
													<td>${vo.prod_id}</td>
													<td></td>
													<td>￦64.50</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							<div class="row">
								<!-- accepted payments column -->
								<div class="col-xs-6">
									<p class="lead">Payment Methods:</p>
									<p class="text-muted well well-sm no-shadow"
										style="margin-top: 10px;">Etsy doostang zoodles disqus
										groupon greplin oooj voxy zoodles, weebly ning heekya handango
										imeem plugg dopplr jibjab, movity jajah plickers sifteo edmodo
										ifttt zimbra.</p>
								</div>
								<!-- /.col -->
								<div class="col-xs-6">
									<p class="lead">결제 2018/09/10</p>
									<div class="table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%">합계 :</th>
													<td>$250.30</td>
												</tr>
												<tr>
													<th>세금 (9.3%)</th>
													<td>$10.34</td>
												</tr>
												<tr>
													<th>배송비:</th>
													<td>$5.80</td>
												</tr>
												<tr>
													<th>총합계:</th>
													<td>$265.24</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

							<!-- this row will not appear when printing -->
							<div class="row no-print">
								<div class="col-xs-12">
									<button class="btn btn-default" onclick="window.print();">
										<i class="fa fa-print"></i> Print
									</button>
									<button class="btn btn-success pull-right">
										<i class="fa fa-credit-card"></i> Submit Payment
									</button>
									<button class="btn btn-primary pull-right"
										style="margin-right: 5px;">
										<i class="fa fa-download"></i> Generate PDF
									</button>
								</div>
							</div>
						</section>
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
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
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

<!-- Custom Theme Scripts -->
<script src="../build/js/custom.min.js"></script>
