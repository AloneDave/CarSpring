package net.hnkj.carspring.service;

import net.hnkj.carspring.model.TreeNode;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ITreeNodeService {

    //查询一级节点
    @Transactional(readOnly = true)
    List<TreeNode> listTreeNode(TreeNode treeNode);

   }