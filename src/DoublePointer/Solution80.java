package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/25-8:58
 */
public class Solution80 {
    /*
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicates(int[] nums) {
        int ans=0;
            for (int i=0;i<nums.length;){
                if(i+2<nums.length&&nums[i]==nums[i+1]&&nums[i+1]==nums[i+2]){
                    nums[ans]=nums[i];
                    nums[ans+1]=nums[i+1];
                    ans+=2;
                    int temp=i+3;
                    while (temp<nums.length&&nums[temp]==nums[i]){
                        temp++;
                    }
                    i=temp;
                }else{
                    nums[ans]=nums[i];
                    ans++;
                    i++;
                }

            }
            return ans;
    }
}
