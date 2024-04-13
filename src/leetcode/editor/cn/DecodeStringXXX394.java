//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1736 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;

//Java：字符串解码
public class DecodeStringXXX394 {
    public static void main(String[] args) {
        Solution solution = new DecodeStringXXX394().new Solution();
// TO TEST
        String s = solution.decodeString("3[c]ef");
        StringBuffer sb = new StringBuffer("ab");
        sb.append("c");
        System.out.println(s
        );
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            // 这一看就是一个适合用栈来操作的题目 递归应该也可以
            // 先写一下栈的解法
            // 先看一下自己费尽心思 错误了好多次之后的写法，重点在以下几点因素需要考虑：
            // 1.每个[]中的字符串都要处理完之后重新入栈
            // 2。本以为要对每段开头和结尾独立的字母序列特殊处理，但其实当执行完上一步之后，直接把栈中所有字母加入结果集即可
            // 3。 注意[左边的数字可能不止一位
            // 4。由于步骤1中重新入栈的操作，所以一次性入栈String比一个个再入栈字符更好，故Stack中存储String而不是Character
            return decodeString1(s);
            /*LinkedList<Character> stack = new LinkedList<>();
            int i = 0;
            int n = s.length();
            int count = 0;
            StringBuffer res = new StringBuffer();
            while (i < n) {
                while (i < n && s.charAt(i) <= 'z' && s.charAt(i) >= 'a' && count == 0) {
                    res.append(s.charAt(i++));
                }
                if (i == n) {
                    break;
                }
                char c = s.charAt(i);
                if (c != ']') {
                    if (c == '[') {
                        count++;
                    }
                    stack.push(c);
                    i++;
                } else {
                    i++;
                    StringBuffer sb = new StringBuffer();
                    while(!stack.isEmpty()) {
                        Character pop = stack.pop();
                        if (pop == '[') {
                            count--;
                            break;
                        }
                        sb.append(pop);
                    }
                    sb = sb.reverse();
                    int num = 0, t = 1;
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        int val = stack.pop() - '0';
                        num += val * t;
                        t *= 10;
                    }
                    String str = sb.toString();
                    for (int j = 1; j < num; j++) {
                        str = str + sb.toString();
                    }
                    if (count > 0) {
                        int j = 0;
                        while (j < str.length()) {
                            stack.push(str.charAt(j++));
                        }
                    } else {
                        res.append(str);
                    }
                }
            }
            return res.toString();*/
        }

        /**
         * 看完答案根据上述的几个因素 再写一遍
         *
         * @param s
         * @return
         */
        private String decodeString1(String s) {
            LinkedList<String> stack = new LinkedList<>();
            int i = 0;
            int n = s.length();
            while (i < n) {
                char c = s.charAt(i);
                if (Character.isLetter(c) || c == '[') {
                    stack.addLast(String.valueOf(c));
                    i++;
                } else if (Character.isDigit(c)) {
                    // 提前处理数字
                    StringBuffer sbDigit = new StringBuffer();
                    while (Character.isDigit(s.charAt(i))) {
                        sbDigit.append(s.charAt(i++));
                    }
                    stack.addLast(sbDigit.toString());
                }
                // 遇到了']' 重新处理后入栈
                else {
                    i++;
                    LinkedList<String> sb = new LinkedList<String>();
                    while (!"[".equals(stack.peekLast())) {
                        sb.addFirst(stack.removeLast());
                    }
                    stack.removeLast();
                    int num = Integer.parseInt(stack.removeLast());
                    String ssb = getString(sb);
                    StringBuffer str = new StringBuffer();
                    while(num-->0){
                        str.append(ssb);
                    }
                    stack.addLast(str.toString());
                }
            }
            return getString(stack);
        }

        public String getString(LinkedList<String> v) {
            StringBuffer res = new StringBuffer();
            for (String s : v) {
                res.append(s);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}