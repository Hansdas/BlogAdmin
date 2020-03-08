package	com.blog.cms.domain.menu;
import java.util.Date;
public class Menu{
	/**
	*主键id
	*/
	private int id;
	/**
	*编号
	*/
	private String number;
	/**
	*节点名称
	*/
	private String nodeName;
	/**
	*路径
	*/
	private String nodePath;
	/**
	*根节点
	*/
	private String rootNode;
	/**
	*是否根节点
	*/
	private boolean isRootNode;
	/**
	*是否叶子节点
	*/
	private boolean isLeafNode;
	/**
	*父节点
	*/
	private String parentNode;
	/**
	*父节点名称
	*/
	private String parentNodeNumber;
	/**
	*创建时间
	*/
	private Date createTime;
	public int getId(){
return id;
}

	public void setId(int id) {
 	this.id = id;
 }

	public String getNumber(){
return number;
}

	public void setNumber(String number) {
 	this.number = number;
 }

	public String getNodeName(){
return nodeName;
}

	public void setNodeName(String nodeName) {
 	this.nodeName = nodeName;
 }

	public String getNodePath(){
return nodePath;
}

	public void setNodePath(String nodePath) {
 	this.nodePath = nodePath;
 }

	public String getRootNode(){
return rootNode;
}

	public void setRootNode(String rootNode) {
 	this.rootNode = rootNode;
 }

	public boolean isRootNode(){
return isRootNode;
}

	public void setIsRootNode(boolean isRootNode) {
 	this.isRootNode = isRootNode;
 }

	public boolean isLeafNode(){
return isLeafNode;
}

	public void setIsLeafNode(boolean isLeafNode) {
 	this.isLeafNode = isLeafNode;
 }

	public String getParentNode(){
return parentNode;
}

	public void setParentNode(String parentNode) {
 	this.parentNode = parentNode;
 }

	public String getParentNodeNumber(){
return parentNodeNumber;
}

	public void setParentNodeNumber(String parentNodeNumber) {
 	this.parentNodeNumber = parentNodeNumber;
 }

	public Date getCreateTime(){
return createTime;
}

	public void setCreateTime(Date createTime) {
 	this.createTime = createTime;
 }

}