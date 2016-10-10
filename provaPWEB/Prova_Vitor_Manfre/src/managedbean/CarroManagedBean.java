package managedbean;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import modelos.Carro;

@ManagedBean
@SessionScoped
public class CarroManagedBean {
	private Carro Carro = new Carro();
	private ArrayList<Carro> Carros = new ArrayList<>();
	
	public Carro getCarro() {
		return Carro;
	}

	public void setCarro(Carro Carro) {
		this.Carro = Carro;
	}

	public ArrayList<Carro> getCarros() {
		return Carros;
	}

	public void setCarros(ArrayList<Carro> Carros) {
		this.Carros = Carros;
	}

	public void salvar() {
		Carros.add(Carro);
		Carro = new Carro();
	}
	
	public void excluir(Carro cli) {
		Carros.remove(cli);
	}
	
}