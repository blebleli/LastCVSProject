<!-- banner 공통 또는 비 공통 부분-->
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
						<c:forEach items="${prodCtgy}" var="ctgy">
						
							<c:choose>
								<c:when test="${ctgy.level == 1}">
									<li class="dropdown mega-dropdown active">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">${ctgy.ctgy_name}<span class="caret"></span></a>
								</c:when>
								<c:when test="${ctgy.level ==2}" >
									<div class="dropdown-menu mega-dropdown-menu w3ls_vegetables_menu">
											<div class="w3ls_vegetables">
											
												<ul>	
													<li><a href="vegetables.html">${ctgy.ctgy_name}</a></li>
												</ul>
											</div>                  
										</div>				
									</li>
								</c:when>
							</c:choose>
						</c:forEach>
						
					</ul>
				</div>
			</nav>
		</div>		
						
						
		
		
