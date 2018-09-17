<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
   <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
 
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Tables <small>Some examples to get you started</small></h3>
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
              <div class="clearfix"></div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Table design <small>Custom design</small></h2>
                    
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

     <div class="container">
         <div class="row">
          	<div class="x_content">
            	 <div class=" col-md-3 col-sm-3 col-xs-3">
                    <div class="table-responsive">
                      <table id="stockTable" class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                           
                            <th class="column-title">NO </th>
                            <th class="column-title">재고번호 </th>
                            <th class="column-title">날짜 </th>
                           <th class="column-title">마감여부 </th> <!-- STOCK ID로 999가 있는지 확인하기 -->

                          </tr>
                        </thead>

                        <tbody>
                        <!-- 행클릭시 AJAX로 리스트 변경 -->
                        <c:forEach items="${stock }" var="stock" varStatus="status">                      		
                          <tr class="even pointer">
                           
                            <td class=" ">${status.count}</td>
                            <td class=" "><span class="stockID"> ${stock.stock_id } </span></td>
                            <td class=" ">${stock.stock_date }</td>                          
                          </tr>
   						</c:forEach>
                                             
                        </tbody>
                      </table>
                    </div>
                  </div>
                    
                
<!-- 상세재고list modal ==================================== -->
				
		       <div class=" col-md-9 col-sm-9 col-xs-9">              
					<button type="button" class="btn btn-success" onclick="btnDayEnd()">마감하기</button>
					<div class="table-responsive">
                     <table class="table table-striped jambo_table bulk_action">
                       <thead>
                         <tr class="headings">
                           <th class="column-title">NO </th>
                           <th class="column-title">상품번호 </th> <!-- PROD JOIN -->
                           <th class="column-title">상품이름 </th>
                           <th class="column-title">수량 </th>
                           <th class="column-title">유통기한 </th>                     	  
                         </tr>
                       </thead>
						<!--  재고 상세 리스트  -->
                       <tbody id="stockDetailTbody"> </tbody>
                     </table>
                   </div>
                 </div>

             </div>
           </div>
         </div>
                        
            </div>
          </div>
        </div>
        
   </div>
   </div>     
        <!-- /page content -->
	<script>
	
	//재고 상세리스트 출력
	$("#stockTable tbody").on("click", "tr", function(){
		var stockID =$(this).find(".stockID").text();	
		console.log("stockID --->"+stockID);
		
	 	$.ajax({
			url : "/cvs/getNowStock",
			method:"get",
			data : {"stockID": stockID },
			success : function(stockList){
				
				$("#stockDetailTbody").empty();
				console.log('stockList --->'+stockList);
				$.each(stockList,function(index, item){
					
				$("#stockDetailTbody").append(		    								
							'<tr class="even pointer">'+        
	                        '<td class=" ">'+index+'</td>'+
	                        '<td class=" ">'+item.prod_id  +'</td>'+
	                        '<td class=" ">'+item.prod_name  +'</td>'+
	                        '<td class=" "><input type="number" name="amount" class="amount">'+item.stcklist_amount +'</input></td>'+
	                        '<td class=" ">'+item.stcklist_exdate  +'</td>'+
	                        '<td style="display: none"><span class="bcd_id">'+ item.bcd_id+'</span></td> '+
	                        '</tr>'	                                                                                     
					);
				})
				
			}
		}); 

	});	
	
	/* 마감하기 버튼 클릭시*/
	function btnDayEnd() {
		
		var dayEndList=[];		
		

		//재고마감리스트 추가 
		//다음날짜로 재고 추가
		//다음날짜로 재고리스트 추가
		
		$("#stockDetailTbody tr").each(function () {		                    	 
			var data = $(this);		
			
			dayEndList.push({bcd_id: data.find('.bcd_id').html(), 
					stcklist_amount: data.find('.amount').val()})
         });	
		
		console.log("dayEndList ::: "+dayEndList);

		$.ajax({
			  url: "/cvs/setDayEnd",
			  method: "post",
			  data: JSON.stringify(dayEndList),
			  contentType: "application/json",
			  success : function () {
				  alert("마감처리 되었습니다.");
				  $("#stockDetailTbody").empty(); 
		      },		 						
			  error : function(){console.log("error");}		  								  
		});					    		
	}
	</script>


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

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
