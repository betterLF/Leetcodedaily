import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1329 {
    /*
    给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp[] = new int[n];
            temp[count++] = mat[0][i];
            int j = 1, k = i + 1;
            while (j < m && k < n) {//将一个对角线组的元素存入数组中
                temp[count++] = (mat[j][k]);
                j++;
                k++;
            }
            Arrays.sort(temp, 0, count);//对数组前count项进行排序
            int r = 0, l = i, count2 = 0;//替换原先的对角线元素
            while (count > 0) {
                mat[r++][l++] = temp[count2++];
                count--;
            }
        }
        for (int i = 0; i < m; i++) {
            int temp[] = new int[m];
            temp[count++] = mat[i][0];
            int j = i + 1, k = 1;
            while (j < m && k < n) {
                temp[count++] = (mat[j][k]);
                j++;
                k++;
            }
            Arrays.sort(temp, 0, count);
            int r = i, l = 0, count2 = 0;
            while (count >0) {
                mat[r++][l++] = temp[count2++];
                count--;
            }
        }
        return mat;
    }
}