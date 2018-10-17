<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

 <title> CVStore_owner| cvsDayEnd </title> 
 
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
    <link href="../build/css/cvsCustom.min.css" rel="stylesheet">
     
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>마감</h3>
              </div>

            </div>

            <div class="clearfix"></div>

             <div class="row">
              <div class="clearfix"></div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><small>마감을 진행할 수 있는 화면입니다</small></h2>
                    
                    <ul class="nav navbar-right panel_toolbox">
                      <li>
                      	<button type="button" class="btn btn-success" onclick="btnDayEnd()">마감하기</button>                      
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

     <div class="container">
         <div class="row">
          	<div class="x_content">
            	 <div class=" col-md-4 col-sm-4 col-xs-4">
                    <div class="table-responsive">
                      <table id="stockTable" class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                           
                            <th class="column-title">NO </th>
                            <th class="column-title">재고번호 </th>
                            <th class="column-title">날짜 </th>
                            <th class="column-title">마감</th> <!-- STOCK ID로 999가 있는지 확인하기 -->

                          </tr>
                        </thead>

                        <tbody>
                        <!-- 행클릭시 AJAX로 리스트 변경 -->
                        <c:forEach items="${stock }" var="stock" varStatus="status">                      		
                          <tr class="even pointer">      
                            <td class=" ">${status.count}</td>
                            <td class=" "><span class="stockID">${stock.stock_id}</span></td>
                            <td class=" "><span class="stock_date"><fmt:formatDate value="${stock.stock_date}" pattern="yyyy-MM-dd" /></span></td> 
                            <td class=" ">
                            <c:choose>                   			
								<c:when test="${stock.stock_kind==888}">
									재고
								</c:when>
								<c:when test="${stock.stock_kind==999}">
									마감
								</c:when>									
								<c:otherwise>
									재고마감
								</c:otherwise>									
							</c:choose>
                            </td>                         
                          </tr>
   						</c:forEach>
                                             
                        </tbody>
                      </table>
                    </div>
                  </div>
                    
                
<!-- 상세재고list modal ==================================== -->
				
		       <div class=" col-md-8 col-sm-8 col-xs-8">              				
					<div class="table-responsive">
                     <table id="stockListTable" class="table table-striped jambo_table bulk_action">
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
                       <tbody id="stockDetailTbody"> 
                       </tbody>
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
        
    <!-- footer content -->
        <footer>
          <div class="pull-right">
           Store Owner by  <a href="/cvs/main">gogo CVS</a>
          </div>
          <div class="clearfix"></div>
        </footer>
    <!-- /footer content -->
    
    
	<script>
	$(document).ready(function(){
		$('#stockTable').DataTable({
			"scrollY":        "380px",
			"lengthMenu": [[5,10], [5,10]],
		    "columnDefs": [{ "width": "18%" , "targets": 3 }]
		});
		
	});
	
	
  	var table = null;
	
	
	//재고 상세리스트 출력
	$("#stockTable tbody").on("click", "tr", function(){
		
		var stockID =$(this).find(".stockID").html();
		var stock_date =$(this).find(".stock_date").html();
		var indx = $(this).index();
		
		console.log("stockID --->"+stockID);
		console.log("indx-->"+indx);
		
	 	$.ajax({
			url : "/cvs/getNowStock",
			method:"get",
			data : {"stockID": stockID,
					"stock_date": stock_date},
			success : function(stockList){
				
				$("#stockDetailTbody").empty();
				
				if (table !== null) {								

				    table.clear().draw();
				    table.destroy();
				    table = null;    
				}
				
				if(indx==0){
					$.each(stockList,function(index, item){				
						$("#stockDetailTbody").append(		    								
									'<tr class="even pointer" data-splylist_id="'+item.splylist_id+'" data-stck_date="'+item.stck_date+'">'+        
			                        '<td >'+(index+1)+'</td>'+	                        
			                        '<td ><span class="prod_id">'+item.prod_id+'</span></td>'+
			                        '<td >'+item.prod_name+'</td>'+
			                        '<td ><input style="width : 100%" type="number" name="amount" class="amount" value='+item.stcklist_amount+'>'+
			                        '</input></td>'+
			                        '<td ><span class="stcklist_exdate">'+ new Date(item.stcklist_exdate).toISOString().substring(0, 10)+'</span></td>'+
			                        '</tr>'
							);
						});
				}else{
					$.each(stockList,function(index, item){				
						$("#stockDetailTbody").append(		    								
									'<tr class="even pointer" data-splylist_id="'+item.splylist_id+'" data-stck_date="'+item.stck_date+'">'+        
			                        '<td >'+(index+1)+'</td>'+	                        
			                        '<td ><span class="prod_id">'+item.prod_id+'</span></td>'+
			                        '<td >'+item.prod_name+'</td>'+
			                        '<td ><input style="width : 100%" type="number" name="amount" class="amount" value='+item.stcklist_amount+' disabled>'+
			                        '</input></td>'+
			                        '<td ><span class="stcklist_exdate">'+ new Date(item.stcklist_exdate).toISOString().substring(0, 10)+'</span></td>'+
			                        '</tr>'
							);
						});
				}

				
				table = $('#stockListTable').DataTable({
				  "scrollY":        "380px",
				  "columnDefs": [
					  { "width": "5%", "targets": 0 },            
				      { "width": "20%", "targets": 1 },
				      { "width": "15%", "targets": 3 }
				      ]	
				});
			  }
			});
		}); 

	
	/* 마감하기 버튼 클릭시*/
	function btnDayEnd() {
		
		var dayEndList=[];		
		

		//재고마감리스트 추가 
		//다음날짜로 재고 추가
		//다음날짜로 재고리스트 추가
		
		$("#stockDetailTbody tr").each(function (index) {		                    	 
				var trData = $(this);		
				
				if(index<=10){ //test용
					
			dayEndList.push({prod_id: trData.find('.prod_id').html(),
							 splylist_id: trData.data('splylist_id'),
							 stck_date: trData.data('stck_date'),
							 stcklist_exdate: trData.find('.stcklist_exdate').html(),
							 stcklist_amount: trData.find('.amount').val()});
							 console.log("each index---"+trData.data('splylist_id'));
				};
	         });	
			
			console.log("dayEndList ::: "+dayEndList.length);
				
			if(dayEndList.length > 0){
				
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
			
			}else{
    			alert('마감할 리스트가 없습니다.');
    			dayEndList=[];
    		}
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
