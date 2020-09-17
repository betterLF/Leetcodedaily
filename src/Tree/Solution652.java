package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/14-11:47
 */
public class Solution652 {
    /*
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
两棵树重复是指它们具有相同的结构以及相同的结点值。
     */
    HashMap<String,Integer> map;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map=new HashMap<>();
        ans=new ArrayList<>();
        return ans;
    }
    private String dfs(TreeNode cur){
        if(cur==null){
            return null;
        }
        String res=cur.val+","+dfs(cur.left)+","+dfs(cur.right);
          map.put(res,map.getOrDefault(res,0)+1);
          if(map.get(res)==2){
              ans.add(cur);
          }
        return res;
    }
}
