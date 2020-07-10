package Math;

/**
 * @authtor liFei
 * @date 2020/7/6-8:20
 */
public class Solution319 {
    /*
    初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，
    每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。
     对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。
     */
    public int bulbSwitch(int n) {
        int ans=0;
        while (n!=0){
            int cur=0;
            for (int i = 1; i*i <=n ; i++) {
                if(n%i==0){
                    cur+=n/i==i?1:2;
                }
            }
            if(cur%2==1){//如果为奇数次
                ans++;
            }
            n--;
        }
        return ans;
    }
    public int bulbSwitch2(int n) {
        int ans=0;
        while (n!=0){
            int temp=(int)Math.sqrt(n);
            if(temp*temp==n){//如果可以开平方，说明该数的因子为奇数个
                ans++;
            }
            n--;
        }
        return ans;
    }
    public int bulbSwitch3(int n) {
         //1-n中每有一个开平方的数则它是亮着的,所以最后的数量是1-n中可以开平方的数
        return (int)Math.sqrt(n);
    }
}
