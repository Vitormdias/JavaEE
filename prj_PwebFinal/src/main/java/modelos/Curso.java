package modelos;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String nome;
	private int qtdAlunos;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@OneToMany(mappedBy="curso")
	private ArrayList<Aluno> alunos = new ArrayList<>();
	
	@ManyToMany(mappedBy="cursos")
	
	private ArrayList<Professor> professores = new ArrayList<>();
	
	public Curso(){
		
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(int qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Curso other = (Curso) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", dataInicio=" + dataInicio + ", alunos=" + alunos
				+ ", professores=" + professores + "]";
	}

	public void addAluno(Aluno aluno){
		alunos.add(aluno);
	}
	
	public void addProfessor(Professor p){
		professores.add(p);
	}
	
	public void removeProfessor(Professor p){
		professores.remove(p);
	}
	
}
