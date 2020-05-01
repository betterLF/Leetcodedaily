package HashTable;

import java.util.HashSet;

/**
 * @authtor liFei
 * @date 2020/4/29-6:39
 */
public class Solution575 {
    /*
    给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
    你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
     */
    public int distributeCandies(int[] candies) {
        HashSet<Integer> kind=new HashSet<>();
        int len=candies.length/2;
        for (int cur:candies){
            kind.add(cur);
        }
        if(len<=kind.size()){
            return len;
        }else{
            return kind.size();
        }
    }
}
