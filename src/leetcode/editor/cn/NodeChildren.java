package leetcode.editor.cn;

import java.util.List;

/**
 * @author: Martina
 * @description:
 * @time: 2023/6/13
 */
public class NodeChildren {
    public int val;
    public List<NodeChildren> children;

    public NodeChildren() {}

    public NodeChildren(int _val) {
        val = _val;
    }

    public NodeChildren(int _val, List<NodeChildren> _children) {
        val = _val;
        children = _children;
    }
}
