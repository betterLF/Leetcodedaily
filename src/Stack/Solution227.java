package Stack;

import java.util.LinkedList;

/**
 * @authtor liFei
 * @date 2020/6/29-7:09
 */
public class Solution227 {
    /*
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
     */
    public int calculate(String s) {
        char[] c = s.toCharArray();
        double first = 0.5;
        double second = 0.5;
        double third = 0.5;
        int flag[] = new int[2];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                continue;
            } else if (c[i] == '+') {
                if (flag[0] == 0) {
                    flag[0] = 1;
                } else {
                    flag[1] = 1;
                }
            } else if (c[i] == '-') {
                if (flag[0] == 0) {
                    flag[0] = 2;
                } else {
                    flag[1] = 2;
                }
            } else if (c[i] == '*') {
                if (flag[0] == 0) {
                    flag[0] = 3;
                } else {
                    flag[1] = 3;
                }
            } else if (c[i] == '/') {
                if (flag[0] == 0) {
                    flag[0] = 4;
                } else {
                    flag[1] = 4;
                }
            } else {
                int j = i + 1;
                while (j < c.length && !(c[j] == ' ' || c[j] == '+' || c[j] == '-' || c[j] == '*' || c[j] == '/')) {
                    j++;
                }
                int temp = Integer.parseInt(s.substring(i, j));
                if (first == 0.5) {
                    first = temp;
                } else if (second == 0.5) {
                    second = temp;
                } else {
                    third = temp;
                }
                i = j - 1;
                if (flag[1] != 0) {//如果已经有了两个运算符
                    if ((flag[1] == 1 || flag[1] == 2) && (flag[0] == 1 || flag[0] == 2)) {
                        if (flag[0] == 1) {
                            first += second;
                        } else {
                            first -= second;
                        }
                        second = third;
                        third = 0.5;
                        flag[0] = flag[1];
                        flag[1] = 0;
                    } else if (flag[0] == 3 || flag[0] == 4) {
                        if (flag[0] == 3) {
                            first *= second;
                        } else {
                            first = (int) first / (int) second;
                        }
                        second = third;
                        third = 0.5;
                        flag[0] = flag[1];
                        flag[1] = 0;
                    } else {
                        if (flag[1] == 3) {
                            second *= third;
                        } else {
                            second = (int) second / (int) third;
                        }
                        third = 0.5;
                        flag[1] = 0;
                    }
                }
            }
        }
        if (flag[0] == 1) {
            first += second;
        } else if (flag[0] == 2) {
            first -= second;
        } else if (flag[0] == 3) {
            first *= second;
        } else if (flag[0] == 4) {
            first = (int) first / (int) second;
        }
        return (int) first;
    }

    public int calculate2(String s) {
        char[] c = s.toCharArray();
        LinkedList<Integer> n = new LinkedList<>();
        int flag[] = new int[2];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                continue;
            } else if (c[i] == '+') {
                if (flag[0] == 0) {
                    flag[0] = 1;
                } else {
                    flag[1] = 1;
                }
            } else if (c[i] == '-') {
                if (flag[0] == 0) {
                    flag[0] = 2;
                } else {
                    flag[1] = 2;
                }
            } else if (c[i] == '*') {
                if (flag[0] == 0) {
                    flag[0] = 3;
                } else {
                    flag[1] = 3;
                }
            } else if (c[i] == '/') {
                if (flag[0] == 0) {
                    flag[0] = 4;
                } else {
                    flag[1] = 4;
                }
            } else {
                int j = i + 1;
                while (j < c.length && !(c[j] == ' ' || c[j] == '+' || c[j] == '-' || c[j] == '*' || c[j] == '/')) {
                    j++;
                }
                int temp = Integer.parseInt(s.substring(i, j));
                n.add(temp);
                i = j - 1;
                if (flag[1] != 0) {//如果已经有了两个运算符
                    if ((flag[1] == 1 || flag[1] == 2) && (flag[0] == 1 || flag[0] == 2)) {
                        if (flag[0] == 1) {
                            n.addFirst(n.removeFirst() + n.removeFirst());
                        } else {
                            n.addFirst(n.removeFirst() - n.removeFirst());
                        }
                        flag[0] = flag[1];
                        flag[1] = 0;
                    } else if (flag[0] == 3 || flag[0] == 4) {
                        if (flag[0] == 3) {
                            n.addFirst(n.removeFirst() * n.removeFirst());
                        } else {
                            n.addFirst(n.removeFirst() / n.removeFirst());
                        }
                        flag[0] = flag[1];
                        flag[1] = 0;
                    } else {
                        int cur1 = n.removeLast();
                        int cur2 = n.removeLast();
                        if (flag[1] == 3) {
                            n.addLast(cur1 * cur2);
                        } else {
                            n.addLast(cur1 / cur2);
                        }
                        flag[1] = 0;
                    }
                }
            }
        }
        if (flag[0] != 0) {
            int cur1 = n.removeFirst();
            int cur2 = n.removeFirst();
            if (flag[0] == 1) {
                return cur1 + cur2;
            } else if (flag[0] == 2) {
                return cur1 - cur2;
            } else if (flag[0] == 3) {
                return cur1 * cur2;
            } else {
                return cur1 / cur2;
            }
        } else {
            return n.removeFirst();
        }

    }
}
