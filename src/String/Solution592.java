package String;

import java.util.ArrayDeque;

/**
 * @authtor liFei
 * @date 2020/8/22-6:43
 */
public class Solution592 {
    /*
    给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。
     这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，
    例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
     */
    public String fractionAddition(String expression) {
            char []c=expression.toCharArray();
            ArrayDeque<Integer> count_Queue=new ArrayDeque<>();
            ArrayDeque<Integer> operator_Queue=new ArrayDeque<>();
            int i=0;
            if(c[0]=='-'){
                if(c[1]!='+'&&c[1]!='-'){
                    if(c[1]=='1'){
                        if(c[2]=='0'){
                           count_Queue.add(-10);
                            i=3;
                        }else{
                            count_Queue.add(-1);
                            i=2;
                        }
                    }else{
                        count_Queue.add(-(c[1]-'0'));
                        i=2;
                    }
                }
            }
        for (; i <c.length ; i++) {
                if(c[i]=='/'){
                    continue;
                }
                if(c[i]=='+'){
                    operator_Queue.add(1);
                }else if(c[i]=='-'){
                    operator_Queue.add(-1);
                }else{
                    if(c[i]=='1'){
                        if(i+1<c.length&&c[i+1]=='0'){
                            count_Queue.add(10);
                            i++;
                        }else{
                            count_Queue.add(1);
                        }
                    }else{
                        count_Queue.add(c[i]-'0');
                    }
                }
        }
        return ope(count_Queue,operator_Queue);
    }
    private String ope(ArrayDeque<Integer> count,ArrayDeque<Integer> operator){
           while (count.size()!=2){
               int first=count.poll();
               int second=count.poll();
               int third=count.poll();
               int four=count.poll();
               int cur_ope=operator.poll();
               int cur1=0;
               int cur2=0;
               if(cur_ope==1){
                  cur1=second*third+first*four;
                  cur2=second*four;
               }else{
                  cur1=-second*third+first*four;
                  cur2=second*four;
               }
               int  g=Math.abs(gcd(cur1,cur2));
               cur1/=g;
               cur2/=g;
               count.addFirst(cur2);
               count.addFirst(cur1);
           }
          return count.poll()+"/"+count.poll();
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
