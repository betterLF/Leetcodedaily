package Bitwise;

/**
 * @authtor liFei
 * @date 2020/7/14-7:36
 */
public class Solution393 {
    /*
UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
这是 UTF-8 编码的工作方式：
     */

    public boolean validUtf8(int[] data) {
        int len=data.length;
        if(len==0){
            return false;
        }
        int []temp=new int[len];
        for (int i = 0; i <len ; i++) {
            temp[i]=(data[i]&255);//得到每个字符的低八位
            if(temp[i]<128){//0xxxxxxxx
                temp[i]=0;
            } else if(temp[i]<192){//10xxxxxx
                temp[i]=1;
            }else if(temp[i]<224){//110xxxxxx
                temp[i]=2;
            }else if(temp[i]<240){//1110xxxx
                temp[i]=3;
            }else if(temp[i]<247){//11110xxx
                temp[i]=4;
            }else{
                return false;
            }
        }
        for (int i = 0; i <len ; i++) {
            if(temp[i]==0){
                continue;
            }else if(temp[i]==2){
                if(i+1<len&&temp[i+1]==1){
                    i+=1;
                }else{
                    return false;
                }
            }else if(temp[i]==3){
                if(i+2<len&&temp[i+1]==1&&temp[i+2]==1){
                    i+=2;
                }else{
                    return false;
                }
            }else if(temp[i]==4){
                if(i+3<len&&temp[i+1]==1&&temp[i+2]==1&&temp[i+3]==1){
                    i+=3;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
