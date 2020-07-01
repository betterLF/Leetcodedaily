package Math;

/**
 * @authtor liFei
 * @date 2020/6/28-7:21
 */
public class Solution223 {
    /*
    在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
                  long area1=(C-A)*(D-B);
                  long area2=(G-E)*(H-F);
                  return (int)(area1+area2-isCoincide(A,C,E,G)*isCoincide(B,D,F,H));
    }
    private long isCoincide(int a1,int a2,int b1,int b2){
        //如果不重合
        if(a2<=b1||b2<=a1){
            return 0;
        }
        //如果重合
        if(a1<=b1&&b1<a2){
            if(b2<=a2){
                return b2-b1;
            }else{
                return a2-b1;
            }
        }
        if(b1<=a1&&a1<b2){
            if(a2<=b2){
                return a2-a1;
            }else{
                return b2-a1;
            }
        }
        return 0;
    }
}
