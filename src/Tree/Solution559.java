package Tree;

import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/8-7:36
 */
public class Solution559 {
    /*
    给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
例如，给定一个 3叉树 :
     */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
    public int maxDepth(Node root) {
           if(root==null){
               return 0;
           }
           int ans=1;
        for(Node cur:root.children){
            ans=Math.max(ans,maxDepth(cur)+1);
        }
        return ans;
    }
}
