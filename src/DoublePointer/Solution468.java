package DoublePointer;

import java.util.Arrays;

/**
 * @authtor liFei
 * @date 2020/7/30-8:33
 */
public class Solution468 {
    /*
    编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334
 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。
所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
     */
    public String validIPAddress(String IP) {
        if(IP.contains(".")&&IP.contains(":")){
            return "Neither";
        }
        if(IP.contains(".")) {
            if(IP.charAt(0)=='.'||IP.charAt(IP.length()-1)=='.'){
                return "Neither";
            }
            String[] ip = IP.split("\\.");
            System.out.println(ip[0]);
            for (int i = 0; i < ip.length; i++) {
                if (ip[i].equals("")) {//出现空字符串
                    return "Neither";
                }
            }
            if (ip.length == 4) {
                return isIPv4(ip) ? "IPv4" : "Neither";
            }
        }else {
            if(IP.charAt(0)==':'||IP.charAt(IP.length()-1)==':'){
                return "Neither";
            }
            String[] ip = IP.split(":");
            for (int i = 0; i < ip.length; i++) {
                if (ip[i].equals("")) {//出现空字符串
                    return "Neither";
                }
            }
            if (ip.length == 8) {
                return isIPv6(ip) ? "IPv6" : "Neither";
            }
        }
        return "Neither";
    }
    private boolean isIPv4(String []s){
        System.out.println(Arrays.toString(s));
        for (int i = 0; i <s.length ; i++) {
            String cur=s[i];
            if(cur.charAt(0)=='0'&&cur.length()>1){//如果首位为0，并且后面还有数字
                return false;
            }
            if(cur.length()>3){
                return false;
            }
            int curAns=0;
            int j=0;
            while (j<cur.length()){
                char c=cur.charAt(j);
                if(c<='9'&&c>='0'){
                    curAns=curAns*10+c-'0';
                }else{//如果出现非数字
                    return false;
                }
                j++;
            }
            if(curAns>255){
                return false;
            }
        }
        return true;
    }
    private boolean isIPv6(String []s){
        String set="0123456789abcdefABCDEF";
        for (int i = 0; i <s.length ; i++) {
            String cur=s[i];
           if(cur.length()>4){//如果超过16比特
               return false;
           }
            for (int j = 0; j <cur.length() ; j++) {
                if(set.indexOf(cur.charAt(j))==-1){
                    return false;
                }
            }
        }
        return true;
    }
}
