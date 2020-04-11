package Tree;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/4/11-10:44
 */
public class Solution654 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root=new TreeNode(0);
        constructTree(nums,root);
        return root;
    }
    private void constructTree(int[] nums,TreeNode target) {
        int max=nums[0];
        int maxIndex=0;
        for(int i=1;i<nums.length;i++){//找到最大值
            max=Math.max(nums[i],max);
            if(max==nums[i]){
                maxIndex=i;
            }
        }
        target.val=max;
        TreeNode temp=target;
        if(maxIndex-1>=0){
            target.left=new TreeNode(0);
            target=target.left;
            constructTree(Arrays.copyOfRange(nums,0,maxIndex),target);
        }
        if(nums.length-2-maxIndex>=0) {
            temp.right=new TreeNode(0);
            target = temp.right;
            constructTree(Arrays.copyOfRange(nums,maxIndex+1,nums.length),target);
        }
    }
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
         return constructTree2(nums,0,nums.length);
    }
    private TreeNode constructTree2(int[] nums,int left,int right) {
        if(left==right){
            return null;
        }
        int max=nums[left];
        int maxIndex=left;
        for(int i=left+1;i<right;i++){//找到最大值
            max=Math.max(nums[i],max);
            if(max==nums[i]){
                maxIndex=i;
            }
        }
        TreeNode root=new TreeNode(0);
          root.val=max;
          root.left= constructTree2(nums,left,maxIndex);
           root.right= constructTree2(nums, maxIndex+1, right);
           return root;
        }
    }

