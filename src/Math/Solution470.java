package Math;

/**
 * @authtor liFei
 * @date 2020/7/31-6:36
 */
//public class Solution470 {
    /*
    已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
不要使用系统的 Math.random() 方法。
     */
//    class Solution extends SolBase {
//        public int rand10() {
//              int  num1=0;
//              while(true){
//                  int cur=rand7();
//                  if(cur<=5){
//                      num1=cur;
//                      break;
//                  }
//              }
//              int num2=0;
//              while (true){
//                  int cur=rand7();
//                  if(cur<=3){
//                      num2=1;
//                      break;
//                  }else if(cur>=5){
//                      num2=2;
//                      break;
//                  }
//              }
//         return num2==1?num1*2-1:num1*2;
//            while(true) {
//                int num = (rand7() - 1) * 7 + rand7(); // 等概率生成[1,49]范围的随机数
//                if(num <= 40) return num % 10 + 1; // 拒绝采样，并返回[1,10]范围的随机数
//            }

//        }
//
//    }
//}
