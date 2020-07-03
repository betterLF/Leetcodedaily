package Design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @authtor liFei
 * @date 2020/6/30-7:15
 */
public class Solution284 {
    /*
    给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器
     -- 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
     */

    class PeekingIterator implements Iterator<Integer> {
        private LinkedList<Integer> list;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            list=new LinkedList<>();
             while (iterator.hasNext()){
                 list.addLast(iterator.next());
             }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
               return list.getFirst();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
           return list.removeFirst();
        }

        @Override
        public boolean hasNext() {
          return list.size()!=0;
        }
    }
    class PeekingIterator2 implements Iterator<Integer> {
        private Iterator<Integer> list;
        private Integer cur;
        private boolean flag;
        public PeekingIterator2(Iterator<Integer> iterator) {
            // initialize any member here.
          list=iterator;
          flag=false;
          cur=0;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
                if(flag==false) {
                    cur = list.next();
                    flag = true;
                    return cur;
                }else{
                    return cur;
                }
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
           if(flag){
               flag=false;
               return cur;
           }
           return list.next();
        }

        @Override
        public boolean hasNext() {
            return list.hasNext()||flag;
        }
    }
}
