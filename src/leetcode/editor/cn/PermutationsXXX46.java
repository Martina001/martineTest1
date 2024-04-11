//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2581 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：全排列
public class PermutationsXXX46 {
    public static void main(String[] args) {
        Solution solution = new PermutationsXXX46().new Solution();
// TO TEST
        solution.permute(new int[]{1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> resAllSet = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (null == nums || nums.length == 0) return resAllSet;
            boolean[] used = new boolean[nums.length];
//            traverseByLinkedList(nums, new LinkedList<>(), used);
//            traverseByList(nums, new ArrayList<>(), used);
            getPaiLie(nums,used);
            return resAllSet;
        }

        List<Integer> track = new ArrayList<>();
        private void getPaiLie(int nums[],boolean[] used){
            if(track.size() == nums.length){
                resAllSet.add(new ArrayList<>(track));
                return;
            }
            for(int i = 0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                getPaiLie(nums,used);
                track.remove(track.size()-1);
                used[i] = false;
            }
        }

        /**
         * 递归全排列
         *
         * @param nums
         * @param track
         * @param used
         */
        private void traverseByLinkedList(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                // 注意 track是引用，如果这里直接add(track)的话 后续track改了之后resAllSet中的值也会改
                resAllSet.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                track.add(nums[i]);
                traverseByLinkedList(nums, track, used);
                used[i] = false;
                track.removeLast();
            }
        }

        /**
         * 不用LinkedList
         *
         * @param nums
         * @param track
         * @param used
         */
        private void traverseByList(int[] nums, ArrayList<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                // 注意 track是引用，如果这里直接add(track)的话 后续track改了之后resAllSet中的值也会改
                resAllSet.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                track.add(nums[i]);
                traverseByList(nums, track, used);
                used[i] = false;
                // 和traverse就这里一处的区别
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}