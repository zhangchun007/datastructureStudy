package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;

/**
 * 两数之和
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * <p>
 * 事例1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出: [0,1]
 * 解释：：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 事例2：
 * 输入:nums = [3,2,4], target = 6
 * 输出: [1,2]
 * <p>
 * 事例3：
 * 输入:nums = [3,3], target = 6
 * 输出: [0,1]
 *
 * @return
 */
public class ExampleUnitTest2 {
    @Test
    public void addition_isCorrect() {

        int[] nums=new int[]{11,7,2,15};
        int[] nums1=new int[]{3,2,4};
        int[] location=twoSum(nums1,6);
        for (int i : location) {
            System.out.println("两数之和下表为：==" + i);
        }
    }

    /**
     * [11,7,2,15]
     *
     * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。
     * 而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     *
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}