/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private int idPedido;
    //private int idCliente;
    private Cliente cliente;
    private List<Item> itens;
    private double valorPedido;
    private Date dataPedido;

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    

//    public int getIdCliente() {
//        return idCliente;
//    }
//    
//    public Long getIdClienteLong() {
//        return new Long(idCliente);
//    }
//
//    public void setIdCliente(int idCliente) {
//        this.idCliente = idCliente;
//    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    

}
