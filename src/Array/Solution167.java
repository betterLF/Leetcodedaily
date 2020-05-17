package Array;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/16-8:18
 */
public class Solution167 {
    /*
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> temp=new HashMap<>();
        int []ans={0,0};
        for (int i = 0; i <numbers.length ; i++) {
            temp.put(numbers[i],i);
        }
        for (int i = 0; i <numbers.length ; i++) {
            if(temp.containsKey(target-numbers[i])){
                ans[0]=i+1;
                ans[1]=temp.get(target-numbers[i])+1;
                break;
            }
        }
        return ans;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        int ans[]=new int[2];
        while (true){
            if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                ans[0]=i+1;
                ans[1]=j+1;
                break;
            }
        }
        return ans;
    }
}
