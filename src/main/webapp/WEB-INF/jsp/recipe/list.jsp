<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Recept</h1>

<a href="/recipe/add">Dodaj receptę</a></br>

<c:forEach items="${allVisitRecipes}" var="visitRecipe">
    <a href="/recipe/${visitRecipe.id}/details"><p>Szczegóły recepty z dnia ${visitRecipe.visit.dateOfVisit}</p></a></br>
</c:forEach>

<a href="/logout">Wylogowanie</a> <br/>
<a href="/visit/list">Powrót do poprzedniej strony</a><br/>
<a href="/vetclinic">Strona Główna</a> <br/>
<a href="/owner/list">Lista właścicieli</a><br/>
