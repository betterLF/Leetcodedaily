import java.util.*;
/*
牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
现在，重复执行以下步骤，直到显示所有卡牌为止：
从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
返回能以递增顺序显示卡牌的牌组顺序。
答案中的第一张牌被认为处于牌堆顶部。
 */
public class Solution950 {
    //集合解法
    public int[] deckRevealedIncreasing(int[] deck) {
        int len=deck.length;
        Arrays.sort(deck);
        List<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<len;i++){
            arr.add(i);
        }
        int res[]=new int[len];
        int temp=0;
        for(int i=0;i<len;i++){
            res[arr.get(0)]=deck[i];//arr.get(0)代表输出的顺序，比如1,3，则只要res[1]=deck[0],res[3]=deck[1]就行
            arr.remove(0);
            if(arr.size()!=0){
                temp=arr.get(0);
                arr.remove(0);
                arr.add(temp);
            }
        }
        return res;
    }
    //队列解法，思路一样，但是时间复杂度更优
    public int[] deckRevealedIncreasing2(int[] deck) {
        int len=deck.length;
        Arrays.sort(deck);
       Deque<Integer> arr=new LinkedList<>();
        for(int i=0;i<len;i++){
            arr.add(i);
        }
        int res[]=new int[len];
        int temp=0;
        for(int i=0;i<len;i++){
        res[arr.pollFirst()]=deck[i];//pollFirst()检索并删除第一个元素，返回该元素，如果为空，则为null
        if(!arr.isEmpty()){
            arr.add(arr.pollFirst());
        }
        }
        return res;
    }
}
