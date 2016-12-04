package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.view.facelets.FaceletContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import modelos.Aluno;
import modelos.Curso;
import modelos.Professor;
import servico.Servico;

@ManagedBean(name = "cursoManagedBean")
@SessionScoped
public class CursoManagedBean {
	private Curso curso = new Curso();
	private Curso cursoSelecionado;
	private Servico servico = new Servico();
	private List<Curso> cursos;

	public void onRowEdit(RowEditEvent event) {
		Curso c = (Curso) event.getObject();
		servico.upDateCurso(c);
	}

	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

	public void setCursoSelecionado(Curso cursoSelecionado) {
		if (cursoSelecionado != null)
			this.cursoSelecionado = servico.upDateC(cursoSelecionado);
	}

	public DataModel<Curso> getCursos() {
		if (cursos == null) {
			cursos = servico.getCursos();
		}
		return new CursoDataModel(cursos);
	}

	public void salvar() {
		servico.saveCurso(curso);
		cursos.add(curso);
		curso = new Curso();
	}

	public void remove(Curso c) {
		if (servico.removeCurso(c)) {
			cursos.remove(c);
			cursoSelecionado = null;
		} else {
			FacesMessage msg = new FacesMessage("Impossivel remover curso com alunos", "Nome: " + curso.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Curso> listarCursos() {
		if (cursos == null) {
			cursos = servico.getCursos();
		}
		return cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void onRowSelect(SelectEvent event) {

	}
	
	public List <Aluno> getAlunosCurso()
	{
		if(cursoSelecionado != null)
			return servico.getAlunosCurso(cursoSelecionado);
		else
			return null;
	}
	
	public List <Professor> getProfessoresCurso()
	{
		if(cursoSelecionado != null)
			return servico.getProfessoresCurso(cursoSelecionado);
		else
			return null;
	}

}
