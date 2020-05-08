package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @authtor liFei
 * @date 2020/5/7-7:16
 */
public class Solution0108ms {
    /*
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> row=new HashSet<>();
        HashSet<Integer> column=new HashSet<>();
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        //行清零
        Iterator<Integer> iterator = row.iterator();
           while (iterator.hasNext()){
               Arrays.fill(matrix[iterator.next()],0);
           }
           //列清零
        Iterator<Integer> iterator2 = column.iterator();
        while (iterator2.hasNext()){
            becomeZero(matrix,iterator2.next());
        }

    }
    private void becomeZero(int matrix[][],int column){
        for (int i=0;i<matrix.length;i++){
            matrix[i][column]=0;
        }
    }
}
