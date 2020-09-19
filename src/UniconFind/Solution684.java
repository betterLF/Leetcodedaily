package UniconFind;

/**
 * @authtor liFei
 * @date 2020/9/17-18:10
 */
public class Solution684 {

    /*
        在本问题中, 树指的是一个连通且无环的无向图。
    输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
    附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
    结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
    返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
         */
    public int []result;
    public int[] findRedundantConnection(int[][] edges) {
        int len=edges.length;
       result=new int[2];
         int []father=new int[len+1];
        for (int i = 0; i <father.length ; i++) {
            father[i]=i;
        }
        for (int i = 0; i <edges.length ; i++) {
                union(father,edges[i][0],edges[i][1]);
        }
        return result;
    }
    private int father(int []father,int x){
        while (father[x]!=x){
            father[x]=father[father[x]];
            x=father[x];
        }
        return x;
    }
    private void union(int []father,int x,int y){
        int x_father=father(father,x);
        int y_father=father(father,y);
        if(x_father!=y_father){
            father[x_father]=y_father;
        }else{
            result[0]=x;
            result[1]=y;
        }
    }
}
