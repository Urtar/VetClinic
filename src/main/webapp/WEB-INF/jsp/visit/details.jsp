<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="visit">
    Lekarz: ${vetName} <br/>
    Imię zwierzęcia: ${petName} <br/>
    Opis: ${visit.description} <br/>

    <c:forEach items="${allVisitRecipes}" var="visitRecipe">
        <p><a href="/recipe/${visitRecipe.id}/details">Szczegóły recepty z dnia ${visitRecipe.visit.dateOfVisit}</a>, <a href="/recipe/${visitRecipe.id}/edit">Edytuj receptę</a></p>
    </c:forEach>

    <a href="/recipe/add">Dodaj receptę</a> <br/>
    <a href="/visit/list">Powrót do poprzedniej strony</a>
</form:form>

