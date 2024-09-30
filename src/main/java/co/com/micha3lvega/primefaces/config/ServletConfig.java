package co.com.micha3lvega.primefaces.config;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.ConfigureListener;

@Configuration
public class ServletConfig {

	@Bean
	ServletRegistrationBean<FacesServlet> facesServletRegistration() {
		var registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration",
					Boolean.TRUE.toString());
			servletContext.setInitParameter("primefaces.THEME", "sunny");
		};
	}

	@Bean
	ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<>(new ConfigureListener());
	}
}
