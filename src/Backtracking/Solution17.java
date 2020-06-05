package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/6/4-6:43
 */
public class Solution17 {
    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     */
    //栈
    public static List<List<Character>> c=new ArrayList<>();
   static  {
        int count=0;
        int cur=2;
        ArrayList<Character> cc;
        c.add(new ArrayList<>());
        c.add(new ArrayList<>());
       while (count!=26){
           cc=new ArrayList<>();
              if(cur!=7&&cur!=9){
                  cc.add((char)(count+97));
                  cc.add((char)(count+98));
                  cc.add((char)(count+99));
                  count+=3;
              }else{
                  cc.add((char)(count+97));
                  cc.add((char)(count+98));
                  cc.add((char)(count+99));
                  cc.add((char)(count+100));
                  count+=4;
              }
              cur++;
              c.add(cc);
       }
    }

    public static void main(String[] args) {
      for (List<Character> a:c){
          System.out.println(a.toString());
      }
    }
    public List<String> ans;
    public List<String> letterCombinations(String digits) {
          ans=new ArrayList<>();
          if(digits.length()==0){
              return ans;
          }
          char []c=digits.toCharArray();
          int []num=new int[c.length];
        for (int i = 0; i <c.length ; i++) {//转成int数组
           // num[i]=Integer.parseInt(""+c[i])-2;
            num[i]=c[i]-'0';//优化
        }
        Stack<Character> cur=new Stack<>();
          next(cur,num,0);
          return ans;
    }
    private void next(Stack cur,int[] num,int curIndex){
        if (curIndex==num.length){//到达末尾直接返回
                StringBuilder c=new StringBuilder();
            for (int i = 0; i <cur.size() ; i++) {
                c.append(cur.get(i));
            }
            ans.add(c.toString());
            return;
        }
       List<Character> n=c.get(num[curIndex]);
        for (int i = 0; i <n.size() ; i++) {
            cur.push(n.get(i));
            next(cur,num,curIndex+1);
            cur.pop();
        }
    }
    //stringbuilder
    public List<String> letterCombinations2(String digits) {
        ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        char []c=digits.toCharArray();
        int []num=new int[c.length];
        for (int i = 0; i <c.length ; i++) {//转成int数组
            num[i]=c[i]-'0';
        }
        StringBuilder cur=new StringBuilder();
        next(cur,num,0);
        return ans;
    }
    private void next(StringBuilder cur,int[] num,int curIndex){
        if (curIndex==num.length){//到达末尾直接返回
            ans.add(cur.toString());
            return;
        }
        List<Character> n=c.get(num[curIndex]);
        for (int i = 0; i <n.size() ; i++) {
            cur.append(n.get(i));
            next(cur,num,curIndex+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
