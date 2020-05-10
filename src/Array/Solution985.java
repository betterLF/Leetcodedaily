package Array;

/**
 * @authtor liFei
 * @date 2020/5/9-7:30
 */
public class Solution985 {
    /*
给出一个整数数组 A 和一个查询数组 queries。
对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。
然后，第 i 次查询的答案是 A 中偶数值的和。
（此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int ans[]=new int[queries.length];
            int sum=0;
        for (int i = 0; i <A.length ; i++) {
            if(A[i]%2==0){
                sum+=A[i];
            }
        }
        for (int i=0;i<queries.length;i++){
            int temp=A[queries[i][1]];
            if(temp%2==0){
                if((temp+queries[i][0])%2==0){
                    ans[i]=sum+queries[i][0];
                    sum+=queries[i][0];
                }else{
                    ans[i]=sum-temp;
                    sum-=temp;
                }
            }else{
                if((temp+queries[i][0])%2==0){
                    ans[i]=sum+queries[i][0]+temp;
                    sum+=queries[i][0]+temp;
                }else{
                    ans[i]=sum;
                }
            }
            A[queries[i][1]]+=queries[i][0];
        }
        return ans;
    }
}
