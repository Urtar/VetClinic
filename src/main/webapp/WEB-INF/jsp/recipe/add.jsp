<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

Numer pesel właściciela: ${ownerPesel} <br/>

<form:form method="POST"
           modelAttribute="recipe">
   <h1>Recepta</h1>
    Opis: <br/>
    <form:input path="description"/> <br/>
    <form:errors path="description"/> <br/>
    <input type="submit" value="Dodaj">
</form:form>
<br/>
<h1>Lista recept</h1>
<c:forEach items="${allVisitRecipes}" var="visitRecipe">
    <a href="/recipe/${visitRecipe.id}/details"><p>Szczegóły recepty z dnia ${visitRecipe.visit.dateOfVisit}</p></a></br>
</c:forEach>

<a href="/visit/list">Lista wizyt</a>