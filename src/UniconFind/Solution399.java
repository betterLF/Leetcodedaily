package UniconFind;

import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/15-6:40
 */
public class Solution399 {
    /*
    给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。
    根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
输入为: vector<pair<string, string>> equations, vector<double>& values,
 vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，
 即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
     */
    class Node {
    private String name;
    private double value;
    private Node parent;
    public Node(String name){
         this.name=name;
         this.value=1.0;//A/fatherA = 1.0
         this.parent=this;
    }
}
    HashMap<String,Node> hashMap=new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 1. 初始化
        for (int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);

            Node node1 = new Node(s1);
            Node node2 = new Node(s2);
            hashMap.put(s1, node1);
            hashMap.put(s2, node2);
        }

        // 2. 更新；
        for (int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            double value = values[i];

            Node node1 = hashMap.get(s1);
            Node node2 = hashMap.get(s2);
            UnionAB(node1, node2, value);
        }

        // 3. 计算；
        return getResult(queries);
    }
    public double[] getResult(List<List<String>> queries) {
        int K = queries.size();
        double[] result = new double[K];

        for (int i = 0; i < K; i++) {
            String s1 = queries.get(i).get(0);
            String s2 = queries.get(i).get(1);

            if (!hashMap.containsKey(s1) || !hashMap.containsKey(s2)) {
                result[i] = -1.0;
            } else {
                Node node1 = hashMap.get(s1);
                Node node2 = hashMap.get(s2);
                Node f1 = findFather(node1);
                Node f2 = findFather(node2);
                if (!f1.equals(f2)) {
                    result[i] = -1.0;
                } else {
                    double s = calRatio(node1) / calRatio(node2);
                    result[i] = s;
                }
            }
        }
        return result;
    }

    // 查找A 的 父节点(祖先)
    private Node findFather(Node A) {
        Node fatherNode = A.parent;
        if (fatherNode.equals(A)) {
            return A;
        }
        return findFather(fatherNode);
    }

    // A/B ， A's father is B
    private void UnionAB(Node A, Node B, double value) {
        Node nodeA = findFather(A);
        Node nodeB = findFather(B);
        nodeA.parent = nodeB;
        nodeA.value = value * calRatio(B) / calRatio(A);
    }

    private double calRatio(Node A) {
        double s = 1.0;
        while (!A.parent.equals(A)) {
            s = s * A.value;
            A = A.parent;
        }
        return s;
    }

}
