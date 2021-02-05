package	com.blog.cms.domain.system;
import com.blog.cms.domain.enums.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class User{
	/**
	*主键id
	*/
	private int id;
	/**
	*用户名称
	*/
	private String userName;
	/**
	*用户账号
	*/
	private String account;
	/**
	*密码
	*/
	private String password;
	/**
	*性别
	*/
	private Sex sex;
	/**
	*电话
	*/
	private String phone;
	/**
	*邮箱
	*/
	private String email;
	/**
	*出生日期
	*/
	private Date birthdate;
	/**
	*签名
	*/
	private String sign;
	/**
	*头像
	*/
	private String headPhoto;
	/**
	*是否失效
	*/
	private boolean isValid;
	/**
	*创建日期
	*/
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	/**
	*更新日期
	*/
	private Date updateTime;
	public int getId(){
return id;
}

	public void setId(int id) {
 	this.id = id;
 }

	public String getUserName(){
return userName;
}

	public void setUserName(String userName) {
 	this.userName = userName;
 }

	public String getAccount(){
return account;
}

	public void setAccount(String account) {
 	this.account = account;
 }

	public String getPassword(){
return password;
}

	public void setPassword(String password) {
 	this.password = password;
 }

	public Sex getSex(){
return sex;
}

	public void setSex(Sex sex) {
 	this.sex = sex;
 }

	public String getPhone(){
return phone;
}

	public void setPhone(String phone) {
 	this.phone = phone;
 }

	public String getEmail(){
return email;
}

	public void setEmail(String email) {
 	this.email = email;
 }

	public Date getBirthdate(){
return birthdate;
}

	public void setBirthdate(Date birthdate) {
 	this.birthdate = birthdate;
 }

	public String getSign(){
return sign;
}

	public void setSign(String sign) {
 	this.sign = sign;
 }

	public String getHeadPhoto(){
return headPhoto;
}

	public void setHeadPhoto(String headPhoto) {
 	this.headPhoto = headPhoto;
 }

	public boolean getIsValid(){
return isValid;
}

	public void setIsValid(boolean isValid) {
 	this.isValid = isValid;
 }

	public Date getCreateTime(){
return createTime;
}

	public void setCreateTime(Date createTime) {
 	this.createTime = createTime;
 }

	public Date getUpdateTime(){
return updateTime;
}

	public void setUpdateTime(Date updateTime) {
 	this.updateTime = updateTime;
 }

}