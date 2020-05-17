package Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/5/16-8:38
 */
public class Solution697 {
    /*
    给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> a=new ArrayList<>();
        int max=0;
        for (Integer key:map.keySet()){
            if(map.get(key)>max){
                a.clear();
                a.add(key);
                max=map.get(key);
            }else if(map.get(key)==max){
                a.add(key);
            }
        }
        int min=65535;
        for (int i=0;i<a.size();i++){
            int left=0;
            int right=nums.length-1;
            int target=a.get(i);
            while (nums[left]!=target){
                left++;
            }
            while (nums[right]!=target){
                right--;
            }
            min=Math.min(min,right-left+1);
        }
        return min;
    }
    public int findShortestSubArray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int[] map = new int[max - min + 1];
        int maxCount = Integer.MIN_VALUE;
        for (int num : nums) {
            map[num - min]++;
            if (map[num - min] > maxCount)
                maxCount = map[num - min];
        }

        if (maxCount == 1) return maxCount;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == maxCount) {
                int target = i + min, left = 0, right = nums.length - 1;
                while (left < right && nums[left] != target) left++;
                while (left < right && nums[right] != target) right--;
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans;
    }
}
