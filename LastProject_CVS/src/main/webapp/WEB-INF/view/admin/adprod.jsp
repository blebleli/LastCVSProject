<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!-- Datatables -->
<!--     <script src="/vendors/datatables.net/js/jquery.dataTables.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-buttons/js/buttons.print.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script> -->
<!--     <script src="/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script> -->
<!--     <script src="/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script> -->
<!--     <script src="/vendors/jszip/dist/jszip.min.js"></script> -->
<!--     <script src="/vendors/pdfmake/build/pdfmake.min.js"></script> -->
<!--     <script src="/vendors/pdfmake/build/vfs_fonts.js"></script> -->

    <!-- Custom Theme Scripts -->
<!--     <script src="/build/js/custom.min.js"></script> -->
<!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
  
<%--   <jsp:include page="/WEB-INF/view/common/admin/ad_prod_top.jsp"/> --%>


<div class="right_col" role="main">
<div class="clearfix"></div>
<div class="row">
<div class="col-md-12">
<div class="x_panel">
<div class="x_title">

<div>


<h1>예상</h1>
[카테고리등록] [행사등록] <br/>

상세검색<br/>
 [대분류] [중분류] [단가/가격] [최소가격]~[최대가격]<br/>
				[ 제 품 명 ]    검색<br/>
□ 순번 대분류 중분류 상품명 단가 가격 유통기한 행사<br/>
□   1  과자류  과자   과자  810  900    355     1+1<br/>



<!--  -->
<hr/>
<h1>검색</h1>

<select>
	<option selected="selected">대분류</option>
	<c:forEach items="${categoryLg }" var="vo">
		<option value="${vo.ctgy_id}">${vo.ctgy_name }</option>
	</c:forEach>
</select>

<select>
	<option selected="selected">중분류</option>
	<c:forEach items="${categoryMd }" var="vo">
		<option value="${vo.ctgy_id}">${vo.ctgy_name }</option>
	</c:forEach>
</select>

<input type="radio" name="money" value="단가">
<input type="radio" name="money" value="정가">

<hr/>
<h1>출력 데이터</h1>
<table border="">
	<tr>
		<th>순번</th>
		<th>대분류</th>
		<th>중분류</th>
		<th>상품명</th>
		<th>단가</th>
		<th>가격</th>
		<th>유통기한</th>
		<th>행사</th>
	</tr>
<!-- 	model.addAttribute("categoryLg", categoryLg); -->
<!-- 		model.addAttribute("categoryMd", categoryMd); -->
<!-- 		model.addAllAttributes(result); -->
	<tbody>
	<!-- 데이터 반복 -->
	<c:forEach items="${prodList }" var="vo">
		<tr>
		<td align="center">${vo.cnt }
			<!-- 제품 코드 -->
			<input type="hidden" name="" id="" value="${vo.prod_id }">
		</td>
		<td>${vo.pr_class_lg }</td>          	
		<td>${vo.pr_class_md }</td>          	
		<td>${vo.prod_name }</td>          	
		<td align="right">${vo.prod_cost }</td>          	
		<td align="right">${vo.prod_price }</td>          	
		<td align="right">${vo.prod_exnum }</td>          	
		<td>${vo.event_id }</td>
		</tr>
	</c:forEach>
	</tbody>
	                           
</table>                       
<%-- 	    ${ pageNavi } --%>


</div>
</div>
</div>
</div>
</div>
</div>


