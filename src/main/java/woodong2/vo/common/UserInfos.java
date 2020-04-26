package woodong2.vo.common;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class UserInfos implements UserDetails {

	// 사용자ID 
	private String userId;

	// 사용자PW 
	private String userPw;

	// 회원가입시 동일한 값 입력했는지 확인하기위한용도
	private String userPw2;

	// 사용자명 
	private String userNm;

	// 사업자코드 
	private String ptnCd;

	// 이전 비밀번호 
	private String prevPw;

	// 로그인오류횟수 
	private Integer lgnErrCnt;

	// 계정화성화여부
	private boolean enabled;

	// 계정 잠금날짜
	private Date LockDate;

	// 계정권한을 보관하기위한 참조변수
	private Collection <? extends GrantedAuthority> authorities;

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

	public String getPtnCd() {
		return ptnCd;
	}

	public void setPtnCd(String ptnCd) {
		this.ptnCd = ptnCd;
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

	public String getUserPw2() {
		return userPw2;
	}

	public void setUserPw2(String userPw2) {
		this.userPw2 = userPw2;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public Date getLockDate() {
		return LockDate;
	}

	public void setLockDate(Date lockDate) {
		LockDate = lockDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	@Override
	public String toString() {
		return "UserInfos [userId=" + userId + ", userPw=" + userPw + ", userPw2=" + userPw2 + ", userNm=" + userNm
				+ ", ptnCd=" + ptnCd +", prevPw=" + prevPw + ", lgnErrCnt=" + lgnErrCnt + ", enabled=" + enabled + ", LockDate=" + LockDate
				+ ", authorities=" + authorities + "]";
	}

}