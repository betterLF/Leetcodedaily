public class Solution106 {
    /*
    根据一棵树的中序遍历与后序遍历构造二叉树。
     */

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
          TreeNode(int x) { val = x; }
     }
    public TreeNode res=new TreeNode(0);
    public TreeNode temp=res;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length-1<0){
            if(res.val==0){
                return null;
            }
            return res;
        }
        int key=postorder[postorder.length-1];
        temp.val=key;
        TreeNode temp2=temp;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==key) {
                if (i - 1 >= 0) {
                    temp.left = new TreeNode(0);
                    temp = temp.left;
                    buildTree(copy(inorder, 0, i - 1), copy(postorder, 0, i - 1));
                }
                if (inorder.length - 2 - i >= 0) {
                    temp2.right = new TreeNode(0);
                    temp = temp2.right;
                    buildTree(copy(inorder, i + 1, inorder.length - 1), copy(postorder, i, postorder.length - 2));
                }
                break;
            }

        }
        return res;
    }
    private int[] copy(int nums[],int i,int j){
        int ans[]=new int[j-i+1];
        for(int k=0;k<ans.length;k++){
            ans[k]=nums[i++];
        }
        return ans;
    }
    //法2，不用数组，但思路一样
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        create(inorder,postorder,0,0,inorder.length);
        return res;
    }

    /**
     *
     * @param inorder
     * @param postorder
     * @param m
     * @param n postorder的起始索引
     * @param len 两个数组的长度
     * @return
     */
  private TreeNode create(int[] inorder, int[] postorder,int m,int n,int len ) {
        if(len-1<0){
            if(res.val==0){
                return null;
            }
            return res;
        }
        int key=postorder[n+len-1];
        temp.val=key;
        TreeNode temp2=temp;
        for(int i=m;i<m+len;i++){
            if(inorder[i]==key) {
                if (i - m >0) {
                    temp.left = new TreeNode(0);
                    temp = temp.left;
                   create(inorder, postorder, m,n,i-m);
                }
                if (len-i+m-1> 0) {
                    temp2.right = new TreeNode(0);
                    temp = temp2.right;
                    create(inorder, postorder, i+1,n+i-m,len-i+m-1);
                }
                break;
            }

        }
        return res;
    }
    }

