package woodong2.dao.common;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.UserInfos;

//USER_INFOS에 접근하는 DAO 클래스

@Repository("userInfosDAO")
public class UserInfosDAO extends AbstractDAO{
	
	public UserInfos getUserInfo(String username) {
		System.out.println(" getUserInfo");
		return (UserInfos)selectOne("userInfos.getUserInfo",username);
	}
	
	
	
	
	
	// 최근리뷰 최대15건 조회 , 메인페이지 조회용도
	public int duplicateCheck(String inputId) {
		int result = 1; // 등록 된 ID가 없으면0, 있으면1
		if ( (Integer)selectOne("userInfos.duplicateCheck",inputId) == null ) result=0;
		return result;
	}
	
	public int registUser(UserInfos userInfo) {
		return (Integer)insert("userInfos.registUser",userInfo);
	}
	
	public int updatePtnCd(UserInfos userInfo) {
		return (Integer)update("userInfos.updatePtnCd",userInfo);
	} 
}
