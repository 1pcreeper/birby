package com.birby.hrms_account_api.app.config;

import com.birby.hrms_account_api.app.filter.BloomFilter;
import com.birby.hrms_account_api.app.component.properties.FirebaseProperties;
import com.birby.hrms_account_api.app.component.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final SecurityProperties securityProperties;
    private final FirebaseProperties firebaseProperties;
    private final BloomFilter bloomFilter;
    @Autowired
    public SecurityConfig(
            SecurityProperties securityProperties,
            FirebaseProperties firebaseProperties,
            BloomFilter bloomFilter
    ){
        this.securityProperties = securityProperties;
        this.firebaseProperties = firebaseProperties;
        this.bloomFilter = bloomFilter;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(
                cors -> cors.configurationSource(corsConfigurationSource())
        ).authorizeHttpRequests(
                authorize -> authorize.requestMatchers(
                        "/ws/**"
                ).permitAll().anyRequest().authenticated()
        ).oauth2ResourceServer(
                oauth2 -> oauth2.jwt(
                        jwt -> jwt.decoder(jwtDecoder())
                )
        ).addFilterAfter(bloomFilter, AuthorizationFilter.class);
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(firebaseProperties.getIssuerLocation());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        List<String> allowedCorsList = Arrays.stream(securityProperties.getAllowedCors().split(",")).toList();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(allowedCorsList);
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(
                jwt -> Optional.ofNullable(
                                jwt.getClaimAsStringList(
                                        firebaseProperties.getRolesClaim()
                                )
                        ).stream()
                        .flatMap(Collection::stream)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
        return jwtAuthenticationConverter;
    }
}
