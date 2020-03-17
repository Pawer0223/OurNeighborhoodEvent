package woodong2.dao.common;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.PtnInfos;

//PTN_INFOS에 접근하는 DAO 클래스

@Repository("ptnInfosDAO")
public class PtnInfosDAO extends AbstractDAO{
	
	public int registPtnInfos(PtnInfos ptnInfo) {
		return (Integer)insert("ptnInfos.registPtnInfos",ptnInfo);
	}
	
	public String getMaxPtnCd() {
		return (String)selectOne("ptnInfos.getMaxPtnCd");
	}
	
	public PtnInfos getPtnInfo(String ptnCd) {
		return (PtnInfos)selectOne("ptnInfos.getPtnInfo" , ptnCd);
	}

	public int bizrNoDuplicateCheck(String bizrRegNo) {
		
		if ( (Integer)selectOne("ptnInfos.bizrNoDuplicateCheck", bizrRegNo) == null ) return 0;
		else return 1;
	}

}
