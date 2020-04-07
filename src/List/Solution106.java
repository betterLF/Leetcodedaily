package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution106 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> res=new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
      while(head!=null){
          res.add(head.val);
          head=head.next;
      }
          return createTree(0,res.size()-1);
    }
    private TreeNode createTree(int begin,int end){
        if(begin>end){
            return null;
        }
        int mid=(begin+end)/2;
        TreeNode node=new TreeNode(res.get(mid));
        if(begin==end){
            return node;
        }
        node.left=createTree(begin,mid-1);
        node.right=createTree(mid+1,end);
        return node;
    }
}
