import java.util.Arrays;
import java.util.HashMap;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        */
/*
事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。
如果它存在，那我们已经找到了对应解，并立即将其返回。
时间复杂度：O(n)，
我们只遍历了包含有 n个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
空间复杂度：O(n)，
所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
 */
public class Solution1 {
    public static int[] twoNum(int nums[],int target){
        HashMap<Integer,Integer> number=new HashMap<Integer, Integer>();
        int result[]=new int[2];
       for(int i=0;i<nums.length;i++){
           if(number.containsKey(target-nums[i])){
                   result[0] = i;
                   result[1] = number.get(target - nums[i]);
                   return result;
               } else{
               number.put(nums[i],i);
           }
       }
       return result;
    }
}
