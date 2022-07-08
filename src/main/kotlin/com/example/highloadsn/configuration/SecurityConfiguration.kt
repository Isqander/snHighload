package com.example.highloadsn.configuration

import com.example.highloadsn.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userService: UserService? = null

//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.inMemoryAuthentication()
//            .withUser("admin")
//            .password(encoder().encode("pass"))
//            .roles("DOCTOR", "ADMIN")
//            .and()
//            .withUser("doctor")
//            .password(encoder().encode("pass"))
//            .roles("DOCTOR")
//    }

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val auth = DaoAuthenticationProvider()
        auth.setUserDetailsService(userService)
        auth.setPasswordEncoder(encoder())
        return auth
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    //    override fun configure(http: HttpSecurity?) {
//        http {
//            httpBasic {}
//            authorizeRequests {
//                authorize("/users/**", hasAuthority("ROLE_ADMIN"))
//                authorize("/users/register/**", permitAll)
//            }
//        }
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers(
            "/registration**", "/js/**",
            "/css/**", "/img/**"
        ).permitAll().anyRequest()
            .authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
            .invalidateHttpSession(true).clearAuthentication(true)
            .logoutRequestMatcher(AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
            .permitAll()
    }


    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}