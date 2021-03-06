package me.cresterida.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "me.cresterida.conf.repository")
public class JpaConfiguration {
	   @Autowired
	    private DataSource dataSource;

	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
	        LocalContainerEntityManagerFactoryBean emf = builder
	                .dataSource(dataSource)
	                .packages("me.cresterida.conf.entity")
	                .build();

	        emf.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);

	        return emf;
	    }
    
}
