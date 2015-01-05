package me.cresterida.conf.service;

import java.util.List;

import me.cresterida.conf.entity.AuthorityModel;
import me.cresterida.conf.entity.UserDetailsCustom;
import me.cresterida.conf.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceCustom implements UserDetailsService{

	
@Autowired
private	UserRepository userRepository;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserDetailsCustom user=userRepository.findByUsername(username);
		 
		
		if (user!=null)
		{
			List<AuthorityModel> authorities = user.getAuthorities();
	        if (authorities.size() > 0) {
	            authorities.get(0).getAuthority();
	        }
		return user;
		}else
			throw new UsernameNotFoundException("Usuario NO EXISTE");
	}

}
