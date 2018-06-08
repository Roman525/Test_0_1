<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Интернет магазин пыва</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<div class="w3-container w3-blue-grey w3-opacity w3-left-align">
    <h1>Список товаров</h1>
</div>
<div>
<table class="w3-table-all w3-xlarge">
    <tr>
        <th width="120">Название</th>
        <th width="120">Изображение</th>
        <th width="120">Цена</th>
        <th width="60">Добавить</th>
        <th width="60">Удалить</th>
    </tr>
    <c:forEach var="i" items="${entities}">
        <tr>
            <td>${i.name}</td>
            <td><img src="${contextPath}/images/${i.picture}" width="200" height="200"></td>
            <td>${i.sum}</td>
            <td></td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</div>
<table>
    <tr>
        <th width="250">Сумма покупки</th>
    </tr>
    <tr>

    </tr>
</table>
</body>
</html>
