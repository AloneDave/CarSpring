package net.hnkj.carspring.mapper;

import net.hnkj.carspring.model.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeNodeMapper {
    //查询一级节点
    List<TreeNode> listTreeNode(TreeNode treeNode);

    //查询节点下的子节点
    List<TreeNode> listTreeNodeByParentNodeId(Integer parentNodeId);
}