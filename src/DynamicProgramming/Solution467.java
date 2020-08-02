package DynamicProgramming;

/**
 * @authtor liFei
 * @date 2020/7/30-7:07
 */
public class Solution467 {
    /*
    把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，
    所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 
现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，
你需要输出字符串 s 中 p 的不同的非空子串的数目。 
注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
     */
    public int findSubstringInWraproundString(String p) {
            int ans=0;
            if(p.length()==0){
                return 0;
            }
            char []c= p.toCharArray();
             int []num=new int[26];
        for (int i = 0; i <p.length() ; i++) {
                  int start=i;
               while (i+1<p.length()&&((c[i]+1)%26==c[i+1]%26)){
                   i++;
               }
            for (int j = start; j <=i ; j++) {
                if(num[c[j]-'a']!=0){//如果集合中已经有该元素
                    if(i-j+1<=num[c[j]-'a']){//如果当前该元素所遍历的长度小于等于之前已经遍历过的，直接退出该层循环
                        break;
                    }else{
                         ans+=i-j+1-num[c[j]-'a'];
                          num[c[j]-'a']=i-j+1;
                    }
                }else{//如果集合中没有该元素
                    num[c[j]-'a']=i-j+1;
                    ans+=i-j+1;
                }
            }

        }
        return ans;
    }
}
