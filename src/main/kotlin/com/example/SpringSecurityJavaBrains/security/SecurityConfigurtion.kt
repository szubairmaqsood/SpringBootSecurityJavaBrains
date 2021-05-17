package com.example.SpringSecurityJavaBrains.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfigurtion:WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
       http
               ?.authorizeRequests()
               ?.antMatchers("/admin")?.hasRole("ADMIN")
               ?.antMatchers("/user")?.hasAnyRole("ADMIN","USER")
               ?.antMatchers("/")?.permitAll()
               ?.and()
               ?.formLogin()
    }
    override fun configure(auth: AuthenticationManagerBuilder?) {
      auth?.inMemoryAuthentication()
              ?.withUser("blah")
              ?.password("blah")
              ?.roles("USER")
              ?.and()
              ?.withUser("foo")
              ?.password("foo")
              ?.roles("ADMIN")
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance();
    }
}