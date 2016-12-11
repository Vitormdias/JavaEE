package managedBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelos.Locadora;
import servico.Servico;

@FacesConverter("converterLocadora")

public class LocadoraConverter implements Converter {
	Servico servico = new Servico();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value != null && !value.isEmpty()) {
			for (Locadora l : servico.getLocadoras())
				if (l.getNome().equals(value))
					return l;

		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object locadora) {
		if (locadora == null || locadora.equals("")) {
			return null;
		} else {
			return ((Locadora) locadora).getNome();

		}
	}
}