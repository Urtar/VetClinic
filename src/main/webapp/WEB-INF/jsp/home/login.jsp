<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form:form method="post" modelAttribute="viewMode">
    Login: <form:input path="login"/>
    Password: <form:password path="password"/>
    <input type="hidden" value="login" name="action"/>
    <input type = "submit" value = "Zaloguj"/>
</form:form>
<%--<form:form method = "post" modelAttribute="viewMode">--%>
<%--    <input type="hidden" value="register" name="action"/>--%>
<%--    <input type = "submit" value = "Zarejestruj"/>--%>
<%--</form:form>--%>

<a href="/vetclinic">Strona główna</a>