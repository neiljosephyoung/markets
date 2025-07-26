package com.njy.markets.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import javax.sql.DataSource;


@Configuration
//@EnableJpaRepositories(basePackages = "com.njy.markets.repository.jpa") // your JPA repo package
@EnableR2dbcRepositories(basePackages = "com.njy.markets.repository.reactive") // your reactive repo package
@EnableR2dbcAuditing
public class RepositoryConfig {


//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
//                        .option(DRIVER, "postgresql")
//                        .option(HOST, "localhost")
//                        .option(PORT, 5432)
//                        .option(DATABASE, "Markets")
//                        // Here is likely the issue:
//                        .option(USER, "postgres")   // this value is missing
//                        .option(PASSWORD, "admin")
//                    .build());
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
}
