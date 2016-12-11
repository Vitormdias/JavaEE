package managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import modelos.*;
import servico.Servico;

@ManagedBean(name = "locadoraManagedBean")
@SessionScoped
public class LocadoraManagedBean {
	private Locadora locadora = new Locadora();
	private Locadora locadoraSelecionada;
	private Servico servico = new Servico();
	private List<Locadora> locadoras;

	public void onRowEdit(RowEditEvent event) {
		Locadora c = (Locadora) event.getObject();
		servico.updateLocadora(c);
	}

	public Locadora getLocadoraSelecionada() {
		return locadoraSelecionada;
	}

	public void setLocadoraSelecionada(Locadora locadoraSelecionada) {
		if (locadoraSelecionada != null)
			this.locadoraSelecionada = servico.updateL(locadoraSelecionada);
	}

	

	public void salvar() {
		servico.saveLocadora(locadora);
		locadoras.add(locadora);
		locadora = new Locadora();
	}

	public void remove(Locadora c) {
		if (servico.removeLocadora(c)) {
			locadoras.remove(c);
			locadoraSelecionada = null;
		} else {
			FacesMessage msg = new FacesMessage("Impossivel remover locadora com carros", "Nome: " + locadora.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Locadora> listarCursos() {
		if (locadoras == null) {
			locadoras = servico.getLocadoras();
		}
		return locadoras;
	}

	
	public List <Carro> getCarrosLocadora()
	{
		if(locadoraSelecionada != null)
			return servico.getCarrosLocadora(locadoraSelecionada);
		else
			return null;
	}
	
	

}
