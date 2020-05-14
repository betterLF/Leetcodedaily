import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/5/12-22:13
 */
public class Solution279 {
    /*
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     */
    public static void main(String[] args) {
        numSquares(12);
    }
    public static int numSquares(int n) {
        int sn=(int)Math.sqrt(n);
        if(sn*sn==n){
            return 1;
        }
        int []squares=new int[sn];
        for (int i = 0; i <sn ; i++) {
           squares[i]=(sn-i)*(sn-i);
        }
        Stack<Integer> ans=new Stack<>();
        int []res={-1};
         bfs(ans,squares,0,n,0,res);
         return res[0];
    }
    private static void bfs(Stack<Integer> ans,int[]squares,int curSum,int n,int index,int []res){
        if(curSum>n||index>=squares.length||(res[0]!=-1&&ans.size()>res[0])){//剪枝
            return;
        }
        if(curSum==n){
                res[0]=ans.size();
            return;
        }
        for (int i=index;i<squares.length;i++){
            ans.push(squares[i]);
            bfs(ans,squares,curSum+squares[i],n,i,res);
            ans.pop();
        }
    }
    //贪心+bfs
    public static int numSquares2(int n) {
        ArrayList<Integer> squares=new ArrayList<>();//存放所有可能的子平方数
        for (int i = 1; i*i <=n ; i++) {
            squares.add(i*i);
        }
        Set<Integer> queue=new HashSet<>();
        queue.add(n);
        int ans=0;
        while (queue.size()>0){
            Set<Integer> cur_queue=new HashSet<>();
            ans++;
            for (Integer remainder:queue){
                for (Integer square:squares){
                    if(remainder.equals(square)){//如果此时剩余值在平方数中能找到，已经达到最小，返回
                        return ans;
                    }else if(remainder<square){//如果小于当前平方数，就往后遍历此时的剩余值集合
                        break;
                    }else{
                        cur_queue.add(remainder-square);//将新的剩余值加入当前队列
                    }
                }
            }
            queue=cur_queue;//更新队列，此时是执行ans+1次后所剩下的所有可能剩余值
        }
        return ans;
    }
}
