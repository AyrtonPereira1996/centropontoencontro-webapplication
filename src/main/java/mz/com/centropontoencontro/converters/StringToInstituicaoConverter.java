package mz.com.centropontoencontro.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.com.centropontoencontro.domain.InstituicaoEnsino;
import mz.com.centropontoencontro.service.InstituicaoEnsinoService;

@Component
public class StringToInstituicaoConverter implements Converter<String, InstituicaoEnsino> {

	@Autowired
	private InstituicaoEnsinoService service;
	
	@Override
	public InstituicaoEnsino convert(String text) {
		
		if (text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.pesquisarPorId(id);
	}

}
