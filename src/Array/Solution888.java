package Array;

/**
 * @authtor liFei
 * @date 2020/5/14-18:01
 */
public class Solution888 {
    /*
爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
如果有多个答案，你可以返回其中任何一个。保证答案存在。
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int total_a=0;
        int total_b=0;
        //HashSet<Integer> b=new HashSet<>();
        int []count=new int[100001];
        for (int i = 0; i <A.length ; i++) {
            total_a+=A[i];
        }
        for (int i = 0; i <B.length ; i++) {
            total_b+=B[i];
            //b.add(B[i]);
            count[B[i]]++;
        }
        int val=(total_a+total_b)/2-total_a;
        int ans[]=new int[2];
        for (int i = 0; i <A.length ; i++) {
            //if(b.contains(A[i]+val)){
            int temp=A[i]+val;
            if((temp>=1&&temp<=100000)&&count[temp]!=0){
                ans[0]=A[i];
                ans[1]=temp;
                return ans;
            }
        }
        return ans;
    }
}
