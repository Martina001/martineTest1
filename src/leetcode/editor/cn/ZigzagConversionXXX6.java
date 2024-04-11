//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2279 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：Z 字形变换
public class ZigzagConversionXXX6 {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversionXXX6().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            // 重点是找规律，最简单的一个方法就是找出"随着s中字符的移动，当前字符c所在的行数"的规律
            // 根据题目可以得出，当行数为0时，c所在行数递增；为numRows-1的时候，c所在行数递减
            // 注意 如果numRows为0或者1，就直接返回 因为此时不适用下面的规律
            if(numRows < 2 || s.length()<=numRows) return s;
            List<StringBuffer> resList = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                resList.add(new StringBuffer());
            }
            int i = 0, flag = -1;
            for (Character c : s.toCharArray()) {
                resList.get(i).append(c);
                if (i == 0 || i == numRows - 1) flag = -flag;
                i += flag;
            }
            StringBuffer res = new StringBuffer();
            for (StringBuffer sb : resList) {
                res.append(sb);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}