package com.blog.cms.domain.bm;
import java.util.Date;
public class Comment{
	/**
	*
	*/
	private String guid;
	/**
	*
	*/
	private String content;
	/**
	*
	*/
	private int commentType;
	/**
	*
	*/
	private String postUser;
	/**
	*
	*/
	private String revicer;
	/**
	*
	*/
	private String additional;
	/**
	*
	*/
	private Date postDate;
	public String getGuid(){
return guid;
}

	public void setGuid(String guid) {
 	this.guid = guid;
 }

	public String getContent(){
return content;
}

	public void setContent(String content) {
 	this.content = content;
 }

	public int getCommentType(){
return commentType;
}

	public void setCommentType(int commentType) {
 	this.commentType = commentType;
 }

	public String getPostUser(){
return postUser;
}

	public void setPostUser(String postUser) {
 	this.postUser = postUser;
 }

	public String getRevicer(){
return revicer;
}

	public void setRevicer(String revicer) {
 	this.revicer = revicer;
 }

	public String getAdditional(){
return additional;
}

	public void setAdditional(String additional) {
 	this.additional = additional;
 }

	public Date getPostDate(){
return postDate;
}

	public void setPostDate(Date postDate) {
 	this.postDate = postDate;
 }

}