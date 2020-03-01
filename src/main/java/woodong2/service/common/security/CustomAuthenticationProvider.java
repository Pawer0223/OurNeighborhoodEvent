package woodong2.service.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import woodong2.vo.common.UserInfos;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		log.info("### authenticate ### ");
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		UserInfos userInfo = (UserInfos) securityService.loadUserByUsername(username);
		
		System.out.println("password Encode : [ " + passwordEncoder.encode(password)+ " ] ");
		
		if ( !passwordEncoder.matches(password,userInfo.getPassword())) { // pw같은지 검증
			throw new BadCredentialsException(username);
		}else if(!userInfo.isEnabled()) { // 계정 활성화여부 확인
			throw new DisabledException(username);
		}
		
		return new UsernamePasswordAuthenticationToken(userInfo, userInfo, userInfo.getAuthorities());
	}


	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
