package com.blog.cms.domain.bm;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class LeaveMessage{
	/**
	*主键id
	*/
	private int id;
	/**
	*内容
	*/
	private String content;
	/**
	*联系邮箱
	*/
	private String contractEmail;
	/**
	*是否处理
	*/
	private boolean isAction;
	/**
	*创建时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	public int getId(){
return id;
}

	public void setId(int Id) {
 	this.id = Id;
 }

	public String getContent(){
return content;
}

	public void setContent(String Content) {
 	this.content = Content;
 }

	public String getContractEmail(){
return contractEmail;
}

	public void setContractEmail(String ContractEmail) {
 	this.contractEmail = ContractEmail;
 }

	public boolean getIsAction(){
return isAction;
}

	public void setIsAction(boolean IsAction) {
 	this.isAction = IsAction;
 }

	public Date getCreateTime(){
return createTime;
}

	public void setCreateTime(Date CreateTime) {
 	this.createTime = CreateTime;
 }

}