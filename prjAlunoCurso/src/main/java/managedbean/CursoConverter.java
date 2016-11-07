package managedbean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import services.Service;
import modelos.Curso;

@FacesConverter("converterCurso")
public class CursoConverter implements Converter {
	Service servico = new Service();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {


		if (value != null && !value.isEmpty()) {
			  for(Curso f : servico.getCursos())
				 if(f.getNome().equals(value))
				  	return f;

		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object curso) {
		if (curso == null || curso.equals("")) {
			return null;
		} else {
			return ((Curso) curso).getNome();

		}
	}

}
