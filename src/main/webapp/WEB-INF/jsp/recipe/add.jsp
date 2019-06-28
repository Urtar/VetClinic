<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="recipe">
    Numer pesel właściciela: <form:select path="owner" items="${allOwners}" itemLabel="pesel" itemValue="id" /> <br/>
    Opis: <form:input path="description"/>
    <form:errors path="description"/>
    <input type="submit" value="Dodaj">
</form:form>