package com.blog.cms.domain.menu;

import java.util.Date;

public class Menu {
    private int id;
    private String number;
    private String nodeName;
    private  String nodePath;
    private String rootNode;
    private boolean isRootNode;
    private boolean isLeafNode;
    private String parentNode;
    private String parentNodeNumber;
    private Date createTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
