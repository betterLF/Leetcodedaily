package Competition;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/5-8:43
 */
public class zhousai196 {
    /*
给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==1){
            return true;
        }
        int dif=arr[1]-arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]-arr[i-1]!=dif){
                return false;
            }
        }
        return true;
    }
    /*
有一块木板，长度为 n 个 单位 。一些蚂蚁在木板上移动，每只蚂蚁都以 每秒一个单位 的速度移动。其中，一部分蚂蚁向 左 移动，其他蚂蚁向 右 移动。
当两只向 不同 方向移动的蚂蚁在某个点相遇时，它们会同时改变移动方向并继续移动。假设更改方向不会花费任何额外时间。
而当蚂蚁在某一时刻 t 到达木板的一端时，它立即从木板上掉下来。
给你一个整数 n 和两个整数数组 left 以及 right 。两个数组分别标识向左或者向右移动的蚂蚁在 t = 0 时的位置。请你返回最后一只蚂蚁从木板上掉下来的时刻。
     */
    public int getLastMoment(int n, int[] left, int[] right) {
        if(left.length==0){
            Arrays.sort(right);
            return n-right[0];
        }else if(right.length==0){
            Arrays.sort(left);
            return left[left.length-1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
            return Math.max(n-right[0],left[left.length-1]);
    }

    /*
给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
     */
    public int numSubmat(int[][] mat) {
        if(mat.length==0){
            return 0;
        }
        int ans=0;
        for (int i = 0; i <mat.length; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                if(mat[i][j]==1) {
                    ans += getCurAns(mat, i, j);
                }
            }
        }
        return ans;
    }
    private int getCurAns(int [][]mat,int startRow,int startColumn){
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i = startRow; i <mat.length ; i++) {
            if(mat[i][startColumn]==0){//该行开头为0
                break;
            }
            int cur=1;
            for (int j = startColumn+1; j <mat[0].length ; j++) {
                if(mat[i][j]==0){
                    break;
                }
                cur++;
            }
            temp.add(cur);
        }
        int ans=temp.get(0);
        int target=temp.get(0);
        for (int i = 1; i <temp.size() ; i++) {
            if(temp.get(i)>=target){
                ans+=target;
            }else{
                ans+=temp.get(i);
                target=temp.get(i);
            }
        }
        return ans;
    }


}
