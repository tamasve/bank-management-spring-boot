package com.application.bankmanagement.security;

import com.application.bankmanagement.entity.UserData;
import com.application.bankmanagement.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserData userData = userDataRepository.findByUsername(username);
        if (username == null)  throw new UsernameNotFoundException(username + " user not found");
        return new CustomUserDetails(userData);
    }
}
