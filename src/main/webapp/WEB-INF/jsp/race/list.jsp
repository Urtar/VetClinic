<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista ras zwierząt</h1>

<c:forEach items="${allRaces}" var="race">
    <p>${race.name}, <a href="/race/${race.id}/edit">Edytuj nazwę rasy</a><p/>
</c:forEach>

<a href="/logout">Wylogowanie</a>
