/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.action;

import geradorpedidos.dao.ProdutoDAO;
import geradorpedidos.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabiano
 */
public class ActionCriarProduto implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Produto produto = new Produto();
        String strValor = request.getParameter("valorproduto");
        double valorProduto = Double.parseDouble(strValor);
        produto.setNomeProduto(request.getParameter("nomeproduto"));
        produto.setValorProduto(valorProduto);

        ProdutoDAO dao = new ProdutoDAO();

        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            produto.setIdProduto(id);
            dao.altera(produto);
            request.setAttribute("produto", "alterado");

        } else {
            dao.adiciona(produto);
            request.setAttribute("produto", "criado");
        }

        return "controller?action=ActionListarProdutos";
    }
}
