package pe.ricardomarcelo.ventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"pe.ricardomarcelo.ventas"})
public class SpringConfig extends WebMvcConfigurationSupport{
	 @Bean
	 public InternalResourceViewResolver getInternalResourceViewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/view/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	 }
	 
}