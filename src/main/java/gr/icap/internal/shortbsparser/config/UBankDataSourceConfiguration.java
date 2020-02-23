package gr.icap.internal.shortbsparser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties", "classpath:application-${spring.profiles.active}.properties" })
@EnableJpaRepositories(basePackages = "gr.icap.internal.shortbsparser.repositories.ubank",
        entityManagerFactoryRef = "ubankEntityManager",
        transactionManagerRef= "ubankTransactionManager"
)
@EnableTransactionManagement
@EnableAutoConfiguration
public class UBankDataSourceConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean ubankEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ubankDataSource());
        em.setPackagesToScan(
                new String[] { "gr.icap.internal.shortbsparser.domain.ubank" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("ubank.jpa.properties.hibernate.dialect",
                env.getProperty("ubank.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    public DataSource ubankDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("ubank.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("ubank.datasource.url"));
        dataSource.setUsername(env.getProperty("ubank.datasource.username"));
        dataSource.setPassword(env.getProperty("ubank.datasource.password"));

        return dataSource;
    }

    @Bean
    @Primary
    public PlatformTransactionManager ubankTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                ubankEntityManager().getObject());
        return transactionManager;
    }
}
