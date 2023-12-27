package id.metrodataacademy.clientapp.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http

                                .authorizeRequests()
                                .antMatchers("/css/**", "/img/**", "/js/**")
                                .permitAll()
                                .antMatchers("/login/**")
                                .permitAll()
                                .antMatchers("/home/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                                .and()
                                .formLogin()
                                // settingan page awal (force)
                                .loginPage("/login")
                                //
                                .loginProcessingUrl("/login")
                                .successForwardUrl("/home")
                                .failureForwardUrl("/login?error=true")
                                .permitAll()
                                .and()
                                .logout()
                                .logoutUrl("/logout")
                                .permitAll();
        }
}
