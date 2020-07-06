package Math;

/**
 * @authtor liFei
 * @date 2020/7/3-7:06
 */
public class Solution371 {
    /*
    不使用运算符 + 和 -，计算两整数a 、b之和。
     */
    public static void main(String[] args) {
        getSum(-3,4);
    }
    public  static int getSum(int a, int b) {
        int c=0;//进位
        int ans=0;//结果
        for (int i = 0; i <32 ; i++) {
              if((a&(1<<i))!=0&&(b&(1<<i))!=0){//如果ab当前位都为1
                  if(c==0){//ans当前位为0
                      c=1;//产生进位
                  }else{//ans当前位为1
                      ans|=(1<<i);
                  }
            }else if((a&(1<<i))==0&&(b&(1<<i))==0){//如果ab当前位都为0
                  if(c==1){
                      ans|=(1<<i);//ans当前位为1
                      c=0;//进位消除
                  }
              }else{//ab一个1一个0
                  if(c==0){
                      ans|=(1<<i);//ans当前位为1
                  }
              }
        }
        //因为返回是int型，所以不会溢出
        return ans;
    }
}
