package me.cresterida.conf;

import javax.sql.DataSource;

import me.cresterida.conf.service.UserDetailsServiceCustom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties security;

	private BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
/*		http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest()
				.fullyAuthenticated().and().formLogin().loginPage("/login")
		     //  .anonymous().and().authorizeRequests().antMatchers("/hello").fullyAuthenticated().and().formLogin().loginPage("/login")
		
		.failureUrl("/login?error").permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
;
*/

//		http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest()
//		.fullyAuthenticated().and().formLogin().loginPage("/login")
//		.failureUrl("/login?error").permitAll();
	
		 http
		 .csrf().disable()
         .authorizeRequests()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll();
		
		
	}


	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	//	auth.userDetailsService(userDetailsService);
		
		
		
	}
	 @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	  @Bean
	    public RedirectStrategy defaultRedirectStrategy() {
	        return new DefaultRedirectStrategy();
	    }
}