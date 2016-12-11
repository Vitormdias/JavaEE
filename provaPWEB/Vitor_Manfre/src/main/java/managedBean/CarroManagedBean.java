package managedBean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import modelos.*;
import servico.Servico;

@ManagedBean(name="carroManagedBean")
@SessionScoped

public class CarroManagedBean {
	private Carro carro = new Carro();
	private Locadora locadora;
	private Montadora montadora;
	private Servico servico = new Servico();
	private List<Carro> carros = null;
	
	public void onRowEdit(RowEditEvent event) 
	{
        Carro a = (Carro) event.getObject();
        servico.updateCarro(a);
    }
	
	public void salvar(){
		montadora.addCarro(carro);
		locadora.addCarro(carro);
		
		carro.setLocadora(locadora);
		carro.setMontadora(montadora);
		
		servico.saveCarro(carro);
		
		carro = new Carro();
		montadora = null;
		locadora = null;
		carros = null;
	}
	
	public List <Montadora> getMontadoras(){
		return servico.getMontadoras();
	}
	
	public List <Locadora> getLocadoras(){
		return servico.getLocadoras();
	}
	
	public void remove(Carro carro){
		carros.remove(carro);
		servico.removeCarro(carro);
	}
	
	public List<Carro> getListaCarros(){
		if(carros == null){
			carros = servico.getCarros();
			
		}
		return carros;
	}
	
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Locadora getLocadora() {
		return locadora;
	}
	public void setLocadora(Locadora locadora) {
		this.locadora = locadora;
	}
	public Montadora getMontadora() {
		return montadora;
	}
	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
}
