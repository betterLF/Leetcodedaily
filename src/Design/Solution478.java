package Design;

/**
 * @authtor liFei
 * @date 2020/8/1-7:04
 */
public class Solution478 {
/*
给定圆的半径和圆心的 x、y 坐标，写一个在圆中产生均匀随机点的函数 randPoint 。
说明:
输入值和输出值都将是浮点数。
圆的半径和圆心的 x、y 坐标将作为参数传递给类的构造函数。
圆周上的点也认为是在圆中。
randPoint 返回一个包含随机点的x坐标和y坐标的大小为2的数组。
 */
//class Solution {
//         double r;
//         double x;
//         double y;
//    public Solution(double radius, double x_center, double y_center) {
//              r=radius;
//              x=x_center;
//              y=y_center;
//    }
//
//    public double[] randPoint() {
//        Random rr=new Random();
//              while (true){
//                  double cur_x=x+r*(rr.nextInt(2)==1?rr.nextDouble():-rr.nextDouble());
//                  double cur_y=y+r*(rr.nextInt(2)==1?rr.nextDouble():-rr.nextDouble());
//                  if(isRight(cur_x,cur_y)){
//                      return new double[]{cur_x,cur_y};
//                  }
//              }
//    }
//    private boolean isRight(double cur_x,double cur_y){
//        double x_2=Math.pow(cur_x-x,2);
//        double y_2=Math.pow(cur_y-y,2);
//        if(x_2+y_2<=r*r){
//            return true;
//        }
//        return false;
//    }
//}
class Solution {

    double radius;
    double x_center;
    double y_center;


    public  Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double r = Math.random() * radius * radius;
        double c = Math.PI * 2 * Math.random();
        r = Math.sqrt(r);
        return new double[]{r * Math.sin(c) + x_center, r * Math.cos(c) + y_center};
    }
}
}
