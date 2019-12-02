package first.actions.service;

import first.actions.model.PtnInfos;

public interface PtnInfosService {

	int inserStoreInfo(PtnInfos ptninfo) throws Exception;
	
	String getMaxPtnCd() throws Exception;
	
	PtnInfos getPtnInfo(String ptnCd) throws Exception;

}
