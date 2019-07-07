<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Właściciel: ${ownerName} <br/>
<form:form method="POST"
           modelAttribute="pet">
    Nazwa: <form:input path="name"/><br/>
    <form:errors path="name"/>
    Płeć Male: <form:radiobutton path="gender" value="M"/>
    Płeć Female: <form:radiobutton path="gender" value="F"/> <br/>
    Numer chipa: <form:input path="chipNumber"/><br/>
    <form:errors path="chipNumber"/>
    Rasa: <form:select path="race" items="${allRaces}" itemLabel="name" itemValue="id"/> <br/>
    Gatunek: <form:select path="petType" items="${allPetTypes}" itemLabel="name" itemValue="id"/> <br/>
    <input type="submit" value="Aktualizuj">
</form:form>
<br/>
<a href="/home/index">Strona Główna</a> <br/>
<a href="/owner/list">Lista właścicieli</a><br/>