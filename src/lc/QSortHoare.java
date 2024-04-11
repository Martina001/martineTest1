package lc;

import java.util.Random;

/**
 * @author: Martina
 * @description:
 * @time: 2024/2/20
 */
public class QSortHoare {
    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 1, 3, 2, 1, 3};
        Random random = new Random();
        for (int k = 0; k < a.length; k++) {
            // random的nextInt左闭右开，生成0-参数之间的随机数
            int i = random.nextInt(a.length - k + 1);
            swap(a, k, k + i);
        }
        sort(a, 0, a.length - 1);
        System.out.println(a.length);
    }

    private static void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = getPivot(a, l, r);
        // 下面的getPivot方法是要返回小于等于p的最小索引，所以这里不是sort(a,l,p-1)
        sort(a, l, p);
        sort(a, p + 1, r);
    }

    /**
     * 双向快速排序，又称hoare排序
     *
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int getPivot(int a[], int l, int r) {
        int p = a[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[i] < p) {
                i++;
            }
            while (i < j && a[j] > p) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            swap(a, i, j);
        }
        // 返回的是此时小于等于p的最小索引
        return j;
    }

    private static void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
