public class Solution1252 {
    /*
    给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。  另有一个索引数组 indices，indices[i] = [ri, ci] 中的 
    ri 和 ci 分别表示指定的行和列（从 0 开始编号）。  你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
     请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
     */
    public static void main(String[] args) {
     int arr[][]={{0,0},{1,1}};
        oddCells(2,2,arr );
    }
    public static int oddCells(int n,int m,int indices[][]){
        boolean h[]=new boolean[n];//默认初始化为false
        boolean l[]=new boolean[m];
        //for循环结束后，如果h[i]为true，代表nm矩阵第i行加奇数次，l[i]同理
        for(int i=0;i<indices.length;i++){
            h[indices[i][0]]= !h[indices[i][0]];
            l[indices[i][1]]=!l[indices[i][1]];
        }
        int hh=0;//为奇数的行有多少
        int ll=0;//为奇数的列有多少
        for(int i=0;i<h.length;i++) {
            if (h[i] == true) {
                hh++;
            }
        }
            for(int i=0;i<l.length;i++){
                if(l[i]==true){
                   ll++;
                }
        }
        System.out.println(hh);
        System.out.println(ll);
        int res=hh*m+ll*n;//一共有多少个（包含重合的）
        res-=hh*ll*2;//减去重合的部分
        return res;
    }
}
