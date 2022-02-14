package com.ascode.qrcodegenerator.services.user;

import com.ascode.qrcodegenerator.domains.User;
import com.ascode.qrcodegenerator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByEmail(userName);
        return Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
                .map(UserDetailsImpl::new).get();
    }
}
