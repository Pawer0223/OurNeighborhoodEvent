package woodong2.service.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import woodong2.dao.common.AuthorityDAO;
import woodong2.dao.common.UserInfosDAO;
import woodong2.vo.common.UserInfos;

@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired
	UserInfosDAO userInfosDao;
	@Autowired
	AuthorityDAO authorityDao;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("## loadUserByUsername ##");
		
		UserInfos userInfo = userInfosDao.getUserInfo(username);
		
		if( userInfo == null ) {
			throw new UsernameNotFoundException(username);
		}
		userInfo.setAuthorities(getAuthorities(username));

		return userInfo;
	}
	
	// 계정권한 조회하기.
	public Collection<GrantedAuthority> getAuthorities(String username) { 
		
		List<String> string_authorities = authorityDao.getAuthorities(username);
		
		if( string_authorities == null ) {
			throw new UsernameNotFoundException(username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 
		
		for (String authority : string_authorities) { 
			authorities.add(new SimpleGrantedAuthority(authority)); 
		} 
		return authorities; 
	}

}
