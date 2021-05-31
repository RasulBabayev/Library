package com.company.LibraryApplicationWithSpringMVC.service.impl;

import com.company.LibraryApplicationWithSpringMVC.repository.UserRepository;
import com.company.LibraryApplicationWithSpringMVC.service.inter.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.company.LibraryApplicationWithSpringMVC.models.User user = userRepository.findByEmail(email);
        User.UserBuilder userBuilder = null;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.disabled(false);
            userBuilder.password(user.getPassword());

            String[] authoritiesArr = new String[]{user.getRole().getName()};
            userBuilder.authorities(authoritiesArr);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
