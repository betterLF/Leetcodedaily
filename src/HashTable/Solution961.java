package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/4/29-7:13
 */
public class Solution961 {
    /*
    在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
返回重复了 N 次的那个元素。
     */
    public int repeatedNTimes(int[] A) {
        HashMap<Integer,Integer> ans=new HashMap<>();
        for (int i=0;i<=A.length/2+1;i++){
            ans.put(A[i],ans.getOrDefault(A[i],0)+1);
        }
        for (Integer key:ans.keySet()){
            if(ans.get(key)!=1){
                return key;
            }
        }
        return -1;
    }
    public int repeatedNTimes2(int[] A) {

        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i + j < A.length) {
                    if (A[i] == A[i + j]) {
                        return A[i];
                    }
                }
            }
        }
        return 0;

    }
}
