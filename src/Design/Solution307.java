package Design;

/**
 * @authtor liFei
 * @date 2020/7/5-7:42
 */
public class Solution307 {
    /*
    给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
     */
//    class NumArray {
//          int []update;
//          int []sum;
//          int []nums;
//        public NumArray(int[] nums) {
//            sum=new int[nums.length+1];
//            for (int i = 1; i <sum.length ; i++) {
//                 sum[i]=sum[i-1]+nums[i-1];
//            }
//            update=new int[nums.length+1];
//            this.nums=nums;
//        }
//
//        public void update(int i, int val) {
//                  update[i+1]=val-nums[i];
//        }
//
//        public int sumRange(int i, int j) {
//                int sumAll=0;
//                sumAll+=sum[j+1]-sum[i];
//            for (int k = i+1; k <=j+1 ; k++) {
//                sumAll+=update[k];
//            }
//            return sumAll;
//        }
//    }
    class NumArray {
        int []numTree;
        int n;
        public NumArray(int[] nums) {
              n=nums.length;
              if(n>=0) {
                  numTree = new int[2 * nums.length];
                  buildTree(nums);
              }

        }
        public void buildTree(int []nums){
            for (int i = n,j=0 ;j<n ; i++,j++) {//线段树最后n个数即为对应nums值
                numTree[i]=nums[j];
            }
            for (int i =n-1; i>=1 ; i--) {//构造线段树
                   numTree[i]=numTree[2*i]+numTree[2*i+1];
            }
        }
        public void update(int i, int val) {
            i+=n;//原数组值对应下标
            int dif=val-numTree[i];
            while (i>0){//更新所有和该值变化有关的元素之和
                numTree[i]+=dif;
                i/=2;
            }
        }
        public int sumRange(int i, int j) {
             i+=n;
             j+=n;
             int sum=0;
             while (i<=j){
                 if(i%2==1){//如果i为其父节点的右子节点，直接加上该值，i++使得下次的i下标对应区间大于该点对应的区间
                    sum+=numTree[i];
                    i++;
                 }
                 if(j%2==0){//如果j为其父节点的左子节点，直接加上该值，j--使得下次的j下标对应区间小于该点对应的区间
                     sum+=numTree[j];
                     j--;
                 }
                 i/=2;//如果i为左子节点，那就判断其父节点
                 j/=2;//如果j为右子节点，那就判断其父节点(极端情况下i和j对应区间刚好为所求区间，此时肯定会返回父节点值)
             }
             return sum;
        }
    }
}
