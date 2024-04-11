//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2161 👎 0

package leetcode.editor.cn;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//Java：找出字符串中第一个匹配项的下标
public class FindTheIndexOfTheFirstOccurrenceInAStringXXX28{
public static void main(String[] args) {
Solution solution = new FindTheIndexOfTheFirstOccurrenceInAStringXXX28().new Solution();
// TO TEST
    int i = solution.strStr("sadbutsad", "saed");
    System.out.println(i);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {

        /*
        // 普通做法 又称BF（Brute Force 暴力匹配），时间复杂度为m*n
        // 但是就是普通的字符串匹配的解法，因为一般字符串都比较短，这个复杂度可以接受，并且非常简单，Java中的indexOf()之类的都是这么实现的
        if(needle == null || haystack == null) return -1;
        int fast = 0,slow = 0;
        while(fast<haystack.length()){
            int f =0;
            while(f < needle.length() && fast < haystack.length() &&
                    haystack.charAt(fast) == needle.charAt(f)){
                fast++;
                f++;
            }
            if(f == needle.length()){
                return slow;
            }
            slow++;
            fast = slow;
        }
        return -1;*/
        // 第二种办法是，RK算法，名字是两个人命名 不重要。重要的是方法：获取原串中所有跟匹配串相等长度的子串，根据hash值来判断子串和匹配串是否相等
        // 那么时间复杂度1：获取所有子串的hash值：最快为只遍历一遍主串，O（n）；复杂度2：子串和匹配串的比较，比较是O（1），共比较n-m+1次，即O（n），所以RK算法的时间复杂度是o(n)
        // 再说一下获取hash值的方法，可以直接指定12345，也可以借助十进制的方式求hash值，这样可以在遍历子串求hash值的时候可以根据前一个子串得出当前子串的hash值，只有O（n）的复杂度
        // 例如，如果字符串都是a-z的小写字母，那么可以指定a的hash值为0，b为1，那么"abc"子串的hash值为0*26^2 + 1*26+2。这样的话，遍历子串求hash值的时候，前后两个子串之间的差值就很有规律（这里的规律就不列出了，纯数学），所以复杂度就只有n


        // 第三种，KMP做法，理论上讲就是讲复杂度降低到m+n，
        // 也就是说去掉一些冗余的操作，找到每次匹配串匹配的后移最大值
        // 有两个概念：最长子前缀和最长子后缀，找最长的相等前缀和后缀（最长公共前后子缀）。例如ababa的最长子前缀为aba，最长后前缀为aba；abaaaab为ab。
        // 找到之后，当需要后移时，每次匹配串后移的距离就是最长子后缀的首字符位置，降低复杂度，这里就需要一个next[]数组来保存最长子后缀的首字符位置，注意next的0和1索引位可置为0，1对应字符串的首位，以便后续处理
        // 这里说明一个next数组的怎么获取，从i=0,j=2开始，如果字符串p[i]!=p[j-1] next[i]=i;
        int n = needle.length();
        char[] p = needle.toCharArray();
        int[] next = new int[n+1];
        for(int j = 2, i = 0; j <= n; j++)  //从j = 2开始计算
        {
            // 要用while循环；
            // 这里i=next[i]解释：此时左指针走到了i，右指针走到了j，当p[i] != p[j - 1]时，找公共最长后缀的首字符位置，不就是(0-i)之间的子串的公共最长后缀的首字符位置吗（因为此时0-i和x-j两串就是最长子缀，在此范围里找最长就是在0-i之间找最长公共或者说是在x-j之间找），也就是next[i]
            while(i > 0 && p[i] != p[j - 1]) i = next[i];
            if(p[i] == p[j - 1]) i++;
            next[j] = i;
        }
        // 下一步就是匹配了，
        char[] s = haystack.toCharArray();
        List<Integer> res  = new ArrayList<>();
        for(int i = 0, j = 0; i < s.length; i++)
        {
            // 匹配失败 调整 j 的位置
            while(j > 0 && s[i] != p[j]) j = next[j];
            // 当前字符匹配成功, j++继续匹配
            if(s[i] == p[j]) j++;
            if(j == p.length)
            {
                // j到了子串p末尾，说明 完全匹配到了一个答案，记录结果，然后继续调整j寻找
                res.add(i - j + 1);
                j = next[j];
            }
        }
        return res.isEmpty()?-1:res.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}