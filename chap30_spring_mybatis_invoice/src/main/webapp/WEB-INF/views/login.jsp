<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Security</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="http://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script> 
</head>

<body>
	<div class="container">	
		<div id="wrap">
		    <div id="login">
		        <h3 class="text-center text-white pt-5"></h3>
		        <div class="container">
		            <div id="login-row" class="row justify-content-center align-items-center">
		                <div id="login-column" class="col-md-6">
		                    <div id="login-box" class="col-md-12">
		                        <form id="login-form" class="form" 
		                        		name="formm" id="login_form"
		                        		action="<c:url value='/lalala' />" 
		                        		method="POST">
									<!-- csrf token -->			  
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />  
		                        		
		                            <h3 class="text-center text-info">Login</h3>
		                            
		                            <div class="form-group">
		                                <label for="username" class="text-info">user_id:</label><br>
		                                <span>
											<input type="text" name="user_id" id="id" class="form-control" required="required" autoFocus="autofocus" value="">
		                                </span>
		                                <span class="error_next_box"> </span>
										<div class="check_font" id="login_id_error"></div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <label for="password" class="text-info">user_pwd:</label><br>
		                                <span>
			                                <input type="password" name="user_pwd" id="pwd" class="form-control" required="required" value="">
		                                </span>
		                                <span class="error_next_box"></span>
										<div class="check_font" id="login_pwd_error"></div>
		                            </div>
		
			                   		<c:if test="${error eq 'true'}">
			                   			<font color="red">
											${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}<br>
											<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
										</font>
									</c:if>
		
		                            <div class="form-group">
		                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
		                                <input type="submit" id="btnLogin" class="btn btn-info btn-md" value="submit">
		                            </div>
		                            <div id="register-link" class="text-right">
		                                <a href="${pageContext.request.contextPath}/join" class="text-info">Register here</a>
		                            </div>
		                            <div id="register-link" class="text-right">
		                                <a href="${pageContext.request.contextPath}/index" class="text-info">Goto Home</a>
		                            </div>
		                            
		                        </form>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>
</body>
</html>
