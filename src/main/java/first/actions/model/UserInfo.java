package first.actions.model;

//USER_INFO 
public class UserInfo {

	// 이메일주소 
	private String email;

	// 비밀번호 
	private String password;

	// 성 
	private String first_name;

	// 이름 
	private String last_name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_Name(String last_name) {
		this.last_name = last_name;
	}

	// UserInfo 모델 복사
	public void CopyData(UserInfo param)
	{
		this.email = param.getEmail();
		this.password = param.getPassword();
		this.first_name = param.getFirst_name();
		this.last_name = param.getLast_name();
	}

	@Override
	public String toString() {
		return "UserInfo [email=" + email + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name+ "]";
	}

}