public class Solution0101ms {
    /*
    实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     */
    //使用额外数据结构
    public static void main(String[] args) {
        StringBuilder s=new StringBuilder();
        for(int i=0;i<25;i++){
            s.append('0');
        }
        System.out.println(s);
        System.out.println(s.length());
s.replace(0,0,"1");


        System.out.println(s);
        System.out.println(s.length());

    }
    public boolean isUnique(String astr) {
        int len=astr.length();
        int temp[]=new int[256];
        for(int i=0;i<len;i++){
            if(temp[astr.charAt(i)]==1){
                return false;
            }
            temp[astr.charAt(i)]=1;
        }
        return true;
    }
    //不使用额外数据结构
    public boolean isUnique2(String astr) {
        int len=astr.length();
         StringBuilder s=new StringBuilder();
         for(int i=0;i<255;i++){
             s.append('0');
         }
       for(int i=0;i<astr.length();i++){
           int index=astr.charAt(i);
           if(s.charAt(index)=='1'){
               return false;
           }
           s.setCharAt(index,'1');
       }
        return true;
    }
    //位运算！他人思路
    public boolean isUnique3(String astr) {
        long x=0; //64位二进制，假定末尾二进制代表‘a’
        int n=astr.length();
        for(int i=0;i<n;i++){
            int c=astr.charAt(i)-'a';//计算索引处为i的字符的ascll码减去'a'的ascll码得到它的位置
            if(((x>>c)&1)==1){ //x右移c位，此时位于末尾的就代表着astr.CharAt(i)，如果与1&，为1说明此时该位置为1，
                                // 说明已经存在该元素，返回false
                return false;
            }
            x|=(1<<c); //1<<c将1左移c位，与x|,使得x的末尾数第i位为1；
        }
        return true;
    }
}
