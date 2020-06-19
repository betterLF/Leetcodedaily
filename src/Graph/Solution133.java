package Graph;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/6/15-7:35
 */
public class Solution133 {
    /*
    给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}
测试用例格式：
简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），
以此类推。该图在测试用例中使用邻接列表表示。
邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
     */
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
             Node newHead=new Node(1);//第一个结点
             Node temp=node;
            HashMap<Integer,Node> map=new HashMap<>();//存放对应克隆结点
             map.put(1,newHead);
             Queue<Node> queue=new ArrayDeque<>();
             HashSet<Integer> set=new HashSet<>();
             set.add(1);
             queue.add(temp);
             while (queue.size()!=0){
                 Node c=queue.poll();//原结点
                 Node cc=map.get(c.val);//得到对应的克隆结点
                 for (int i = 0; i <c.neighbors.size() ; i++) {
                     Node neighbour=c.neighbors.get(i);//得到该原结点的一个邻接结点
                     if(!set.contains(neighbour.val)) {//如果该结点未出现过
                         queue.add(neighbour);//将其加入bfs队列中
                         set.add(neighbour.val);
                         map.put(neighbour.val,new Node(neighbour.val));//创建克隆结点
                     }
                     cc.neighbors.add(map.get(neighbour.val));//克隆
                 }
             }
             return newHead;
    }
}
