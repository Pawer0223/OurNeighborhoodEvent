package woodong2.dao.common;

import org.springframework.stereotype.Repository;

import woodong2.vo.common.Authority;
import woodong2.vo.common.UserInfos;

//USER_INFOS에 접근하는 DAO 클래스

@Repository("userInfosDAO")
public class UserInfosDAO extends AbstractDAO{
	
	// 계정정보조회
	public UserInfos getUserInfo(String username) {
		return (UserInfos)selectOne("userInfos.getUserInfo",username);
	}
	// 계정 실패횟수 증가
	public void loginFailCntUp(String username) {
		update("userInfos.loginFailCntUp", username);
	}
	// 계정 활성화여부 변경
	public void changeEnabled(String username) {
		update("userInfos.changeEnabled", username);
	}
	
	public void resetFailCnt(String username) {
		update("userInfos.resetFailCnt", username);
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
	public void insertAuthority(Authority authority) {
		insert("userInfos.insertAuthority",authority);
	} 
}
