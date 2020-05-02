package Greedy;

/**
 * @authtor liFei
 * @date 2020/4/30-10:14
 */
public class Solution944 {
    /*
    你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
比如，有 A = ["abcdef", "uvwxyz"]，
要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
     */
    public int minDeletionSize(String[] A) {
             int ans=0;
             for (int i=0;i<A[0].length();i++){
                   for (int j=0;j<A.length-1;j++){
                       if(A[j].charAt(i)>A[j+1].charAt(i)){
                           ans++;
                           break;
                       }
                   }
             }
             return ans;
    }
}
