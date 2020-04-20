package String;

/**
 * @authtor liFei
 * @date 2020/4/20-8:12
 */
public class Solution709 {
    /*
实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     */
    public String toLowerCase(String str) {
          StringBuilder res=new StringBuilder();
          for(char c:str.toCharArray()){
              if(c>='A'&&c<='Z'){
                  res.append((char)(c+32));
              }else{
                  res.append(c);
              }
          }
          return res.toString();
    }
}
