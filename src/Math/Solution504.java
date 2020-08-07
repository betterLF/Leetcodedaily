package Math;

/**
 * @authtor liFei
 * @date 2020/8/5-6:07
 */
public class Solution504 {
    /*
给定一个整数，将其转化为7进制，并以字符串形式输出。
     */
    public String convertToBase7(int num) {
          StringBuilder ans=new StringBuilder();
          if(num<0){
              ans.append('-');
              num=-num;
          }
              int cur=7;

              while (num/cur>=7){
                  cur*=7;
              }
              ans.append(num/cur);
              num-=cur*(num/cur);
              while (cur>1){
                  cur/=7;
                  ans.append(num/cur);
                  num-=cur*(num/cur);
              }

          return ans.toString();
    }
}
