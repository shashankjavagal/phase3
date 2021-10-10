package com.org.sportyshoes.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.sportyshoes.entity.User;
import com.org.sportyshoes.repository.UserRepository;
import com.org.sportyshoes.security.UserPrincipal;

@Service
public class UserService implements UserDetailsService {
    
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Exit");
		
		return new UserPrincipal(user);
	}
	
	public List<User> displayAllCustomer(){
		List<User> customers=new ArrayList<User>();
		userRepository.findAll().forEach(customer->customers.add(customer));
		return customers;
	}
	
	public void registerCustomer(User customer) {
		userRepository.save(customer);
	}
	
	public User getUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}
	
	
	
}
