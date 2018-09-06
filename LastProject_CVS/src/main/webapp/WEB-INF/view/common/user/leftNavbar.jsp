<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div class="w3l_banner_nav_left"> 
		<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				
					<ul class="nav navbar-nav nav_1">
					<li><a href="/userProd/view?i=${i }">전체</a></li>
				<c:forEach items="${prodCtgy}" var="ctgy" varStatus="">
					<li class="dropdown mega-dropdown active"><c:if
							test="${ctgy.ctgy_id == ctgy.ctgy_level}">
							<a href="/userProd/bestList?level=lg&ctgy_id=${ctgy.ctgy_id }&page=1&pageSize=32" class="dropdown-toggle" data-toggle="dropdown">${ctgy.ctgy_name}<span
								class="caret"></span>
								
							</a>
								<c:set value="${ctgy.ctgy_id }" var="ctgy_id"></c:set>
						</c:if>
						<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
							<div class="w3ls_vegetables">
									<ul>
										<c:forEach items="${prodCtgy }" var="prodCtgy">
											<c:if test="${ctgy_id == prodCtgy.ctgy_parent }">
											<li><a href="/userProd/bestList?level=md&ctgy_id=${prodCtgy.ctgy_id }&page=1&pageSize=32">${prodCtgy.ctgy_name}
											</a></li>
											</c:if>
										</c:forEach>
									</ul>
							</div>
						</div></li>

				</c:forEach>

			</ul>
				</div>
			</nav>
		</div>		
						
					
		
		
