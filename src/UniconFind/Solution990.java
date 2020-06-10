package UniconFind;

/**
 * @authtor liFei
 * @date 2020/6/8-7:37
 */
public class Solution990 {
    /*
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     */
    public boolean equationsPossible(String[] equations) {
        int []parent=new int[26];
        for(int i=0;i<26;i++){//每个父节点初始化都是自身
            parent[i]=i;
        }
        for (String cur:equations){
            if(cur.charAt(1)=='=') {//将等式的两个字母的父节点指向一个
                int index1 = cur.charAt(0)-'a';
                int index2 = cur.charAt(3)-'a';
                union(parent,index1,index2);//将他们的父节点指向同一个
            }
        }
        for (String cur:equations){
            if(cur.charAt(1)=='!') {//将等式的两个字母的父节点指向一个
                int index1 = cur.charAt(0)-'a';
                int index2 = cur.charAt(3)-'a';
                if(find(parent,index1)==find(parent,index2)){//如果这两点父节点相同
                    return false;
                }
            }
        }
        return true;
    }
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);//将第一个数的根节点的父节点指向第二个数的根结点
        //如果两个根节点相同，没有修改，如果不同，那么以index1对应的根节点为父节点的结点的根结点都修改成第二个结点
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {//只要不是最终的父节点
            parent[index] = parent[parent[index]];//将当前父节点的父节点赋值给该元素
            index = parent[index];//下标后移
        }
        return index;//找到最终的父节点
    }
    }

