package com.jimmy.android.datastructurestudy.sort;

import org.junit.Test;

/**
 * @Description: 插入排序也是一种比较直观和容易理解的排序算法，通过构建有序序列，将未排序中的数据插入到已排序中序列，最终未排序全部插入到有序序列，达到排序效果。 主要步骤：
 * <p>
 * 将原始数据的第一个元素当成已排序序列，然后将除了第一个元素的后面元素当成未排序序列。
 * 从后面未排序元素中从前到后扫描，挨个取出元素，在已排序的序列中从后往前扫描，将从未排序序列中取出的元素插入到已排序序列的指定位置。
 * 当未排序元素数量为0时，则排序完成。
 * @Author: zhangchun
 * @CreateDate: 2022/2/14
 * @Version: 1.0
 */
public class InsertSort {
    @Test
    public void insertTest() {
        int[] array = new int[]{3, 2, 5, 8, 1, 9, 4, 6, 7};
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        insertSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    public void insertSort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int sortItem = arrays[i];
            int j = i;
            // 将当前元素插入到前面的有序元素里，将当前元素与前面有序元素从后往前挨个对比，然后将元素插入到指定位置。

            while (j > 0 && sortItem < arrays[j - 1]) {
                arrays[j] = arrays[j - 1];
                j--;
            }
            // 若当前元素在前面已排序里面不是最大的，则将它插入到前面已经确定了位置里。
            if (j != i) {
                arrays[j] = sortItem;
            }
        }
    }
}
