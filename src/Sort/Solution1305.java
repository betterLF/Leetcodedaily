package Sort;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/15-10:13
 */
public class Solution1305 {
    /*
给你 root1 和 root2 这两棵二叉搜索树。
请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
     */
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
   }
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> arr1=new ArrayList<>();
            List<Integer> arr2=new ArrayList<>();
            infix(root1,arr1);
            infix(root2,arr2);
            return sort(arr1,arr2);
    }
    private void infix(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        infix(root.left,arr);
        arr.add(root.val);
        infix(root.right,arr);
    }
    private List<Integer>  sort(List<Integer> arr1,List<Integer> arr2){//用数组更快
               List<Integer> ans=new ArrayList<>();
               int len1=arr1.size();
               int len2=arr2.size();
               int cur1=0;
               int cur2=0;
               while(cur1<len1&&cur2<len2){
                   int num1=arr1.get(cur1);
                   int num2=arr2.get(cur2);
                   if(num1<=num2){
                       ans.add(num1);
                       cur1++;
                   }else{
                       ans.add(num2);
                       cur2++;
                   }
               }
                   while(cur2!=len2){
                       ans.add(arr2.get(cur2++));
                   }
                   while(cur1!=len1){
                       ans.add(arr1.get(cur1++));
               }
               return ans;
    }
}
