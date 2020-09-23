package Competition;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/9/20-7:14
 */
public class zhousai207 {
    /*
给你一个字符串 text ，该字符串由若干被空格包围的单词组成。
每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。题目测试用例保证 text 至少包含一个单词 。
请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，并尽可能 最大化 该数目。
如果不能重新平均分配所有空格，请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
返回 重新排列空格后的字符串 。
     */
    public String reorderSpaces(String text) {
          StringBuilder ans=new StringBuilder();
          int count=0;
        Queue<String> queue=new ArrayDeque<>();
        int start=0;
        for (int i = 0; i <text.length() ; i++) {
            if(text.charAt(i)==' '){
                count++;
                if(i-start>=1) {
                    queue.add(text.substring(start, i));
                }
                start=i+1;
            }
        }
        if(text.charAt(text.length()-1)!=' '){
            queue.add(text.substring(start, text.length()));
        }
        if(queue.size()==1){
            ans.append(queue.poll());
            for (int i = 0; i <count ; i++) {
                ans.append(' ');
            }
            return ans.toString();
        }
        int c=count/(queue.size()-1);
        int last=count-c*(queue.size()-1);
        StringBuilder cc=new StringBuilder();
        for (int i = 0; i <c ; i++) {
            cc.append(' ');
        }
        while (queue.size()!=1){
            ans.append(queue.poll()).append(cc);
        }
        ans.append(queue.poll());

        for (int i = 0; i <last ; i++) {
            ans.append(' ');
        }
        return ans.toString();
    }


/*
给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
注意：子字符串 是字符串中的一个连续字符序列。
 */
     Stack<String> stack;
     int max;
    public int maxUniqueSplit(String s) {
        stack=new Stack<>();
        max=0;
         back(s,0);
         return max;
    }
    private void back(String s,int start){
        if(start==s.length()){
            max=Math.max(stack.size(),max);
            return ;
        }
        int loss=s.length()-start;
        for (int i =1 ; i <=loss ; i++) {
            String cur=s.substring(start,start+i);
            if(stack.contains(cur)){
                 continue;
            }else{
                stack.add(cur);
                back(s,start+i);
                stack.pop();
            }
        }
    }


/*
给你一个大小为 rows x cols 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
在从左上角 (0, 0) 开始到右下角 (rows - 1, cols - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为负数，则返回 -1 。
注意，取余是在得到最大积之后执行的。
 */
long ans;
public int maxProductPath(int[][] grid) {
 ans=-1;
 back(0,0,grid,grid.length,grid[0].length,grid[0][0]);
 return (int)(ans%(1000000000+7));
}
private void back(int row,int col,int [][]grid,int m,int n,long cur){
    if(cur==0&&ans>0){
        return;
    }
    if(row==m-1&&col==n-1){
        ans=Math.max(ans,cur);
        return ;
    }
    if(row+1<m) {
        back(row + 1, col, grid, m, n, cur * grid[row + 1][col]);
    }
    if(col+1<n) {
        back(row , col+1, grid, m, n, cur * grid[row][col+1]);
    }
}

}
