package servico;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelos.Aluno;
import modelos.Curso;
import modelos.Professor;

@ManagedBean(name = "servico", eager = true)
@ApplicationScoped
public class Servico {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prj_PwebFinal");

	public void saveAluno(Aluno a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(a);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void removeAluno(Aluno a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    Aluno alu = em.find(Aluno.class, a.getRa());
	    em.remove(alu);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public List<Aluno> getAlunos(){
		List <Aluno> alunos; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Aluno a",Aluno.class);
		alunos = q.getResultList();
		em.close();
		return alunos;
	}
	
	public void upDateAluno(Aluno a){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(a);
	    em.getTransaction().commit();
	    em.close();
		
	}
	
	
	//CURSO
	
	public void saveCurso(Curso c){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(c);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void upDateCurso(Curso c){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(c);
	    em.getTransaction().commit();
	    em.close();
		
	}
	
	public boolean removeCurso(Curso curso){
	    boolean sucesso = false;
		try
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
	   		Curso c = em.find(Curso.class, curso.getCodigo());
	   		em.remove(c);
	   		em.getTransaction().commit();
	   		em.close();
	   		sucesso = true;
		}
		catch (Exception e) {
			
		}
	
		return sucesso;
		
	}
	
	public Curso upDateC(Curso cursoSelecionado) {
		EntityManager em = emf.createEntityManager();
		Curso f = em.find(Curso.class, cursoSelecionado.getCodigo());
		em.refresh(f);
		em.close();
		return f;
	}

	public List<Aluno> getAlunosCurso(Curso cursoSelecionado) {

		List<Aluno> alunos = null;
		EntityManager em = emf.createEntityManager();
		Curso c = em.find(Curso.class, cursoSelecionado.getCodigo());
		em.refresh(c);
		alunos = c.getAlunos();
		em.close();

		return alunos;
	}
	
	public List<Professor> getProfessoresCurso(Curso cursoSelecionado) {

		List<Professor> professores = null;
		EntityManager em = emf.createEntityManager();
		Curso c = em.find(Curso.class, cursoSelecionado.getCodigo());
		em.refresh(c);
		professores = c.getProfessores();
		em.close();

		return professores;
	}
	
	
	
	
	public List<Curso> getCursos() {

		List<Curso> cursos;
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Curso c", Curso.class);
		cursos = q.getResultList();
		em.close();
		return cursos;
	}
	
	
	//PROFESSOR
	
	public void saveProfessor(Professor p){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(p);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public void upDateProfessor(Professor p){
		EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	    em.merge(p);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public Professor upDateP(Professor p){
		EntityManager em = emf.createEntityManager();
		Professor prof = em.find(Professor.class, p.getNumero());
	    em.refresh(prof);
	    em.close();
	    
	    return prof;
	}
	
	public boolean removeProfessor(Professor professor){
		boolean sucesso = false;
		try
		{
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
	   		Professor p = em.find(Professor.class, professor.getNumero());
	   		em.remove(p);
	   		em.getTransaction().commit();
	   		em.close();
	   		sucesso = true;
		}
		catch (Exception e) {
			
		}
	
		return sucesso;
	}
	
	public List<Professor> getProfessores(){
		List <Professor> professores; 
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select p From Professor p",Professor.class);
		professores = q.getResultList();
		em.close();
		return professores;
	}
	
	public List<Curso> getCursosProfessor(Professor professorSelecionado){
		List<Curso> cursos = null;
		EntityManager em = emf.createEntityManager();
		Professor p = em.find(Professor.class, professorSelecionado.getNumero());
		em.refresh(p);
		cursos = p.getCursos();
		em.close();
		
		return cursos;
	}
	
}
