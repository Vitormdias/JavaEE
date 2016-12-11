package servico;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelos.*;

@ManagedBean(name = "servico", eager = true)
@ApplicationScoped
public class Servico {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("p2_pweb");
	
	// Montadora
	
	public void saveMontadora(Montadora a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public boolean removeMontadora(Montadora a){
		boolean sucesso = false;
		
		try
		{
			EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();
		    Montadora mont = em.find(Montadora.class, a.getCodigo());
		    em.remove(mont);
		    em.getTransaction().commit();
		    em.close();
		    sucesso = true;
		} catch (Exception e) {
			
		}
		
		return sucesso;
	}
	
	public List<Montadora> getMontadoras(){
		List <Montadora> montadoras; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From MONTADORA a",Montadora.class);
		montadoras = q.getResultList();
		em.close();
		return montadoras;
	}
	
	public void updateMontadora(Montadora a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public Montadora updateM(Montadora montadoraSelecionada) {
		EntityManager em = emf.createEntityManager();
		Montadora f = em.find(Montadora.class, montadoraSelecionada.getCodigo());
		em.refresh(f);
		em.close();
		return f;
	}
	
	public List<Carro> getCarrosMontadora(Montadora montadoraSelecionada) {

		List<Carro> carros = null;
		EntityManager em = emf.createEntityManager();
		Montadora c = em.find(Montadora.class, montadoraSelecionada.getCodigo());
		em.refresh(c);
		carros = c.getCarros();
		em.close();

		return carros;
	}
	
	//Locadora
	
	public void saveLocadora(Locadora a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public boolean removeLocadora(Locadora a){
		boolean sucesso = false;
		
		try
		{
			EntityManager em = emf.createEntityManager();
		    em.getTransaction().begin();
		    Locadora loc = em.find(Locadora.class, a.getCodigo());
		    em.remove(loc);
		    em.getTransaction().commit();
		    em.close();
		    sucesso = true;
		} catch (Exception e) {
			
		}
		
		return sucesso;
	}
	
	public List<Locadora> getLocadoras(){
		List <Locadora> locadoras; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From LOCADORA a",Locadora.class);
		locadoras = q.getResultList();
		em.close();
		return locadoras;
	}
	
	public void updateLocadora(Locadora a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public Locadora updateL(Locadora locadoraSelecionada) {
		EntityManager em = emf.createEntityManager();
		Locadora f = em.find(Locadora.class, locadoraSelecionada.getCodigo());
		em.refresh(f);
		em.close();
		return f;
	}
	
	public List<Carro> getCarrosLocadora(Locadora locadoraSelecionada) {

		List<Carro> carros = null;
		EntityManager em = emf.createEntityManager();
		Locadora c = em.find(Locadora.class, locadoraSelecionada.getCodigo());
		em.refresh(c);
		carros = c.getCarros();
		em.close();

		return carros;
	}
	
	//Carro
	
	public void saveCarro(Carro a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void removeCarro(Carro c){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    Carro car = em.find(Carro.class, c.getPlaca());
	    em.remove(car);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public List<Carro> getCarros(){
		List <Carro> carros; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From CARRO a",Carro.class);
		carros = q.getResultList();
		em.close();
		return carros;
	}
	
	public void updateCarro(Carro a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
}
