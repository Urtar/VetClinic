<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="vet">
    Imię: <form:input path="firstName"/>
    <form:errors path="firstName"/></br>
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/></br>
    Tytuł naukowy: <form:input path="title"/>
    <form:errors path="title"/></br>
    Password: <form:input type="password" path="password" value="p"/>
    <form:errors path="password"/></br>
    <input type="submit" value="Aktualizuj">
</form:form>