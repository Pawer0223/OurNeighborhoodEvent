package first.loginAction.model;

import java.sql.Date;

//USER_INFO 
public class UserInfo {

 // 이메일주소 
 private String email;

 // 비밀번호 
 private String password;

 // 성 
 private String firstName;

 // 이름 
 private String lastName;

 // 생성일시 
 private Date creationDate;

 // 변경일시 
 private Date updateDate;

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

 public String getFirstName() {
     return firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public Date getCreationDate() {
     return creationDate;
 }

 public void setCreationDate(Date creationDate) {
     this.creationDate = creationDate;
 }

 public Date getUpdateDate() {
     return updateDate;
 }

 public void setUpdateDate(Date updateDate) {
     this.updateDate = updateDate;
 }

 // UserInfo 모델 복사
 public void CopyData(UserInfo param)
 {
     this.email = param.getEmail();
     this.password = param.getPassword();
     this.firstName = param.getFirstName();
     this.lastName = param.getLastName();
     this.creationDate = param.getCreationDate();
     this.updateDate = param.getUpdateDate();
 }

@Override
public String toString() {
	return "UserInfo [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", creationDate=" + creationDate + ", updateDate=" + updateDate + "]";
}
 
}