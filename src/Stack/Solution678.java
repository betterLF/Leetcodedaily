package Stack;

/**
 * @authtor liFei
 * @date 2020/9/17-13:13
 */
public class Solution678 {
    /*
    给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
     */
    public boolean checkValidString(String s) {
              int min=0;
              int max=0;
        for (char cur:s.toCharArray()) {
            if(cur=='('){
                 min++;
                 max++;
            }else if(cur==')'){
                if (min > 0) min--;
                if (max-- == 0) return false;// 左括号不够
            }else{
                 if(min>0){
                     min--;
                 }
                 max++;
            }
        }
        return min==0;
    }
}
