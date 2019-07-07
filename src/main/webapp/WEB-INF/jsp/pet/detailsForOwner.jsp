<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Wizyt</h1>

<c:forEach items="${allPetVisits}" var="visit">
    <a href="/visit/${visit.id}/detailsForOwner"><p>Szczegóły wizyty ${visit.dateOfVisit}</p></a></br>
</c:forEach>

<a href="/owner/petList">Lista zwierząt</a> <br/>
<a href="/logout">Wylogowanie</a> <br/>
