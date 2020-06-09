package com.blog.cms.domain.system.menu;

import java.util.List;

public class MenuDto {
    /**
     * 菜单编号
     */
    private String id;
    /**
     * 菜单名字
     */
    private String title;
    /**
     * 链接
     */
    private String href;
    /**
     * 是否是根节点
     */
    private boolean isRootNode;
    /**
     * 上级菜单
     */
    private String parentNode;
    /**
     * 子节点
     */
    private List<MenuDto> children;
    /**
     * 是否属于叶子节点
     */
    private boolean isLeafNode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    public boolean isRootNode() {
        return isRootNode;
    }

    public void setRootNode(boolean rootNode) {
        isRootNode = rootNode;
    }


    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public List<MenuDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDto> children) {
        this.children = children;
    }
    public boolean isLeafNode() {
        return isLeafNode;
    }

    public void setLeafNode(boolean leafNode) {
        isLeafNode = leafNode;
    }

}
