package managedBean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import modelos.*;
import servico.Servico;

@ManagedBean(name = "montadoraManagedBean")
@SessionScoped
public class MontadoraManagedBean {
	private Montadora montadora = new Montadora();
	private Montadora montadoraSelecionada;
	private Servico servico = new Servico();
	private List<Montadora> montadoras;

	public void onRowEdit(RowEditEvent event) {
		Montadora c = (Montadora) event.getObject();
		servico.updateMontadora(c);
	}

	public Montadora getMontadoraSelecionada() {
		return montadoraSelecionada;
	}

	public void setMontadoraSelecionada(Montadora montadoraSelecionada) {
		if (montadoraSelecionada != null)
			this.montadoraSelecionada = servico.updateM(montadoraSelecionada);
	}

	

	public void salvar() {
		servico.saveMontadora(montadora);
		montadoras.add(montadora);
		montadora = new Montadora();
	}

	public void remove(Montadora c) {
		if (servico.removeMontadora(c)) {
			montadoras.remove(c);
			montadoraSelecionada = null;
		} else {
			FacesMessage msg = new FacesMessage("Impossivel remover montadora com carros", "Nome: " + montadora.getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Montadora> listarCursos() {
		if (montadoras == null) {
			montadoras = servico.getMontadoras();
		}
		return montadoras;
	}

	
	public List <Carro> getCarrosMontadora()
	{
		if(montadoraSelecionada != null)
			return servico.getCarrosMontadora(montadoraSelecionada);
		else
			return null;
	}
	
	

}
