package Backtracking;

/**
 * @authtor liFei
 * @date 2020/8/17-7:05
 */
public class Solution526 {
    /*
    假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，
    使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
    第 i 位的数字能被 i 整除
    i 能被第 i 位上的数字整除
    现在给定一个整数 N，请问可以构造多少个优美的排列？
     */
//    public int ans;
//    public int countArrangement(int N) {
//        ans=0;
//        ArrayList<Integer> arr=new ArrayList<>();
//        for (int i = 1; i <=N ; i++) {
//            arr.add(i);
//        }
//        dfs(arr,1,N);
//        return ans;
//    }
//    private void dfs(ArrayList<Integer> arr,int curN,int N){
//        if(curN==N+1){
//            ans++;
//            return;
//        }
//        for (int i = 0; i <arr.size() ; i++) {
//            if(arr.get(i)%curN==0||curN%arr.get(i)==0){
//                int cur=arr.get(i);
//                arr.remove(i);
//                dfs(arr,curN+1,N);
//                arr.add(i,cur);
//            }
//        }
//    }
    public int ans;
    private boolean isVisited[];
    public int countArrangement(int N) {
        ans=0;
         isVisited=new boolean[N];
        dfs(isVisited,1,N);
        return ans;
    }
    private void dfs(boolean []arr,int curN,int N){
        if(curN==N+1){
            ans++;
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
                 if(arr[i]==false&&((i+1)%curN==0||curN%(i+1)==0)){
                     arr[i]=true;
                     dfs(arr,curN+1,N);
                     arr[i]=false;
            }
        }
    }
}
