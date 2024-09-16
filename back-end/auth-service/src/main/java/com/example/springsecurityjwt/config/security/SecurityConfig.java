package com.example.springsecurityjwt.config.security;

import com.example.springsecurityjwt.config.jwt.JwtRequestFilter;

import com.example.springsecurityjwt.filter.EmailVerificationFilter;
import com.example.springsecurityjwt.filter.IpFilterWhiteList;
import com.example.springsecurityjwt.filter.PerfFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter(){
        return new JwtRequestFilter();
    }


    @Bean
    public PerfFilter perfFilter(){
        return new PerfFilter();
    }


    @Bean
    public IpFilterWhiteList ipFilterWhiteList(){
        return new IpFilterWhiteList();
    }

/*    @Bean
    public EmailVerificationFilter emailVerificationFilter(){
        return new EmailVerificationFilter();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/**").permitAll()  // Routes d'authentification ouvertes
                        .requestMatchers("/api/products/**").hasAnyRole("USER","ADMIN")  // Routes produits pour USER et ADMIN
                        .requestMatchers("/api/products/admin/**").hasRole("ADMIN")  // Routes admin pour les produits
                        .requestMatchers("/api/orders/**").hasAnyRole("USER", "ADMIN") // Routes de commande pour USER et ADMIN
                        .requestMatchers("/api/users/**").hasRole("ADMIN") // Routes de gestion utilisateur pour ADMIN uniquement
                        .anyRequest().authenticated() // Toute autre requête doit être authentifiée
                )

                )
                .addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(perfFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(ipFilterWhiteList(), UsernamePasswordAuthenticationFilter.class);
              //  .addFilterBefore(emailVerificationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000","http://192.168.1.13:3001","http://127.0.0.1:3000"));
       // configuration.setAllowedOriginPatterns(Arrays.asList("http://13.39.149.74:3000"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);
        return source;
    }





}
