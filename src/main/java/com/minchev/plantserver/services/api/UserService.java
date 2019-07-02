package com.minchev.plantserver.services.api;

import com.minchev.plantserver.models.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserServiceModel findUserByUserName(String username);
}


