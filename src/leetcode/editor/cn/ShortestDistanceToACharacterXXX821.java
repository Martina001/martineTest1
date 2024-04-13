//给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。 
//
// 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的
//字符 c 的 距离 。 
//
// 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "loveleetcode", c = "e"
//输出：[3,2,1,0,1,0,0,1,2,2,1,0]
//解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
//距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
//距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
//对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
//距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaab", c = "b"
//输出：[3,2,1,0]
// 
//
// 
//提示：
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] 和 c 均为小写英文字母 
// 题目数据保证 c 在 s 中至少出现一次 
// 
//
// Related Topics 数组 双指针 字符串 👍 357 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

//Java：字符的最短距离
public class ShortestDistanceToACharacterXXX821{
public static void main(String[] args) {
Solution solution = new ShortestDistanceToACharacterXXX821().new Solution();
// TO TEST
    int[] ints = solution.shortestToChar("bbaa", 'b');
    System.out.println(ints.length);
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        /*// 换一种简单的方式，先正序一遍，再逆序一遍 选中较小值就行
        int index[] = new int[n];
        Arrays.fill(index,n+1);
        int j = -1;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == c) {
                j = i;
            }
            if(j != -1){
                index[i] = i-j;
            }
        }
        j=-1;
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == c){
                j = i;
            }
            if(j != -1){
                index[i] = Math.min(index[i],j-i);
            }
        }
        return index;*/
        // 再写一下题解中的BFS的写法 还是没能准确的掌握BFS和树的内涵，这道题其实也是一个节点，向两端扩散
        // 所以先把为c的点加入队列，然后对每个节点的两端分别遍历处理 每次加一后入队列，以此类推
        return bfs(s,c);
        /*
        // 自己写的也太丑了 回头再看一下双指针怎么搞
        int res[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == c){
                res[i] = 0;
                list.add(i);
            }
        }
        int j =0;
        int m = list.size();
        int leftC = list.get(j),rightC = list.get(Math.min(m-1,++j));
        for(int i = 0;i<n;i++){
            if(i>rightC){
                leftC = rightC;
                rightC = list.get(Math.min(m-1,++j));
            }
            if(s.charAt(i) != c){
                int leftLen = Math.abs(leftC-i);
                int rightLen = Math.abs(rightC-i);
                if(leftLen < rightLen){
                    res[i] = leftLen;
                }else{
                    res[i] = rightLen;
                    leftC = rightC;
                    rightC = list.get(Math.min(m-1,++j));
                }
            }
        }
        return res;*/
    }

    private int[] bfs(String s,char c){
        int n = s.length();
        int res[] = new int[n];
        Arrays.fill(res,-1);
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == c){
                queue.offer(i);
                res[i] =0;
            }
        }
        int []dir = new int[]{-1,1};
        while(!queue.isEmpty()){
            int index = queue.poll();
            for(int d:dir){
                int next = index+d;
                if(next >=0 && next<n && res[next] ==-1){
                    res[next] = res[index] +1;
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}