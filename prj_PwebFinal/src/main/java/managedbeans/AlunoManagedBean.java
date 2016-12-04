package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import modelos.Aluno;
import modelos.Curso;
import servico.Servico;

@ManagedBean(name="alunoManagedBean")
@SessionScoped

public class AlunoManagedBean {
	private Aluno aluno = new Aluno();
	private Curso curso;
	private Servico servico = new Servico();
	private List<Aluno> alunos = null;
	

	public void onRowEdit(RowEditEvent event) 
	{
        Aluno a = (Aluno) event.getObject();
        servico.upDateAluno(a);
		
    }
	
	public void salvar(){
		curso.addAluno(aluno);
		aluno.setCurso(curso);
		servico.saveAluno(aluno);
		
		aluno = new Aluno();
		curso = null;
		alunos = null;
	}
	
	public List <Curso> getCursos(){
		return servico.getCursos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void remove(Aluno aluno){
		alunos.remove(aluno);
		servico.removeAluno(aluno);;
	}
	
	public List<Aluno> getListaAlunos(){
		if(alunos == null){
			alunos = servico.getAlunos();
			
		}
		return alunos;
	}
	
	public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }

	
	
}
