//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3845 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：有效的括号
public class ValidParenthesesXXX20 {
    public static void main(String[] args) {
        Solution solution = new ValidParenthesesXXX20().new Solution();
// TO TEST
        String s = "(())";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            /*List<Character> lList = new ArrayList<>();
            lList.add('(');
            lList.add('[');
            lList.add('{');

            LinkedList<Character> stack = new LinkedList<>();
            if (s == null || s.length() <= 1) return false;
            for(int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                if (lList.contains(c)) {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (!isOk(pop, c)) return false;
                }
            }
            return stack.isEmpty();*/
            // 简单写法
            if(s.isEmpty()) return false;
            LinkedList<Character> stack = new LinkedList<>();
            for(char c:s.toCharArray()){
                if(c == '('){
                    stack.push(')');
                }else if(c == '['){
                    stack.push(']');
                }else if(c == '{'){
                    stack.push('}');
                }else if(stack.isEmpty() || c != stack.pop()){
                    return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isOk(char l, char r) {
            return (l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}