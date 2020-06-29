package	com.blog.cms.domain.leavemessage;
import java.util.Date;
public class LeaveMessage{
	/**
	*id
	*/
	private int Id;
	/**
	*留言内容
	*/
	private String Content;
	/**
	*联系邮箱
	*/
	private String ContractEmail;
	/**
	*是否已处理
	*/
	private boolean IsAction;
	/**
	*创建时间
	*/
	private Date CreateTime;
	public int getId(){
return Id;
}

	public void setId(int Id) {
 	this.Id = Id;
 }

	public String getContent(){
return Content;
}

	public void setContent(String Content) {
 	this.Content = Content;
 }

	public String getContractEmail(){
return ContractEmail;
}

	public void setContractEmail(String ContractEmail) {
 	this.ContractEmail = ContractEmail;
 }

	public boolean getIsAction(){
return IsAction;
}

	public void setIsAction(boolean IsAction) {
 	this.IsAction = IsAction;
 }

	public Date getCreateTime(){
return CreateTime;
}

	public void setCreateTime(Date CreateTime) {
 	this.CreateTime = CreateTime;
 }

}