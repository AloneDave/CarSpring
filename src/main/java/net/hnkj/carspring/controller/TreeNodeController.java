package net.hnkj.carspring.controller;

import net.hnkj.carspring.model.TreeNode;
import net.hnkj.carspring.service.ITreeNodeService;
import net.hnkj.carspring.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin
public class TreeNodeController {

    @Autowired
    private ITreeNodeService treeNodeService;

    @RequestMapping("/listMenu")
    public JsonData listTreeNode(TreeNode treeNode){
        JsonData jsonData = new JsonData();
        List<TreeNode> treeNodes = treeNodeService.listTreeNode(treeNode);
        jsonData.setCode(1);
        jsonData.setMessage("菜单初始化成功");
        jsonData.setRows(treeNodes);
        return jsonData;
    }


}
