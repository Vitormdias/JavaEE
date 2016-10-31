package entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
	
	@Id
	private int codigo;
	private String nome;
	private double salario;
	private String estadoCivil;
	private String departamento;
	private boolean deFerias;
	
	public boolean isDeFerias() {
		return deFerias;
	}
	public void setDeFerias(boolean deFerias) {
		this.deFerias = deFerias;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
