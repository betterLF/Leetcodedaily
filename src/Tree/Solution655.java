package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/14-12:08
 */
public class Solution655 {
    /*

在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
行数 m 应当等于给定二叉树的高度。
列数 n 应当总是奇数。
根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
每个未使用的空间应包含一个空的字符串""。
使用相同的规则输出子树。
     */
    public List<List<String>> printTree(TreeNode root) {
         List<List<String>> ans=new ArrayList<>();
         int height=getHeight(root);
         String [][]cur=new String[height][(1<<height)-1];
         for (String []c:cur){
             Arrays.fill(c,"");
         }
         dfs(root,0,cur[0].length,0,cur);
         for (String []c:cur){
             ans.add(Arrays.asList(c));
         }
         return ans;
    }
    private void dfs(TreeNode root,int left,int right,int depth,String[][] cur){
        if(root==null){
            return;
        }
        String []s=cur[depth];
        s[(left+right)/2]=""+root.val;
      dfs(root.left,left,(left+right)/2,depth+1,cur);
      dfs(root.right,(left+right+1)/2,right,depth+1,cur);
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
