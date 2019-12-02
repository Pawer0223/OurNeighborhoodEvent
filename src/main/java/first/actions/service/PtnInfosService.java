package first.actions.service;

import first.actions.model.PtnInfos;

public interface PtnInfosService {

	int registPtnInfos(PtnInfos ptninfo) throws Exception;
	
	String getMaxPtnCd() throws Exception;
	
	PtnInfos getPtnInfo(String ptnCd) throws Exception;

}
