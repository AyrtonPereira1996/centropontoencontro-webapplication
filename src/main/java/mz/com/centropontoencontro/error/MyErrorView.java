package mz.com.centropontoencontro.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyErrorView implements ErrorViewResolver {

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		ModelAndView model = new ModelAndView("/error");
		model.addObject("status", status.value());
		
		switch (status.value()) {
		case 404:
			model.addObject("error", "Lamento! A página não foi encontrada!");
			model.addObject("message", "A URL para a página '" + map.get("path") + "' não existe!");
			break;
		case 500:
			model.addObject("error", "Lamento! Ocorreu um erro no servidor!");
			model.addObject("message", "Por favor, tente mais tarde!");
			break;
		case 403:
			model.addObject("error", "Lamento! Acesso proibido!");
			model.addObject("message", "Não tem privilégios para aceder a esta parte do sistema");
			break;
		default:
			model.addObject("error", map.get("error"));
			model.addObject("message", map.get("message"));
			break;
		}
		return model;
	}

}
