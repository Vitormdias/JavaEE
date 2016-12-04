package managedbeans;


import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import modelos.Curso;
import servico.Servico;

public class CursoDataModel extends ListDataModel<Curso> implements SelectableDataModel<Curso>{
	private static Servico servico = new Servico();

	public CursoDataModel() {}
	
	public CursoDataModel(List <Curso> list) {
		super(list);
	}

	@Override
	public Curso getRowData(String rowKey) {
		for(Curso c: servico.getCursos()){
			if(Integer.parseInt(rowKey) == c.getCodigo())
				return c;
		}
		return null;
	}

	@Override
	public Object getRowKey(Curso curso) {
		return curso.getCodigo();
	}
	
	
}
