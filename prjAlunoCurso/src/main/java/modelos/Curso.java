package modelos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nome, coordenador;
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	@OneToMany(mappedBy="curso")
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	
	public void addAluno(Aluno a) {
		alunos.add(a);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
