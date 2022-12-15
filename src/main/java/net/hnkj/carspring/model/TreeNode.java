package net.hnkj.carspring.model;

import lombok.ToString;
import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
public class TreeNode implements Serializable {
    private Integer treeNodeId;

    private String treeNodeName;

    private Integer treeNodeType;

    private Integer parentNodeId;

    private String url;

    private Integer position;

    private String icon;

    //保存该节点下面的子节点
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(Integer treeNodeId, String treeNodeName, Integer treeNodeType, Integer parentNodeId, String url, Integer position, String icon) {
        this.treeNodeId = treeNodeId;
        this.treeNodeName = treeNodeName;
        this.treeNodeType = treeNodeType;
        this.parentNodeId = parentNodeId;
        this.url = url;
        this.position = position;
        this.icon = icon;
    }

    public TreeNode() {
        super();
    }

    public Integer getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Integer treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public String getTreeNodeName() {
        return treeNodeName;
    }

    public void setTreeNodeName(String treeNodeName) {
        this.treeNodeName = treeNodeName;
    }

    public Integer getTreeNodeType() {
        return treeNodeType;
    }

    public void setTreeNodeType(Integer treeNodeType) {
        this.treeNodeType = treeNodeType;
    }

    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
