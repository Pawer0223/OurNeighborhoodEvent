package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.PtnInfosDAO;
import first.actions.model.UserInfo;
import first.actions.service.PtnInfosService;

@Service("ptnInfosService")
public class PtnInfosServiceImpl implements PtnInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="ptnInfosDAO")
	private PtnInfosDAO ptnInfosDAO;

	@Override
	public UserInfo login(UserInfo info) throws Exception {
		return null;
	}
	
}
