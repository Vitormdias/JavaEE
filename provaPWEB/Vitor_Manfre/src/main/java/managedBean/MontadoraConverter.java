package managedBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelos.Montadora;
import servico.Servico;

@FacesConverter("converterMontadora")

public class MontadoraConverter implements Converter {
	Servico servico = new Servico();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		if (value != null && !value.isEmpty()) {
			for (Montadora l : servico.getMontadoras())
				if (l.getNome().equals(value))
					return l;

		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object montadora) {
		if (montadora == null || montadora.equals("")) {
			return null;
		} else {
			return ((Montadora) montadora).getNome();

		}
	}
}