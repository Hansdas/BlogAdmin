package com.blog.cms.domain.devlop;
import java.util.Date;
public class Log{
	/**
	*生成日期
	*/
	private Date Date;
	/**
	*请求ip
	*/
	private String Request;
	/**
	*日志级别
	*/
	private String Level;
	/**
	*日志对象
	*/
	private String Logger;
	/**
	*	 错误消息
	*/
	private String Message;
	/**
	*异常信息
	*/
	private String Exception;
	public Date getDate(){
return Date;
}

	public void setDate(Date Date) {
 	this.Date = Date;
 }

	public String getRequest(){
return Request;
}

	public void setRequest(String Request) {
 	this.Request = Request;
 }

	public String getLevel(){
return Level;
}

	public void setLevel(String Level) {
 	this.Level = Level;
 }

	public String getLogger(){
return Logger;
}

	public void setLogger(String Logger) {
 	this.Logger = Logger;
 }

	public String getMessage(){
return Message;
}

	public void setMessage(String Message) {
 	this.Message = Message;
 }

	public String getException(){
return Exception;
}

	public void setException(String Exception) {
 	this.Exception = Exception;
 }

}