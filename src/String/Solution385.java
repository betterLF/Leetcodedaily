package String;

/**
 * @authtor liFei
 * @date 2020/7/13-6:25
 */
//public class Solution385 {
    /*
    给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。
列表中的每个元素只可能是整数或整数嵌套列表
提示：你可以假定这些字符串都是格式良好的：
字符串非空
字符串不包含空格
字符串只包含数字0-9、[、-、,、]
     */

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
//      public class NestedInteger {
//          // Constructor initializes an empty nested list.
//          public NestedInteger();
//
//         // Constructor initializes a single integer.
//         public NestedInteger(int value);
//
//          // @return true if this NestedInteger holds a single integer, rather than a nested list.
//         public boolean isInteger();
//        // @return the single integer that this NestedInteger holds, if it holds a single integer
//          // Return null if this NestedInteger holds a nested list
//          public Integer getInteger();
//
//         // Set this NestedInteger to hold a single integer.
//          public void setInteger(int value);
//
//          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//          public void add(NestedInteger ni);
//
//          // @return the nested list that this NestedInteger holds, if it holds a nested list
//          // Return null if this NestedInteger holds a single integer
//          public List<NestedInteger> getList();
//     }
//    int nowIndex;
//    public NestedInteger deserialize(String s) {
//        char []c=s.toCharArray();
//        nowIndex=0;
//        return dfs(c,0);
//    }
//    private NestedInteger dfs(char []c,int start){
//        int cur=0;
//        boolean flag=false;
//        boolean a=false;
//        boolean zf=false;
//        NestedInteger nestedInteger=new NestedInteger();
//        for (int i = start; i <c.length ; i++) {
//            if(c[i]=='-'){
//                zf=true;
//            }
//            if(c[i]==','){
//                if(zf){
//                    cur=-cur;
//                    zf=false;
//                }
//                if(flag) {
//                    nestedInteger.add(new NestedInteger(cur));
//                    flag=false;
//                }
//                a=true;
//                cur=0;
//            }else if(c[i]>='0'&&c[i]<='9'){//拼接字符
//                cur=cur*10+c[i]-'0';
//                flag=true;
//            }else if(c[i]=='['&&i!=0){//递归下一个列表
//                a=true;
//                nestedInteger.add(dfs(c,i+1));
//                i=nowIndex;
//            }else if(c[i]==']'){//如果当前为右括号，当前该列表已经出现，直接返回
//                if(flag) {
//                    a=true;
//                    if(zf){
//                        cur=-cur;
//                        zf=false;
//                    }
//                    nestedInteger.add(new NestedInteger(cur));
//                }
//                nowIndex=i;
//                return nestedInteger;
//            }
//        }
//        if(flag) {
//            if(zf){
//                cur=-cur;
//                zf=false;
//            }
//            if(a) {
//                nestedInteger.add(new NestedInteger(cur));
//            }else{
//                nestedInteger.setInteger(cur);
//            }
//        }
//        return nestedInteger;
//    }
//}
