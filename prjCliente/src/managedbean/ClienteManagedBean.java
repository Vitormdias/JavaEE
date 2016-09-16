package managedbean;

import java.util.ArrayList;
import java.util.Comparator;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import modelos.Cliente;


@ManagedBean
@SessionScoped
public class ClienteManagedBean {
	private Cliente cliente = new Cliente();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private boolean alteracaoAtiva = false;
    private String msg="";

    public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
    
    public boolean isAlteracaoAtiva() {
		return alteracaoAtiva;
	}

	public void setAlteracaoAtiva(boolean alteracaoAtiva) {
		this.alteracaoAtiva = alteracaoAtiva;
	}
    
    public void pesquisar(){
		
		for(Cliente a: clientes)
			if(a.getCodigo() == cliente.getCodigo()){
				cliente = a;
				alteracaoAtiva = true;
				msg="";
				return;
			}
		
		msg="Cliente nao cadastrado!";
	}
    
    public void cancel(){
		cliente = new Cliente();
		alteracaoAtiva=false;
		msg="";
	}
    
	public ArrayList<Cliente> getAtivos() {
		ArrayList<Cliente> ativos = new ArrayList<>();
		for (Cliente iterator : clientes) {
			if(iterator.isAtivo())
				ativos.add(iterator);
		}
		return ativos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void salvar() {
		if(!alteracaoAtiva)
			clientes.add(cliente);
		cliente = new Cliente();
		alteracaoAtiva = false;
		msg = "";
	}
	
	public void excluir(Cliente cli) {
		clientes.remove(cli);
	}
	
	public ArrayList<Cliente> getListaOrdenada() {
		ArrayList<Cliente> ordenados = clientes;
		ordenados.sort(Comparator.comparing(Cliente::getSaldo));
		return ordenados;
	}
	
	
	
}
