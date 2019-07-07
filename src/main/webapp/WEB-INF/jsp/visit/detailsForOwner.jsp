<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="POST"
           modelAttribute="visit">
    Data wizyty:${visit.dateOfVisit}<br/>
    Imię zwierzęcia: ${petName} <br/>
    Opis: ${visit.description}<br/>

    <a href="/recipe/${visit.id}/listForOwner">Lista recept</a> <br/>
    <a href="/pet/${petId}/detailsForOwner">Powrót do poprzedniej strony</a>
</form:form>

