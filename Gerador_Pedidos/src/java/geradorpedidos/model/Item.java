/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.model;

/**
 *
 * @author fabiano.eger
 */
public class Item {
    private int idItem;
    private int quantidade;
     private Pedido pedido;
    private Produto produto;
//    private int idPedido;
//    private int idProduto;
   

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    

//    public int getIdPedido() {
//        return idPedido;
//    }
//
//    public void setIdPedido(int idPedido) {
//        this.idPedido = idPedido;
//    }
//
//    public int getIdProduto() {
//        return idProduto;
//    }
//
//    public void setIdProduto(int idProduto) {
//        this.idProduto = idProduto;
//    };

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
     
}
