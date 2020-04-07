public class Solution0107ms {
    public void rotate(int [][]matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //每一行依次首尾换位
        for(int i=0;i<matrix.length;i++){
            for(int j=0,k=matrix[i].length-1;j<k;j++,k--){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
            }
        }
    }
}
