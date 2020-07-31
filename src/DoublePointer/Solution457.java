package DoublePointer;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/7/29-7:24
 */
public class Solution457 {
    /*
    给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，
    如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，
    所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。
此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
     */
    public boolean circularArrayLoop(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if(set.contains(i)){//如果该点被访问过，直接跳过
                continue;
            }
            int pre=nums[i];//表示当前方向
            int curIndex=i;//表示当前遍历到的结果
            HashSet<Integer> cc=new HashSet<>();
            cc.add(i);
            while (true){
                int preIndex=curIndex;
                if(nums[curIndex]*pre<0){//说明方向不同
                    break;
                }
                //得到下一个到达的点
                int cur=curIndex+nums[curIndex];
                if(nums[curIndex]<0){
                    if(cur>=0){
                        curIndex=cur;
                    }else{
                        curIndex=nums.length+cur;
                        while (curIndex<0){
                            curIndex+=nums.length;
                        }
                    }
                }else{
                    if(cur<nums.length){
                        curIndex=cur;
                    }else{
                        curIndex=nums.length+cur;
                        while (curIndex>nums.length){
                            curIndex-=nums.length;
                        }
                    }
                }
                if(cc.contains(curIndex)){//如果该点在当前遍历过的点中已经出现过而且循环不为1
                    if(preIndex!=curIndex) {
                        return true;
                    }else{
                        break;
                    }
                }
                cc.add(curIndex);
                set.add(curIndex);//标记该点已经访问过
            }
            set.add(i);//标记出发点已经访问
        }
        return false;
    }
}
