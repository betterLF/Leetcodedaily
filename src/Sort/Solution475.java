package Sort;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/21-5:55
 */
public class Solution475 {
    /*

冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
说明:
给出的房屋和供暖器的数目是非负数且不会超过 25000。
给出的房屋和供暖器的位置均是非负数且不会超过10^9。
只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
所有供暖器都遵循你的半径标准，加热的半径也一样。
     */
    //双指针
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans=0;
        int curIndex=0;
        int len=heaters.length;
        for (int i = 0; i <houses.length ; i++) {
                int curValue=0;
                while (curIndex<len&&houses[i]>heaters[curIndex]){
                 curIndex++;
                }
                if(curIndex==len){
                    curValue=houses[i]-heaters[curIndex-1];
                }else if(curIndex!=0){
                    curValue=(int)Math.min(houses[i]-heaters[curIndex-1],heaters[curIndex]-houses[i]);
                }else{
                    curValue=heaters[curIndex]-houses[i];
                }
                ans=Math.max(ans,curValue);
            }
        return ans;
    }
    //二分查找
    public int findRadius_2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans=0;
        int curIndex=0;
        int len=heaters.length;
        for (int i = 0; i <houses.length ; i++) {
           ans=Math.max(ans,binarySearch(heaters,houses[i]));
        }
        return ans;
    }
    private int binarySearch(int []heaters,int house){
        int left=0;
        int right=heaters.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(house==heaters[mid]){
                return 0;
            }
            else if(house<heaters[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

        if(left>heaters.length-1){
            return house-heaters[heaters.length-1];
        }
        else if(right<0){
            return heaters[0]-house;
        }
        else{
            return Math.min((heaters[left]-house),(house-heaters[right]));
        }
    }

}
