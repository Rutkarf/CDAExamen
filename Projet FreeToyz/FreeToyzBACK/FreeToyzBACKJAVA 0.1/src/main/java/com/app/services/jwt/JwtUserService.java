package com.app.services.jwt;

import com.app.services.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtUserService extends UserService {
    String generateJwtForUser(UserDetails user);
    UserDetails getUserFromJwt(String jwt);
}
