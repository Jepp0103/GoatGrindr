package edu.kea.jnd.goatsite.SpringSecurity;

import edu.kea.jnd.goatsite.model.Goat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource datasource;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception{
            auth.jdbcAuthentication()
             .dataSource(datasource)
                    .usersByUsernameQuery()
                    .authoritiesByUsernameQuery()
             .withDefaultSchema()
             .withUser(User.withUsername("username")
             .password(passwordEncoder().encode("password"))
             .roles("USER"));
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/loginPage", "/createGoat", "/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/loginPage")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

}


