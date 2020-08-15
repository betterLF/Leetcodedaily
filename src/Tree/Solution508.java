package Tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/13-6:28
 */
public class Solution508 {
    /*
    给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。
    一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     */
    HashMap<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
          map=new HashMap<>();
          if(root==null){
              return new int[0];
          }
          getSum(root);
        ArrayList<Integer> ans=new ArrayList<>();
          int curMaxCount=0;
        for (Integer key:map.keySet()){
             if(map.get(key)>curMaxCount){
                 ans.clear();
                 ans.add(key);
                 curMaxCount=map.get(key);
             }else if(map.get(key)==curMaxCount){
                 ans.add(key);
             }
        }
        int []res=new int[ans.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i]=ans.get(i);
        }
        return res;
    }
    private int getSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int curSum=root.val+getSum(root.left)+getSum(root.right);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        return curSum;
    }
}
