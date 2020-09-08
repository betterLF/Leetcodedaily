package Math;

/**
 * @authtor liFei
 * @date 2020/9/5-12:03
 */
public class Solution812 {
    /*
    给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
     */
    public double largestTriangleArea(int[][] points) {
        int len=points.length;
       double ans=0;
        for (int i = 0; i <len ; i++) {
            for (int j = i+1; j <len ; j++) {
                for (int k = j+1; k <len ; k++) {
                     ans=Math.max(ans,area(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }
    private double area(int r[],int g[],int b[]){
        return 0.5*Math.abs(r[0]*g[1]+g[0]*b[1]+b[0]*r[1]-r[1]*g[0]-g[1]*b[0]-b[1]*r[0]);
    }
}
