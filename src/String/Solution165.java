package String;

/**
 * @authtor liFei
 * @date 2020/6/19-8:03
 */
public class Solution165 {
    /*
    比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
你可以假设版本字符串非空，并且只包含数字和 . 字符。
 . 字符不代表小数点，而是用于分隔数字序列。
例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
     */

    public int compareVersion(String version1, String version2) {
               int v1=0;
               int v2=0;
               char []vv1=version1.toCharArray();
               char []vv2=version2.toCharArray();
               while (v1<vv1.length&&v2<vv2.length){
                   while (v1<vv1.length&&vv1[v1]=='0'){//找到不为0的起点
                       if(v1+1<vv1.length&&vv1[v1+1]=='.'||v1+1>=vv1.length){
                           break;
                       }
                       v1++;
                   }
                   int n1=v1+1;
                   while (n1<vv1.length&&vv1[n1]!='.'){
                       n1++;
                   }
                   int temp1= Integer.parseInt(version1.substring(v1,n1));//得到当前字符串
                   while (v2<vv2.length&&vv2[v2]=='0'){//找到不为0的起点
                       if(v2+1<vv2.length&&vv2[v2+1]=='.'||v2+1>=vv2.length){
                           break;
                       }
                       v2++;
                   }
                   int n2=v2+1;
                   while (n2<vv2.length&&vv2[n2]!='.'){
                       n2++;
                   }
                   int temp2= Integer.parseInt(version2.substring(v2,n2));
                   if(temp1==temp2){
                       v1=n1+1;
                       v2=n2+1;
                       continue;
                   }else if(temp1>temp2){
                       return 1;
                   }else{
                       return -1;
                   }
               }
               if(v1>=vv1.length&&v2>=vv2.length){
                   return 0;
               }else if(v1>=vv1.length){
                   if(isZero(vv2,v2)){
                       return 0;
                   }
                   return -1;
               }else{
                   if(isZero(vv1,v1)){
                       return 0;
                   }
                   return 1;
               }
    }
  private boolean isZero(char c[],int start){
      for (int i = start; i <c.length ; i++) {
          if(c[i]=='0'||c[i]=='.'){
              continue;
          }else{
              return false;
          }
      }
      return true;
  }
}
