package leetcode.editor.cn;

//给你一个整数数组 arr 。 
//
// 将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。 
//
// 返回能将数组分成的最多块数？ 
//
// 示例 1： 
//
// 
//输入：arr = [5,4,3,2,1]
//输出：1
//解释：
//将数组分成2块或者更多块，都无法得到所需的结果。 
//例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,3,4,4]
//输出：4
//解释：
//可以把它分成两块，例如 [2, 1], [3, 4, 4]。 
//然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 2000 
// 0 <= arr[i] <= 10⁸ 
// 
//
// Related Topics 栈 贪心 数组 排序 单调栈 👍 302 👎 0

import java.util.LinkedList;

public class MaxChunksToMakeSortedIiXXX768{
    public static void main(String[] args) {
        Solution solution = new MaxChunksToMakeSortedIiXXX768().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        // 思路1 按照题意，相当于每个块内元素的和 与 排序后的arr对应范围内的元素和是相等的
        // 将arr先排序得到sortArr，然后两个数组一起滑动 当和相等 就说明成了一个独立块，计算共几次相等和即可
        // 这样的话 意味着时间复杂度为排序的时间复杂度O( nLogn) 空间复杂度为O(n)
        int n = arr.length;
//        int sortArr[] = Arrays.copyOf(arr,n);
//        Arrays.sort(sortArr);
//        int aSum =0,bSum = 0;
//        int index =0;
//        int res = 0;
//        while (index<n){
//            aSum+=arr[index];
//            bSum +=sortArr[index];
//            index++;
//            if(aSum == bSum){
//                res++;
//                aSum = 0;
//                bSum =0;
//            }
//        }
//        return res;
        // 另一种常见思路：单调栈 这个思路比较巧妙，假设现在已经分好了前面的块，又新增一个元素num，可以分情况讨论
        // 1. num比最近的块中的max还大，那就num自成一块
        // 2。 num比最近块中的max小，这时候就需要去和前一块的max2比较，如果比max2大，那么num加入最近块；如果比max2还小，那么num就得再往前一块进行比较，
        // 直到找到一个块B的最大值小于num，这时num就必须和B块以及其后所有的块成为一块，整个块的最大值为最近块的最大值max。
        // 所以单调栈中只用存储每个块的最大值即可 我们来写一下代码
        LinkedList<Integer> stack = new LinkedList<>();

        for(int i =0;i<n;i++){
            int num =arr[i];
            if(stack.isEmpty() || num>=stack.peekLast()){
                stack.addLast(num);
            }else{
                int max = stack.removeLast();
                // 只要发现有最大值小于num的，这些块都要被合并
                while(!stack.isEmpty() && num<stack.peekLast()){
                    stack.removeLast();
                }
                stack.addLast(max);
            }
        }

        return stack.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}