package managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import modelos.Curso;
import services.Service;

@ManagedBean(name="cursoManagedBean")
@RequestScoped
public class CursoManagedBean {

	private Curso curso = new Curso();
	private Service service = new Service();
    private List <Curso> cursos;

	public void onRowEdit(RowEditEvent event)
	{
        Curso f = (Curso) event.getObject();
        service.updateCurso(f);
    }

	public void salvar()
	{

		service.saveCurso(curso);
		curso = new Curso();
	}



	public List <Curso> getCursos()
	{
		if(cursos == null)
		  cursos =  service.getCursos();

		return cursos;
	}


	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void remove(Curso curso)
	{

		if(service.removeCurso(curso))
			cursos.remove(curso);
		else
		{
			 FacesMessage msg = new FacesMessage("Imposs�vel remover curso com produtos", "Nome: " + curso.getNome());
		     FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}


}