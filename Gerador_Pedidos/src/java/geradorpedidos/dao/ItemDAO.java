/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ItemDAO {

    // Conexao ao banco
    private EntityManagerFactory factory;
    private EntityManager manager;

    public ItemDAO() {
        this.factory = Persistence.createEntityManagerFactory("Gerador_PedidosPU");
        this.manager = factory.createEntityManager();
    }

    public void adiciona(Item item) {
        this.manager.getTransaction().begin();
        this.manager.persist(item);
        this.manager.getTransaction().commit();

    }

    public Item getItem(int id) {
        Item item = this.manager.find(Item.class, id);
        return item;
    }

    public List<Item> getLista() {
        //@SuppressWarnings("unchecked")
        List<Item> item = this.manager.createQuery("select c from Item c").getResultList();
        return item;
    }

    public void altera(Item item) {
        this.manager.getTransaction().begin();
        this.manager.merge(item);
        this.manager.getTransaction().commit();
    }

    public void remove(Item item) {
        this.manager.getTransaction().begin();
        Item i = this.manager.getReference(Item.class, item.getIdItem());
        this.manager.remove(i);
        this.manager.getTransaction().commit();
    }

}
