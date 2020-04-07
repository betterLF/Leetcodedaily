import java.util.Arrays;

public class Solution1051 {
/*
    学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
    请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
    注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 */
 public int heightChecker(int[] heights) {
   int count=0;
   int temp[]=new int[heights.length];
   for(int cur:heights){
       temp[count++]=cur;
   }
   count=0;//此时用于计算temp与排序好的heights在相同下标处不同元素的个数
     Arrays.sort(heights);
     for(int i=0;i<heights.length;i++){
         if(temp[i]!=heights[i]){
             count++;
         }
     }
     return count;
 }
    //别人的
    /*
 非递减 排序也就是升序排列，最直观的一种解法就是排序后对比计数每个位置的不同数量。
但是涉及到比较排序，时间复杂度最低也有 O(NlogN)。
我们真的需要排序吗？
首先我们其实并不关心排序后得到的结果，我们想知道的只是在该位置上，与最小的值是否一致
题目中已经明确了值的范围 1 <= heights[i] <= 100
这是一个在固定范围内的输入，比如输入： [1,1,4,2,1,3]
输入中有 3 个 1,1 个 2，1 个 3 和 1 个 4，3 个 1 肯定会在前面，依次类推
所以，我们需要的仅仅只是计数而已
     */
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {//只要arr[i]!=0,代表heights里面有i，而且这个i是按照递增排序的
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
