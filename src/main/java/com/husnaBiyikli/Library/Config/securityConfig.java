package com.husnaBiyikli.Library.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class securityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers(new AntPathRequestMatcher("/user/register"),
                                                                new AntPathRequestMatcher("/user/login"),
                                                                new AntPathRequestMatcher("/user/registerPage"),
                                                                new AntPathRequestMatcher("/auth/login"))
                                                .permitAll()
                                                .requestMatchers(new AntPathRequestMatcher("/book/delete"))
                                                .hasRole("ADMIN")
                                                .anyRequest().authenticated())
                                .formLogin(login -> login
                                                .loginPage("/auth/login")
                                                .failureUrl("/auth/login?failed")
                                                .defaultSuccessUrl("/home/allbook", true)
                                                .failureHandler(authenticationFailureHandler())
                                                .permitAll())
                                .logout(logout -> logout
                                                .invalidateHttpSession(true)
                                                .clearAuthentication(true)
                                                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                                                .logoutSuccessUrl("/user/login?logout")
                                                .permitAll());

                return http.build();
        }

        @SuppressWarnings("deprecation")
        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
                return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }

        @Bean
        public AuthenticationFailureHandler authenticationFailureHandler() {
                return (request, response, exception) -> {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        response.getWriter().write("Geçersiz kullanıcı adı veya şifre\n");
                        response.getWriter().write(exception.getMessage());
                };
        }
}
