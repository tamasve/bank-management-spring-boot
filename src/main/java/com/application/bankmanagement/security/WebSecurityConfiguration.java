package com.application.bankmanagement.security;

import com.application.bankmanagement.entity.UserData;
import com.application.bankmanagement.repository.UserDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/", "/error", "/test").permitAll()
                .requestMatchers("/test/read", "/test/**").hasRole("READ")
                .requestMatchers("/admin", "/test/admin").hasRole("ADMIN")
                .and().formLogin().permitAll()
                .and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService( userDetailsService() );
        daoAuthenticationProvider.setPasswordEncoder( passwordEncoder() );
        return daoAuthenticationProvider;
    }

    // load 3 basic users into DB - just to start with something
    @Bean
    public CommandLineRunner basicUserDataLoader(UserDataRepository userDataRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userDataRepository.findAll().isEmpty()) {
                userDataRepository.save( new UserData(1L, "basic", passwordEncoder.encode("1234"), "basic@basic.com", "ROLE_READ", "", true));
                userDataRepository.save( new UserData(2L, "admin", passwordEncoder.encode("1234"), "admin@admin.com", "ROLE_ADMIN", "", true));
                userDataRepository.save( new UserData(3L, "mixed", passwordEncoder.encode("1234"), "mixed@mixed.com", "ROLE_READ,ROLE_ADMIN", "", true));
                System.out.println("3 basic users were saved into DB");
            }
        };
    }
}