<%@page import="com.javaworks.shopping.util.DbConn"%>
<%@page import="com.javaworks.shopping.dao.ProductDao"%>
<%@ page import="com.javaworks.shopping.model.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
	// 화면이 열리면서 자동으로 데이터를 불러오도록 하기 위해서 작성(비즈니스 로직 역할)
	ProductDao pdDao = new ProductDao(DbConn.getConnection());
	// 모든 상품
	List<Product> products = pdDao.getAllProducts();
	// 최근 상품 4개
	List<Product> recentProducts = pdDao.getRecentProducts();
	// 인기 상품 4개
	List<Product> hitProducts = pdDao.getHitProducts();
	
	/* User user = null;
	String userId = "";
	if(session.getAttribute("user") != null){
		user = (User) session.getAttribute("user");
		userId = user.getUserId();
		System.out.println("Navbar > 로그인한 사용자 세션 : " + user);
	}else{
		System.out.println("Navbar > 로그인 하지 않은 사용자입니다.");	
	} */ 	
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>쇼핑몰에 오신걸 환영합니다.</title>
	<%@include file="/WEB-INF/includes/header.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/includes/navbar.jsp"%>

	<%
		out.print("Login User Session : " + session.getAttribute("user"));
		//System.out.println(application.getContextPath());
		//System.out.println("index.jsp페이지 application.getRealPath('/image'): " + application.getRealPath("/image"));
	%>

	<div class="container" style="margin-top: 80px;">
		<!-- 모든 상품 -->
		<div class="card">
			<div class="card-header bg-warning bg-gradient p-2 fw-bold" style="-bs-bg-opacity: .1;">모든 상품</div>
			<div class="card-body">
				<div class="row">
					<%
						/* 데이터가 정사적으로 넘어오는지 미리 체크
						out.print("데이터 갯수 :  : " + products.size());
						if(!products.isEmpty()){
							for(Product p:products){
								out.println(p.toString());
							}
						}
						*/
					%>

					<%
						if (!products.isEmpty()) {
						for (Product p : products) {
					%>
					<div class="col-lg-3 col-md-4 col-sm-6 col-12 mt-2">
						<div class="card w-100" style="width: 18rem;">
							<a href="${pageContext.request.contextPath}/detailView?productId=<%=p.getProductId()%>">
								<img class="card-img-top" src="${pageContext.request.contextPath}/images/<%=p.getImage()%>" alt="<%=p.getProductName()%>">
							</a>
							<div class="card-body">
								<div class="card-title">
									제품명 :
									<%=p.getProductName()%></div>
								<div class="price">
									가격 :
									<%=p.getUnitPrice()%>원
								</div>
								<div class="category">
									카테고리 :
									<%=p.getCategoryName() %></div>
								<div class="mt-3 d-flex justify-content-between">
									<a href="#" class="btn btn-secondary" style="font-size:0.8rem;">카트에 추가</a> <a href="#"
										class="btn btn-success" style="font-size:0.8rem;">즉시구매</a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
		</div>
		<!-- 모든 상품 -->
		<!-- 최근 상품 -->
		<div class="card mt-3">
			<div class="card-header bg-info bg-gradient p-2 fw-bold"
				style="-bs-bg-opacity: .2;">최근 상품</div>
			<div class="card-body">
				<div class="row">
					<%
						if (!recentProducts.isEmpty()) {
						for (Product p : recentProducts) {
					%>
					<div class="col-lg-3 col-md-4 col-sm-6 col-12 mt-2">
						<div class="card w-100" style="width: 18rem;">
							<a href="${pageContext.request.contextPath}/detailView?productId=<%=p.getProductId()%>">
								<img class="card-img-top" src="${pageContext.request.contextPath}/images/<%=p.getImage()%>" alt="<%=p.getProductName()%>">
							</a>							
							<div class="card-body">
								<h5 class="card-title">
									제품명 :
									<%=p.getProductName()%></h5>
								<div class="price">
									가격 :
									<%=p.getUnitPrice()%>원
								</div>
								<div class="category">
									카테고리 :
									<%=p.getCategoryName()%></div>
								<div class="mt-3 d-flex justify-content-between">
									<a href="#" class="btn btn-secondary" style="font-size:0.8rem;">카트에 추가</a> <a href="#"
										class="btn btn-success" style="font-size:0.8rem;">즉시구매</a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
		</div>
		<!-- 최근 상품 -->
		
		<!-- 히트 상품 -->
		<div class="card mt-3">
			<div class="card-header bg-success bg-gradient p-2 fw-bold"
				style="-bs-bg-opacity: .2;">인기 상품</div>
			<div class="card-body">
				<div class="row">
					<%
						if (!hitProducts.isEmpty()) {
						for (Product p : hitProducts) {
					%>
					<div class="col-lg-3 col-md-4 col-sm-6 col-12 mt-2">
						<div class="card w-100" style="width: 18rem;">
							<a href="${pageContext.request.contextPath}/detailView?productId=<%=p.getProductId()%>">
								<img class="card-img-top" src="${pageContext.request.contextPath}/images/<%=p.getImage()%>" alt="<%=p.getProductName()%>">
							</a>							
							
							<div class="card-body">
								<h5 class="card-title">
									제품명 :
									<%=p.getProductName()%></h5>
								<div class="price">
									가격 :
									<%=p.getUnitPrice()%>원
								</div>
								<div class="category">
									카테고리 :
									<%=p.getCategoryName()%></div>
								<div class="mt-3 d-flex justify-content-between">
									<a href="#" class="btn btn-secondary" style="font-size:0.8rem;">카트에 추가</a> <a href="#"
										class="btn btn-success" style="font-size:0.8rem;">즉시구매</a>
								</div>
							</div>
						</div>
					</div>
					<%
						}
					}
					%>
				</div>
			</div>
		</div>
		<!-- 히트 상품 -->	
	</div>
	<!-- container -->
<script type="text/javascript">
	function fnGoCart(){
		// 로그인 유무 파악
		// 세션에 저장한 사용자 객체 사용
		//// var user = '<%=(User)session.getAttribute("user")%>';	// 방법.1 
		var user = '${sessionScope.user}'; // 방법.2
		console.log(user);
		if(user == ""){
			alert("로그인 전입니다. 로그인을 하세요.");
			return false;
		}		
		return true;
	}
</script>


	<%@include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>