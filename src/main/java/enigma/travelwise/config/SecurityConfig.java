package enigma.travelwise.config;

import enigma.travelwise.model.Role;
import enigma.travelwise.security.JwtAuthenticationFilter;
import enigma.travelwise.security.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserSecurity userSecurity;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .authorizeRequests(authz -> authz
                        .requestMatchers("/api/v1/auth/**").permitAll()
                        // Accommodation EndPoint
                        .requestMatchers(HttpMethod.POST, "/api/v1/accommodations").hasAuthority(String.valueOf(Role.ROLE_MITRA))
                        .requestMatchers(HttpMethod.POST, "/api/v1/accommodations").hasAuthority(String.valueOf(Role.ROLE_ADMIN))
                        .requestMatchers(HttpMethod.GET, "/api/v1/accommodations").permitAll()
//                        .requestMatchers(HttpMethod.PUT, "/api/v1/accommodations/{id}").access(userAuthorizationManager())

                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Add your frontend URL here
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthorizationManager<RequestAuthorizationContext> userAuthorizationManager() {
        // Create authorization manager, first check if the user role is an Admin or not
        AuthorizationManager<RequestAuthorizationContext> adminAuth = AuthorityAuthorizationManager.hasRole("ADMIN");
        return (authentication, context) -> {
            // If the user is an Admin, grant the authorization
            if (adminAuth.check(authentication, context).isGranted()) {
                return new AuthorizationDecision(true);
            }
            try {
                // Get the user ID from the request context and check if the authenticated user matches the ID
                int userId = Integer.parseInt(context.getVariables().get("id"));
                return new AuthorizationDecision(userSecurity.isUser(authentication.get(), userId));
            } catch (NumberFormatException e) {
                // If the user ID doesn't match, deny the authorization
                return new AuthorizationDecision(false);
            }
        };
    }
}
