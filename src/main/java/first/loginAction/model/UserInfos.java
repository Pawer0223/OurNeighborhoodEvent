package first.loginAction.model;

// 사용자정보 
public class UserInfos {

	// 사용자ID 
	private String userId;

	// 사용자PW 
	private String userPw;

	// 사용자명 
	private String userNm;

	// 동네 
	private String neighbor;

	// 사용자구분코드 
	private String userGbnCd;

	// 사업자코드 
	private String ptnCd;

	// 이메일 
	private String email;

	// 프로필사진 
	private String profilePic;

	// 휴대폰번호 
	private String phoneNum;

	// 이전 비밀번호 
	private String prevPw;

	// 로그인오류횟수 
	private Integer lgnErrCnt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(String neighbor) {
		this.neighbor = neighbor;
	}

	public String getUserGbnCd() {
		return userGbnCd;
	}

	public void setUserGbnCd(String userGbnCd) {
		this.userGbnCd = userGbnCd;
	}

	public String getPtnCd() {
		return ptnCd;
	}

	public void setPtnCd(String ptnCd) {
		this.ptnCd = ptnCd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPrevPw() {
		return prevPw;
	}

	public void setPrevPw(String prevPw) {
		this.prevPw = prevPw;
	}

	public Integer getLgnErrCnt() {
		return lgnErrCnt;
	}

	public void setLgnErrCnt(Integer lgnErrCnt) {
		this.lgnErrCnt = lgnErrCnt;
	}

	// UserInfos 모델 복사
	public void CopyData(UserInfos param)
	{
		this.userId = param.getUserId();
		this.userPw = param.getUserPw();
		this.userNm = param.getUserNm();
		this.neighbor = param.getNeighbor();
		this.userGbnCd = param.getUserGbnCd();
		this.ptnCd = param.getPtnCd();
		this.email = param.getEmail();
		this.profilePic = param.getProfilePic();
		this.phoneNum = param.getPhoneNum();
		this.prevPw = param.getPrevPw();
		this.lgnErrCnt = param.getLgnErrCnt();
	}

	@Override
	public String toString() {
		return "UserInfos [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", neighbor=" + neighbor
				+ ", userGbnCd=" + userGbnCd + ", ptnCd=" + ptnCd + ", email=" + email + ", profilePic=" + profilePic
				+ ", phoneNum=" + phoneNum + ", prevPw=" + prevPw + ", lgnErrCnt=" + lgnErrCnt + "]";
	}


}