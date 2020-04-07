import java.util.ArrayList;
import java.util.List;

/*
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
public class Solution241 {

    public  List<Integer> diffWaysToCompute(String input) {
        //如果全是数字，就返回该数字
        List<Integer> res=new ArrayList<Integer>();
        int sum=0;
        boolean flag=true;
        for(int i=0;i<input.length();i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                sum = sum * 10 + input.charAt(i) -'0';
            } else {
                flag = false;
                break;
            }
        }
            if(flag){
                res.add(sum);
                return res;
            }
        for(int i=0;i<input.length();i++){
            if(isOperation(input.charAt(i))){//如果是运算符，就递归调用，直到该运算符里只有数字
                List<Integer> res1=diffWaysToCompute(input.substring(0,i));
                List<Integer> res2=diffWaysToCompute(input.substring(i+1));
               res.addAll(Calculate(input.charAt(i),res1,res2));//将运算结果返回上一级
            }
            }
        return res;
    }
    public  boolean isOperation(char c){
       return c=='+'||c=='-'||c=='*';

    }
    public List<Integer> Calculate(char c,List<Integer> res1,List<Integer> res2){
        List<Integer> res3=new ArrayList<Integer>();
        if(c=='+'){
            for(int i=0;i<res1.size();i++){
                for (int j=0;j<res2.size();j++){
                    res3.add(res1.get(i)+res2.get(j));
                }
            }
        }else if(c=='-'){
            for(int i=0;i<res1.size();i++){
                for (int j=0;j<res2.size();j++){
                    res3.add(res1.get(i)-res2.get(j));
                }
            }
        }else if(c=='*'){
            for(int i=0;i<res1.size();i++){
                for (int j=0;j<res2.size();j++){
                    res3.add(res1.get(i)*res2.get(j));
                }
            }
        }
        return res3;
    }

}
