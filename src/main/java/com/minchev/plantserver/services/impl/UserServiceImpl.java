package com.minchev.plantserver.services.impl;

import com.minchev.plantserver.database.repository.UserRepository;
import com.minchev.plantserver.models.UserServiceModel;
import com.minchev.plantserver.services.api.RoleService;
import com.minchev.plantserver.services.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleService roleService,
                           ModelMapper modelMapper
                           ) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;

    }

        @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }


    @Override
    public UserServiceModel findUserByUserName(String username) {
        return null;
    }
}
