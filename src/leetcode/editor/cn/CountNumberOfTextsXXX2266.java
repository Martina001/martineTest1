//Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。 
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
//
// Related Topics 哈希表 数学 字符串 动态规划 👍 50 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：统计打字方案数
public class CountNumberOfTextsXXX2266 {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTextsXXX2266().new Solution();
// TO TEST
        int ss = solution.countTexts("ss");
        System.out.println(ss);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTexts(String pressedKeys) {
            // 看起来有点麻烦，其实很简单，就是一个数学题
            // 其实也很麻烦，建议别做
            // 理一下怎么搞 首先 数学规律（没看出来）如果不是数字7和9，就是f[i]=f[i - 1] + f[i - 2] + f[i - 3]
            // 如果是7和9 就是f[i]=f[i - 1] + f[i - 2] + f[i - 3]+f[i-4]
            // 可以先把所有的f都计算一遍，存一下，然后再去找电话号码的规律
            // 如果当前数字跟之前的字符不一样，就是方案数为dp[i-1]*f[x]，其中x从上一个不一样的字符开始计数
            // 例如 2223 就是4*1=4；22233就是4*2=8；222333就是4*4=16；2223333就是4*7=28
            int n = pressedKeys.length();
            int MOD = (int)1e9+7;
            int f[] = new int[n+4];
            int g[] = new int[n+4];
            f[0] = g[0] = 1;
            f[1] = g[1] = 1;
            f[2] = g[2] = 2;
            f[3] = g[3] = 4;

            for (int i = 4; i < n+4; i++) {
                // 先转long再转int
                f[i] = (int) (((long) f[i - 1] + f[i - 2] + f[i - 3]) % MOD);
                g[i] = (int) (((long) g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD);
            }

            int res =1,cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt++;
                char cur = pressedKeys.charAt(i);
                // 一种需要前后对比的时候的方式，不用在循环外判断
                if(i == n-1 || cur != pressedKeys.charAt(i+1)){
                    int dp = f[cnt];
                    if(cur == '7' || cur == '9'){
                        dp = g[cnt];
                    }
                    res =(int) ((long)res*dp %MOD);
                    // cnt重新开始计数
                    cnt=0;
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}