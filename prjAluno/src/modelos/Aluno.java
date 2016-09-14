package modelos;
 
public class Aluno {
	private int matricula;
	private String nome , curso;
	private double nota1 , nota2;
	private boolean aprov;
	
	
	public boolean isAprov() {
		return aprov;
	}
	public void setAprov(boolean aprov) {
		this.aprov = aprov;
	}
	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public Aluno() {
		
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
