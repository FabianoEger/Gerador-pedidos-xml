/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorpedidos.dao;

import geradorpedidos.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author raphael.silva
 */
public class ClienteDAO {
      private EntityManagerFactory factory;
    private EntityManager manager;
  
    
    public ClienteDAO(){
        this.factory = Persistence.createEntityManagerFactory("Gerador_PedidosPU");
        this.manager = factory.createEntityManager();
    }
    
    public void adiciona(Cliente cliente){
        this.manager.getTransaction().begin();
        this.manager.persist(cliente);
        this.manager.getTransaction().commit();
    }
    
    public Cliente getCliente(int id){
        Cliente cliente = this.manager.find(Cliente.class, id);
        return cliente;
    }
    
    public List<Cliente> getLista(){
        List<Cliente> cliente = this.manager.createQuery("select c from Cliente c").getResultList();
        return cliente;
    }     
    
    public void altera(Cliente cliente){
          this.manager.getTransaction().begin();
        this.manager.merge(cliente);
        this.manager.getTransaction().commit();
    }
    
    public void remove(Cliente cliente){
          this.manager.getTransaction().begin();
          Cliente c = this.manager.getReference(Cliente.class, cliente.getIdCliente());
        this.manager.remove(c);
        this.manager.getTransaction().commit();
    }
	
    
}
