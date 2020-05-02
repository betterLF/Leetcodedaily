package Greedy;

/**
 * @authtor liFei
 * @date 2020/5/1-8:22
 */
public class Solution860 {
    /*
    在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，
也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     */
    public boolean lemonadeChange(int[] bills) {
             int arr[]=new int [20];
             if(bills[0]!=5){
                 return false;
             }
              arr[5]=1;
             for (int i=1;i<bills.length;i++){
                 if(bills[i]==5){
                     arr[5]++;
                 }else if(bills[i]==10){
                     if(arr[5]!=0){
                         arr[5]--;
                         arr[10]++;
                     }else{
                         return false;
                     }
                 }else{
                     if(arr[5]!=0&&arr[10]>=1){
                         arr[10]--;
                         arr[5]--;
                     }else if(arr[5]>=3){
                         arr[5]-=3;
                     }else{
                         return false;
                     }
                 }
             }
             return true;
    }
}
