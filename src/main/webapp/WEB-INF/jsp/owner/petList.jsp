<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Lista Zwierząt ${ownerFirstName}, ${ownerLastName}</h1>

<c:forEach items="${allPets}" var="pet">
    <a href="/pet/${pet.id}/detailsForOwner"><p>Imię: ${pet.name}</p></a>
</c:forEach>

<a href="/logout">Wylogowanie</a> <br/>
<a href="/login">Strona logowania</a> <br/>
<a href="/vetclinic">Strona Główna</a> <br/>