package com.aliAwards.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Aquí deberías cargar el usuario desde tu base de datos
        // Este es solo un ejemplo de usuario en memoria
        if ("user".equals(username)) {
            return User.withUsername(username)
                    .password("{noop}password") // {noop} significa que no hay codificación de contraseña
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
