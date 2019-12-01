package first.actions.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import first.actions.dao.PtnInfosDAO;
import first.actions.model.PtnInfos;
import first.actions.service.PtnInfosService;
import first.loginAction.model.UserInfo;

@Service("ptnInfosService")
public class PtnInfosServiceImpl implements PtnInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="ptnInfosDAO")
	private PtnInfosDAO ptnInfosDAO;

	@Override
	public int inserStoreInfo(PtnInfos ptninfo) throws Exception {
		
		return ptnInfosDAO.insertStoreInfo(ptninfo);
	}
	
}
