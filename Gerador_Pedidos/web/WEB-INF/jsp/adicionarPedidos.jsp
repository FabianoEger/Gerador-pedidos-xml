<%-- 
    Document   : cadastrarClientes
    Created on : 15/03/2016, 21:37:52
    Author     : fabiano.eger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="pedido" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Cadastrar pedido</title>
    <link href="css/jquery-ui.css" rel="stylesheet"> 
    
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
  </head>
  <body>
    <h1>Adiciona pedidos</h1>
    <hr/>
    <form action="controller?action=ActionCriarPedido" method="POST">
        Cliente: 
        <select name="idCliente">
        <c:forEach items="${clientes}" var="cliente">
            <option value="${cliente.idCliente}" ${pedido.cliente.idCliente eq cliente.idCliente ? 'selected' : ''}>${cliente.nomeCliente}</option>
        </c:forEach>
        </select><br>
        
        Data pedido: <fmt:formatDate value="${pedido.dataPedido.time}" pattern="dd/MM/yyyy" var="formattedDate"/>
    	<pedido:campoData id="dataPedido" value="${formattedDate}"></pedido:campoData><br>
        
    	<c:if test="${ pedido.idPedido != 0 }">
    		<input type="hidden" name="id" value="${pedido.idPedido}">
    	</c:if>
    	<input type="submit" value="Gravar">
    </form>
  </body>
</html>