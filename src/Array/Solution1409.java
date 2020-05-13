package Array;

/**
 * @authtor liFei
 * @date 2020/5/11-13:31
 */
public class Solution1409 {
    /*
 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。
 请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
一开始，排列 P=[1,2,3,...,m]。
对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），然后将其从原位置移动到排列 P 的起始位置
（即下标为 0 处）。注意， queries[i] 在 P 中的位置就是 queries[i] 的查询结果。
请你以数组形式返回待查数组  queries 的查询结果。
     */
    public static void main(String[] args) {
        int []a={7,5,5,8,3};
        processQueries(a,8);
    }
    public static int[] processQueries(int[] queries, int m) {
              int n=queries.length;
              int map[]=new int[n+m+1];
              int index[]=new int[m+1];
              int count=1;
              int startIndex=n+1;//记录此时的开始索引位置
        for (int i = n+1; i <map.length ; i++) {
            map[i]=i-n;
            index[count]=i;
            count++;
        }
        int ans[]=new int[n];
        for (int i=0;i<n;i++){
           int curIndex= index[queries[i]];//获取当前元素在数组中的索引位置
            ans[i]=getSum(map,startIndex,curIndex);//求出当前元素前的元素个数，加入结果集中
            startIndex--;//开始索引前移
            map[startIndex]=queries[i];//开始索引处元素赋值为当前元素
            map[curIndex]=-1;//此元素之前位置值变为-1
            index[queries[i]]=startIndex;//更新此元素的索引
        }
        return ans;
    }
    private static int getSum(int[] map,int startIndex,int curIndex){
        int sum=0;
        for (int i=startIndex;i<curIndex;i++){
            if(map[i]!=-1){
                sum++;
            }
        }
        return sum;
    }
}
