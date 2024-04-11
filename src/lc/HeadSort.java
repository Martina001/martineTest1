package lc;

/**
 * @author: Martina
 * @description:
 * @time: 2023/10/31
 */
public class HeadSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 9,4, 6, 23, 12, 34, 0, 1};
//        int[] arr = {3, 3, 4, 5, 3};
        heapSort(arr);
        System.out.println(String.valueOf(arr));
    }


    private static void buildMaxHeap(int nums[], int hSize) {
        for (int i = hSize / 2; i >= 0; i--) {
            maxHeapifyFor(nums, i, hSize);
        }
    }

    /**
     * 大顶堆 迭代for循环
     *
     * @param nums
     * @param i
     * @param hSize
     */
    private static void maxHeapifyFor(int nums[], int i, int hSize) {
        int temp = nums[i];
        for(int k = i * 2 + 1;k<hSize ;k= i * 2 + 1){
            if(k+1<hSize && nums[k]<nums[k+1]){
                k++;
            }
            if(nums[k]<temp){
                break;
            }
            // 互换
            nums[i]=nums[k];
            i = k;
        }
        nums[i] = temp;
    }

    private static void maxHeapifyFor2(int nums[],int i,int hSize){
        for(int l = i*2+1;l<hSize;l=2*l+1){
            int r = l+1;
            if(r<hSize && nums[r]>nums[l]){
                l++;
            }
            if(nums[l]>nums[i]){
                swap(nums,i,l);
                // 注意这里，当前元素的索引已经发生变化，继续往下遍历需要先更新i
                i=l;
            }
        }
    }

    /**
     * 大顶堆，递归
     *
     * @param nums
     * @param i
     * @param hSize
     */
    private static void maxHeapify(int nums[], int i, int hSize) {
        int lChild = i * 2 + 1, rChild = i * 2 + 2, largest = i;
        if (lChild < hSize && nums[largest] < nums[lChild]) {
            largest = lChild;
        }
        if (rChild < hSize && nums[largest] < nums[rChild]) {
            largest = rChild;
        }
        if (largest != i) {
            swap(nums, i, largest);
            // 继续找下一个最大值进行互换
            maxHeapify(nums, largest, hSize);
        }
    }

    /**
     * 堆排序
     *
     * @param nums
     */
    private static void heapSort(int nums[]) {
        // 先构建大顶堆
        buildMaxHeap(nums,nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            // 堆顶和末尾元素互换之后再调整堆
            swap(nums, i, 0);
            maxHeapifyFor(nums, 0, i);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
