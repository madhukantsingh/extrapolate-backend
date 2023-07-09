package com.anyaudit.security;

import com.anyaudit.security.jwt.AuthEntryPointJwt;
import com.anyaudit.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .cors().and().csrf().disable()
              .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
              .authorizeRequests()
              .antMatchers("/api/auth/**").permitAll()
              .antMatchers("/v3/api-docs/**").permitAll()
              .antMatchers("/swagger-ui/index.html").permitAll()
              .antMatchers("/swagger-ui/**").permitAll()
              .antMatchers("/api/noauth/**").permitAll()
              .antMatchers("/api/test/**").permitAll()
//              .antMatchers("/api/client/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER", "ROLE_INCHARGE", "ROLE_SENIOR", "ROLE_JUNIOR")
              .anyRequest().authenticated();

      http.authenticationProvider(authenticationProvider());
      http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }



  @Bean
  public ViewResolver viewResolver() {
    final InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setViewClass(JstlView.class);
    bean.setPrefix("/WEB-INF/views/");
    bean.setSuffix(".jsp");
    return bean;
  }
}

