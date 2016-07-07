package geradorpedidos.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import geradorpedidos.dao.ClienteDAO;
import geradorpedidos.dao.ItemDAO;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Cliente;
import geradorpedidos.model.Item;
import geradorpedidos.model.Pedido;
import geradorpedidos.model.Produto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionFormEditarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String strId = request.getParameter("id");
        Item item = new Item();
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        //int idProduto = Integer.parseInt(request.getParameter("idProduto"));
         
        Pedido pedido = new PedidoDAO().getPedido(idPedido);
        Cliente cliente = new ClienteDAO().getCliente(idPedido);
        List<Produto> produtos = new ProdutoDAO().getLista();
        request.setAttribute("produtos", produtos);
        request.setAttribute("pedido", pedido);
        request.setAttribute("cliente", cliente);

        if (strId != null) {
            int id = Integer.parseInt(strId);
            ItemDAO dao = new ItemDAO();
            item = dao.getItem(id);
        }
        request.setAttribute("item", item);
        return "/WEB-INF/jsp/adicionarItens.jsp";
    }

}
