package Greedy;

/**
 * @authtor liFei
 * @date 2020/9/13-17:35
 */
public class Solution649 {

/*
 Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
禁止一名参议员的权利：
参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
宣布胜利：
          如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。
然后，如果有 n 个参议员，给定字符串的大小将是 n。
以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。
所有失去权利的参议员将在过程中被跳过。
假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在
Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 */
//public String predictPartyVictory(String senate) {
//        Queue<Integer> queue = new LinkedList();
//        int[] people = new int[]{0, 0};
//        int[] bans = new int[]{0, 0};
//
//        for (char person: senate.toCharArray()) {
//            int x = person == 'R' ? 1 : 0;
//            people[x]++;
//            queue.add(x);
//        }
//
//        while (people[0] > 0 && people[1] > 0) {
//            int x = queue.poll();
//            if (bans[x] > 0) {
//                bans[x]--;
//                people[x]--;
//            } else {
//                bans[x^1]++;
//                queue.add(x);
//            }
//        }
//
//        return people[1] > 0 ? "Radiant" : "Dire";
//    }
    public String predictPartyVictory(String senate) {

        boolean R = true, D = true;
        char[] arr = senate.toCharArray();

//      标记变量，当person > 0的时候，此时R方有权利把D方的成员淘汰掉
//      当person < 0的时候，D方有权利把R方的成员淘汰掉
        int person = 0;
        while(R && D) {

//        	当遇到双方成员的时候置为true，表示当前还有人员存在
//        	当R或D为false，表示一方已经没有成员存在了，胜负已分，结束循环
            R = false; D = false;

            for(int i = 0; i < arr.length; ++i) {
                if(arr[i] == 'R') {
                    R = true;
                    if(person < 0) arr[i] = 'O';
                    ++person;
                }
                else if(arr[i] == 'D') {
                    D = true;
                    if(person > 0) arr[i] = 'O';
                    --person;
                }
            }
        }
        return person > 0 ? "Radiant" : "Dire";
    }
}

