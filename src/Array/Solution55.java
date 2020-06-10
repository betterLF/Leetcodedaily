package Array;

/**
 * @authtor liFei
 * @date 2020/6/8-9:21
 */
public class Solution55 {
    /*
    给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
     */
    public static void main(String[] args) {
        int []a={0,1,1,1};
        canJump(a);
    }
    public static boolean canJump(int[] nums) {
        int len=nums.length;
        if(nums.length==1){
            return true;
        }
          int noAccess=len-1;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(i+noAccess>=len){//如果该点不可达，直接返回false
                return false;
            } else if(i+nums[i]>=len-1){
                return true;
            }else{
                noAccess=Math.min(noAccess,len-1-i-nums[i]);
            }
        }
        return false;
    }
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;//右边界
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {//如果i<=有边界，该点可达
                rightmost = Math.max(rightmost, i + nums[i]);//右边界更新
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
