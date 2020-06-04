package String;

/**
 * @authtor liFei
 * @date 2020/6/2-6:38
 */
public class Solution168 {
    /*
    给定一个正整数，返回它在 Excel 表中相对应的列名称。
     */
    public String convertToTitle(int n) {
            StringBuilder ans=new StringBuilder();
            if(n<=26){
                String res=""+(char)(n+64);
                return res;
            }
              getAns(ans,n);
            return ans.reverse().toString();

    }
    private void getAns(StringBuilder ans,int n){
        if(n<=26){
                ans.append((char)(n+64));
                return;
        }else{
            int temp=n-(n/26)*26;
            if(temp==0) {
                ans.append('Z');
                n-=26;
            }else {
                ans.append((char) (temp + 64));
                n -= temp;
            }
            n/=26;
            getAns(ans,n);
        }
    }
    public String convertToTitle2(int n) {
        if(n==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int m = 0;
        while(n>0) {
            m = n % 26;
            n /= 26;
            if (n != 0 && m == 0) {
                sb.append('Z');
                n-= 1;
            } else if (m != 0) {
                sb.append((char) ('A' + m - 1));
            } else {
                continue;
            }
        }
        return sb.reverse().toString();
    }
}
