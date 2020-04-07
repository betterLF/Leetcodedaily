import java.util.*;

public class Solution216 {
    /*
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    说明：  所有数字都是正整数。 解集不能包含重复的组合。
     */
    public static void main(String[] args) {
        combinationSum3(3,9);
    }
    public static List<List<Integer>> res=new LinkedList<>();
    public static List<Integer> cur= new ArrayList<Integer>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int h=k;//用于存储当前还剩的个数
        int w=n;//用于存储当前还剩的值
        int i=1;//用于记录开始的索引
        if(cur.size()-1>=0&&cur.get(cur.size()-1)!=null){
            i=cur.get(cur.size()-1)+1;
        }//求当前cur集合最后一个元素，比如[1,3],则下一次添加应该在3+1=4处
        for(;i<10;i++) {
            cur.add(i);
            h = k - 1;//加i后剩余的可加元素个数
            w = n - i;//加i后离所求值的差值
            if (h == 0 && w == 0) {//如果此时k，w都等于0.说明满足条件，新建集合a（此时的cur值），将a加入结果集中
                ArrayList<Integer> a = new ArrayList<>(cur);
                res.add(a);
                cur.remove(cur.size() - 1);//因为此时满足条件，所以cur只有移除两个元素才有可能达到目标
                cur.remove(cur.size() - 1);
                break;
            } else if (h == 0 && w > 0) {//如果此时的个数为0但是w>0,就移除一个元素，继续往后遍历
                cur.remove(cur.size() - 1);
                if (i == 9) {//如果到9时都小于值，说明9前的一个元素的最大值都不满足条件，则再移除前一个元素，
                    cur.remove(cur.size() - 1);
                }
                h = k;//恢复成开始
                w = n;//恢复成开始
                continue;
            } else if ( w < 0) {//如果所求值小于0，此时后面都不用执行了，后面肯定更大
                if (cur.size() >= 2) {//如果此时cur有两个元素，就移除，没有两个元素，说明一个就大于所求值了，那保留着往后遍历也没影响
                    cur.remove(cur.size() - 1);
                    cur.remove(cur.size() - 1);
                }
                break;//退出此次循环
            } else {//如果w>0并且h>0
                if (i == 9 && h != 0) {//如果此时i=9时满足该条件，因为返回的集合是按照从小到大的顺序，
                                       // 而9后面没有元素了，所以要把9和前面一个元都移除
                    cur.remove(cur.size() - 1);
                    if(cur.size()-1>=0) {//如果此时是刚好只有一个9也满足条件
                        cur.remove(cur.size() - 1);
                    }
                } else {
                    combinationSum3(h, w);//此时继续往后找下一个元素
                    h = k;//进行下一次循环
                    w = n;//进行下一次循环
                }
            }
        }
        return res;
    }
    //别人的！学习，深搜+减枝
    List<List<Integer>> ans = new ArrayList<>();
    //尽量不要使用遗留类Stack,Deque完成可以实现Stack功能。
    Deque<Integer> path = new ArrayDeque<>();

    /**
     * 整体思路
     *
     * @param k k个数
     * @param n 组合成n（累加和为n)
     *          组合数范围1~9，且不重复
     * @return
     */
    public List<List<Integer>> combinationSum32(int k, int n) {
        dfs(k, n, 1);
        return ans;
    }

    /**
     * @param k     k个数
     * @param n     组合成n（累加和为n)
     * @param start 组合数范围start~9，且不重复
     */
    private void dfs(int k, int n, int start) {
        if (k < 0 || n < 0) return;   // 剪枝
        // 刚好k个数、刚好递减成0（说明这k个数累加和刚好为n)
        if (k == 0 && n == 0) {
            if (!path.isEmpty())
                ans.add(new ArrayList<>(path));
            return;
        }

        // 从start开始，到9的范围，然后就是递归分支（选、不选) 记得恢复状态
        for (int i = start; i < 10; i++) {
            path.push(i);
            dfs(k - 1, n - i, ++start);
            path.pop();
        }
    }


}

