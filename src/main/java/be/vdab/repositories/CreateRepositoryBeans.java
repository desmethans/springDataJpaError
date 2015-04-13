package be.vdab.repositories;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import be.vdab.entities.Person;

// enkele imports
@Configuration
@ComponentScan
@EnableJpaRepositories
public class CreateRepositoryBeans {

	  @Bean
	  DataSource dataSource() {
		  return new SimpleDriverDataSource(new org.hsqldb.jdbcDriver(), "jdbc:hsqldb:mem:persons", "sa", "");
	  }
	
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan(Person.class.getPackage().getName());
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		factory.setJpaVendorAdapter(adapter);
		factory.getJpaPropertyMap().put(
				"javax.persistence.schema-generation.database.action", "create");
		return factory;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}
	@Bean
	PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslator() {
		return new PersistenceExceptionTranslationPostProcessor();
	}


}
