//给你一个 n 个视频的上传序列，每个视频编号为 1 到 n 之间的 不同 数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 
//最长上传前缀 。 
//
// 如果 闭区间 1 到 i 之间的视频全部都已经被上传到服务器，那么我们称 i 是上传前缀。最长上传前缀指的是符合定义的 i 中的 最大值 。 请你实现 
//LUPrefix 类： 
//
// 
// LUPrefix(int n) 初始化一个 n 个视频的流对象。 
// void upload(int video) 上传 video 到服务器。 
// int longest() 返回上述定义的 最长上传前缀 的长度。 
// 
//
// 
//
// 示例 1： 
//
// 输入：
//["LUPrefix", "upload", "longest", "upload", "longest", "upload", "longest"]
//[[4], [3], [], [1], [], [2], []]
//输出：
//[null, null, 0, null, 1, null, 3]
//
//解释：
//LUPrefix server = new LUPrefix(4);   // 初始化 4个视频的上传流
//server.upload(3);                    // 上传视频 3 。
//server.longest();                    // 由于视频 1 还没有被上传，最长上传前缀是 0 。
//server.upload(1);                    // 上传视频 1 。
//server.longest();                    // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
//server.upload(2);                    // 上传视频 2 。
//server.longest();                    // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= video <= 10⁵ 
// video 中所有值 互不相同 。 
// upload 和 longest 总调用 次数至多不超过 2 * 10⁵ 次。 
// 至少会调用 longest 一次。 
// 
//
// Related Topics 并查集 设计 树状数组 线段树 二分查找 有序集合 堆（优先队列） 👍 11 👎 0

package leetcode.editor.cn;

//Java：最长上传前缀
public class LongestUploadedPrefixXXX2424{
public static void main(String[] args) {
    LUPrefix solution = new LongestUploadedPrefixXXX2424().new LUPrefix(4);
// TO TEST
    solution.upload(4);
    solution.upload(3);solution.upload(1);solution.upload(2);
    int longest = solution.longest;
    System.out.println(longest);
}
//leetcode submit region begin(Prohibit modification and deletion)
class LUPrefix {
    private  int longest = 0;
    private int[] arr;
    public LUPrefix(int n) {
        arr = new int[n+1];
    }
    
    public void upload(int video) {
        if(video<arr.length) {
            arr[video] = 1;
            /*int count = 0;
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] !=  1){
                    break;
                }
                count++;
            }
            longest = count;*/
            // 直接从longest遍历即可，不用从1开始遍历
            while(longest+1< arr.length && arr[longest+1] == 1){
                longest++;
            }
        }
    }
    
    public int longest() {
        return longest;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
//leetcode submit region end(Prohibit modification and deletion)

}