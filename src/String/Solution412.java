package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/17-7:48
 */
public class Solution412 {
    /*

写一个程序，输出从 1 到 n 数字的字符串表示。
1. 如果 n 是3的倍数，输出“Fizz”；
2. 如果 n 是5的倍数，输出“Buzz”；
3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     */
    public List<String> fizzBuzz(int n) {
           List<String> ans=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if(n%15==0){
                ans.add("FizzBuzz");
            }else if(n%5==0){
                ans.add("Buzz");
            }else if(n%3==0){
                ans.add("Fizz");
            }else{
                ans.add(Integer.toString(i));
            }
        }
           return ans;
    }
}
