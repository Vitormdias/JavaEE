package modelos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Montadora {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private String nome, sede;
	
	@OneToMany(mappedBy="montadora")
	private ArrayList<Carro> carros = new ArrayList<>();
	
	public Montadora() {
		
	}
	
	public Montadora(int codigo) {
		super();
		this.codigo = codigo;
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
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public void addCarro(Carro carro) {
		carros.add(carro);
	}
	
	public ArrayList<Carro> getCarros() {
		return carros;
	}

	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
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
		Montadora other = (Montadora) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Montadora [codigo=" + codigo + ", nome=" + nome + ", sede=" + sede + "]";
	}
	
	
}
