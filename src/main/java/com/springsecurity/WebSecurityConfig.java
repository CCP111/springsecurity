package com.springsecurity;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.authentication.builders.*;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;  
@EnableWebSecurity  
@ComponentScan("com.javatpoint")  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {  
      
    @Bean  
    public UserDetailsService userDetailsService() {  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User.withDefaultPasswordEncoder()  
        .username("irfan").password("khan").roles("ADMIN").build());  
        return manager;  
    }  
      
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
                  
        http                              
        .authorizeRequests()  
            .anyRequest().hasRole("ADMIN")  
            .and().formLogin().and()  
        .httpBasic()  
        .and()  
        .logout()  
        .logoutUrl("/j_spring_security_logout")  
        .logoutSuccessUrl("/")  
        ;  
    }  
}  
