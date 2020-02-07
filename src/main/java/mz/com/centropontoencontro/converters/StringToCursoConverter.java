package mz.com.centropontoencontro.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.com.centropontoencontro.domain.Curso;
import mz.com.centropontoencontro.service.CursoService;

@Component
public class StringToCursoConverter implements Converter<String, Curso> {
	
	@Autowired
	private CursoService service;
	
	@Override
	public Curso convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.pesquisarPorId(id);
	}

}
