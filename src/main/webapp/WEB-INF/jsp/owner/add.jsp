<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="owner">
    Imię: <form:input path="firstName"/>
    <form:errors path="firstName"/></br>
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/></br>
    Email: <form:input path="email"/>
    <form:errors path="email"/></br>
    PESEL: <form:input path="pesel"/>
    <form:errors path="pesel"/></br>
    Login: <form:input path="login"/>
    <form:errors path="login"/></br>
    Password: <form:input type='password' path="password"/>
    <form:errors path="password"/></br>
    <input type="submit" value="Dodaj">
</form:form>
<br/>
<a href="/owner/list">Powrót do poprzedniej strony</a>