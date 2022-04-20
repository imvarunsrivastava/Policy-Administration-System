package com.cts.authorization.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.MyUserDetails;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("inside loadUserByUsername method");
		Optional<User> user = userRepository.findById(username);
		if(!user.isPresent()) {
			log.info("User NOT Found");
			throw new UsernameNotFoundException("User NOT Found");
		}
		return new MyUserDetails(user.get());
	}

}
