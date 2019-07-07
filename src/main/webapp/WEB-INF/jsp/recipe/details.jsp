<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

Numer pesel właściciela: ${ownerPesel} <br/>
<form:form method="POST"
           modelAttribute="recipe">
    Imię zwierzęcia: ${petName} <br/>
    Opis: ${recipe.description} <br/>

    <a href="/recipe/add">Dodaj receptę</a> <br/>
    <a href="/recipe/list">Wróć do poprzedniej strony</a>
</form:form>
