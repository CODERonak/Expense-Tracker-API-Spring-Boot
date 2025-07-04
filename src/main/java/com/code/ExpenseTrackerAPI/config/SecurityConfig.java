package com.code.ExpenseTrackerAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.code.ExpenseTrackerAPI.service.CustomUserDetailsService;

// setting up the security config
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    // security filter chain for allowing the requests without any authentication
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // alowing the register, login and the test page without any authentication
        http.authorizeHttpRequests(requests -> requests
        .requestMatchers("/register", "/login", "/test").permitAll()
        .anyRequest().authenticated())
        
        // enabling the basic authentication
        .httpBasic(Customizer.withDefaults())
        .formLogin(form -> form.disable())
        .authenticationManager(authenticationManager())
        .csrf(csrf -> csrf.disable());
        
        return http.build();
    }
    private final CustomUserDetailsService userDetailsService;
    
        public SecurityConfig(CustomUserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}