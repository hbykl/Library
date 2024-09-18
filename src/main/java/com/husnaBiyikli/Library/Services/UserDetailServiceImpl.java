package com.husnaBiyikli.Library.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.husnaBiyikli.Library.Repositorys.userRepository;

import com.husnaBiyikli.Library.Entitys.user;
import com.husnaBiyikli.Library.ServiceImpl.userDetailImpl;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final userRepository userRepository;

    public UserDetailServiceImpl(com.husnaBiyikli.Library.Repositorys.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı");
        }
        return new userDetailImpl(user);
    }

}
