package	com.blog.cms.domain.bm;
import com.blog.cms.domain.enums.ArticleType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
public class Article{
	/**
	*主键id
	*/
	private int id;
	/**
	*作者
	*/
	private String author;
	/**
	*标题
	*/
	private String title;
	/**
	*内容截取部分
	*/
	private String testSection;
	/**
	*正文
	*/
	private String content;
	/**
	*文章类型
	*/
	private ArticleType articleType;
	/**
	 *文章类型
	 */
	private String articleTypeText;
	/**
	*点赞数
	*/
	private int praiseCount;
	/**
	*浏览数
	*/
	private int browserCount;
	/**
	*是否草稿
	*/
	private boolean isDraft;
	/**
	*是否发送邮件
	*/
	private boolean isSendEmail;
	/**
	*创建时间
	*/
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	/**
	*更新时间
	*/
	private Date updateTime;
	public int getId(){
return id;
}

	public void setId(int id) {
 	this.id = id;
 }

	public String getAuthor(){
return author;
}

	public void setAuthor(String author) {
 	this.author = author;
 }

	public String getTitle(){
return title;
}

	public void setTitle(String title) {
 	this.title = title;
 }

	public String getTestSection(){
return testSection;
}

	public void setTestSection(String testSection) {
 	this.testSection = testSection;
 }

	public String getContent(){
return content;
}

	public void setContent(String content) {
 	this.content = content;
 }

	public ArticleType getArticleType(){
return articleType;
}

	public void setArticleType(ArticleType articleType) {
 	this.articleType = articleType;
 }

	public String getArticleTypeText() {
		return articleType.getText();
	}

	public int getPraiseCount(){
return praiseCount;
}

	public void setPraiseCount(int praiseCount) {
 	this.praiseCount = praiseCount;
 }

	public int getBrowserCount(){
return browserCount;
}

	public void setBrowserCount(int browserCount) {
 	this.browserCount = browserCount;
 }

	public boolean getIsDraft(){
return isDraft;
}

	public void setIsDraft(boolean isDraft) {
 	this.isDraft = isDraft;
 }

	public boolean getIsSendEmail(){
return isSendEmail;
}

	public void setIsSendEmail(boolean isSendEmail) {
 	this.isSendEmail = isSendEmail;
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