package Competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/6/28-10:26
 */
public class zhousai195 {
    /*
给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
     */
    class xoy{
        int x;
        int y;

        public xoy(int a,int b) {
        x=a;
        y=b;
        }
    }
    public boolean isPathCrossing(String path) {
              char []c=path.toCharArray();
        HashSet<xoy> set=new HashSet<>();
        set.add(new xoy(0,0) );
        int x=0;
        int y=0;
        for (int i = 0; i <c.length ; i++) {
            if(c[i]=='N'){
                y++;
            }else if(c[i]=='S'){
                y--;
            }else if(c[i]=='E'){
                x++;
            }else{
                x--;
            }
            xoy cur=new xoy(x,y);
            if(set.contains(cur)){
                return true;
            }else{
                set.add(cur);
            }
        }
        return false;
    }
    public boolean isPathCrossing2(String path) {
        char []c=path.toCharArray();
        int x=0;
        int y=0;
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        map.put(0,new ArrayList<>());
        map.get(0).add(0);
        for (int i = 0; i <c.length ; i++) {
            if(c[i]=='N'){
                y++;
            }else if(c[i]=='S'){
                y--;
            }else if(c[i]=='E'){
                x++;
            }else{
                x--;
            }
             if(map.containsKey(x)){
                 if(map.get(x).contains(y)){
                     return true;
                 }else{
                     map.get(x).add(y);
                 }
             }else{
                 map.put(x,new ArrayList<>());
                 map.get(x).add(y);
             }
        }
        return false;
    }

    /*
给你一个整数数组 arr 和一个整数 k ，其中数组长度是偶数，值为 n 。
现在需要把数组恰好分成 n / 2 对，以使每对数字的和都能够被 k 整除。
如果存在这样的分法，请返回 True ；否则，返回 False 。
     */
    public boolean canArrange(int[] arr, int k) {
        int freq[]=new int[k];
        for(int i=0;i<arr.length;i++){
            freq[(arr[i]%k+k)%k]++; //负余数需要变为正数，配对效果相同且判断简单，统一为[0,k-1]
        }
        for(int i=1;i<k;i++){//如果相加和为k的数不相等，直接返回false
            if(freq[i]!=freq[k-i]) return false;
        }
        if(freq[0]%2!=0) return false;  //余数为0需要单独处理，因为0!=k-0条件不适用，
        return true;
    }


    /*
给你一个整数数组 nums 和一个整数 target 。
请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
由于答案可能很大，请将结果对 10^9 + 7 取余后返回。
     */
    public static void main(String[] args) {
        int a[]={27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22};
        System.out.println(numSubseq(a,31));
    }
    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] pow = new int[nums.length];
        pow[0] = 1;
        int mode = 1000000007;
        for (int i = 1; i < nums.length; i ++) {
            pow[i] = pow[i-1] * 2;
            pow[i] %= mode;
        }
        long sum=0;
        for (int i = 0,j=nums.length-1; i <nums.length ; i++) {
            if(i>j){
                break;
            }
            while (i<=j&&nums[i]+nums[j]>target){
                j--;
            }
            if(j<i){
                break;
            }
            sum+=pow[j-i];
            sum%=(long)(Math.pow(10,9)+7);
        }
        return (int)sum;
    }

}
