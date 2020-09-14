package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @authtor liFei
 * @date 2020/9/11-7:51
 */
public class Solution638 {
    /*
    在LeetCode商店中， 有许多在售的物品。
然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
任意大礼包可无限次购买。
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        return shopping(price,special,needs,map);

    }
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs,HashMap<List<Integer>,Integer> map){
        if(map.containsKey(needs)){
            return map.get(needs);
        }
        int res=curAns(price,needs);
        for (List<Integer> s:special){
            List<Integer> cur=new ArrayList<>(needs);
            int i=0;
            for (; i <needs.size() ; i++) {
                int dif=cur.get(i)-s.get(i);
            if(dif<0){
                break;
            }else{
                cur.set(i,dif);
            }
            }
            if(i==needs.size()){
                res=Math.min(res,s.get(i)+shopping(price, special, cur, map));
            }
        }
        map.put(needs,res);
        return res;
    }
    private int curAns(List<Integer> price,List<Integer> needs){
        int ans=0;
        for (int i = 0; i <price.size() ; i++) {
            ans+=price.get(i)*needs.get(i);
        }
        return ans;
    }
}

