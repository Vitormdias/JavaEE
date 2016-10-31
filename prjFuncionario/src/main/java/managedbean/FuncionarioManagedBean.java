package managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.RowEditEvent;

import entidade.Funcionario;
import service.FuncionarioService;

@ManagedBean
@SessionScoped
public class FuncionarioManagedBean {
	
	private FuncionarioService prodService =new FuncionarioService();
	private Funcionario funcionario = new Funcionario();
	private List <Funcionario> funcionarios = null;
	 
	public void salvar(){
		prodService.salvar(funcionario);
		
		if(funcionarios != null)
			funcionarios.add(funcionario);
		
		funcionario = new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List <Funcionario> getAllFuncionarios(){
		if(funcionarios == null)
			funcionarios =  prodService.allFuncionarios();
		
		return funcionarios;
	}
	
	public void onRowEdit(RowEditEvent event) {
		Funcionario p =  ((Funcionario) event.getObject());
		prodService.update(p);
		
    }
	
	public void remover(Funcionario funcionario){
		prodService.remover(funcionario);
		funcionarios.remove(funcionario);
	}


}
