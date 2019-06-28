<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="visit">
    Lekarz: <form:textarea path="vet" item="${vet.getId}" itemLabel="firstName" itemValue="id" /> <br/>
    Imię zwierzęcia: <form:select path="pet" items="${allPetsOfOwner}" itemLabel="name" itemValue="id" /> <br/>
    Opis: <form:input path="description"/>
    <form:errors path="description"/>
    <a: href="recipe/add/${pet.id}">Dodaj receptę</a:>
    <input type="submit" value="Dodaj">
</form:form>