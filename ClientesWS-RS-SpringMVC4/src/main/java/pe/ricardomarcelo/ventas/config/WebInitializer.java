package pe.ricardomarcelo.ventas.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        DispatcherServlet dispatcher = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic dispatcherServ = servletContext.addServlet("dispatcher", dispatcher);
        dispatcherServ.setLoadOnStartup(1);
        dispatcherServ.addMapping("/rs/*");
		              
	}

}