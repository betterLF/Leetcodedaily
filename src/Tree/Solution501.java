package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/8/4-7:31
 */
public class Solution501 {
    /*
    给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
假定 BST 有如下定义：
结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],
     */
    private List<Integer> ans;
    private int curSum;
    private int maxSum;
    private TreeNode pre;
    public int[] findMode(TreeNode root) {
         ans=new ArrayList<>();
         pre=new TreeNode(Integer.MAX_VALUE);
         curSum=0;
         maxSum=0;
         suffix(root);
        if (curSum == maxSum&&curSum!=0) {//如果前一个点和已知的最大长度相同并且不为0
            ans.add(pre.val);
        } else if (curSum > maxSum) {//大于最大长度
            ans.clear();
            ans.add(pre.val);
            maxSum=curSum;
        }
         int []res=new int[ans.size()];
        for (int i = 0; i <ans.size() ; i++) {
            res[i]=ans.get(i);
        }
        return res;
    }
    private void suffix(TreeNode cur){
        if(cur==null){
            return;
        }
            suffix(cur.left);
        if(cur.val==pre.val){
            curSum++;
        }else{//如果当前点和前面一个点不同
            //处理前一个点
                if (curSum == maxSum&&curSum!=0) {//如果前一个点和已知的最大长度相同并且不为0
                    ans.add(pre.val);
                } else if (curSum > maxSum) {//大于最大长度
                    ans.clear();
                    ans.add(pre.val);
                    maxSum=curSum;
                }
                curSum=1;//更新前驱结点
                pre=cur;
            }
            suffix(cur.right);

    }
}
