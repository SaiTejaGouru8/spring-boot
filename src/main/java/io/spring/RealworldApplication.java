package io.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class RealworldApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RealworldApplication.class);
    }

  public static void main(String[] args) {
    SpringApplication.run(RealworldApplication.class, args);
  }
}
