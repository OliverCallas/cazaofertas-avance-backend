package com.idat.cazaofertas.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
/*import org.springframework.security.core.userdetails.User;*/
/*import org.springframework.security.core.userdetails.UserDetailsService;*/
/*import org.springframework.security.provisioning.InMemoryUserDetailsManager;*/


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private DataSource datasource;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Inyecta el datasource y el passwordencoder al metodo void configureGlobal
	@Autowired 
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		//Busca registro del usuario por consulta SQL
		build.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder).
    	usersByUsernameQuery("select username, password, enabled from users where username=?").
    	authoritiesByUsernameQuery("select username, authority from users where username=?");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
 
    	String[] staticResources = {
    			"/assets/**",
                "/index.css",
                "/img/**",
                "/css/**",
                "/js/**",
                "/style.css",
                "/login.js",
                };
    	
        http.authorizeRequests()
        		.antMatchers(staticResources).permitAll()
        		.antMatchers("/","/index").permitAll()
                .antMatchers("/menu").hasAnyRole("ADMIN","USER")
                .antMatchers("/registro").permitAll()
                .antMatchers("/registrosys").hasAnyRole("ADMIN")
                .antMatchers("/registrologin").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error");
 
        return http.build();
    }
    
    /* 
    //Crear manualmente usuarios en memoria
    @Bean
    public UserDetailsService userDetailsService() throws Exception {
 
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
 
        manager.createUser(User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build()); 
        manager.createUser(User.withUsername("admin").password(passwordEncoder.encode("321")).roles("ADMIN","USER").build());
 
        return manager;
    } 
    */
}
