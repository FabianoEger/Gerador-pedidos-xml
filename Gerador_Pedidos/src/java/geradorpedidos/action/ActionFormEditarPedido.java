/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;
import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Cliente;
import geradorpedidos.model.Pedido;
import geradorpedidos.model.Produto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabinho
 */
public class ActionFormEditarPedido implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
              String strId = request.getParameter("id");

        Pedido pedido = new Pedido();
        
        List<Cliente> clientes = new ClienteDAO().getLista();
        List<Produto> produtos = new ProdutoDAO().getLista();

        if (strId != null) {
            int id = Integer.parseInt(strId);
            PedidoDAO dao = new PedidoDAO();
            pedido = dao.getPedido(id);
            //pedido = dao.getPedidoById(id);
        }

        request.setAttribute("pedido", pedido);
        request.setAttribute("clientes", clientes);
        request.setAttribute("produtos", produtos);

        return "/WEB-INF/jsp/adicionarPedidos.jsp";
    }
    
}
