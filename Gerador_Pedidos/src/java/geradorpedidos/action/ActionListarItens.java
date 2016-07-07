package geradorpedidos.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import geradorpedidos.dao.*;
import geradorpedidos.model.Cliente;
import geradorpedidos.model.Item;
import geradorpedidos.model.Pedido;
import geradorpedidos.model.Produto;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionListarItens implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        //int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        
        Pedido pedido = new PedidoDAO().getPedido(idPedido);
        //Pedido pedido = new PedidoDAO().getPedidoById(idPedido);
        //Cliente cliente = new ClienteDAO().getCliente(idProduto);
        //Cliente cliente = new ClienteDAO().getClienteById(pedido.getIdCliente());
        List<Item> itens = new ItemDAO().getLista();
        //List<Item> itens = new ItemDAO().getItens();
        
        ProdutoDAO produtos = new ProdutoDAO();
        produtos.getLista();
        //Map produtos = new ProdutoDAO().getProdutosMap();
	//request.setAttribute("produto", produtos);
        request.setAttribute("itens", itens);
        request.setAttribute("pedido", pedido);
        //request.setAttribute("cliente", cliente);
        
        return "/WEB-INF/jsp/listarItens.jsp";
    }

}
