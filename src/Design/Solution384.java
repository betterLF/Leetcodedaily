package Design;

import java.util.Arrays;
import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/7/13-5:56
 */
public class Solution384 {
    /*
    打乱一个没有重复元素的数组。
     */
//    class Solution {
//         private int[] clone;
//         private int len;
//         ArrayList<Integer> index;
//        public Solution(int[] nums) {
//                clone= Arrays.copyOf(nums,nums.length);
//                len=nums.length;
//                index=new ArrayList<>();
//            for (int i = 0; i <len ; i++) {
//                index.add(i);
//            }
//        }
//
//        /** Resets the array to its original configuration and return it. */
//        public int[] reset() {
//              return clone;
//        }
//
//        //暴力
//        public int[] shuffle() {
//           int temp=len;
//           int []ans=new int[len];
//           ArrayList<Integer> arr=new ArrayList<>(index);
//            for (int i = 0; i <ans.length ; i++) {
//                int random=new Random().nextInt(len);
//                ans[i]=clone[arr.get(random)];
//                arr.remove(random);
//               temp--;
//            }
//            return ans;
//        }
//
//    }
    class Solution {
        private int[] clone;
        private int[] array;
        public Solution(int[] nums) {
            clone= nums;
             array=Arrays.copyOf(nums,nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return clone;
        }

        public void swap(int []array,int i,int j){
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
        }
        public int[] shuffle() {
            for (int i = 0; i <array.length ; i++) {
                swap(array,i,new Random().nextInt(array.length-i)+i);
            }
            return array;
        }

    }
}
