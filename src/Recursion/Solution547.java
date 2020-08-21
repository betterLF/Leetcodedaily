package Recursion;

/**
 * @authtor liFei
 * @date 2020/8/19-7:09
 */
public class Solution547 {
    /*
    班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
    如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
     */
//    boolean []flag;
//    public int findCircleNum(int[][] M) {
//        int ans=0;
//        flag=new boolean[M.length];
//        for (int i = 0; i <M.length ; i++) {
//            if(!flag[i]) {
//                boolean temp=false;
//                for (int j = 0; j < M[0].length; j++) {
//                    if (i == j || M[i][j] == 0) {
//                        continue;
//                    } else {
//                        Queue<Integer> queue = new ArrayDeque<>();
//                        queue.add(i);
//                        flag[i]=true;
//                        bfs(M, queue);
//                        ans++;
//                        temp=true;
//                        break;
//                    }
//                }
//                if(!temp){
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//    private void bfs(int [][]M,Queue<Integer> queue){
//     while (!queue.isEmpty()){
//         int row=queue.poll();
//         flag[row]=true;
//         for (int i = 0; i <M[0].length ; i++) {
//             if(row!=i&&M[row][i]!=0){
//                 queue.add(i);
//                 M[row][i]=0;
//             }
//         }
//     }
//    }
    boolean []flag;
    public int findCircleNum(int[][] M) {
        int ans=0;
        flag=new boolean[M.length];
        for (int i = 0; i <M.length ; i++) {
            if(!flag[i]) {
             ans++;
             flag[i]=true;
             dfs(M,i);
            }
        }
        return ans;
    }
    private void dfs(int [][]M,int curRow){
        for (int i = 0; i <M[0].length ; i++) {
            if(M[curRow][i]==1&&flag[i]==false){
                flag[i]=true;
                dfs(M,i);
            }
        }
    }
}
