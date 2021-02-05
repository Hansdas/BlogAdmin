package com.blog.cms.domain.system;
import java.util.Date;
public class Config{
	/**
	*主键id
	*/
	private int id;
	/**
	*key值
	*/
	private String key;
	/**
	*value值
	*/
	private String value;
	/**
	*创建时间
	*/
	private Date createtime;
	public int getId(){
return id;
}

	public void setId(int id) {
 	this.id = id;
 }

	public String getKey(){
return key;
}

	public void setKey(String key) {
 	this.key = key;
 }

	public String getValue(){
return value;
}

	public void setValue(String value) {
 	this.value = value;
 }

	public Date getCreatetime(){
return createtime;
}

	public void setCreatetime(Date createtime) {
 	this.createtime = createtime;
 }

}