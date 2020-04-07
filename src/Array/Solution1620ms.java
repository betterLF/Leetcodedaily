import java.util.LinkedList;
import java.util.List;

public class Solution1620ms {
    /*
    在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。
    每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。
    你会得到一张含有有效单词的列表。映射如下图所示：
     */
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res=new LinkedList<>();
             for(int i=0;i<words.length;i++){
                 if(words[i].length()!=num.length()){
                     continue;
                 }
                 int count=words.length-1;
                 while(count>=0){
                    int temp= words[i].charAt(count)-'a';
                    int temp2=num.charAt(count)-'0';
                     if(temp2<7){
                         if((temp2-2)*3<=temp&&temp<(temp2-1)*3){
                             count--;
                             continue;
                         }else{
                             break;
                         }
                     }
                     if(temp2==7){
                         if(15<=temp&&temp<=18){
                             count--;
                             continue;
                         }else{
                             break;
                         }
                     }
                     if(temp2==8){
                         if(19<=temp&&temp<=21){
                             count--;
                             continue;
                         }else{
                             break;
                         }
                     }
                     if(temp2==9){
                         if(22<=temp&&temp<=25){
                             count--;
                             continue;
                         }else{
                             break;
                         }
                     }
                 }
                 if(count==0){
                     res.add(words[i]);
                 }
             }
             return res;
    }
}
