package modelos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cidade {
	@Id
	private int cod;
	private String nome,estado,pais;
	private int habitantes;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	@Override
	public String toString() {
		return "Cidade [cod=" + cod + ", nome=" + nome + ", estado=" + estado + ", pais=" + pais + ", habitantes="
				+ habitantes + "]";
	}
	
	
}
