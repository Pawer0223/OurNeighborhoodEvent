package first.actions.dao;

import org.springframework.stereotype.Repository;

import first.actions.model.PtnInfos;
import first.common.dao.AbstractDAO;

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

}
