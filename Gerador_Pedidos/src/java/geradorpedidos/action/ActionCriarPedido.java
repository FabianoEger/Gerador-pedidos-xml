/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.model.Cliente;
import geradorpedidos.model.Pedido;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabiano.eger
 */
public class ActionCriarPedido implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Pedido pedido = new Pedido();
        Cliente cliente = new ClienteDAO().getCliente(Integer.parseInt(request.getParameter("idCliente")));
        
        pedido.setCliente(cliente);
        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataPedido"));

        pedido.setDataPedido(data);
        PedidoDAO daopedido = new PedidoDAO();
        String idStr = request.getParameter("id");
        if (idStr != null && !"".equals(idStr)) {
            int idPedido = Integer.parseInt(idStr);
            pedido.setIdPedido(idPedido);
            daopedido.altera(pedido);
            
            request.setAttribute("mensagem",  "Pedido alterado com sucesso");
        } else {
            daopedido.adiciona(pedido);
            request.setAttribute("pedidos", pedido.getIdPedido());
            request.setAttribute("mensagem", "Pedido criado com sucesso");
        }
        
        //return "controller?action=ActionListarPedidos";
        return "controller?action=ActionListarItens&idPedido=" + pedido.getIdPedido();
    }

}
