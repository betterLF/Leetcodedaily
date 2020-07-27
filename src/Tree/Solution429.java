package Tree;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/7/24-16:22
 */
public class Solution429 {
    /*
    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
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
    public List<List<Integer>> levelOrder(Node root) {
               List<List<Integer>> ans=new ArrayList<>();
               if(root==null){
                   return ans;
               }
               Queue<Node> queue=new ArrayDeque<>();
               queue.add(root);
               ArrayList<Integer> cur=new ArrayList<>();
               int count=1;
               int nextCount=0;
               while (!queue.isEmpty()){
                   Node curNode=queue.poll();
                   cur.add(curNode.val);
                   count--;
                   for (Node node:curNode.children){
                       queue.add(node);
                       nextCount++;
                   }
                   if(count==0){
                       ans.add(new ArrayList<>(cur));
                       cur.clear();
                       count=nextCount;
                       nextCount=0;
                   }
               }
               return ans;
    }
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder2(Node root) {
        levelOrderCore(root, 0);
        return ans;
    }

    public void levelOrderCore(Node root, int level) {
        if (root == null) return;
        if (level == ans.size()) {
            ans.add(new LinkedList<>());
        }
        ans.get(level).add(root.val);
        for(Node n : root.children) {
            levelOrderCore(n, level+1);
        }
    }
}
