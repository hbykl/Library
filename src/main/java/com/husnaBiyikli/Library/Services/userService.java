package com.husnaBiyikli.Library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.husnaBiyikli.Library.Entitys.user;
import com.husnaBiyikli.Library.Repositorys.userRepository;
import com.husnaBiyikli.Library.ServiceImpl.userImpl;

@Service
public class userService implements userImpl {
    @Autowired
    userRepository userRepository;

    @Override
    public void saveUser(user user) {
        userRepository.save(user);
    }

    @Override
    public user gettCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()
                && !(authentication.getPrincipal() instanceof String)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            return userRepository.findByUserName(userDetails.getUsername());
        } else {
            throw new SecurityException("Geçerli kullanıcı bulunamadı.");
        }
    }
}
