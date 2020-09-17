package Tree;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/9/15-7:58
 */
public class Solution662 {
    /*

给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     */
//    public int widthOfBinaryTree(TreeNode root) {
//                if(root==null){
//                    return 0;
//                }
//                int ans=1;
//        Queue<TreeNode> queue=new ArrayDeque<>();
//        HashMap<TreeNode,Long> map=new HashMap<>();
//        queue.add(root);
//        map.put(root,(long)1);
//        int count=1;
//        while (!queue.isEmpty()){
//            long left=-1;
//            long right=-1;
//            int curCount=0;
//            while (count!=0){
//                TreeNode cur=queue.poll();
//                long len=map.get(cur);
//                if(cur.left!=null){
//                    queue.add(cur.left);
//                    curCount++;
//                    map.put(cur.left,2*len-1);
//                    if(left==-1){
//                        left=2*len-1;
//                    }else{
//                        right=2*len-1;
//                    }
//                }
//                if(cur.right!=null){
//                    queue.add(cur.right);
//                    curCount++;
//                    map.put(cur.right,2*len);
//                    if(left==-1){
//                        left=2*len;
//                    }else{
//                        right=2*len;
//                    }
//                }
//                count--;
//            }
//            count=curCount;
//            if(curCount>=2) {
//                ans = Math.max(ans, (int)(right - left + 1));
//            }
//        }
//        return ans;
//    }
    private int ans;
    private HashMap<Integer,Integer> map = new HashMap<>();
    private void dfs(TreeNode root,int level,int index){
        if (root == null){
            return;
        }
        if (! map.containsKey(level)){
            map.put(level,index);
        }
        ans = Math.max(ans,index-map.get(level)+1);
        dfs(root.left,level+1,index*2);
        dfs(root.right,level+1,index*2+1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,0);
        return ans;
    }
}
