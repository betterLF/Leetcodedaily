package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @authtor liFei
 * @date 2020/7/16-20:20
 */
public class Solution785 {
    /*
    给定一个无向图graph，当这个图为二分图时返回true。
如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，
一个来自B集合，我们就将这个图称为二分图。
graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。
这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
     */
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    public boolean isBipartite(int[][] graph) {
      int n=graph.length;
      color=new int[n];
        Arrays.fill(color,UNCOLORED);
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {//如果当前图没有被分配，如果分配过则肯定满足条件
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = RED;//当前结点为red图
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;//得到当前结点不在哪个图
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;//将该点放到不同的图中
                        } else if (color[neighbor] != cNei) {//如果该点不为不同的点，直接返回false
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    }

