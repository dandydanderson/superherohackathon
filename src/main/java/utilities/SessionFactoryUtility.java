package utilities;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Superhuman;
import models.Superteams;

public class SessionFactoryUtility {

	private static SessionFactory sf;
	private static SessionFactoryUtility sfu;

	private static final String USERNAME = System.getenv("POSTGRES_USERNAME");
	private static final String PASSWORD = System.getenv("AWS_POSTGRES_PASSWORD");
	private static final String URL = "jdbc:postgresql://" + System.getenv("AWS_POSTGRES_SUPERHUMANS")
			+ ":5432/postgres?";

	private static String schema = "public";

	public static SessionFactoryUtility getSessionFactoryUtility() {
		if (sfu == null) {
			sfu = new SessionFactoryUtility();
		}
		return sfu;
	}

	private SessionFactoryUtility() {
		if (sf == null) {
			Map<String, String> settings = new HashMap<String, String>();
			settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
			settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.default_schema", schema);
			settings.put("show_sql", "true");
			settings.put("connection.pool_size", "1");
			settings.put("hibernate.connection.url", URL);
			settings.put("hibernate.connection.username", USERNAME);
			settings.put("hibernate.connection.password", PASSWORD);

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().applySettings(settings)
					.build();
			Metadata metadata = new MetadataSources(standardRegistry)
					.addAnnotatedClass(Superhuman.class)
					.addAnnotatedClass(Superteams.class)
					.getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
					.build();
			sf = metadata.getSessionFactoryBuilder().build();
		}
	}

	public SessionFactory getSessionFactory() {
		return this.sf;
	}

}
