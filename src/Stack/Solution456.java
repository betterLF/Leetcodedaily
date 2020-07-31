package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/7/29-6:58
 */
public class Solution456 {
    /*
    给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
    设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
注意：n 的值小于15000。
     */
    public boolean find132pattern(int[] nums) {
          int len=nums.length;
          if(len<3){
              return false;
          }
          int []min=new int[len+1];
          min[0]=Integer.MAX_VALUE;
        for (int i = 1; i <len+1 ; i++) {
            min[i]=Math.min(min[i-1],nums[i-1]);
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums[len-1]);
        for (int i = len-2; i>=0 ; i--) {
            if(nums[i]>min[i]){
                while (!stack.isEmpty()&&stack.peek()<=min[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()&&stack.peek()<nums[i]){
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
