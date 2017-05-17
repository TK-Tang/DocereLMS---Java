<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Docere register</title>
		
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arimo|Open+Sans|Roboto:100,300,400">
    	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    	
    	<link rel="stylesheet" href="/DocereLMS/resources/css/materialize.min.css">
    	<link rel="stylesheet" href="/DocereLMS/resources/css/style-login.css">
		
		<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
    	<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.3/angular.min.js"></script>
    	<script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.3/angular-route.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
    	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    	
    	<script type="text/javascript">
    		function onLoad(){
    			$("#password").keyup(checkPasswordsMatch);
    			$("#confirmpassword").keyup(checkPasswordsMatch);
    			
    			$("#form").submit(canSubmit);
    			$("#form").submit(checkIfUsernameLongerThanOneChar);
    			$("#form").submit(checkIfPasswordLongerThanSevenChars);
    		}
    		
    		function canSubmit(){
    			var password = $("#password").val();
    			var confirmPassword = $("#confirmpassword").val();
    			
    			if (password == confirmPassword){
    				return true;
    			}
    			
    			alert("Passwords do not match.");
    			return false;
    		}
    		
    		function checkPasswordsMatch() {
    	        var password = $("#password").val();
    	        var confirmPassword = $("#confirmpassword").val();
    	        
    	        if (password.length > 7 && confirmpassword.length >7){
    	        	
    	        	if (password == confirmPassword){
    	        		$("#matchpassword").text("Passwords match");
    	        		$("#matchpassword").removeclass("alert-danger");
    	        		$("#matchpassword").addClass("alert-success");
    	        	} else {
    	        		$("#matchpassword").text("Passwords do not match");
    	        		$("#matchpassword").removeClass("alert-success");
    	        		$("#matchpassword").addClass("alert-danger");
    	        	}
    	        	
    	        }
    		}
    		
    		function checkIfPasswordLongerThanSevenChars(){
    			var password = $("#password").val();
    			
    			if (password.length < 7){
    				alert("Password must be longer than seven chars");
    				return false;
    			}
    			
    			return true;
    		}
    		
    		function checkIfUsernameLongerThanOneChar(){
    			var username = $("#username").val();
    			
    			if (username.length < 1){
    				alert("Username must be longer than five characters");
    				return false;
    			}
    			
    			return true;
    		}
    		
    		$(document).ready(onLoad);
    	
    	</script>
	</head>
	
	<body class="login">
		
		<div class="container-fluid full-container">
			<div class="container-fluid">
				<div class="container">
					<div class="row">
						<div class="col-sm-8">
							<h2>Docere</h2>
						
							<div class="col-sm-12 tagline">
								<h4>Forums. Announcements. Chat. Learning Materials.</h4>
								<h5>Simple and easy.</h5>
							</div>
						</div>
						
						<!-- Login box -->
						<div class="col-sm-4 login-box">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger" role="alert">
									<strong>Username already exists</strong>
								</div>
							</c:if>
							
							<div class="alert" id="matchpassword"></div>
							 
							 <!-- commandName is a HTML attribute that must match the model type being put into the webpage -->
							<sf:form id="form" method="POST" action="${pageContext.request.contextPath}/createaccount" modelAttribute="User">
								
								<div class="input-field col s12">
									Username
									<sf:input id="username" class="control" path="username" name="username" type="text" placeholder="Username"/>
									
									<div class="error">
										<sf:errors path="username"></sf:errors>
									</div>
								</div>
								
								<div class="input-field col s12">
									Password
									<sf:input id="password" class="control" path="password" name="password" type="password" placeholder="Password"/>
									
									<div class="error">
										<sf:errors path="password"></sf:errors>
									</div>
								</div>
								
								<div class="input-field col s12">
									Confirm Password
									<input id="confirmpassword" class="control" name="confirmpassword" type="password" placeholder="Confirm Password"/>
								</div>
								
								<div class="col s12"> 
									<input class="btn col s12 control" name="submit" type="submit" value="Sign up"/>
								</div>
							
							</sf:form>
							
							<div class="col s12 signup-link">
								Already have an account?
								<a href = "<c:url value="login"/>"> Login here!</a>
							</div>
						</div>
						<!-- Login box -->
					</div>
				</div>
			</div>
		</div>
	</body>
</html>