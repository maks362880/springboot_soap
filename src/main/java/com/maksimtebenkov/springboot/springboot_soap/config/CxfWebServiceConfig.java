package com.maksimtebenkov.springboot.springboot_soap.config;

import com.maksimtebenkov.springboot.springboot_soap.controllers.soap.CustomerWS;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CxfWebServiceConfig {
    @Autowired
    private Bus cxfBus;

    @Bean
    public ServletRegistrationBean cxfServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean servletDef = new ServletRegistrationBean<>((Servlet) cxfServlet, "/ws/*");
        servletDef.setLoadOnStartup(1);
        return servletDef;
    }

    @Bean
    public EndpointImpl customerWebService(CustomerWS customerWS) {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, customerWS);
        endpoint.setAddress("/customerWS");
        endpoint.publish();
        return endpoint;
    }
}
