package Design;

import java.util.HashSet;
import java.util.Random;

/**
 * @authtor liFei
 * @date 2020/8/14-6:59
 */
public class Solution519 {
    /*
    题中给出一个 n_rows 行 n_cols 列的二维矩阵，且所有值被初始化为 0。要求编写一个 flip 函数，
    均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；同样编写一个 reset 函数，
    将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
注意:
1 <= n_rows, n_cols <= 10000
0 <= row.id < n_rows 并且 0 <= col.id < n_cols
当矩阵中没有值为 0 时，不可以调用 flip 函数
调用 flip 和 reset 函数的次数加起来不会
     */
    class Solution {
           HashSet<Integer> set;
           int sum;
           int col;
           Random r;
        public Solution(int n_rows, int n_cols) {
               set=new HashSet<>();
               sum=n_cols*n_rows;
               col=n_cols;
               r=new Random();
        }

        public int[] flip() {
            int cur=r.nextInt(sum);
            while(set.contains(cur)){
                   cur=r.nextInt(sum);
            }
            set.add(cur);
            return new int[]{cur/col,cur%col};
        }

        public void reset() {
            set.clear();
        }
    }
}
