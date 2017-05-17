<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>Docere Login</title>
		
		<link rel="stylesheet" href="/DocereLMS/resources/css/materialize.min.css">
		<link rel="stylesheet" href="/DocereLMS/resources/css/style-login.css">
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arimo|Open+Sans|Roboto:100,300,400">
    	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    	
    	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
    	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

	</head>
	<body class="login">
		<div class="container-fluid full-container">
			<div class="container-fluid">
				<div class="container">
					<div class="row">
					
						<div class="col-sm-8">
							<h2>
								<span>
									Docere LMS
								</span>
							</h2>
							
							<div class="col-sm-12 tagline">
								<h4>Forums. Chat. Announcements. Learning Resources.</h4>
								
								<h5>Simple and easy.</h5>
							</div>
						</div>
	
						<div class="col-sm-4 login-box">
						
							<c:if test="${param.error != null}">
								<div class="alert alert-danger" role="alert">
									<strong>Login failed.</strong> Check your username and password.
								</div>
							</c:if>
							
							<form id="form" name="login" action="<c:url value='j_spring_security_check'/>" method="POST">
								<div class="input-field col s12">
									<input id="username" class="control" type="text" name="username" value="" placeholder="Username">
									<label for="username">Username</label>	
								</div>
								
								<div class="input-field col s12">
									<input id="password" class="control" type="password" name="password" placeholder="Password">
									<label for="password">Password</label>
								</div>
								
								<div class="col s12">
									<input class="btn col s12" name="submit" type="submit" value="Login">
								</div>
								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form>
							
							<div class="col s12 signup-link">
								Don't have an account?
								<a href="<c:url value="/register"/>"> Sign up now!</a>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		
		</div>
	
	</body>
</html>