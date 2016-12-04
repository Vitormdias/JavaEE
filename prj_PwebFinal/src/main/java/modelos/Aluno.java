package modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	
	@Id
	private int ra;
	private String nome;
	private String sexo;


	@ManyToOne
	private Curso curso;
	
	
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Aluno(){
		
	}
	
	public Aluno(int ra) {
		super();
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ra;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (ra != other.ra)
			return false;
		return true;
	}
	
	
	
}
