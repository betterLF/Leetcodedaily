package Competition;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/8/30-9:22
 */
public class zhousai204 {
    /*
给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
如果数组中存在一个至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
     */
//    public boolean containsPattern(int[] arr, int m, int k) {
//        int count = k;
//        if (m * k > arr.length) {
//            return false;
//        }
//        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i <= arr.length - m; i++) {
//            String c = Arrays.toString(Arrays.copyOfRange(arr, i, i + m));
//            ArrayList<Integer> orDefault = map.getOrDefault(c, new ArrayList<>());
//            orDefault.add(i);
//            map.put(c, orDefault);
//        }
//        for (String i : map.keySet()) {
//            ArrayList<Integer> cur = map.get(i);
//            if (cur.size() < k) {
//                continue;
//            } else {
//                for (int j = 0; j < cur.size(); j++) {
//                    int c = cur.get(j);
//                    count--;
//                    while (cur.contains(c + m) && count != 0) {
//                        c += m;
//                        count--;
//                    }
//                    if (count == 0) {
//                        return true;
//                    } else {
//                        count = k;
//                    }
//                }
//            }
//        }
//            return false;
//        }

    public boolean containsPattern(int[] arr, int m, int k) {
        int len=arr.length;
        for (int i = 0; i+m*k <=len; i++) {
            boolean flag=true;
            for (int j = 0; j < m; j++) {
                for (int l = 1; l < k; l++) {
                 if(arr[i + (l - 1) * m + j] != arr[i + l * m + j]){
                     flag=false;
                     break;
                 }
                }
                if(!flag){
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }


    /*
给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。
一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。
请你返回乘积为正数的最长子数组长度。
     */
    public int getMaxLen(int[] nums) {
        int max=0;
        ArrayList<Integer> a=new ArrayList<>();
        int pre=-1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==0){
                if(a.size()%2==0){
                    max=Math.max(max,i-1-pre);
                }else{
                    max=Math.max(max,i-1-(a.get(0)+1)+1);
                    max=Math.max(max,a.get(a.size()-1)-1-pre);
                }
                a.clear();
                pre=i;
            }else if(nums[i]<0){
                a.add(i);
            }
        }
        int i=nums.length-1;
        if(a.size()%2==0){
            max=Math.max(max,i-1-pre);
        }else{
            max=Math.max(max,i-1-(a.get(0)+1)+1);
            max=Math.max(max,a.get(a.size()-1)-1-pre);
        }
        return max;
    }



    /*
给你一个由若干 0 和 1 组成的二维网格 grid ，其中 0 表示水，而 1 表示陆地。岛屿由水平方向或竖直方向上相邻的 1 （陆地）连接形成。
如果 恰好只有一座岛屿 ，则认为陆地是 连通的 ；否则，陆地就是 分离的 。
一天内，可以将任何单个陆地单元（1）更改为水单元（0）。
返回使陆地分离的最少天数。
     */
    boolean[][] visited;
    int[][] dirs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    int n;
    int m;
    int[][] grid;
    public int minDays(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        this.grid = grid;
        visited = new boolean[n][m];

        if(check()){
            return 0;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]==0){
                    continue;
                }
                grid[i][j] = 0;
                if(check()){
                    return 1;
                }
                grid[i][j] =1;
            }
        }
        return 2;
    }
    public void dfs(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            dfs(i + dir[0], j + dir[1]);
        }
    }

    public boolean check(){//得到当前岛屿的数量(block)
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }
        int block = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    block++;
                }
            }
        }
        return block > 1;
    }
}
