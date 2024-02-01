package ru.netology.daohibernateentitymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DaoHibernateEntitymanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DaoHibernateEntitymanagerApplication.class, args);
    }
}
