package first.actions.dao;

import org.springframework.stereotype.Repository;

import first.actions.model.UserInfos;
import first.common.dao.AbstractDAO;

//USER_INFOS에 접근하는 DAO 클래스

@Repository("userInfosDAO")
public class UserInfosDAO extends AbstractDAO{
	// 최근리뷰 최대15건 조회 , 메인페이지 조회용도
	public int duplicateCheck(String inputId) {
		int result = 1; // 등록 된 ID가 없으면0, 있으면1
		if ( (Integer)selectOne("userInfos.duplicateCheck",inputId) == null ) result=0;
		return result;
	}
	
	public int registUser(UserInfos userInfo) {
		return Integer.valueOf((Integer)insert("userInfos.registUser",userInfo));
	}
	
	public UserInfos login(UserInfos userInfo) {
		return (UserInfos)selectOne("userInfos.login",userInfo);
	}
}
