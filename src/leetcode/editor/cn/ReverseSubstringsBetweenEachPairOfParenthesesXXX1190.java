//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 
//输入：s = "(u(love)i)"
//输出："iloveu"
//解释：先反转子字符串 "love" ，然后反转整个字符串。 
//
// 示例 3： 
//
// 
//输入：s = "(ed(et(oc))el)"
//输出："leetcode"
//解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。 
//
// 示例 4： 
//
// 
//输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 题目测试用例确保所有括号都是成对出现的 
// 
//
// Related Topics 栈 字符串 👍 283 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//Java：反转每对括号间的子串
public class ReverseSubstringsBetweenEachPairOfParenthesesXXX1190 {
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParenthesesXXX1190().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseParentheses(String s) {
            // 直接用栈，需要注意的是栈里存储的是当前的String结果，而不是下面自己写的只存括号
            Deque<String> stack = new LinkedList<>();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(sb.toString());
                    sb.setLength(0);
                } else if (c == ')') {
                    sb.reverse();
                    // 直接把栈中的上个string结果拼接在sb上
                    sb.insert(0,stack.pop());
                }else{
                    sb.append(c);
                }
            }
            return sb.toString();
            /*  自己写的，可优化的部分很多
            LinkedList<HashMap<Character, Integer>> stack = new LinkedList<>();
            char[] arr = s.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    HashMap<Character, Integer> map = new HashMap<>();
                    map.put(c, i+1);
                    stack.push(map);
                } else if (c == ')') {
                    HashMap<Character, Integer> pop = stack.pop();
                    Integer index = pop.get('(');
                    reverse(arr, index, i-1);
                }
            }
            StringBuffer sb =  new StringBuffer();
            for(Character c:arr){
                if( c == ')' || c =='('){
                    continue;
                }
                sb.append(c);
            }
            return sb.toString();*/
        }

        private void swap(char[] a, int i, int j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private void reverse(char[] arr, int l, int r) {
            while (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}