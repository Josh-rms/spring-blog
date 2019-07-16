//package com.codeup.springblog.services;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
//
//    private UserDetailsLoader usersLoader;
//
//    public SecurityConfigurations(UserDetailsLoader usersLoader) {
//        this.usersLoader = usersLoader;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(usersLoader)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/po/profile")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/", "/po")
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers(
//                        "/po/create",
//                        "/po/edit/{id}",
//                        "/po/profile",
//                        "/po/delete/{id}"
//                )
//                .authenticated();
//    }
//}
