package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/7/28-8:01
 */
public class Solution454 {
    /*
    给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     */
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer,Integer> ab=new HashMap();
            HashMap<Integer,Integer> cd=new HashMap<>();
            int ans=0;
            for (int i = 0; i <A.length ; i++) {
                for (int j = 0; j <B.length ; j++) {
                    int cur=A[i]+B[j];
                    ab.put(cur,ab.getOrDefault(cur,0)+1);
                }
            }
            for (int i = 0; i <C.length ; i++) {
                for (int j = 0; j <D.length ; j++) {
                    int cur=C[i]+D[j];
                    cd.put(cur,cd.getOrDefault(cur,0)+1);
                }
            }
             for (Integer key:ab.keySet()){
                 if(cd.containsKey(-key)){
                     ans+=ab.get(key)*cd.get(-key);
                 }
             }
            return ans;
        }
    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> ab=new HashMap();
        int ans=0;
        for (int i = 0; i <A.length ; i++) {
            for (int j = 0; j <B.length ; j++) {
                int cur=A[i]+B[j];
                ab.put(cur,ab.getOrDefault(cur,0)+1);
            }
        }
        for (int i = 0; i <C.length ; i++) {
            for (int j = 0; j <D.length ; j++) {
                int cur=C[i]+D[j];
               if(ab.containsKey(-cur)){
                   ans+=ab.get(-cur);
               }
            }
        }
        return ans;
    }
}
