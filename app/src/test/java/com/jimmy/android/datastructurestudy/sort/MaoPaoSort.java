package com.jimmy.android.datastructurestudy.sort;

import org.junit.Test;

/**
 * @Description: 冒泡排序
 * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个.
 * 2.对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3.针对所有的元素重复以上的步骤，除了最后一个。
 * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p>
 * 作者：往事一块六毛八
 * 链接：https://juejin.cn/post/6942307107114844173
 * 来源：稀土掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author: zhangchun
 * @CreateDate: 2022/2/13
 * @Version: 1.0
 */
public class MaoPaoSort {
    @Test
    public void maoPaoTest() {
        int[] array = new int[]{3, 2, 5, 8, 1, 9, 4, 6, 7};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n-------------sort2优化排序----------------- ");
        sort2(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public void sort(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            //
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    /**
     * 优化
     * 如果swap一次都没执行，说明当前元素已经是有序的了
     *
     * @param array
     */
    public void sort2(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }

    }
}
