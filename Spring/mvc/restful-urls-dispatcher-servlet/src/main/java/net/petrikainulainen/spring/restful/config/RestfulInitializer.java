package net.petrikainulainen.spring.restful.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

/**
 * Web application Java configuration class. The usage of web application
 * initializer requires Spring Framework 3.1 and Servlet 3.0.
 * @author Petri Kainulainen
 */
public class RestfulInitializer implements WebApplicationInitializer {
    
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING_HOME = "/home";
    private static final String DISPATCHER_SERVLET_MAPPING_PRODUCTS = "/products/*";
    private static final String DISPATCHER_SERVLET_MAPPING_SERVICES = "/services/*";
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_HOME);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_PRODUCTS);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING_SERVICES);

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }
}
