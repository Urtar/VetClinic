<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Wizyt ${petName}</h1>

<a href="/visit/add">Dodaj wizytę</a></br>

<c:forEach items="${allPetVisits}" var="petVisit">
    <a href="/visit/${petVisit.id}/details"><p>Szczegóły wizyty z dnia ${petVisit.dateOfVisit}</p></a></br>
</c:forEach>

<a href="/logout">Wylogowanie</a>
