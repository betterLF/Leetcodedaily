package Competition;

import java.util.*;

/**
 * @authtor liFei
 * @date 2020/4/19-10:25
 */
public class zhousai185 {
    /*
    5388. 重新格式化字符串
给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
     */
    public static void main(String[] args) {
    }
    public static String reformat(String s) {
       char cur[]=s.toCharArray();
       char num[]=new char[s.length()];
       int len1=0;
       char num2[]=new char[s.length()];
       int len2=0;
       for(char c:cur){
           if(c>='0'&&c<='9'){
               num[len1]=c;
               len1++;
           }else{
               num2[len2]=c;
               len2++;
           }
       }
       if(Math.abs(len1-len2)>1){
           return new String();
       }
       StringBuilder res=new StringBuilder();
       int min=Math.min(len1,len2);
       if(min<len1){
           for(int i=0;i<min;i++){
               res.append(num[i]).append(num2[i]);
           }
           res.append(num[len1-1]);
       }else if(min<len2){
           for(int i=0;i<min;i++){
               res.append(num2[i]).append(num[i]);
           }
           res.append(num2[len2-1]);
       }else{
           for(int i=0;i<min;i++){
               res.append(num2[i]).append(num[i]);
           }
       }
       return res.toString();
    }
    /*
    5389. 点菜展示表
    给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
    其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans=new ArrayList<>();
        ArrayList<String> food=new ArrayList<>();
       ArrayList<String> table=new ArrayList<>();
        for(List<String> c:orders) {
            if (!food.contains(c.get(2))) {
                food.add(c.get(2));
            }
            if (!table.contains(c.get(1))) {
                table.add(c.get(1));
            }
        }
        String ff[]=new String[food.size()];
        for(int i=0;i<food.size();i++){
            ff[i]=food.get(i);
        }
        String tt[]=new String[table.size()];
        for(int i=0;i<table.size();i++){
            tt[i]=table.get(i);
        }
      Comparator<String> f=new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
             char one[]=o1.toCharArray();
             char two[]=o2.toCharArray();
             int min=Math.min(one.length,two.length);
             for(int i=0;i<min;i++){
                 if(one[i]<two[i]){
                     return 1;
                 }else if(one[i]>two[i]){
                     return -1;
                 }
             }
             if(min==one.length){
                 return 1;
             }else {
                 return -1;
             }
          }
      };
        Comparator<String> t=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        };
        Arrays.sort(ff,f);
        Arrays.sort(tt,t);
        for(int i=0;i<=tt.length;i++){
            ans.add(new ArrayList<>());
        }
        ans.get(0).add("table");
        for(int i=0;i<ff.length;i++){
            ans.get(0).add(ff[i]);
        }
        for(int i=1;i<=tt.length;i++){
            ans.get(i).add(tt[i-1]);
            int fff[]=new int[ff.length];
            for(List<String> c:orders){
                if(c.get(1).equals(tt[i-1])){
                    String cur=c.get(2);
                    for(int j=0;j<ff.length;j++){
                        if(ff[j].equals(cur)){
                            fff[j]++;
                            break;
                        }
                    }
                }
            }
            for(int cur:fff){
                ans.get(i).add(String.valueOf(cur));
            }
        }
        return ans;
    }
    /*
    5390. 数青蛙
    给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
    所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
     */
    public int minNumberOfFrogs(String croakOfFrogs) {
      int num[]=new int[5];//用于存放当前5个字符的个数，其中k字符个数恒为0，
        // 每次碰到k字符，记录此时的num[0]的大小，与max进行比较，并且前4个字符均-1
      char start[]=croakOfFrogs.toCharArray();
      int max=0;
      for(char cur:start){
          if(cur=='c'){//碰到c字符，num[0]就+1
              num[0]++;
          }else if(cur=='r'){//碰到r字符，要确保num[1]+1后不能大于num[0]，否则就会出现无效的字符
              if(num[0]<=num[1]){
                  return -1;
              }
              num[1]++;
          }else if(cur=='o'){//同上
              if(num[1]<=num[2]){
                  return -1;
              }
              num[2]++;
          }else if(cur=='a'){//同上
              if(num[2]<=num[3]){
                  return -1;
              }
              num[3]++;
          }else{
              if(num[3]<=num[4]){//同上
                  return -1;
              }
              max=max>=num[0]?max:num[0];//此时num[0]存放的就是到目前为止(即出现一个k前)的c个数，代表有多少只青蛙
              num[0]--;//出现k，所以一个croak就结束，前4个元素都-1.
              num[1]--;
              num[2]--;
              num[3]--;
          }
      }
        for (int i = 0; i <5 ; i++) {//确保croak是完整的
            if(num[i]!=0){
                return -1;
            }
        }
        return max;
    }
}
