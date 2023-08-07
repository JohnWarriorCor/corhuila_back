package com.corhuila.corhuila.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/Inicio").permitAll()
		.antMatchers("/logo").permitAll()
		.antMatchers("/campos/**").permitAll()
		.antMatchers("/asignaturas").permitAll()
		.antMatchers("/asignatura/form").permitAll()
		.antMatchers("/planes").permitAll()
		.antMatchers("/planes/form").permitAll()
		.antMatchers("/resoluciones").permitAll()
		.antMatchers("/resolucion/form").permitAll()
		.antMatchers("/programas").permitAll()
		.antMatchers("/uaa").permitAll()
		.antMatchers("/uaa/form").permitAll()
		.antMatchers("/traslados").permitAll() 
		.antMatchers("/homologaciones").permitAll()
		.antMatchers("/homo-configuracion").permitAll()
		.antMatchers("/traslado-configuracion").permitAll()
		.antMatchers("/token").permitAll()	
		.antMatchers("/paa/{codigo}/{username}").permitAll()
		.antMatchers("/certificado/{proCodigo}").permitAll()
		.antMatchers("/obtenerFoto/{codigo}").permitAll()
		.antMatchers("/archivos/{per_codigo}/{uaa}/{usuario}").hasAnyRole("REGISTRO_Y_CONTROL_MATRICULA_POSGRADO")
		.antMatchers("/archivos/{usuario}/{uaa}").hasAnyRole("REGISTRO_Y_CONTROL_MATRICULA_POSGRADO")
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/webparametro/**").permitAll()
		.antMatchers("/**.webmanifest").permitAll()
		.antMatchers("/manifest.webmanifest").permitAll()
		.antMatchers("/assets/**").permitAll()
		.antMatchers("/assets/icons/**").permitAll()
		.antMatchers("/icons/**").permitAll()
		.antMatchers("/**.png").permitAll()
		.antMatchers("/**.gif").permitAll()
		.antMatchers("/logo").permitAll()
		.antMatchers("/**.js").permitAll()
		.antMatchers("/**.css").permitAll()
		.antMatchers("/publico/**").permitAll()
		.antMatchers("/aprobacion/**").permitAll()
		.antMatchers("/programasAll/snies/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/").permitAll()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(false);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}


	
}