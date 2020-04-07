import java.util.ArrayList;
import java.util.List;

public class Solution1380 {
    /*
 给你一个 m * n 的矩阵，矩阵中的数字各不相同,请你按任意顺序返回矩阵中的所有幸运数。
幸运数是指矩阵中满足同时下列两个条件的元素：
在同一行的所有元素中最小
在同一列的所有元素中最大
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> temp=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
               for(int i=0;i<matrix.length;i++){
                   temp.add(searchMin(matrix[i]));
               }
               for(int i=0;i<matrix[0].length;i++){
                   int t=searchMax(matrix,i);
                   if(temp.contains(t)){
                       res.add(t);
                   }
               }
               return res;
    }
    private int searchMin(int h[]){
        int min=h[0];
        for(int i=1;i<h.length;i++){
            min=h[i]>=min?min:h[i];
        }
        return min;
    }
    private int searchMax(int matrix[][],int m){
        int max=matrix[0][m];
        for(int i=1;i<matrix.length;i++){
            max=matrix[i][m]>=max?matrix[i][m]:max;
        }
        return max;
    }
}
