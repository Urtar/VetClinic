<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Weterynarzy</h1>

<a href="/vet/add">Dodaj Weterynarza</a></br>

<c:forEach items="${allVets}" var="vet">
    Lekarz: <p>${vet.firstName} ${vet.lastName} ${vet.title} ${vet.login}, <a href="/vet/${vet.id}/edit">Edytuj dane weterynarza</a></p>
</c:forEach>

<a href="/logout">Wylogowanie</a>
