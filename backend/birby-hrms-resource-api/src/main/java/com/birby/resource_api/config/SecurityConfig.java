package com.birby.resource_api.config;

import com.birby.resource_api.properties.FirebaseProperties;
import com.birby.resource_api.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final SecurityProperties securityProperties;
    private final FirebaseProperties firebaseProperties;
    @Autowired
    public SecurityConfig(
            SecurityProperties securityProperties,
            FirebaseProperties firebaseProperties
    ){
        this.securityProperties = securityProperties;
        this.firebaseProperties = firebaseProperties;
    }
//    @Value("${firebase-config.issuer-location}")
//    private String issuerLocation;
//    @Value("${firebase-config.claims}")
//    private String claims;
//    @Value("${security-config.allowed-cors}")
//    private String allowedCors;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(
                cors -> cors.configurationSource(corsConfigurationSource())
        ).authorizeHttpRequests(
                authorize -> authorize.requestMatchers(
                        "/auth",
                        "/auth/**",
                        "/ws/**"
                ).permitAll().anyRequest().authenticated()
        ).oauth2ResourceServer(
                oauth2 -> oauth2.jwt(
                        jwt -> jwt.decoder(jwtDecoder())
                )
        );
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(firebaseProperties.getIssuerLocation());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList(securityProperties.getAllowedCors()));
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
