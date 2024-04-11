//给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。 
//
// 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。 
//
// 请按身高 降序 顺序返回对应的名字数组 names 。 
//
// 
//
// 示例 1： 
//
// 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
//输出：["Mary","Emma","John"]
//解释：Mary 最高，接着是 Emma 和 John 。
// 
//
// 示例 2： 
//
// 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
//输出：["Bob","Alice","Bob"]
//解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
// 
//
// 
//
// 提示： 
//
// 
// n == names.length == heights.length 
// 1 <= n <= 10³ 
// 1 <= names[i].length <= 20 
// 1 <= heights[i] <= 10⁵ 
// names[i] 由大小写英文字母组成 
// heights 中的所有值互不相同 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 94 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：按身高排序
public class SortThePeopleXXX2418 {
    public static void main(String[] args) {
        Solution solution = new SortThePeopleXXX2418().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {

            return sortP(names,heights);
            /*// 直接使用HashMap进行频率的存储，注意只有互不相同的才可当key，不可用names当key
            HashMap<Integer, String> map = new HashMap<>(heights.length);
            List<Integer> list = new ArrayList<>();
            int i = 0;
            for (int h : heights) {
                map.put(h, names[i++]);
                list.add(h);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    // 降序
                    return o2 - o1;
                }
            });
            int j = 0;
            for (Integer h : list) {
                names[j++] = map.get(h);
            }
            return names;*/
        }

        private String[] sortP(String[] names,int[] heights){
            Integer [] index = new Integer[heights.length];
            for(int i =0;i<heights.length;i++){
                index[i] = i;
            }
            // 这里用了Arrays的sort 底层其实也是实现了Comparator
            Arrays.sort(index,(a,b)->heights[b] - heights[a]);
            String []res = new String[names.length];
            for(int i =0;i<heights.length;i++){
                res[i] = names[index[i]];
            }
            return  res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}