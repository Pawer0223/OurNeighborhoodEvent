package woodong2.service.common.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

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
		System.out.println("요기탑니까? : " + username);
		log.debug("## loadUserByUsername ##");
		
		System.out.println("class 이름 : " + this.getClass());
		
		if ( userInfosDao == null ) {
			System.out.println("못만들엇네..");
		}else {
		System.out.println("만들엇는데? ㅡㅡ..");
		}
		
		UserInfos userInfo = userInfosDao.getUserInfo(username);
		System.out.println("2");
		
		if( userInfo == null ) {
			System.out.println(" 3 ");
			throw new UsernameNotFoundException(username);
		}
		
		System.out.println("4");
		userInfo.setAuthorities(getAuthorities(username));
		
		System.out.println("5");

		return userInfo;
	}
	
	// 계정권한 조회하기.
	public Collection<GrantedAuthority> getAuthorities(String username) { 
		
		System.out.println("6");
		
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
