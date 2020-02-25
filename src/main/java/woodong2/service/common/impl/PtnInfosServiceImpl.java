package woodong2.service.common.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import woodong2.dao.common.PtnInfosDAO;
import woodong2.service.common.PtnInfosService;
import woodong2.vo.common.PtnInfos;

@Service("ptnInfosService")
public class PtnInfosServiceImpl implements PtnInfosService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="ptnInfosDAO")
	private PtnInfosDAO ptnInfosDAO;

	@Override
	public int registPtnInfos(PtnInfos ptninfo) throws Exception {
		return ptnInfosDAO.registPtnInfos(ptninfo);
	}

	@Override
	public String getMaxPtnCd() throws Exception {
		return ptnInfosDAO.getMaxPtnCd();
	}

	@Override
	public PtnInfos getPtnInfo(String ptnCd) throws Exception {
		return ptnInfosDAO.getPtnInfo(ptnCd);
	}
	
}
