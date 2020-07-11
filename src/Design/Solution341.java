package Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/7/9-7:30
 */
public class Solution341 {
    /*
给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
     */
  public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
             public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return null if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
  }
    public class NestedIterator implements Iterator<Integer> {
          ArrayList<Integer> list;
          int count;
          int sum;
        public NestedIterator(List<NestedInteger> nestedList) {
                     count=0;//初始化下标为0
            list=new ArrayList<>();
            for (int i = 0; i <nestedList.size() ; i++) {
                if(nestedList.get(i).isInteger()){
                    list.add(nestedList.get(i).getInteger());
                }else{
                    dfs(nestedList.get(i).getList());
                }
            }
            sum=list.size();
        }

        @Override
        public Integer next() {
                    if (hasNext()){
                        Integer integer = list.get(count);
                        count++;
                        return integer;
                    }else{
                        return -1;
                    }
        }

        @Override
        public boolean hasNext() {
              if(count<sum){
                  return true;
              }else {
                  return false;
              }
        }
        public void dfs(List<NestedInteger> nestedList){
            for (int i = 0; i <nestedList.size() ; i++) {
                if(nestedList.get(i).isInteger()){
                    list.add(nestedList.get(i).getInteger());
                }else{
                         dfs(nestedList.get(i).getList());
                }
            }
        }
    }
}
