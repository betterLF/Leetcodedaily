package HashTable;

/**
 * @authtor liFei
 * @date 2020/8/25-7:47
 */
public class Solution645 {
    /*
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，
再找到丢失的整数，将它们以数组的形式返回。
     */
    public int[] findErrorNums(int[] nums) {
        int xor=0;
        int []hash=new int[nums.length+1];
        int first=-1;
        int index=-1;
        for (int i = 0; i <nums.length ; i++) {
            int cur=nums[i];
              xor^=(i+1)^nums[i];
              hash[cur]++;
              if(hash[cur]==2){
                  first=cur;
                  index=i+1;
                  break;
              }
        }
        for (int i = index; i <nums.length ; i++) {
            xor^=(i+1)^nums[i];
        }
        return new int[]{first,xor^first};
    }
}
