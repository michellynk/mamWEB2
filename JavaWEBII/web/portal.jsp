<%-- 
    Document   : portal
    Created on : 20/09/2018, 20:08:37
    Author     : ananicole
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="erro.jsp" %>
<%-- Procura se existe um usuário instanciado --%>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <jsp:forward page="index.jsp">
            <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema." />
        </jsp:forward>
    </c:when>
    <c:otherwise>
        <!DOCTYPE html>        
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
                <link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap-reboot.min.css" type="text/css">
                <title>Portal</title>
            </head>
            <body class="bgimg">
                <%@include file="menu.jsp" %>
                <jsp:useBean id="user" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>
                <div class="container" style="width: 400px; margin: 100px;">
                    <div class="row">
                        <div class="col offset-m3 m6">
                            <h1 class="display-4">Portal</h1>
                            <h2 class="lead" >Olá, <jsp:getProperty name="user" property="nome"/></h2>
                            <div class="divider"></div>
                            <div style="height: 50px;"></div>
                            <div class="collection">
                                <a href="ClientesServlet" class="collection-item">Cadastro de clientes</a>
                                <a href="LogoutServlet" class="collection-item">Sair</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </body>
        </html>        
    </c:otherwise>    
</c:choose>