package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @authtor liFei
 * @date 2020/6/19-9:05
 */
public class Solution166 {
    /*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。
     */
    StringBuilder ans;
    ArrayList<Long> current;
    ArrayList<String> s;
    public String fractionToDecimal(int numerator, int denominator) {
            ans=new StringBuilder();
            current=new ArrayList<>();
            s=new ArrayList<>();
            if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)){
                ans.append('-');
            }
//           long numerator1=0;
//        if(numerator==-2147483648){
//            numerator1=2147483647;
//            numerator1++;
//        }else{
//            numerator1=(long)Math.abs(denominator);
//        }
//            long denominator1=0;
//            if(denominator==-2147483648){
//                denominator1=2147483647;
//                denominator1++;
//            }else{
//                denominator1=(long)Math.abs(denominator);
//            }
            long numerator1=numerator;
            long denominator1=denominator;
            numerator1=Math.abs(numerator1);
            denominator1=Math.abs(denominator);
       long first=numerator1/denominator1;
            if(denominator1*first==numerator1){//如果刚好整除，直接返回结果
                ans.append(first);
                return ans.toString();
            }else{
                ans.append(first).append('.');
            }
          long nowNumerator=(numerator1-first*denominator1)*10;
            solve(nowNumerator,denominator1);
            return ans.toString();
    }
    private void solve(long nowNumerator,long denominator){
         current.add(nowNumerator/10);//将每次的除数加入除数集
        StringBuilder ss=new StringBuilder();
        while (nowNumerator<denominator){//只要除数小于被除数
            nowNumerator*=10;
            ss.append('0');
        }
        long c=nowNumerator/denominator;
        long next=nowNumerator-denominator*c;//得到下一个被除数
        ss.append(c);
        s.add(ss.toString());//将该点加入结果集
        if(current.contains(next)){//如果下一个和现在初始的一样，则为循环小数,添加后直接返回
           int j=0;
           while (current.get(j)!=next){
               ans.append(s.get(j));
               j++;
           }
           ans.append('(');
            for (int i = j; i <s.size() ; i++) {
                ans.append(s.get(i));
            }
            ans.append(')');
            return;
        }else if(next==0){//如果刚好除尽
            for (int i = 0; i <s.size() ; i++) {//将结果拼接
                ans.append(s.get(i));
            }
            return;
        }else{
            next*=10;
            solve(next,denominator);
        }
    }
    public String fractionToDecimal2(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder ns = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) ns.append('-');
        long a = numerator;
        long b = denominator;
        a = Math.abs(a);
        b = Math.abs(b);
        ns.append(a / b);
        Map<Long, Integer> map = new HashMap<>();
        long r = a % b;
        if (r != 0) ns.append('.');
        while (r != 0) {
            if (map.containsKey(r)) {//如果当前的余数已经出现过，就在出现该余数的前面插入(
                ns.insert(map.get(r), "(");
                ns.append(")");
                break;
            }
            map.put(r, ns.length());//将余数和其此时对应的结果长度加入集合中
            r *= 10;
            ns.append(r / b);//将下一个结点加入结果集中
            r %= b;//得到下一个除数
        }
        return ns.toString();
    }
}
