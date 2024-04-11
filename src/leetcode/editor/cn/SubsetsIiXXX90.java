//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1203 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class SubsetsIiXXX90 {
    public static void main(String[] args) {
        Solution solution = new SubsetsIiXXX90().new Solution();
// TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        private void getZiji(int[] nums, int start) {
            // 注意要new
            res.add(new ArrayList<>(track));
            for (int i = start; i < nums.length; i++) {
                // 排序后可实现 有重复元素，不可复选
                // 注意要判断i>start 不是i>0
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                getZiji(nums, i + 1);
                track.remove(track.size() - 1);
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 涉及重复元素不可复选的情况 需要先排序
            Arrays.sort(nums);
            getZiji(nums, 0);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}