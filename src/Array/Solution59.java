public class Solution59 {
/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
*/
    public int[][] generateMatrix(int n){
        int res[][]=new int[n][n];
        int count=1;
        int i=0;
        int j=0;
        while(count<=n*n){
            if(res[i][j]==0) {
                res[i][j] = count;
                //如果右边可以走并且上边不可以走
                if((j+1<n&&res[i][j+1]==0)&&!(i-1>=0&&res[i-1][j]==0)){
                    j++;
                }else if(i+1<n&&res[i+1][j]==0){//如果下边可以走
                    i++;
                }else if(j-1>=0&&res[i][j-1]==0){//如果左边可以走
                    j--;
                }else {
                    i--;
                }
            }
            count++;
        }
        return res;
    }
    //别人思路，也可以
    public int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
