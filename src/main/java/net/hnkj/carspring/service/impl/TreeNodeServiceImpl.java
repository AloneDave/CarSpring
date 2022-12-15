package net.hnkj.carspring.service.impl;


import net.hnkj.carspring.mapper.TreeNodeMapper;
import net.hnkj.carspring.model.TreeNode;
import net.hnkj.carspring.service.ITreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeServiceImpl implements ITreeNodeService {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public List<TreeNode> listTreeNode(TreeNode treeNode) {
        //查询一级节点
        List<TreeNode> treeNodes = treeNodeMapper.listTreeNode(treeNode);
        //遍历一级节点
        for (TreeNode node : treeNodes) {
            //获取一级节点的treeNodeId
//            Integer treeNodeId = node.getTreeNodeId();
            //通过一级节点的treeNodeId查询这个节点下的子节点
            List<TreeNode> treeNodes1 = treeNodeMapper.listTreeNodeByParentNodeId(node.getTreeNodeId());
            //将该节点下的子节点放入到一级节点的children属性中
            node.setChildren(treeNodes1);
        }

        return treeNodes;
    }
}
