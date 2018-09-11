<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/css/custom.min.css" rel="stylesheet">
    
    <style>
		.tbl-accordion {
		  margin: 0 auto;
		  width: 900px;
		  border: 1px solid #d9d9d9;
		}
		.tbl-accordion thead {
		  background: #d9d9d9;
		}
		.tbl-accordion .tbl-accordion-nested {
		  width: 100%;
		}
		.tbl-accordion .tbl-accordion-nested tr:nth-child(even) {
		  background-color: #eeeeee;
		}
		.tbl-accordion .tbl-accordion-nested td, .tbl-accordion .tbl-accordion-nested th {
		  padding: 10px;
		  border-bottom: 1px solid #d9d9d9;
		}
		.tbl-accordion .tbl-accordion-nested .tbl-accordion-section {
		  background: #1E90FF;
		  color: #fff;
		  cursor: pointer;
		}
    </style>
    
    <script>
    $(function(){
    	$(".tbl-accordion-nested").each(function() {
    		  var thead = $(this).find("thead");
    		  var tbody = $(this).find("tbody");

    		  tbody.hide();
    		  thead.click(function() {
    		    tbody.slideToggle();
    		  });
    		});
    });
    
    </script>
</head>




<!-- banner -->
<div class="banner">
		<div class="w3l_banner_nav_right">
			<div class="agileinfo_single">
				<h5>${prod.prod_name }</h5>
				<div class="col-md-4 agileinfo_single_left">
					<img id="example" src="${prod.file_path }/${prod.file_upname}" alt=" " class="img-responsive" />
				</div>
				<div class="col-md-8 agileinfo_single_right">
					<div class="rating1">
						<span class="starRating">
							<input id="rating5" type="radio" name="rating" value="5">
							<label for="rating5">5</label>
							<input id="rating4" type="radio" name="rating" value="4">
							<label for="rating4">4</label>
							<input id="rating3" type="radio" name="rating" value="3" checked>
							<label for="rating3">3</label>
							<input id="rating2" type="radio" name="rating" value="2">
							<label for="rating2">2</label>
							<input id="rating1" type="radio" name="rating" value="1">
							<label for="rating1">1</label>
						</span>
					</div>
					<div class="w3agile_description">
						<h4>상품 정보 :</h4>
						<p>${prod.prod_intro }</p>
					</div>
					<div class="snipcart-item block">
						<div class="snipcart-thumb agileinfo_single_right_snipcart">
							<h3>${prod.prod_price } 원 </h3>
						</div>
						<div class="snipcart-details agileinfo_single_right_details">
<%-- 							<c:if test="${user == null }"> --%>
<!-- 								<form -->
<%-- 							</c:if> --%>
							<form action="/userPay/pay" method="post" id="prodDetailFrm">
								<fieldset>

									<input type="hidden" name="prod_id" value="${prod.prod_id }">
									<input type="submit" name="submit" value="장바구니에 담기" class="button" />
									<input type="submit" name="submit" value="결제" class="button" />
								</fieldset>
							</form>
						</div>
					</div>
				</div>
				<br>
			<div class="col-md-10 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                  
                    <br>
                    <h4><strong>상품 리뷰 </strong></h4>
                    <hr>
                    	<c:if test="${userInfo != null }">
                    		<form action="/review/write" method="POST">
	                    		<div class="rating1">
									<span class="starRating">
										<input id="rating5" type="radio" name="rating" value="5">
										<label for="rating5">5</label>
										<input id="rating4" type="radio" name="rating" value="4">
										<label for="rating4">4</label>
										<input id="rating3" type="radio" name="rating" value="3" checked>
										<label for="rating3">3</label>
										<input id="rating2" type="radio" name="rating" value="2">
										<label for="rating2">2</label>
										<input id="rating1" type="radio" name="rating" value="1">
										<label for="rating1">1</label>
									</span>
								</div>
	                    		<textarea name="reviewCont" class="form-control" rows="3" cols="3"></textarea>
	                    		<input type="submit" value="write" name="saveReview" style="background-color:#1E90FF"/>
	                    		<input type="hidden" value="${ctgy_id }" name="ctgy_id">
	                    		<input type="hidden" value="${prod.prod_id }" name="prod_id">
                    		</form>
                    	
                    	</c:if>
                    
                    <div class="clearfix"></div>
                  </div>
				<div class="clearfix"> </div>
			</div>
<!-- 	 <div class=""> -->
	
                  
                  <div class="x_content">
                    <!-- start accordion -->
                    <!-- ---------------------------------------- -->
                    <div>
                    <c:forEach items="${reviewList }" var="review">
                    
                    <table cellpadding="0" cellspacing="0" class="tbl-accordion">
						  <tbody>
						    <tr>
						      <td >
						        <table cellpadding="0" cellspacing="0" class="tbl-accordion-nested">
						          <thead class="tbl-accordion-section">
						            <tr style="backgroud-color : 	#1E90FF">
						              <td>${review.bd_title }</td>
						              <td>${review.mem_name }</td>
						              <td>${review.bd_date }</td>
<%-- 						              <td><fmt:formatDate value="${review.bd_date }" pattern="yyyy-MM-dd"/></td> --%>
						              <td>조회수:${review.bd_views }</td>
						              <c:if test="${userInfo.mem_id == review.mem_id }">
						              <td><a class="btn btn-danger" href="/review/delete?bd_id=${review.bd_id }" aria-label="Delete">
  											<i class="fa fa-trash-o" aria-hidden="true"></i>
										   </a></td>
						              </c:if>
						            </tr>
						          <thead>
						          <tbody>
						            <tr>
						              <td colspan="3" >${review.bd_content }</td>
						            </tr>
						            <c:if test="${userInfo !=null }">
							            <tr>
							              <td colspan="3" ><textarea name="reviewCont" class="form-control" rows="3" cols="4"></textarea></td>
							            </tr>
						            </c:if>
						          </tbody>
						        </table>
						      </td>
						    </tr>
						  </tbody>
						</table>			
                    </c:forEach>
                    </div>
                    <!-- ---------------------------------------- -->
                    <!-- end of accordion -->
                  </div>
                <div class="clearfix"></div>
<!--                 </div> -->
              </div>
              </div>
            <div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	
	<br>
	
              
	
	
	

</body>
</html>
