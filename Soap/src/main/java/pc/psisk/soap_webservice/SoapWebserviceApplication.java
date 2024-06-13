//główna klasa webservice
package pc.psisk.soap_webservice;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapWebserviceApplication {

    //funkcja główna
    public static void main(String[] args) {
        SpringApplication.run(SoapWebserviceApplication.class, args);
    }

    //metoda tworząca i konfigurująca fabrykę serwera webowego
    @Bean
    public ServletWebServerFactory servletContainer() {
        //tworzenie instancji fabryki serwera Tomcat
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        //dodawanie dodatkowego konektora HTTP do fabryki Tomcat
        tomcat.addAdditionalTomcatConnectors(createHttpConnector());
        return tomcat;
    }

    //metoda tworząca konektor HTTP
    private Connector createHttpConnector() {
        //tworzenie nowego konektora z domyślnym protokołem Tomcat
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        //ustawienie schemtu na HTTP
        connector.setScheme("http");
        //dodanie portu
        connector.setPort(8080); // Port HTTP
        return connector;
    }
}
