package Math;

/**
 * @authtor liFei
 * @date 2020/7/23-18:08
 */
public class Solution423 {
    /*
    给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
注意:
输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。
     */
    public String originalDigits(String s) {
         int []a=new int[26];
        for (char c:s.toCharArray()){
          a[c-'a']++;
        }
        int []ans=new int[10];
        //zero排除
        if(a['z'-97]!=0){
            int cur=a['z'-97];
            ans[0]=cur;
            a['e'-97]-=cur;
            a['r'-97]-=cur;
            a['o'-97]-=cur;
            a['z'-97]=0;
        }
        //two排除
        if(a['w'-97]!=0){
            int cur=a['w'-97];
            ans[2]=cur;
            a['t'-97]-=cur;
            a['o'-97]-=cur;
            a['w'-97]=0;
        }
        //six排除
        if(a['x'-97]!=0){
            int cur=a['x'-97];
            ans[6]=cur;
            a['s'-97]-=cur;
            a['i'-97]-=cur;
            a['x'-97]=0;
        }
        //eight排除
        if(a['g'-97]!=0){
            int cur=a['g'-97];
            ans[8]=cur;
            a['e'-97]-=cur;
            a['i'-97]-=cur;
            a['h'-97]-=cur;
            a['t'-97]-=cur;
            a['g'-97]=0;
        }
        //seven排除
        if(a['s'-97]!=0){
            int cur=a['s'-97];
            ans[7]=cur;
            a['e'-97]-=2*cur;
            a['v'-97]-=cur;
            a['n'-97]-=cur;
            a['s'-97]=0;
        }
        //three排除
        if(a['t'-97]!=0){
            int cur=a['t'-97];
            ans[3]=cur;
            a['e'-97]-=2*cur;
            a['h'-97]-=cur;
            a['r'-97]-=cur;
            a['t'-97]=0;
        }
        //four排除
        if(a['r'-97]!=0){
            int cur=a['r'-97];
            ans[4]=cur;
            a['f'-97]-=cur;
            a['o'-97]-=cur;
            a['u'-97]-=cur;
            a['r'-97]=0;
        }
        //five排除
        if(a['f'-97]!=0){
            int cur=a['f'-97];
            ans[5]=cur;
            a['i'-97]-=cur;
            a['v'-97]-=cur;
            a['e'-97]-=cur;
            a['f'-97]=0;
        }
        //one排除
        if(a['o'-97]!=0){
            int cur=a['o'-97];
            ans[1]=cur;
            a['n'-97]-=cur;
            a['e'-97]-=cur;
            a['o'-97]=0;
        }
        //nine排除
        if(a['i'-97]!=0){
            int cur=a['i'-97];
            ans[9]=cur;
            a['e'-97]-=cur;
            a['n'-97]-=2*cur;
            a['i'-97]=0;
        }
        StringBuilder res=new StringBuilder();
        for (int i = 0; i <10 ; i++) {
            while (ans[i]!=0){
                res.append(i);
                ans[i]--;
            }
        }
        return res.toString();
    }
}
