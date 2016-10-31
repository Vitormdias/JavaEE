package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidade.Funcionario;

public class FuncionarioService {

private EntityManagerFactory emf;
	
	public FuncionarioService(){
      emf = Persistence.createEntityManagerFactory("prjFuncionario");	
	}
	
	
	public void salvar(Funcionario funcionario){
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Funcionario> allFuncionarios(){
		List <Funcionario> list;
		
		EntityManager em  = emf.createEntityManager();
		list = em.createQuery("Select p from Funcionario p").getResultList();
		em.close();
		
		return list;
		
	}


	public void update(Funcionario funcionario) {
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
		em.close();
		
	}


	public void remover(Funcionario funcionario) {
		EntityManager em  = emf.createEntityManager();
		
		funcionario = em.find(Funcionario.class, funcionario.getCodigo());
		
		em.getTransaction().begin();
				em.remove(funcionario);
		em.getTransaction().commit();
		
		em.close();
		
	}


}
