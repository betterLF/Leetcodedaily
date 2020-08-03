package String;

/**
 * @authtor liFei
 * @date 2020/8/1-7:33
 */
public class Solution481 {
    /*
神奇的字符串 S 只包含 '1' 和 '2'，并遵守以下规则：
字符串 S 是神奇的，因为串联字符 '1' 和 '2' 的连续出现次数会生成字符串 S 本身。
字符串 S 的前几个元素如下：S = “1221121221221121122 ......”
如果我们将 S 中连续的 1 和 2 进行分组，它将变成：
1 22 11 2 1 22 1 22 11 2 11 22 ......
并且每个组中 '1' 或 '2' 的出现次数分别是：
1 2 2 1 1 2 1 2 2 1 2 2 ......
你可以看到上面的出现次数就是 S 本身。
给定一个整数 N 作为输入，返回神奇字符串 S 中前 N 个数字中的 '1' 的数目。
注意：N 不会超过 100,000。
     */
    public int magicalString(int n) {
             if(n==0){
                 return 0;
             }
             if(n<=3){
                 return 1;
             }
        int ans=1;
        char []num=new char[n];
        num[2]='2';
        int fast=2;//代表末尾
        int i=0;
        for (i=2; fast<n ; i++) {
            if (num[i] == '2') {
                if (num[fast] == '1') {
                    num[fast + 1] = '2';
                    num[fast + 2] = '2';
                } else {
                    num[fast + 1] = '1';
                    num[fast + 2] = '1';
                }
                fast += 2;
            } else {
                if (num[i] == '1') {
                    if (num[fast] == '1') {
                        num[fast + 1] = '2';
                    } else {
                        num[fast + 1] = '1';
                    }
                    fast += 1;
                }
                ans++;//1的个数++
            }
        }
        for (; i<n ; i++) {
            if(num[i]=='1'){
                ans++;
            }
        }
        return ans;
    }
}
