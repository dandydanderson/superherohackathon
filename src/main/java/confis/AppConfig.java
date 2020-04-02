package confis;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import utilities.SessionFactoryUtility;


@Configuration
public class AppConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	public SessionFactory sf() {
		return SessionFactoryUtility.getSessionFactoryUtility().getSessionFactory();
	}


}
