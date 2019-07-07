<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Recept</h1>

<c:forEach items="${allVisitRecipes}" var="visitRecipe">
    <a href="/recipe/${visitRecipe.id}/detailsForOwner"><p>Szczegóły recepty z dnia ${visitRecipe.visit.dateOfVisit}</p></a></br>
</c:forEach>


<a href="/visit/${visitId}/detailsForOwner">Powrót do poprzedniej strony</a><br/>
<a href="/logout">Wylogowanie</a> <br/>
<a href="/vetclinic">Strona Główna</a> <br/>
