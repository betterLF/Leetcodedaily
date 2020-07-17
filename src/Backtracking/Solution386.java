package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/13-21:22
 */
public class Solution386 {
    /*
    给定一个整数 n, 返回从 1 到 n 的字典顺序。
例如，
给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
     */
    List<Integer> ans;
    public List<Integer> lexicalOrder(int n) {
        ans=new ArrayList<>();
        for (int i = 1; i <=9&&i<n ; i++) {
            ans.add(i);
            dfs(i,n);
        }
        return ans;
    }
    public void dfs(int cur,int n){
        cur*=10;
        for (int i = 0; i <=9&&cur+i<=n ; i++) {
            ans.add(cur+i);
            dfs(cur+i,n);
        }
    }
}
