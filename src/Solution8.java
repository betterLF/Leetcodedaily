/*请你来实现一个 atoi 函数，
        使其能将字符串转换成整数。首先，该函数会根据需要丢弃无用的开头空格字符，
        直到寻找到第一个非空格的字符为止。当我们寻找到的第一个非空字符为正或者负号时，
        则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，
        则直接将其与之后连续的数字字符组合起来，形成整数。该字符串除了有效的整数部分之后也可能会存在多余的字符，
        这些字符可以被忽略，它们对于函数不应该造成影响。注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、
        字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
        在任何情况下，若函数不能进行有效的转换时，请返回 0。
        */
public class Solution8 {
    public  int myAtoi(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else {
                count = i;
                break;
            }
        }
        boolean flag1 = str.charAt(count) == '+' || str.charAt(count) == '-';
        boolean flag2 = (str.charAt(count) > '0' && str.charAt(count) <= '9');
        //boolean flag3=str.charAt(0)==' ';
        boolean flag4 = str.charAt(count) == '0';
        if (!flag1 && !flag2 && !flag4) {
            return 0;
        }
        StringBuilder s = new StringBuilder();
        if (flag2) {
            s.append(str.charAt(count));
        }
        for (int i = count + 1; i < str.length(); i++) {
            //如果第一个字符为正负号
            boolean flag = str.charAt(i) > '0' && str.charAt(i) <= '9';
            if (flag1) {
                if (str.charAt(i) == '0' && s.length() == 0) {
                    continue;
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    s.append(str.charAt(i));
                } else {
                    break;
                }
            } else if (flag2) {//第一个字符为数字而且不为0
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    s.append(str.charAt(i));
                } else {
                    break;
                }
            } else if (flag4) {//为零
                if (str.charAt(i) == '0' && s.length() == 0) {
                    continue;
                } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    s.append(str.charAt(i));
                } else {
                    break;
                }
            }
        }
        if (s.length() == 0) {
            s.append('0');
        }
        String ss = s.toString();
        //判断是否越界
        if (flag1) {
            if (str.charAt(count) == '+') {
                String sss = Integer.toString(Integer.MAX_VALUE);
                if (ss.length() > sss.length()) {
                    return Integer.MAX_VALUE;
                }
                if (ss.length() == sss.length()) {
                    for (int i = 0; i < ss.length(); i++) {
                        if (ss.charAt(i) > sss.charAt(i)) {
                            return Integer.MAX_VALUE;
                        } else if (ss.charAt(i) < sss.charAt(i)) {
                            break;
                        }
                    }
                }
                return Integer.parseInt(ss);
            }else {
                String sss = Integer.toString(Integer.MIN_VALUE);
                if (ss.length() > sss.length() - 1) {
                    return Integer.MIN_VALUE;
                }
                if (ss.length() == sss.length() - 1) {
                    for (int i = 0; i < ss.length(); i++) {
                        if (ss.charAt(i) > sss.charAt(i)) {
                            return Integer.MIN_VALUE;
                        } else if (ss.charAt(i) < sss.charAt(i)) {
                            break;
                        }
                    }
                }
                return -Integer.parseInt(ss);
            }
        }
        String sss = Integer.toString(Integer.MAX_VALUE);
        if (ss.length() > sss.length()) {
            return Integer.MAX_VALUE;
        }
        if (ss.length() == sss.length()) {
            for (int i = 0; i < ss.length(); i++) {
                if (ss.charAt(i) > sss.charAt(i)) {
                    return Integer.MAX_VALUE;
                } else if (ss.charAt(i) < sss.charAt(i)) {
                    break;
                }
            }
        }
        return Integer.parseInt(ss);
    }
    //可以用long类型比较与int最大值的大小，判断是否溢出

    public  int myAtoi2(String str) {
        if(str.length()==0){
            return 0;
        }
        //去除字符串的前行空格，找到真正的起始点
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            } else {
                count = i;
                break;
            }
        }
        //起始点的三种情况对应不同的解决方法
        boolean flag1 = str.charAt(count) == '+' || str.charAt(count) == '-';
        boolean flag2 = (str.charAt(count) > '0' && str.charAt(count) <= '9');
        boolean flag3 = str.charAt(count) == '0';
        //字符串不有效
        if (!flag1 && !flag2 && !flag3) {
            return 0;
        }
        long res=0L;//定义长整型，用于溢出的判断
        //如果第一个字符为数字，初始化长整型
        if (flag2) {
           res=str.charAt(count)-48;
        }
        for (int i = count + 1; i < str.length(); i++) {
            //如果第一个字符为正负号
            boolean flag=str.charAt(i) >= '0' && str.charAt(i) <= '9';
            if (flag1) {
                if (str.charAt(i) == '0' && res == 0) {//在出现非0数字前只要是0就一直向后找
                    continue;
                } else if (flag) {//如果是数字，就加入long中进行运算
                   res=res*10+str.charAt(i)-48;//每加入一次判断是否溢出
                    if(str.charAt(count)=='+'){
                        if(res>Integer.MAX_VALUE){
                            return Integer.MAX_VALUE;
                        }
                    }else{
                        res=-res;
                      if(res<Integer.MIN_VALUE){
                          return Integer.MIN_VALUE;
                      }
                      res=-res;
                    }
                } else {//不是数字就退出
                    break;
                }
            } else if (flag2) {//第一个字符为数字而且不为0
                if (flag) {
                    res=res*10+str.charAt(i)-48;
                    if(res>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                } else {
                    break;
                }
            } else if (flag3) {//第一个字符为零
                if (str.charAt(i) == '0' &&res == 0) {
                    continue;
                } else if (flag) {
                    res=res*10+str.charAt(i)-48;
                    if(res>Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        return (int)res;
    }


}
