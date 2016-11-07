package services;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelos.Aluno;
import modelos.Curso;

@ManagedBean(name="service",eager=true)
@ApplicationScoped
public class Service {
	
	                                                                                 
	private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("prjAlunoCurso");
	
	public Service()
	{
		
	}
	
	public List<Curso> getCursos() {
		
		List <Curso> cursos; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Curso f",Curso.class);
		cursos = q.getResultList();
		em.close();
		return cursos;
	}
	
	public void saveAluno(Aluno aluno)
	{
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(aluno);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void removeAluno(Aluno aluno) {
		
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    		Aluno p = em.find(Aluno.class, aluno.getId());
	    		em.remove(p);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public List<Aluno> getAlunos() {
		List <Aluno> alunos; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p From Aluno p",Aluno.class);
		alunos = q.getResultList();
		em.close();
		return alunos;
	}
	
	public void updateAluno(Aluno a) {
	    
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}
	
	public void saveCurso(Curso curso) {
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(curso);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void updateCurso(Curso c) {
		
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(c);
	    em.getTransaction().commit();
	    em.close();
		
	}
	
	public boolean removeCurso(Curso curso) {
		
	    boolean sucesso = false;
		try
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
	   		Curso c = em.find(Curso.class, curso.getId());
	   		em.remove(c);
	   		em.getTransaction().commit();
	   		em.close();
	   		sucesso = true;
		}
		catch (Exception e) {
			
		}
	
		return sucesso;
		
	}
}
