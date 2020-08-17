package HashTable;

import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/15-7:32
 */
public class Solution525 {
    /*
    给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
    */
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int ans=0;
        map.put(0,-1);
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==1){
                sum+=1;
            }else{
                sum+=-1;
            }
            if(map.containsKey(sum)){
                ans=Math.max(ans,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
