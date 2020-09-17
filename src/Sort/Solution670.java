package Sort;

/**
 * @authtor liFei
 * @date 2020/9/15-8:32
 */
public class Solution670 {
    /*
    给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     */
    public int maximumSwap(int num) {
        int []count=new int[10];
        int []temp=new int[100];
        int len=0;
        while (num!=0){
            int cur=num%10;
            count[cur]++;
            temp[len]=cur;
            len++;
            num/=10;
        }
        int []ans=new int[len];
        for (int i = 0; i <len ; i++) {
            ans[i]=temp[len-1-i];
        }
        int curMax=getNext(count,count.length);
        for (int i = 0; i <ans.length ; i++) {
            if(ans[i]!=curMax){
                for (int j = ans.length-1; j>i ; j--) {
                    if(ans[j]==curMax){
                        int t=ans[i];
                        ans[i]=ans[j];
                        ans[j]=t;
                        break;
                    }
                }
                break;
            }else{
                count[curMax]--;
                if(count[curMax]==0){
                    curMax=getNext(count,curMax);
                }
            }
        }
        int max=0;
        for (int i = 0; i <ans.length ; i++) {
            max=max*10+ans[i];
        }
        return max;
    }
    private int getNext(int []arr,int index){
        for (int i = index-1; i>=0 ; i--) {
            if(arr[i]!=0){
                return i;
            }
        }
        return -1;
    }
}
