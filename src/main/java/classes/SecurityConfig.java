package classes;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private MyUserDetailService myUserDetailService;


    @Override
    protected void configure(HttpSecurity http)throws Exception {
        http.userDetailsService(myUserDetailService)
                .authorizeRequests()
                .antMatchers("/admin*//**" ).hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/user-login.html")
                .defaultSuccessUrl("/success-login.html")
                .failureUrl("/error-login.html")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index.html");
    }

}


