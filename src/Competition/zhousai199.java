package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @authtor liFei
 * @date 2020/7/26-10:18
 */
public class zhousai199 {
    /*
给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
返回重新排列后的字符串。
     */
    public String restoreString(String s, int[] indices) {
        if(s.length()==0){
            return "";
        }
        char []ans=new char[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            ans[indices[i]]=s.charAt(i);
        }
        return new String(ans);
    }
    /*
房间中有 n 个灯泡，编号从 0 到 n-1 ，自左向右排成一行。最开始的时候，所有的灯泡都是 关 着的。
请你设法使得灯泡的开关状态和 target 描述的状态一致，其中 target[i] 等于 1 第 i 个灯泡是开着的，等于 0 意味着第 i 个灯是关着的。
有一个开关可以用于翻转灯泡的状态，翻转操作定义如下：
选择当前配置下的任意一个灯泡（下标为 i ）
翻转下标从 i 到 n-1 的每个灯泡
翻转时，如果灯泡的状态为 0 就变为 1，为 1 就变为 0 。
返回达成 target 描述的状态所需的 最少 翻转次数。
     */
    public int minFlips(String target) {
         int curCount=0;//翻转次数
         int i=0;
         while (i<target.length()) {
             if ((curCount - (target.charAt(i) - '0')) % 2 == 0) {//如果当前翻转次数-当前值的结果取余为0，说明该点已经满足结果
                 i++;
             } else {//否则此时不满足结果。
                   curCount++;
             }
         }
         return curCount;
        }
    /*
给你二叉树的根节点 root 和一个整数 distance 。
如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
返回树中 好叶子节点对的数量 。
     */
//     public class TreeNode {
//     int val;
//      TreeNode left;TreeNode right;
//      TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }
//    private List<String> ans;
//    public int countPairs(TreeNode root, int distance) {
//     ans=new ArrayList<>();
//     if(root==null){
//         return 0;
//     }
//     dfs(root,"");
//     int res=0;
//        for (int i = 0; i <ans.size() ; i++) {
//            for (int j = i+1; j <ans.size() ; j++) {
//               String m=ans.get(i);
//               String n=ans.get(j);
//               int count=0;
//               while (count<m.length()&&count<n.length()){
//                   if(m.charAt(count)==n.charAt(count)){
//                       count++;
//                   }else{
//                       int curAns=2+m.length()-1-count+n.length()-1-count;
//                       if(curAns<=distance){
//                           res++;
//                       }
//                       break;
//                   }
//               }
//            }
//        }
//        return res;
//    }
//    private void dfs(TreeNode node,String cur){
//        if(node.left==null&&node.right==null){
//            ans.add(cur);
//            return;
//        }
//        if(node.left!=null){
//            dfs(node.left,new StringBuilder(cur).append(0).toString());
//        }
//        if(node.right!=null){
//            dfs(node.right,new StringBuilder(cur).append(1).toString());
//        }
//    }
    /*
    行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。
    例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
     */
    public static void main(String[] args) {
        getLengthOfOptimalCompression( "aabbaa",2);
    }
    public static int getLengthOfOptimalCompression(String s, int k) {
       int curCount=1;
       char pre=s.charAt(0);
       char []ss=s.toCharArray();
        Arrays.sort(ss);
       ArrayList<Integer> temp=new ArrayList<>();
        for (int i = 1; i <ss.length ; i++) {
            if(pre==ss[i]){
                curCount++;
            }else{
                temp.add(curCount);
                curCount=1;
                pre=ss[i];
            }
        }
         temp.add(curCount);
        Collections.sort(temp);
        while (k!=0&&temp.size()!=0){
           k=nowK(temp,k);
        }
        int res=0;
        for (int i = 0; i <temp.size() ; i++) {
            if(temp.get(i)==1){
                res++;
                continue;
            }
            if(temp.get(i)>=10){
                res+=3;
                continue;
            }
            if(temp.get(i)<10){
                res+=2;
                continue;
            }
        }
        return res;
}
private static int nowK(ArrayList<Integer> temp,int k){
        int curIndex=-1;
    for (int i = 0; i <temp.size() ; i++) {//如果当前结果中有1或者2，减去该数后长度少1位
        if(temp.get(i)==1||temp.get(i)==2){
            curIndex=i;
            break;
        }
    }
    if(curIndex!=-1) {
       if(temp.get(curIndex)==2){
           temp.set(curIndex,1);
       }else{
           temp.remove(curIndex);
       }
        k--;
        return k;
    }
    //没有1和2了
    int curMin=110;
    int Index=-1;
    for (int i = 0; i <temp.size() ; i++) {
           int c=temp.get(i);
           if(temp.get(i)<10){
               if(c-1<curMin){
                   curMin=c-1;
                   Index=i;
               }
           }else{
               if(c-9<curMin){
                   curMin=c-9;
                   Index=i;
               }
           }
    }
    if(k-curMin<0){//此时找不到可以的结果
        return 0;
    }
    if(temp.get(Index)<10){
        temp.set(Index,1);
    }else {
        temp.set(Index, 9);
    }
    return k-curMin;
}
    }
