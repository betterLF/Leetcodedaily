package String;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/9/11-8:30
 */
public class Solution640 {
    /*
    求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
如果方程没有解，请返回“No solution”。
如果方程有无限解，则返回“Infinite solutions”。
如果方程中只有一个解，要保证返回值 x 是一个整数。
     */
    public String solveEquation(String equation) {
              String []s=equation.split("=");
                int []left=getAns(s[0]);
                int []right=getAns(s[1]);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
                if(right[0]-left[0]==0){
                    if(left[1]-right[1]==0){
                        return "Infinite solutions";
                    }else {
                        return "No solution";
                    }
                }else{
                    return "x="+Integer.toString((left[1]-right[1])/(right[0]-left[0]));
                }
    }
    private int[] getAns(String cur){
        int xCount=0;
        int numCount=0;
        char []c=cur.toCharArray();
        int ope=1;
        int num=0;
        for (int i = 0; i <c.length ; i++) {
            if(c[i]=='+'){
                if(i-1>=0&&c[i-1]!='x'){
                    numCount+=num*ope;
                   num=0;
                }
                ope=1;
            }else if(c[i]=='-'){
                if(i-1>=0&&c[i-1]!='x'){
                    numCount+=num*ope;
                    num=0;
                }
                ope=-1;
            }else if(c[i]=='x'){
                if(num==0) {
                    if (i - 1 < 0) {
                        num = 1;
                    }else if(c[i-1]=='+'||c[i-1]=='-'){
                        num=1;
                    }
                }
                num=num*10+c[i]-'0';
            }
            num=0;
        }
        if(num!=0){
            numCount+=num*ope;
        }
        return new int[]{xCount,numCount};
    }
}
