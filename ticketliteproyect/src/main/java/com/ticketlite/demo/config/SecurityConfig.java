package com.ticketlite.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta es una clase de configuración de Spring
@EnableWebSecurity // Habilita la configuración de seguridad web de Spring Security
public class SecurityConfig {

    // Define la cadena de filtros de seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilita CSRF (Cross-Site Request Forgery) para APIs REST.
                // Considera habilitarlo y protegerlo adecuadamente en aplicaciones web con formularios.
                .csrf(csrf -> csrf.disable())
                // Configura las reglas de autorización para las solicitudes HTTP
                .authorizeHttpRequests(authorize -> authorize
                        // Puedes permitir el acceso público a ciertas rutas si es necesario (ej. para un endpoint de login)
                        // .requestMatchers("/api/auth/**").permitAll() // Por ejemplo, si tienes un controlador de autenticación
                        // Para este ejemplo, todas las demás solicitudes DEBEN ser autenticadas
                        .anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación
                )
                // Habilita la autenticación HTTP Basic.
                // Esto significa que el navegador o cliente enviará un encabezado 'Authorization: Basic Base64(username:password)'
                .httpBasic(org.springframework.security.config.Customizer.withDefaults());

        return http.build();
    }

    // Define los usuarios en memoria para propósitos de demostración.
    // EN UN PROYECTO REAL: Reemplazarías esto por una implementación de UserDetailsService
    // que cargue los usuarios (y sus roles y contraseñas cifradas) desde tu base de datos.
    @Bean
    public UserDetailsService userDetailsService() {
        // Crea un usuario de ejemplo con rol "USER"
        UserDetails user = User.builder()
                .username("user") // Nombre de usuario
                .password(passwordEncoder().encode("password")) // Contraseña cifrada
                .roles("USER") // Rol asignado
                .build();

        UserDetails admin = User.builder()
                .username("admin") // Nombre de usuario
                .password(passwordEncoder().encode("adminpass")) // Contraseña cifrada
                .roles("ADMIN", "USER") // Roles asignados
                .build();

        // Retorna un gestor de detalles de usuario en memoria con estos usuarios
        return new InMemoryUserDetailsManager(user, admin);
    }

    // Bean para cifrar contraseñas.
    // Es CRÍTICO cifrar las contraseñas, incluso para usuarios en memoria,
    // y especialmente para los usuarios en base de datos.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Un algoritmo de hashing fuerte para contraseñas
    }
}