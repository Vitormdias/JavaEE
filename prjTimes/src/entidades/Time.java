package entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Time {
	@Id
	private int cod;
	private String nome, craque; 
	private int campeonatosBrasileiros, campeonatosInternacionais;
	
	
	public int getCampeonatosInternacionais() {
		return campeonatosInternacionais;
	}
	public void setCampeonatosInternacionais(int campeonatosInternacionais) {
		this.campeonatosInternacionais = campeonatosInternacionais;
	}
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
	public String getCraque() {
		return craque;
	}
	public void setCraque(String craque) {
		this.craque = craque;
	}
	public int getCampeonatosBrasileiros() {
		return campeonatosBrasileiros;
	}
	public void setCampeonatosBrasileiros(int campeonatosBrasileiros) {
		this.campeonatosBrasileiros = campeonatosBrasileiros;
	}
	@Override
	public String toString() {
		return "Time [nome=" + nome + ", craque=" + craque + ", campeonatosBrasileiros=" + campeonatosBrasileiros
				+ ", campeonatosInternacionais=" + campeonatosInternacionais + ", cod=" + cod + "]";
	}
	
	
	
}
