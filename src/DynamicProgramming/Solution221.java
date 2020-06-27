package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/6/27-8:32
 */
public class Solution221 {
    /*
     */
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        for (int i = 0; i <m ; i++) {
            if(m-i<=max){//如果当前遍历到的行到结尾的距离小于当前最大正方形边长，直接退出
                break;
            }
            for (int j = 0; j <n; j++) {
                if(n-j<=max){//同理
                    break;
                }
                if(matrix[i][j]=='1'){
                    int flag=1;
                    int count=1;
                    while ((i+count)<m&&(j+count)<n){
                        for (int k =i; k <=i+count ; k++) {//行
                               if(matrix[k][j+count]!='1'){
                                   flag=0;
                                   break;
                               }
                        }
                        if(flag==0){
                            break;
                        }
                        for (int k =j+count; k>=j ; k--) {//列
                            if(matrix[i+count][k]!='1'){
                                flag=0;
                                break;
                            }
                        }
                        if(flag==0){
                            break;
                        }
                        count++;
                    }
                    max=Math.max(max,count);
                }
            }
        }
        return max*max;
    }

}
