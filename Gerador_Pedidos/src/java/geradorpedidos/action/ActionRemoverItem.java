package geradorpedidos.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import geradorpedidos.dao.ItemDAO;
import geradorpedidos.model.Item;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionRemoverItem implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        //Item item = new Item();
        //item.setIdItem(id);
        
        ItemDAO dao = new ItemDAO();
        
        Item item = dao.getItem(id);
//        Item item = dao.getItensById(id);        
//        dao.remover(id);;
        System.out.println("Excluindo item ... ");
        request.setAttribute("mensagem", "Item removido com sucesso.");
        //return "controller?action=ActionListarItens&idPedido=" + item.getIdPedido();
         return "controller?action=ActionListarItens&idPedido=" + item.getPedido().getIdPedido();
    }

}
