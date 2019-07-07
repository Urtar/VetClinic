<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista gatunków zwierząt</h1>

<c:forEach items="${allPetTypes}" var="petType">
    <p>${petType.name}, <a href="/petType/${petType.id}/edit">Edytuj nazwę gatunku</a><p/>
</c:forEach>

<a href="/logout">Wylogowanie</a>
