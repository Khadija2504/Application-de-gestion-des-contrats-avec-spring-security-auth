package com.example.gestioncontrat.config;

import org.springframework.security.authentication.BadCredentialsException;
import com.example.gestioncontrat.service.implementations.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserActivityFilter userActivityFilter;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    public SecurityConfig(UserActivityFilter userActivityFilter) {
        this.userActivityFilter = userActivityFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Profile("TEST")
    @Bean
    public AuthenticationManager testAuthenticationManager() {
        System.out.println("Using TEST authentication manager");
        return authentication -> {
            String username = authentication.getName();
            return new UsernamePasswordAuthenticationToken(username, null, authentication.getAuthorities());
        };
    }

    @Profile("!TEST")
    @Bean
    public AuthenticationManager productionAuthenticationManager(PasswordEncoder encoder, UserDetailsService userDetailsService) {
        System.out.println("Using production authentication manager");
        return authentication -> {
            var user = userDetailsService.loadUserByUsername(authentication.getName());
            if (!encoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
                throw new BadCredentialsException("Invalid Password!");
            }
            return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login", "/auth/register").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/auth/login?logout")
                )
                .addFilterAfter(userActivityFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
