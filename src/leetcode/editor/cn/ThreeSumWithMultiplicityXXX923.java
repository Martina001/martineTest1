//给定一个整数数组
// arr ，以及一个整数 target 作为目标值，返回满足 i < j < k 且
// arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。 
//
// 由于结果会非常大，请返回 10⁹ + 7 的模。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//输出：20
//解释：
//按值枚举(arr[i], arr[j], arr[k])：
//(1, 2, 5) 出现 8 次；
//(1, 3, 4) 出现 8 次；
//(2, 2, 4) 出现 2 次；
//(2, 3, 3) 出现 2 次。
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,2,2,2,2], target = 5
//输出：12
//解释：
//arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
//我们从 [1,1] 中选择一个 1，有 2 种情况，
//从 [2,2,2,2] 中选出两个 2，有 6 种情况。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
//
// Related Topics 数组 哈希表 双指针 计数 排序 👍 132 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

//Java：三数之和的多种可能
public class ThreeSumWithMultiplicityXXX923{
public static void main(String[] args) {
Solution solution = new ThreeSumWithMultiplicityXXX923().new Solution();
// TO TEST
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod =  1000000007;
        long res =0;
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){
            int tt=target-arr[i];
            int j = i+1,k = arr.length-1;
            while(j<k){
                int rr = arr[j] + arr[k];
                if(rr<tt){
                    j++;
                }else if(rr > tt){
                    k--;
                }else if(arr[k]==arr[j]){
                    // 说明k和j之间的数值相同 直接乘积就是结果
                    res += (k-j+1)*(k-j)/2;
                    res %=mod;
                    break;
                }else{
                    // 如果arr[k]！=arr[j]但是rr == tt，说明此时就要考虑j到k之间有多少等于arr[j]和arr[k]的值
                    int l=1,r=1;
                    while(j+1<k && arr[j]==arr[j+1]){
                        l++;j++;
                    }
                    while(j+1<k && arr[k]==arr[k-1]){
                        r++;k--;
                    }

                    res += l * r;
                    res%=mod;

                    // 记得往下继续走
                    j++;k--;
                }
            }
        }
        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}