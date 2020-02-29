package woodong2.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woodong2.dao.common.AuthorityDAO;
import woodong2.service.common.AuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="authorityDAO")
	private AuthorityDAO authorityDAO;

	@Override
	public List<String> getAuthorities(String username) throws Exception {
		return authorityDAO.getAuthorities(username);
	}
	
}
