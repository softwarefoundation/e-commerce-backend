package br.com.devchampions.ecommerce.security;

import br.com.devchampions.ecommerce.security.config.CorsConfigurationSourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {


    @Autowired
    CorsConfigurationSourceImpl configurationSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req.anyRequest().permitAll())
                .cors(c -> c.configurationSource(configurationSource));

        return httpSecurity.build();
    }

}