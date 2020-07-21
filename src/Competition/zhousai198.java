package Competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/19-6:58
 */
public class zhousai198 {
    /*
小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
请你计算 最多 能喝到多少瓶酒。
     */
    public int numWaterBottles(int numBottles, int numExchange) {
                  int curLast=numBottles;
                  int cur=0;
                  int ans=0;
                  while (numBottles!=0){
                      numBottles--;
                      ans++;
                      cur++;
                      if(cur==numExchange){
                          numBottles++;
                          cur=0;
                      }
                  }
                  return ans;
    }
    /*
给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，
树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）
边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。
返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。
树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树。
     */
//
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        ArrayList<Integer>[] graph = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        for (int[] edge : edges) {
//            graph[edge[0]].add(edge[1]);
//            graph[edge[1]].add(edge[0]);
//        }
//        int[] count = new int[26], sum = new int[n];
//        boolean[] visited = new boolean[n];
//        countSubTrees(0, visited, sum, count, graph, labels);
//        return sum;
//    }
//
//    private void countSubTrees(int index, boolean[] visited, int[] sum, int[] count, ArrayList<Integer>[] graph,
//                               String labels) {
//        if (!visited[index]) {
//            visited[index] = true;
//            for (int i : graph[index]) {
//                int[] newCount = new int[26];
//                countSubTrees(i, visited, sum, newCount, graph, labels);
//                for (int j = 0; j < 26; j++) {
//                    count[j] += newCount[j];
//                }
//                sum[index] += newCount[labels.charAt(index) - 'a'];
//            }
//            sum[index]++;
//            count[labels.charAt(index) - 'a']++;
//        }
//    }
    int []ans;
    boolean []visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char []c=labels.toCharArray();
        ans=new int[n];
        visited=new boolean[n];
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i <edges.length ; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
                dfs(map, 0, c);
        return ans;
    }
    private int[] dfs(HashMap<Integer,ArrayList<Integer>> map,int curIndex,char[]c){
        visited[curIndex]=true;
        ArrayList<Integer> list = map.get(curIndex);
        ArrayList<int[]> arr=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if(visited[list.get(i)]==false) {
                arr.add(dfs(map, list.get(i), c));
            }
        }
        int temp[]=new int[26];
        for (int i = 0; i <arr.size() ; i++) {
            for (int j = 0; j <26 ; j++) {
                temp[j]+=arr.get(i)[j];
            }
        }
        temp[c[curIndex]-'a']++;
        ans[curIndex]= temp[c[curIndex]-'a'];
        return temp;
    }
    /*
给你一个只包含小写字母的字符串 s ，你需要找到 s 中最多数目的非空子字符串，满足如下条件：
这些字符串之间互不重叠，也就是说对于任意两个子字符串 s[i..j] 和 s[k..l] ，要么 j < k 要么 i > l 。
如果一个子字符串包含字符 c ，那么 s 中所有 c 字符都应该在这个子字符串中。
请你找到满足上述条件的最多子字符串数目。如果有多个解法有相同的子字符串数目，
请返回这些子字符串总长度最小的一个解。可以证明最小总长度解是唯一的。
请注意，你可以以 任意 顺序返回最优解的子字符串。
     */
    public List<String> maxNumOfSubstrings(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                index[i][j] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {//得到每个字母的出现位置和结束位置
            if (index[s.charAt(i) - 'a'][0] == -1) {
                index[s.charAt(i) - 'a'][0] = i;
            }
            index[s.charAt(i) - 'a'][1] = i;
        }
        int[] ee = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ee[i] = -1;
        }
        for (int i = 0; i < 26; i++) {
            if (index[i][0] != -1) {
                int max = index[i][1];
                for (int j = index[i][0]; j <= max; j++) {//一开始从当前元素的开头遍历到结尾
                    if (index[s.charAt(j) - 'a'][0] >= index[i][0]) {//如果当前元素的开头元素大于该元素位置
                        max = Math.max(max, index[s.charAt(j) - 'a'][1]);//最大位置更新
                    } else {//否则该位置不能作为开头
                        ee[index[i][0]] = -2;
                        break;
                    }
                }
                if (ee[index[i][0]] != -2) {//如果该位置可以作为开头，则该位置能满足条件的边界点为max
                    ee[index[i][0]] = max;
                }
            }
        }
        int start = ee.length;
        ArrayList<String> list = new ArrayList<>();
        for (int i = ee.length - 1; i >= 0; i--) {
            if (ee[i] >= 0 && ee[i] < start) {//如果i位置可以作为开头并且其最后一个位置小于当前字符串长度
                list.add(s.substring(i, ee[i] + 1));//将该字符加入结果集
                start = i;
            }
        }
        return list;
    }
}
