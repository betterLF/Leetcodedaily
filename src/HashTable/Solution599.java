package HashTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @authtor liFei
 * @date 2020/8/12-6:55
 */
public class Solution599 {
    /*
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<String> ans=new ArrayList<>();
        for (int i = 0; i <list1.length ; i++) {
            map.put(list1[i],i);
        }
        int indexOfSum=Integer.MAX_VALUE;
        for (int i = 0; i <list2.length ; i++) {
            if(i>indexOfSum){
                break;
            }
            if(map.containsKey(list2[i])){
                if(i+map.get(list2[i])<indexOfSum){
                    ans.clear();
                    ans.add(list2[i]);
                    indexOfSum=i+map.get(list2[i]);
                }else if(i+map.get(list2[i])==indexOfSum){
                    ans.add(list2[i]);
                }
            }
        }
//        String []res=new String[ans.size()];
//        for (int i = 0; i <res.length ; i++) {
//            res[i]=ans.get(i);
//        }
       // return res;
        return ans.toArray(new String[ans.size()]);
    }
}
