/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutoDAO {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public ProdutoDAO() {
        this.factory = Persistence.createEntityManagerFactory("Gerador_PedidosPU");
        this.manager = factory.createEntityManager();

    }

    public void adiciona(Produto produto) {
        this.manager.getTransaction().begin();
        this.manager.persist(produto);
        this.manager.getTransaction().commit();
    }

    public Produto getProduto(int id) {
        Produto produto = this.manager.find(Produto.class, id);
        return produto;
    }

    public List<Produto> getLista() {
        List<Produto> produto = this.manager.createQuery("select c from Produto c").getResultList();
        return produto;
    }

    public void altera(Produto produto) {
          this.manager.getTransaction().begin();
        this.manager.merge(produto);
        this.manager.getTransaction().commit();
    }

    public void remove(Produto produto) {
        this.manager.getTransaction().begin();
        Produto p = this.manager.getReference(Produto.class, produto.getIdProduto());
        this.manager.remove(p);
        this.manager.getTransaction().commit();
    }
}
