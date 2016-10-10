package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelos.Cidade;

public class CidadeJPA {
	
	public List<Cidade> getAllCidades() {
		EntityManagerFactory emf;
		EntityManager        em;
		List <Cidade> Cidades;
		
		emf = Persistence.createEntityManagerFactory("Prova_Vitor_Manfre");
		em = emf.createEntityManager();
		
		Query q = em.createQuery("Select t from Cidade t");
		Cidades = q.getResultList();
		
		em.close();
		emf.close();
		   
		return Cidades;		   
	}
	
	public void salvar(Cidade Cidade){
		   EntityManagerFactory emf;
		   EntityManager        em;
		   
		   emf = Persistence.createEntityManagerFactory("Prova_Vitor_Manfre");
		   em = emf.createEntityManager();
		   
		   em.getTransaction().begin();
		   		em.persist(Cidade);
		   em.getTransaction().commit();
		   
		   em.close();
		   emf.close();
		   
	   }
		
		
	public static void main(String[] args) {

		Cidade Cidade = new Cidade();
		Cidade.setCod(801);
		Cidade.setNome("Santos");
		Cidade.setEstado("SP");
		Cidade.setHabitantes(7000000);
		Cidade.setPais("Brasil");
		
		CidadeJPA jpa = new CidadeJPA();
			//jpa.salvar(Cidade);
		
		List <Cidade> aux = jpa.getAllCidades();
		for(Cidade t : aux)
			System.out.println(t);			
		}
}