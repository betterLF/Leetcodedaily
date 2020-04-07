import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;
//同78，方法不同
/*
幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。  说明：解集不能包含重复的子集。
 */
public class Solution0804ms {
    public static List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> res = new LinkedList<>();
        int count = (int) Math.pow(2, nums.length) - 1;
        for (int i = count; i >= 0; i--) {
            List<Integer> arr = new ArrayList<Integer>();
            String s=toBinary(i,nums.length);
            for(int m=0;m<nums.length;m++){
                if(s.charAt(m)=='1'){
                    arr.add(nums[m]);
                }
            }
            res.add(arr);
        }
        return res;
    }
    private static String toBinary(int count,int length){
        StringBuilder s=new StringBuilder();
        while(count>0){
            s.append(count%2);
            count/=2;
        }
        while(s.length()!=length){
            s.append(0);
        }
        s.reverse();
        return s.toString();
    }
    //位运算的解法！！重点！
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int) Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);//（i>>>j)每一次右移最低位，如果此时最低位为1，
                                                            // 则与1&，结果为1，代表此时nums[i]对应真值为1
            subsets.add(subset);
        }
        return subsets;
    }
}
