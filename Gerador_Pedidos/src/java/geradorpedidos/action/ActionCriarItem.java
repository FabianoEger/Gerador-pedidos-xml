package geradorpedidos.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import geradorpedidos.dao.ItemDAO;
import geradorpedidos.dao.PedidoDAO;
import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Item;
import geradorpedidos.model.Pedido;
import geradorpedidos.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionCriarItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        
        Pedido p = new PedidoDAO().getPedido(idPedido);
        Produto pr = new ProdutoDAO().getProduto(idProduto);
        
        Item item = new Item();
        //item.setPedido(p);
        item.setPedido(p);
        item.setQuantidade(quantidade);
        item.setProduto(pr);
        //item.setPedido(idProduto);
        //item.setIdProduto(idProduto);
    
        ItemDAO dao = new ItemDAO();

        if (request.getParameter("iditem") != null) {
           int iditem = Integer.parseInt(request.getParameter("iditem"));
            item.setIdItem(iditem);
            item.setQuantidade(quantidade);
            dao.altera(item);
            //dao.atualizar(item);
            request.setAttribute("item", "alterado");
            request.setAttribute("pedido", " alterado");
         

        } else {
            dao.adiciona(item);
            //dao.inserir(item);
            request.setAttribute("item", "criado");
            request.setAttribute("pedido", " alterado");
            
        }

        return "controller?action=ActionListarItens&idPedido=" + item.getPedido();
    }
}
