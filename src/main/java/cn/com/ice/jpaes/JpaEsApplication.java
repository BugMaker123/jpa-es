package cn.com.ice.jpaes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "cn.com.ice.jpaes.mapper")
@EntityScan(basePackages = "cn.com.ice.jpaes.entity")
@SpringBootApplication
public class JpaEsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEsApplication.class, args);
    }

}
