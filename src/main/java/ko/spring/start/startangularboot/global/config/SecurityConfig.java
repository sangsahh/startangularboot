package ko.spring.start.startangularboot.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF 일단 비활성화 (API용)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/user/**","/api/auth/**").permitAll()  // 회원가입은 누구나
                .anyRequest().authenticated()                   // 나머지는 인증 필요
            )
            .httpBasic(Customizer.withDefaults()); // or formLogin 등

        return http.build();
    }


}
