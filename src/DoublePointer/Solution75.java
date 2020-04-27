package DoublePointer;

/**
 * @authtor liFei
 * @date 2020/4/18-10:06
 */
public class Solution75 {
    /*
    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */
    public void sortColors(int[] nums) {
      int arr[]=new int[3];
        for (int i = 0; i <nums.length ; i++) {
            arr[nums[i]]++;
        }
        int count=0;
        for(int i=0;i<3;i++){
            while (arr[i]!=0){
                nums[count++]=i;
                arr[i]--;
            }
        }
    }
    public void sortColors2(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}
