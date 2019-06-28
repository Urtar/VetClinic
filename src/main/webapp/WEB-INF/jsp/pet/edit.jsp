<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="pet">
    Nazwa: <form:input path="name"/>
    <form:errors path="name"/>
    Płeć: <select path="gender" size="3" multiple="multiple" tabindex="1">
    <option value="M">Male</option>
    <option value="F">Female</option>
</select>
    Numer chipa: <form:input path="chip"/>
    <form:errors path="chip"/>
    Właściciel: <form:select path="owner" items="${allOwners}" itemLabel="login" itemValue="id" /> <br/>
    Rasa: <form:select path="race" items="${allRaces}" itemLabel="race" itemValue="id" /> <br/>
    <input type="submit" value="Aktualizuj">
</form:form>