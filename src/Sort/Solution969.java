package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/4/18-9:23
 */
public class Solution969 {
    /*
    给定数组 A，我们可以对其进行煎饼翻转：我们选择一些正整数 k <= A.length，然后反转 A 的前 k 个元素的顺序。
    我们要执行零次或多次煎饼翻转（按顺序一次接一次地进行）以完成对数组 A 的排序。
返回能使 A 排序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * A.length 范围内的有效答案都将被判断为正确。
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res=new ArrayList<>();
        int count=A.length-1;
        for(int i=0;i<A.length;i++){
            int max=maxValue(A,count);
            if(max!=count){//如果最大值所在下标不为它应该处于的位置，就进行翻转
                reverseArr(A,max);//对最大值所在元素下标处进行翻转，使得最大值到达数组首部
                res.add(max+1);//翻转的元素个数为下标加一
                reverseArr(A,count);//翻转到数组尾部
                res.add(count+1);
            }
            count--;
        }
        return res;
    }

    /**
     *
     * @param A 要翻转的数组
     * @param k 前k+1项进行翻转
     */
    private void reverseArr(int []A,int k){
        for (int i = 0; i <=k/2 ; i++) {
            int temp=A[i];
            A[i]=A[k-i];
            A[k-i]=temp;
        }
    }

    /**
     *
     * @param A 求最大值的数组
     * @param k 前k+1项最大值
     * @return  返回最大值所在下标
     */
    private int maxValue(int []A,int k){
        int index=0;
        int max=A[0];
        for (int i = 1; i <=k; i++) {
            if(max<A[i]){
                max=A[i];
                index=i;
            }
        }
        return index;
    }
}
