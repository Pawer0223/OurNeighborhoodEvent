package woodong2.vo.common;

public class Authority {
	
	private String userId;
	private String authorityName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAuthorityName() {
		return authorityName;
	}
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	@Override
	public String toString() {
		return "Authority [userId=" + userId + ", authorityName=" + authorityName + "]";
	}
}
