package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import modelos.Aluno;

@ManagedBean
@SessionScoped
public class AlunoManagedBean {
	private Aluno aluno = new Aluno();
	private ArrayList <Aluno> alunos = new ArrayList<>();
	private ArrayList <Aluno> alunosAprov = new ArrayList<>();
	private ArrayList <Aluno> alunosReprov = new ArrayList<>();
	private ArrayList <Aluno> maioresNotas = new ArrayList<>();
	private String msg = "";
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ArrayList<Aluno> getMaioresNotas() {
		return maioresNotas;
	}

	public void setMaioresNotas(ArrayList<Aluno> maioresNotas) {
		this.maioresNotas = maioresNotas;
	}

	public ArrayList<Aluno> getAlunosAprov() {
		return alunosAprov;
	}

	public void setAlunosAprov(ArrayList<Aluno> alunosAprov) {
		this.alunosAprov = alunosAprov;
	}

	public ArrayList<Aluno> getAlunosReprov() {
		return alunosReprov;
	}

	public void setAlunosReprov(ArrayList<Aluno> alunosReprov) {
		this.alunosReprov = alunosReprov;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public double calcMedia(double n1 , double n2) {
		return ((n1+n2)/2);
	}
	
	public boolean alunoExiste(Aluno alu) {
		boolean status=false;
		for (Aluno it : alunos) {
			status = aluno.getMatricula() == it.getMatricula();
			if(status) {
				msg="";
				break;
			}
		}
		return status;
	}
	
	
	
	public void salvar() {
		if(alunoExiste(aluno)) {
			
		}
		else {
			alunos.add(aluno);
			double maiorMedia=-1 , media = calcMedia(aluno.getNota1(), aluno.getNota2());
			if(!maioresNotas.isEmpty())
				maiorMedia = calcMedia(maioresNotas.get(0).getNota1() , maioresNotas.get(0).getNota2());
			aluno.setAprov(media >= 6);
			if(aluno.isAprov()) {
				alunosAprov.add(aluno);
				if(maioresNotas.isEmpty()) {
					maioresNotas.add(aluno);
				}
				else if(media > maiorMedia) {
					maioresNotas.clear();
					maioresNotas.add(aluno);
				}
				else if(media == maiorMedia) 
					maioresNotas.add(aluno);
			}
			else
				alunosReprov.add(aluno);
			aluno = new Aluno();
		}
	}
	
	public void pesquisar() {
		for (Aluno it : alunos) {
			if(aluno.getMatricula() == it.getMatricula())
				aluno.setAprov(it.isAprov());
				aluno.setCurso(it.getCurso());
				aluno.setNome(it.getNome());
				aluno.setNota1(it.getNota1());
				aluno.setNota2(it.getNota2());
		}
	}
	
	public void excluir(Aluno alu) {
		alunos.remove(alu);
		alunosAprov.remove(alu);
		alunosReprov.remove(alu);
		maioresNotas.remove(alu);
		}
	}

