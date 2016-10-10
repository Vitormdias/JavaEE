package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Time;

public class TimeJPA {
	
	public List<Time> getAllTimes() {
		EntityManagerFactory emf;
		EntityManager        em;
		List <Time> times;
		
		emf = Persistence.createEntityManagerFactory("prjTimes");
		em = emf.createEntityManager();
		
		Query q = em.createQuery("Select t from Time t");
		times = q.getResultList();
		
		em.close();
		emf.close();
		   
		return times;		   
	}
	
	public void salvar(Time time){
		   EntityManagerFactory emf;
		   EntityManager        em;
		   
		   emf = Persistence.createEntityManagerFactory("prjTimes");
		   em = emf.createEntityManager();
		   
		   em.getTransaction().begin();
		   		em.persist(time);
		   em.getTransaction().commit();
		   
		   em.close();
		   emf.close();
		   
	   }
		
		
	public static void main(String[] args) {

		Time time = new Time();
		time.setCod(3);
		time.setNome("Santos");
		time.setCampeonatosBrasileiros(8);
		time.setCampeonatosInternacionais(5);
		time.setCraque("Lucas Reus Lima");
		
		TimeJPA jpa = new TimeJPA();
			//jpa.salvar(time);
		
		List <Time> aux = jpa.getAllTimes();
		for(Time t : aux)
			System.out.println(t);			
		}
}
