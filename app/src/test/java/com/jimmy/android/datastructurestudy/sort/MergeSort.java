package com.jimmy.android.datastructurestudy.sort;

import org.junit.Test;

/**
 * @Description: 归并排序是采用的分而治之的递归方式来完成数据排序的，主要是将已有序的两个子序列，合并成一个新的有序子序列。
 * 先将子序列分段有序，然后再将分段后的子序列合并成，最终完成数据的排序。
 * <p>
 * <p>
 * 主要步骤：
 * <p>
 * 将数据的长度从中间一分为二，分成两个子序列，执行递归操作，直到每个子序列就剩两个元素
 * 然后分别对这些拆好的子序列进行归并排序。
 * 将排序好的子序列再两两合并，最终合并成一个完整的排序序列
 * @Author: zhangchun
 * @CreateDate: 2022/2/15
 * @Version: 1.0
 */
public class MergeSort {

    @Test
    public void testMergeSort() {
        int[] array=new int[]{6,11,8,2,9,4,1,5,7,10,3};
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println("");
        mergeSort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    /**
     * 归并过程:
     * <p>
     * 设置两个数组分别装载左，右边排序好的数据
     * 设置两个变量（快慢指针）分别指向左右数组的起始位置
     * 设置一个变量指向原始数组的位置，比较左右两个数组数据的大小，小的按顺序存放在原始数组中
     *
     * @param array
     * @param left
     * @param right
     */

    public void mergeSort(int[] array, int left, int right) {

        if (left == right) {
            return;
        } else {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid + 1, right);

        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left;
        int rightSize = right - mid + 1;
        //生成数组
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        //填充数据
        for (int i = left; i < mid; i++) {
            leftArray[i-left] = array[i];
        }
        for (int i = mid; i <= right; i++) {
            rightArray[i - mid] = array[i];
        }

        //合并

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                i++;
                k++;
            } else {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }


    }
}
