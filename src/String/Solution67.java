package String;

/**
 * @authtor liFei
 * @date 2020/5/27-17:33
 */
public class Solution67 {
    /*
    给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。
     */
    public String addBinary(String a, String b) {
                  char []aa=a.toCharArray();
                  char []bb=b.toCharArray();
                  int len1=aa.length-1;
                  int len2=bb.length-1;
                  char curC='0';
                  StringBuilder ans=new StringBuilder();
                  while (len1>=0&&len2>=0){
                   if((curC-'0')+(aa[len1]-'0')+(bb[len2]-'0')==3){
                       ans.append('1');
                       curC='1';
                   }else if((curC-'0')+(aa[len1]-'0')+(bb[len2]-'0')==2){
                       ans.append('0');
                       curC='1';
                   }else if((curC-'0')+(aa[len1]-'0')+(bb[len2]-'0')==1){
                       ans.append('1');
                       curC='0';
                   }else{
                       ans.append('0');
                   }
                   len1--;
                   len2--;
                  }
                  if(len1<0){
                      while (len2>=0){
                          if((curC-'0')+(bb[len2]-'0')==2){
                              ans.append('0');
                              curC='1';
                          }else if((curC-'0')+(bb[len2]-'0')==1){
                              ans.append('1');
                              curC='0';
                          }else{
                              ans.append('0');
                          }
                          len2--;
                      }
                  }else {
                      while (len1>=0){
                          if((curC-'0')+(aa[len1]-'0')==2){
                              ans.append('0');
                              curC='1';
                          }else if((curC-'0')+(aa[len1]-'0')==1){
                              ans.append('1');
                              curC='0';
                          }else{
                              ans.append('0');
                          }
                          len1--;
                      }
                  }
                  if(curC=='1'){
                      ans.append('1');
                  }else{
                      if(ans.charAt(ans.length()-1)=='0'){
                          ans.deleteCharAt(ans.length()-1);
                      }
                  }
                  if(ans.length()==0){
                      ans.append('0');
                  }
                  return ans.reverse().toString();
    }
}
