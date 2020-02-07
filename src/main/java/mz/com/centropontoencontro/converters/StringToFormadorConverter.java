package mz.com.centropontoencontro.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import mz.com.centropontoencontro.domain.Formador;
import mz.com.centropontoencontro.service.FormadorService;

@Component
public class StringToFormadorConverter implements Converter<String, Formador> {

@Autowired
	private FormadorService service;

	@Override
	public Formador convert(String text) {
		
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		
		return service.pesquisarPorId(id);
	}

}
