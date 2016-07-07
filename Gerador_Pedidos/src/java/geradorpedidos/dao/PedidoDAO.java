/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author raphael.silva
 */
public class PedidoDAO {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public PedidoDAO() {
        this.factory = Persistence.createEntityManagerFactory("Gerador_PedidosPU");
        this.manager = factory.createEntityManager();
    }

    public void adiciona(Pedido pedido) {
        this.manager.getTransaction().begin();
        this.manager.persist(pedido);
        this.manager.getTransaction().commit();
    }

    public Pedido getPedido(int id) {
        Pedido pedido = this.manager.find(Pedido.class, id);
        return pedido;
    }

    public List<Pedido> getLista() {
        //@SuppressWarnings("unchecked")
        List<Pedido> pedido = this.manager.createQuery("select c from Pedido c").getResultList();
        return pedido;
    }

    public void altera(Pedido pedido) {
        this.manager.getTransaction().begin();
        this.manager.merge(pedido);
        this.manager.getTransaction().commit();
    }

    public void remove(Pedido pedido) {
        this.manager.getTransaction().begin();
        Pedido p = this.manager.getReference(Pedido.class, pedido.getIdPedido());
        this.manager.remove(pedido);
        this.manager.getTransaction().commit();
    }

}
