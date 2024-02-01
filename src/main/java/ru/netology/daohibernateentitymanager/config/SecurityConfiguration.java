package ru.netology.daohibernateentitymanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").hasAnyAuthority("citySearch")
                .and()
                .authorizeRequests().antMatchers("/persons/by-less-than-age").hasAnyAuthority("ageSearch")
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-and-surname").hasAnyAuthority("nameSurnameSearch")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User1")
                .password("{noop}123456")
                .authorities("citySearch", "ageSearch")
                .and()
                .withUser("User2")
                .password(encoder.encode("321"))
                .authorities("citySearch")
                .and()
                .withUser("User3")
                .password(encoder.encode("777"))
                .authorities("nameSurnameSearch", "citySearch", "ageSearch");
    }
}
