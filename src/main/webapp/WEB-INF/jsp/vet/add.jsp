<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="vet">
    Imię: <form:input path="firstName"/>
    <form:errors path="firstName"/>
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/>
    Tytuł naukowy: <form:input path="title"/>
    <form:errors path="title"/>
    Login: <form:input path="login"/>
    <form:errors path="login"/>
    Password: <form:input path="password"/>
    <form:errors path="password"/>
    <input type="submit" value="Dodaj">
</form:form>