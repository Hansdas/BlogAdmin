package com.blog.cms.domain.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Menu {
    /**
     * id
     */
    private int id;
    /**
     * 排序
     */
    private int Order;
    /**
     * 菜单编码
     */
    private String number;
    /**
     * 菜单名称
     */
    private String nodeName;
    /**
     * 菜单路径
     */
    private  String nodePath;
    /**
     * 根路径
     */
    private String rootNode;
    /**
     * 是否属于根节点
     */
    private boolean isRootNode;
    /**
     * 是否属于叶子节点
     */
    private boolean isLeafNode;
    /**
     * 父节点名称
     */
    private String parentNode;
    /**
     * 父节点编码
     */
    private String parentNodeNumber;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getOrder() {
        return Order;
    }

    public void setOrder(int order) {
        Order = order;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodePath() {
        return nodePath;
    }

    public void setNodePath(String nodePath) {
        this.nodePath = nodePath;
    }

    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }

    public boolean getIsRootNode() {
        return isRootNode;
    }

    public void setIsRootNode(boolean rootNode) {
        isRootNode = rootNode;
    }

    public boolean getIsLeafNode() {
        return isLeafNode;
    }

    public void setIsLeafNode(boolean leafNode) {
        isLeafNode = leafNode;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getParentNodeNumber() {
        return parentNodeNumber;
    }

    public void setParentNodeNumber(String parentNodeNumber) {
        this.parentNodeNumber = parentNodeNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
