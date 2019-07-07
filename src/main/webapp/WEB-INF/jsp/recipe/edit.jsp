<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

Numer pesel właściciela: ${ownerPesel} <br/>

<form:form method="POST"
           modelAttribute="recipe">
    Opis: <br/>
    <form:input path="description"/> <br/>
    <form:errors path="description"/> <br/>
    <input type="submit" value="Aktualizuj">
</form:form>
<br/>
<h1>Lista Recept</h1>
<c:forEach items="${allVisitRecipes}" var="visitRecipe">
    <p><a href="/recipe/${visitRecipe.id}/details">Szczegóły recepty z dnia ${visitRecipe.visit.dateOfVisit}</a>, <a href="/recipe/${visitRecipe.id}/edit">Edytuj receptę</a></p></br>
</c:forEach>

<a href="/visit/list">Poprzednia strona</a>