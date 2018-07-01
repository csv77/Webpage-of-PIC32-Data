package sensordata.pic32.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sensordata.pic32.config.SensorDataDaoConfiguration;

@Configuration
@Import(SensorDataDaoConfiguration.class)
@EnableWebSecurity
public class SensorDataSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("#{dataSource}")
	private DataSource dataSource;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
				"SELECT username, password, enabled FROM users WHERE username = ?")
		.authoritiesByUsernameQuery(
				"SELECT username, authority FROM authorities WHERE username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http/*.requiresChannel()
				.antMatchers("/login*").requiresSecure()
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
