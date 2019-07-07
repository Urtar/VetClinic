<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Właścicieli</h1>

<a href="/owner/add">Dodaj Właściciela</a><br/>
<a href="/race/add">Dodaj rasę zwierzęcia</a><br/>
<a href="/race/list">Lista ras zwierząt</a><br/>
<a href="/pettype/add">Dodaj gatunek zwierzęcia</a><br/>
<a href="/petType/list">Lista gatunków zwierząt</a><br/>

<h1>Lista właścicieli:</h1>
<c:forEach items="${allOwners}" var="owner">
    <p><a href="/owner/${owner.id}">Imię: ${owner.firstName}, Nazwisko: ${owner.lastName}</a> , <a href="/owner/${owner.id}/edit">Edytuj dane właściciela</a><p/>
<%--    Zwierzęta: <form:select path="pet" items="${allPets}" itemLabel="name" itemValue="id" /> <br/>--%>
</c:forEach>

<a href="/logout">Wylogowanie</a> <br/>
<a href="/login">Strona logowania</a> <br/>
<a href="/vetclinic">Strona Główna</a> <br/>
<a href="/owner/list">Lista właścicieli</a><br/>

