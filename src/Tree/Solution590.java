package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/11-6:56
 */
public class Solution590 {
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
    public List<Integer> postorder(Node root) {
         List<Integer> ans=new ArrayList<>();
         if(root==null){
             return ans;
         }
         dfs(root,ans);
         return ans;
    }
    private void dfs(Node cur,List<Integer> ans){
        if(cur==null){
            return;
        }
      for (Node c:cur.children){
          dfs(c,ans);
      }
      ans.add(cur.val);
    }
    public List<Integer> postorder2(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);//将首结点加入栈中
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);//将当前结果加入结果集
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
