package managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.primefaces.event.RowEditEvent;

import services.Service;
import modelos.Curso;
import modelos.Aluno;

@ManagedBean(name="alunoManagedBean")
@RequestScoped
public class AlunoManagedBean {

	private Aluno aluno = new Aluno();
	private Curso curso;
	private Service service = new Service();
	private List <Aluno> alunos = null;
		
	public void onRowEdit(RowEditEvent event) 
	{
        Aluno p = (Aluno) event.getObject();
        service.updateAluno(p);
		
    }
	
	
	public void salvar()
	{
		curso.addAluno(aluno);
		aluno.setCurso(curso);
		
		service.saveAluno(aluno);
		
		aluno = new Aluno();
		curso = null;
		alunos = null;
		
	}
	
	
	
	public List <Curso> getCursos()
	{
		return service.getCursos();
		
	}
	
	
	public Curso getCurso() {
		return curso;
	}


	public void remove(Aluno aluno)
	{
		alunos.remove(aluno);
		service.removeAluno(aluno);
		
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	public List<Aluno> getListaAlunos() {
		if(alunos == null)
		  alunos = service.getAlunos();
		
		return alunos;
	}	

}
