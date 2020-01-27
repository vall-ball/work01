package ru.vallball.work01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan("ru.vallball.work01")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/users/**").permitAll()
		//.and().authorizeRequests().antMatchers(HttpMethod.GET, "/subjects").permitAll()
		//.and().authorizeRequests().antMatchers(HttpMethod.POST, "/subjects").hasRole("ADMIN")
		//.and().authorizeRequests().antMatchers(HttpMethod.PUT, "/subjects/**").hasRole("ADMIN")
		//.and().authorizeRequests().antMatchers(HttpMethod.DELETE, "/subject/**").hasRole("ADMIN")
		//.and().authorizeRequests().antMatchers("/dayschedules/**", "/schedules/**").hasAnyRole("ADMIN","TEACHER","DIRECTOR")
		//.and().authorizeRequests().antMatchers("/classes/**").hasRole("ADMIN").and().httpBasic()
		//		.authenticationEntryPoint(restAuthenticationEntryPoint)
		.and().csrf().disable();
		// antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
		// .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
		// hasRole("ADMIN")
		// .and().formLogin().disable();
		// .antMatchers("/users/changeProfile", "/forClient").hasAnyRole("CLIENT",
		// "ADMIN").and().authorizeRequests()
		// .antMatchers("/adminPage","/genres","/films","/sessions").hasRole("ADMIN").
		// and().authorizeRequests().antMatchers("/clients/**","/accounts/**").hasRole("BANKIR").
		// and().authorizeRequests().antMatchers("/","/registration").permitAll().

		// and().exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler());
		// and().exceptionHandling().accessDeniedPage("/403");
		// and().exceptionHandling().accessDeniedHandler(new MyAccessDeniedHandler())
	}

}
	

