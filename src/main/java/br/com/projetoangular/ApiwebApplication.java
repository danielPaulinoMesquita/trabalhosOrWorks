package br.com.projetoangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.projetoangular.ws.controller.TokenFilter;


@SpringBootApplication
public class ApiwebApplication {

	@Bean
	public FilterRegistrationBean<TokenFilter> filtroJwt() {
		FilterRegistrationBean<TokenFilter> frb = new FilterRegistrationBean<TokenFilter>();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiwebApplication.class, args);
	}
}
