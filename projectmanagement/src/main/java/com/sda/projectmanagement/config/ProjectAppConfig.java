package com.sda.projectmanagement.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.sda.projectmanagement")
@EntityScan("com.sda.projectmanagement.persistence")
@EnableJpaRepositories("com.sda.projectmanagement.repositories")
@Import({WebSecurityConfig.class})
public class ProjectAppConfig {
}
