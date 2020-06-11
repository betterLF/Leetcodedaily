package Math;

import java.util.LinkedList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/6/8-18:48
 */
public class Solution60 {
    /*
    给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
     */
    public static int[] counts=new int[9];//下标代表n为i是的排列总和
    static {
        counts[0]=1;
        counts[1] = 1;
        for (int i = 2; i < 9; i++) {
            counts[i] = i * counts[i - 1];
        }
    }

    public static String getPermutation(int n, int k) {
        List<Integer> curNum=new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            curNum.add(i);
        }
        StringBuilder ans=new StringBuilder();
        int count=n-1;
        while (!curNum.isEmpty()){//只要存入的集合不为空，说明元素未取完，继续取
            int curRemoveIndex=k%counts[count]==0?k/counts[count]:k/counts[count]+1;
            ans.append(curNum.remove(curRemoveIndex-1));
            k-=(curRemoveIndex-1)*counts[count];
            if(k==0){
                for (int i = 0; i <curNum.size() ; i++) {
                    ans.append(curNum.get(i));
                }
                break;
            }
            count--;
        }
        return ans.toString();
    }
}
