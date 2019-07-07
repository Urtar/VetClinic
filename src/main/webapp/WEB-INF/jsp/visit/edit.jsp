<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="visit">
    Lekarz: ${vetName}<br/>
    Imię zwierzęcia: ${petName} <br/>
    Opis: <br/>
    <form:textarea rows="30" cols="150" path="description"/>
    <form:errors path="description"/>
    <br/>
    <input type="submit" value="Aktualizuj">
</form:form>