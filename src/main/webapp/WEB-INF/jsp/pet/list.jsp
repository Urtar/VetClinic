<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Zwierząt</h1>

Właściciel: ${ownerName} <br/>

<a href="/pet/add">Dodaj zwierzę</a></br>

<c:forEach items="${allPets}" var="pet">
    <a href="/pet/${pet.id}/details"><p>${pet.name}</p></a></br>
</c:forEach>

<a href="/logout">Wylogowanie</a>
