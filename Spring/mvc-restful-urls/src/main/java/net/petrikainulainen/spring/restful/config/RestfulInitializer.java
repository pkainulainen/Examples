package net.petrikainulainen.spring.restful.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author Petri Kainulainen
 */
public class RestfulInitializer implements WebApplicationInitializer {
    
    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/app/*";

    private static final String URL_REWRITE_FILTER_NAME = "urlRewrite";
    private static final String URL_REWRITE_FILTER_MAPPING = "/*";
    private static final String URL_REWRITE_FILTER_PARAM_LOGLEVEL = "logLevel";
    private static final String URL_REWRITE_FILTER_LOGLEVEL_SLF4J = "slf4j";
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(ApplicationContext.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

        servletContext.addListener(new ContextLoaderListener(rootContext));

        FilterRegistration.Dynamic urlReWrite = servletContext.addFilter(URL_REWRITE_FILTER_NAME, new UrlRewriteFilter());
        urlReWrite.setInitParameter(URL_REWRITE_FILTER_PARAM_LOGLEVEL, URL_REWRITE_FILTER_LOGLEVEL_SLF4J);
        EnumSet<DispatcherType> urlReWriteDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        urlReWrite.addMappingForUrlPatterns(urlReWriteDispatcherTypes, true, URL_REWRITE_FILTER_MAPPING);
    }
}
