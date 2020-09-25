package Stack;

import java.util.Stack;

/**
 * @authtor liFei
 * @date 2020/9/23-7:35
 */
public class Solution735 {
    /*
    给定一个整数数组 asteroids，表示在同一行的行星。
对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <asteroids.length ; i++) {
            boolean flag=true;
            boolean turn=false;
            while (stack.size()>0&&asteroids[i]<0&&stack.peek()>0&&flag){
                    if(stack.peek()<-asteroids[i]){
                        stack.pop();
                        turn=true;
                        continue;
                    }else if(stack.peek()==-asteroids[i]){
                           stack.pop();
                    }
                    turn=false;
                    flag=false;
            }
            if(turn) {
                stack.push(asteroids[i]);
            }
        }
        int []ans=new int[stack.size()];
        for (int i = ans.length-1; i>=0 ; i--) {
            ans[i]=stack.pop();
        }
        return ans;
    }
}
