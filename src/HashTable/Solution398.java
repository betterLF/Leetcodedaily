package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/7/15-6:25
 */
public class Solution398 {
    /*
    给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
     */
    //hashmap
    class Solution {
        HashMap<Integer, ArrayList<Integer>> map;
        public Solution(int[] nums) {
            map=new HashMap<>();
            for (int i = 0; i <nums.length ; i++) {
                if(map.containsKey(nums[i])){
                    map.get(nums[i]).add(i);
                }else{
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(i);
                    map.put(nums[i],list);
                }
            }
        }

        public int pick(int target) {
               int len=map.get(target).size();
               return map.get(target).get(new Random().nextInt(len));
        }
    }
    //蓄水池抽样
    class Solution_2 {
        private int[] nums;
        public Solution_2(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            Random r = new Random();
            int n = 0;
            int index = 0;
            for(int i = 0;i < nums.length;i++)
                if(nums[i] == target){
                    //我们的目标对象中选取。
                    n++;
                    //我们以1/n的概率留下该数据
                    if(r.nextInt() % n == 0) index = i;
                }
            return index;
        }
    }

}
