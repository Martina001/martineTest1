package leetcode.editor.cn.mystructure;

import java.util.HashMap;

/**
 * @author: Martina
 * @description:
 * @time: 2023/6/9
 */
// 拓展：直接设计一个二叉搜索树TreeNode，保存对应左子树的节点个数
// (这里直接用TreeNode和一个sizeMap就可以构成一个BiTreeNode了，下面的写法有点多余，纯属练习)
class BiTreeNode{
    private int val;
    private BiTreeNode left;
    private BiTreeNode right;
    // 保存以该节点为根的节点总数
    private int size;
    HashMap<BiTreeNode,Integer> sizeMap = new HashMap<>();

    public int getNodeNums(BiTreeNode root){
        return sizeMap.getOrDefault(root,0);
    }

    public BiTreeNode(BiTreeNode root){
        countSize(root);
        this.size = sizeMap.get(root);
    }

    private int countSize(BiTreeNode root){
        if(root == null) return 0;
        // 注意这里不要直接return countSize(root.left)+countSize(root.right)+1
        // 不然就相当于每个节点还是又算了一遍，起不到备忘录的作用了
        sizeMap.put(root,countSize(root.left)+countSize(root.right)+1);
        return sizeMap.get(root);
    }
}
