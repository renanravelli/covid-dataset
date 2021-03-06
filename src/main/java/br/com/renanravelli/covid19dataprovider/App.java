package br.com.renanravelli.covid19dataprovider;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableBatchProcessing
@EntityScan(basePackages = "br/com/renanravelli/covid19dataprovider/core/domain")
@EnableJpaRepositories(basePackages = "br.com.renanravelli.covid19dataprovider")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
