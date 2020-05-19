package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/5/18-8:00
 */
public class Solution228 {
    /*
    给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if(nums.length==0){
            return ans;
        }
        int pre=nums[0];
        int count=1;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]-count==pre){
                count++;
            }else{
                if(count==1){
                    ans.add(Integer.toString(pre));
                }else{
                    ans.add(""+pre+"->"+(pre+count-1));
                    ans.add(new StringBuilder().append(pre).append("->").append(pre+count-1).toString());
                }
                pre=nums[i];
                count=1;
            }
        }
        if(count==1){
            ans.add(Integer.toString(pre));
        }else{
            ans.add(new StringBuilder().append(pre).append("->").append(pre+count-1).toString());
        }
        return ans;
    }

}
