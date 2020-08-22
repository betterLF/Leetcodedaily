package Tree;

/**
 * @authtor liFei
 * @date 2020/8/20-7:21
 */
public class Solution558 {
    /*
    二进制矩阵中的所有元素不是 0 就是 1 。
给你两个四叉树，quadTree1 和 quadTree2。其中 quadTree1 表示一个 n * n 二进制矩阵，而 quadTree2 表示另一个 n * n 二进制矩阵。
请你返回一个表示 n * n 二进制矩阵的四叉树，它是 quadTree1 和 quadTree2 所表示的两个二进制矩阵进行 按位逻辑或运算 的结果。
注意， isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
     */
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };
    public Node intersect(Node quadTree1, Node quadTree2) {
               return Order(quadTree1,quadTree2);
    }
    private Node Order(Node quadTree1,Node quadTree2){
        if(quadTree1.isLeaf){//如果其为叶子结点
            if(quadTree1.val){//如果其值为true，即1则直接返回该结点
                return quadTree1;
            }
            return quadTree2;//否则返回另外一个结点
        }else if(quadTree2.isLeaf){
            if(quadTree2.val){
                return quadTree2;
            }
            return quadTree1;
        }
        //合并之后的各个分支
        Node topLeft = Order(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = Order(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = Order(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = Order(quadTree1.bottomRight, quadTree2.bottomRight);

        //因为可能存在返回的都叶子节点 因此要判断一下返回的节点是否全部叶子节点 并且 都为 True 或者 False 这样要合并为一个大的节点
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
            return new Node(topLeft.val,true,null,null,null,null);
        }
        //否则的话保留各个分支节点 不进行合并
        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}

