package Math;

/**
 * @authtor liFei
 * @date 2020/8/19-7:31
 */
public class Solution553 {
    /*
    给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。
你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
     */
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        if(nums.length == 1) return sb.toString();
        sb.append("/");
        if(nums.length == 2){
            sb.append(nums[1]);
            return sb.toString();
        }
        sb.append("(");
        for(int i = 1 ; i < nums.length ; i++){
            sb.append(nums[i]);
            sb.append("/");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return sb.toString();
    }

}
