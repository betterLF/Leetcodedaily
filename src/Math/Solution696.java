package Math;

/**
 * @authtor liFei
 * @date 2020/8/10-7:44
 */
public class Solution696 {
    /*
    给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
重复出现的子串要计算它们出现的次数。
     */
    public int countBinarySubstrings(String s) {
        if(s.isBlank()){
            return 0;
        }
        int []count=new int[2];
        int pre=0;
        int preCount=0;
        if(s.charAt(0)=='0'){
         count[0]++;
        }else{
            count[1]++;
            pre=1;
        }
        int res=0;
        for (int i = 1; i <s.length() ; i++) {
            if(s.charAt(i)-'0'==pre){
                count[pre]++;
            }else{
                res+=Math.min(preCount,count[pre]);
                preCount=count[pre];
                count[pre]=0;
                pre^=1;
                count[pre]=1;
            }
        }
        res+=Math.min(preCount,count[pre]);
        return res;
    }

}
