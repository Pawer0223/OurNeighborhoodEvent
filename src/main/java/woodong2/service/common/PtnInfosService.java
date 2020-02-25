package woodong2.service.common;

import woodong2.vo.common.PtnInfos;

public interface PtnInfosService {

	int registPtnInfos(PtnInfos ptninfo) throws Exception;
	
	String getMaxPtnCd() throws Exception;
	
	PtnInfos getPtnInfo(String ptnCd) throws Exception;

}
