<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Itens</title>
    </head>
    <body>


        Número do Pedido: ${pedido.idPedido}<br>
        Nome cliente:${pedido.cliente.nomeCliente}<br>
        Data:  <fmt:formatDate value="${pedido.dataPedido}" pattern="dd/MM/yyyy" /><br><br>
        <a href="controller?action=ActionFormEditarItem&idPedido=${pedido.idPedido}">Novo Item</a> <br>

        <table>
            <thead>
                <tr>
                    <th>Código do Item</th>
                      <th>Nome do produto</th>
                    <th>Quantidade</th>
                    <th>Valor do pedido</th>
                    <th>Código do Pedido</th>
                    <th colspan="2">attribute</th>
                </tr>
            </thead>
            <c:forEach var="item" items="${itens}" varStatus="idPedido">
                <tr bgcolor="#${id.count %2 == 0 ? 'aaee88' : 'ffffff' }">
                    <td>${item.idItem}</td>
                    
                    <td>$${item.produto.nomeProduto}</td>
                    <td>${item.quantidade}</td>
                    <td>${item.pedido.idPedido}</td>
                    <td><a href="controller?action=ActionFormEditarItem&idPedido=${pedido.idPedido}">Editar</a></td>
                    <td><a href="controller?action=ActionRemoverItem&id=${item.idItem}">Remover</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>