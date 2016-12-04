package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int numero;
	private String nome;
	private boolean exclusivo;
	
	@ManyToMany
	@JoinTable(name="Professor_Curso")
	private List <Curso> cursos = new ArrayList <Curso>();
	
	public Professor(){
		
	}
	
	
	public boolean isExclusivo() {
		return exclusivo;
	}
	public void setExclusivo(boolean exclusivo) {
		this.exclusivo = exclusivo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	
}
