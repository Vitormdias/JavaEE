package managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import modelos.Cidade;
import jpa.CidadeJPA;

@ManagedBean
public class CidadeManagedBean {
	private Cidade Cidade = new Cidade();

	public Cidade getCidade() {
		return Cidade;
	}

	public void setCidade(Cidade Cidade) {
		this.Cidade = Cidade;
	}
	
	public void salvar(){
	    CidadeJPA jpa = new CidadeJPA();
	    jpa.salvar(Cidade);
	    Cidade = new Cidade();
	    
	}
   
	public List <Cidade> getAllCidades(){
		CidadeJPA jpa = new CidadeJPA();
		return jpa.getAllCidades();
	}
}