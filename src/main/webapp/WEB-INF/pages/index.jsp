<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html data-ng-app="developersCorner">
<head>
<meta charset="ISO-8859-1">
<!-- Styles -->
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="/static/css/styles.css" rel="stylesheet" type="text/css">

<!-- SockJs -->
<script src="/static/js/sockjs.min.js"></script>
<script src="/static/js/stomp.min.js"></script>

<!-- Angular -->
<script
      src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.js"
      type="text/javascript"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
    <script
      type="text/javascript"
      src="https://cdn.rawgit.com/auth0/angular-jwt/master/dist/angular-jwt.js"
    ></script>
    
    <!-- Angular custom file -->
    <script src="/static/js/app.module.js" type="text/javascript"></script>
    <script
      src="/static/js/service/user.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/service/auth.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/service/notification.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/service/question.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/service/profile.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/service/chat.service.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/controller/user.controller.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/controller/auth.controller.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/controller/profile.controller.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/controller/question.controller.js"
      defer
      type="text/javascript"
    ></script>
    <script
      src="/static/js/controller/chat.controller.js"
      defer
      type="text/javascript"
    ></script>
<title>Developers Corner | Get Unstuck</title>
</head>
<body ng-controller="AuthController">
	<header>
		<div class="container">
			<nav>
				<a class="logo" href="/">Developers Corner</a>
				<ul>
					<li><a href="/">Home</a></li>
					<li ng-show="!isLoggedIn"><a href="#!login">Login</a></li>
					<li ng-show="isLoggedIn"><a href="#" ng-click="logout()" id="logoutBtn">Logout</a></li>
					<li><a href="#!questions">Questions</a></li>
					<li ng-show="!isLoggedIn"><a href="#!register">Register</a></li>
					<li><a href="#!profile">Profile</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main ng-view></main>
	<footer>
		<div class="container">
			<p>©DevelopersCorner 2023 All rights reserved</p>
		</div>
	</footer>
</body>
</html>
