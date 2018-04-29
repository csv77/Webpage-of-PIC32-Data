package sensordata.pic32.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SensorDataSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser("csabi")
			.password("$2a$04$6cQ2xN58KhZCmzJDTsd4IeN2Okq8lk6IyGmjrFmHOEzGywhg5STwS")
			.authorities("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http/*.requiresChannel()
				.antMatchers("/**", "/perform_login").requiresSecure()
			.and()*/
				.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/home")
				.permitAll()
				.failureUrl("/login?error")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
				.headers();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
