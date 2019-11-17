package edu.kea.jnd.goatsite.model;

import edu.kea.jnd.goatsite.repository.GoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private GoatRepository goatRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Goat goat = goatRepository.findGoatByUsername(username);
        if(goat == null)
            throw new UsernameNotFoundException("User 404 Not Found");

        return new CurrentUser(goat);
    }
}
