<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">
<script src="/static/js/activeNavLinks.js" type="text/javascript" defer></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/auth0/angular-jwt/master/dist/angular-jwt.js"></script>
<script src="/static/js/app.module.js" type="text/javascript"></script>
<script src="/static/js/service/user.service.js" defer
	type="text/javascript"></script>
<script src="/static/js/service/auth.service.js" defer
	type="text/javascript"></script>
<script src="/static/js/controller/auth.controller.js" defer
	type="text/javascript"></script>
<title>Developers Corner | Login Page</title>
</head>
<body data-ng-app="developersCorner" ng-controller="AuthController">
	<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
					<li><a href="/">Home</a></li>
					<li style="display: block;"><a href="/login">Login</a></li>
					<li><a id="logout" href="#">Logout</a></li>
					<li><a href="/questions">Questions</a></li>
					<li><a href="/register">Register</a></li>
					<li><a href="/profile">Profile</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main class="container">
		<form ng-submit="login()" name="loginForm">
			<div class="panel container-xsm m-auto">
				<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1">@</span> <input
								type="email" ng-model="user.email" name="email"
								class="form-control" placeholder="email@example.com"
								aria-label="Email" aria-describedby="basic-addon1" required />
						</div>
						<!-- Email errors  -->
						<div class="alert alert-danger"
							ng-show="loginForm.email.$touched && loginForm.email.$error.required">
							This is a required field</div>
						<div class="alert alert-danger"
							ng-show="loginForm.$error.email">This field is invalid</div>


				<div class="input-group mb-3">
							<span class="input-group-text" id="basic-addon1"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-lock" viewBox="0 0 16 16">
	  						<path
										d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2zM5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1z" />
							</svg>
							</span> <input type="password" ng-model="user.password" name="password"
								class="form-control" placeholder="m@2#ac%" aria-label="Password"
								aria-describedby="basic-addon1" required ng-minlength="6" />
						</div>
						<!-- Password errors  -->
						<div class="alert alert-danger"
							ng-show="loginForm.password.$touched && loginForm.password.$error.required">This
							is a required field</div>
						<div class="alert alert-danger"
							ng-show="loginForm.password.$error.minlength">Minimum
							length required is 6</div>
						<div class="alert alert-danger"
							ng-show="loginForm.$error.password">This field is
							invalid</div>
					
				<!-- Form submit button -->
				<div class="form-actions floatRight">
					<input class="btn btn-primary" type="submit"
						value="Login"
						ng-disabled="loginForm.$invalid" />
				</div>
			</div>
		</form>
	</main>

	<footer>
		<div class="container">
			<p>©DevelopersCorner 2023 All rights reserved</p>
		</div>
	</footer>
</body>
</html>