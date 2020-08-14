package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/8/12-6:36
 */
public class Solution503 {
    /*
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     */
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
            int len=nums.length;
            int []ans=new int[len];
            int curIndex=0;
            int max=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(curIndex);
        max=nums[curIndex];
        curIndex++;
        while (curIndex!=len){//一遍遍历得到所有不循环时候的下一个最大元素
            while (!stack.isEmpty()&&nums[curIndex]>nums[stack.peek()]){
                int cur=stack.pop();
                ans[cur]=nums[curIndex];
            }
            stack.push(curIndex);
            max=Math.max(max,nums[curIndex]);
            curIndex++;
        }
        curIndex=0;
        while(curIndex<len&&!stack.isEmpty()){
            while (!stack.isEmpty()&&nums[stack.peek()]==max){
                int cur=stack.pop();
                ans[cur]=-1;
            }
            while (!stack.isEmpty()&&nums[curIndex]>nums[stack.peek()]){
                int cur=stack.pop();
                ans[cur]=nums[curIndex];
            }
            curIndex++;
        }
        return ans;
    }
}
