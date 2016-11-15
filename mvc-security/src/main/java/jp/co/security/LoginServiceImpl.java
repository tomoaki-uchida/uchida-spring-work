package jp.co.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (arg0.equals("admin")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin", "admin", authorities);		
		} else if (arg0.equals("user")) {
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			return new User("user", "user", authorities);					
		} else {
			return null;
		}
	}

}
