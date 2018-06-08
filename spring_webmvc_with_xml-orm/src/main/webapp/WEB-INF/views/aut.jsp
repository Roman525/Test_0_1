<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<html>
<head>
    <title>Аутентификация</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Введите логин и пароль</h1>
</div>
<div class="w3-card-4">
<from:form method="post" class="w3-selection w3-light-grey w3-padding" modelAttribute="pol" action="/Login">

    <br>Name: <from:input class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" path="name"/>  </br>
    <br>Password: <from:input class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%" path="password"/>   </br>
    <br><from:button class="w3-btn w3-hover-green w3-grey w3-round-large">Sign Up</from:button></br>

</from:form>
</div>


</body>
</html>
