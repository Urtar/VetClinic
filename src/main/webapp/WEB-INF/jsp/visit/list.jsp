<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Wizyt</h1>

<a href="/visit/add">Dodaj wizytę</a></br>

<c:forEach items="${allPetVisits}" var="petVisit">
    <p><a href="/visit/${petVisit.id}/details">Szczegóły wizyty z dnia ${petVisit.dateOfVisit}</a>, <a href="/visit/${petVisit.id}/edit">Edytuj wizytę</a> </p>
</c:forEach>

<a href="/logout">Wylogowanie</a> <br/>
<a href="/vetclinic">Strona Główna</a> <br/>
<a href="/owner/list">Lista właścicieli</a><br/>
