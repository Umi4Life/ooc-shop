package io.ooc.project.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private EntryConfig entryConfig;

    @Autowired
    private FailAuthhentication failAuth;

    @Autowired
    private SuccessAuthentication successAuthentication;

    @Autowired
    private AuthenticationHandler authenticationHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http://stackoverflow.com/questions/19500332/spring-security-and-json-authentication

        //to parse user infomation: http://localhost:8080/login?username=muic&password=ooc
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginProcessingUrl("/login")
                .successHandler(successAuthentication).failureHandler(failAuth)
                .and()
                .exceptionHandling().authenticationEntryPoint(entryConfig)
                .and()
                .cors()
                .and()
                .logout().logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .permitAll();


        //

        http
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationHandler);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
