package String;

/**
 * @authtor liFei
 * @date 2020/4/20-8:09
 */
public class Solution1108 {
    /*
    给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     */
    public String defangIPaddr(String address) {
          StringBuilder res=new StringBuilder();
          for(char cur:address.toCharArray()){
              if(cur=='.'){
                  res.append("[.]");
              }else{
                  res.append(cur);
              }
          }
          return res.toString();
    }
}
