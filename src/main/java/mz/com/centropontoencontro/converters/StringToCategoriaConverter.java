package mz.com.centropontoencontro.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.com.centropontoencontro.domain.CategoriaLivro;
import mz.com.centropontoencontro.service.CategoriaLivroService;

@Component
public class StringToCategoriaConverter implements Converter<String, CategoriaLivro> {
	
	@Autowired
	private CategoriaLivroService service;
	
	@Override
	public CategoriaLivro convert(String text) {
		
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.pesquisarPorId(id);
	}

}
