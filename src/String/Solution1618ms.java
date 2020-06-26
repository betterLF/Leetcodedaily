package String;

/**
 * @authtor liFei
 * @date 2020/6/22-6:59
 */
public class Solution1618ms {
    /*
    你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
    例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
    但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
     */
    public boolean patternMatching(String pattern, String value) {
        int a = 0;
        int b = 0;
        int len = value.length();
        for (char cur : pattern.toCharArray()) {//统计a和b字符的个数，用于计算选择某个子串是否在长度上合理
            if (cur == 'a') {
                a++;
            } else {
                b++;
            }
        }
        if(value.length()==0&&a*b!=0){//如果a和b都不为0，但value长度为0
            return false;
        }
        if(a==0&&b==0&&value.length()!=0){
            return false;
        }
        if(a==0&&b==0&&value.length()==0){
            return true;
        }
        if(a==0||b==0){
            int temp=a==0?b:a;
            if(len%temp!=0){
                return false;
            }else{
                int now=len/temp;
                String cur=value.substring(0,now);
                for (int i=now;i<len;i+=now){
                    if(!cur.equals(value.substring(i,i+now))){
                        return false;
                    }
                }
                return true;
            }
        }
        //如果a和b都不为0
        if (a * b != 0) {
            int first=0;
            int second=0;
            //得到a和b第一次出现的位置
            for (int i = 0; i <pattern.length() ; i++) {
                if(pattern.charAt(i)=='a'){
                    first=i;
                    break;
                }
            }
            for (int i = 0; i <pattern.length() ; i++) {
                if(pattern.charAt(i)=='b'){
                    second=i;
                    break;
                }
            }
            for (int i = 0; i < len; i++) {
                if(len-a*i<0){
                    break;
                }
                if ((len - a * i) % b == 0) {//如果当前len的长度刚好可以使得a对应i个字符，b对应(len-a*i)%b个字符。
                    int j=(len-a*i)/b;
                    String aa=value.substring(first*j,first*j+i);
                    String bb=value.substring(second*i,second*i+j);
                    if(aa.equals(bb)){
                        continue;
                    }
                    if(isAccess(pattern,value,aa,bb,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean isAccess(String pattern,String value,String aa,String bb,int i,int j){
              int count=0;
        for (int k = 0; k <value.length() ; ) {
            if(pattern.charAt(count)=='a'){
                if(!value.substring(k,k+i).equals(aa)){
                    return false;
                }
                k+=i;
            }else{
                if(!value.substring(k,k+j).equals(bb)){
                    return false;
                }
                k+=j;
            }
            count++;
        }
        return true;
    }
}
