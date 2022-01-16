package com.jimmy.android.datastructurestudy.leetcode;

import android.content.Intent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 查找字符串数组中的最长公共前缀。
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 事例1：
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 事例2：
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * @return
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String[] str1 = new String[]{"flower", "flow", "flight"};
        String[] str2 = new String[]{"dog", "racecar", "car"};

        //方法一：横向扫描
        String prefix = getCommonStr(str1);
        System.out.println("数组str1的最长公共前缀==" + prefix);
        String prefix2 = getCommonStr(str2);
        System.out.println("数组str2的最长公共前缀==" + prefix2);


        //方法二：纵向扫描
        String prefix3 = getLongestCommonPrefix(str1);
        String prefix4 = getLongestCommonPrefix(str2);
        System.out.println("数组str1的最长公共前缀==" + prefix3);
        System.out.println("数组str2的最长公共前缀==" + prefix4);


        //方法三：分治
        String prefix5 = longestCommonPrefix(str1);
        String prefix6 = longestCommonPrefix(str2);
        System.out.println("数组str1的最长公共前缀==" + prefix5);
        System.out.println("数组str2的最长公共前缀==" + prefix6);


        //方法三：二分
        String prefix7 = longestCommonPrefix3(str1);
        String prefix8 = longestCommonPrefix3(str2);
        System.out.println("数组str1的最长公共前缀==" + prefix7);
        System.out.println("数组str2的最长公共前缀==" + prefix8);


    }

    /**
     * 方法一：横向扫描
     * LCP(S1...Sn)表示字符串S1...Sn的最长公共前缀
     * LCP(S1...Sn)=LCP(LCP(LCP(S1,S2),S3)...Sn)
     * <p>
     * 1:依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。
     * 2:如果在尚未遍历完所有的字符串时，最长公共前缀已经是空串，则最长公共前缀一定是空串，因此不需要继续遍历剩下的字符串，直接返回空串即可。
     * <p>
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     *
     * @param str
     * @return
     */
    public String getCommonStr(String[] str) {
        if (str == null || str.length == 0) return "";
        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            prefix = getLongestCommonPrefix(prefix, str[i]);
            if (prefix.length() == 0)
                break;
        }

        return prefix;
    }

    private String getLongestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * <p>
     * 方法二：纵向扫描
     * 纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
     * 如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。
     * <p>
     * 时间复杂度：O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     */

    public String getLongestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return "";
        int length = str[0].length();

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < str.length; j++) {
                if (i == str[j].length() || str[0].charAt(i) != str[j].charAt(i)) {//i == strs[j].length()这个判断是主要判断这样的数组["flower","flow"]，当第二个比字符串比第一个短直接返回当前长度
                    return str[0].substring(0, i);
                }
            }
        }
        return "";
    }

    /**
     * 方法三：分治
     *
     *
     * <p>
     * LCP(S1...Sn)=LCP(LCP(S1..Sk),LCP(Sk+1..Sn))
     * 其中LCP(S1...Sn)表示字符串S1...Sn的最长公共前缀，1<k<n
     * 对于问题 LCP(Si...Sj),可以分解成两个子问题LCP(Si...Smid),与LCP(Smid...Sj),其中mid=(i+j)/2
     * 对两个子问题分别求解，然后对两个子问题的解计算最长公共前缀，即为原问题的解。
     * <p>
     * 时间复杂度：O(mn):其中 m是字符串数组中的字符串的平均长度，n是字符串的数量
     * 时间复杂度的递推式是 T(n)=2 *T(n/2)+O(m)，通过计算可得 T(n)=O(mn)
     */

    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) return "";
        else {
            return longestCommonPrefix(str, 0, str.length - 1);
        }

    }

    private String longestCommonPrefix(String[] str, int start, int end) {
        if (start == end) {
            return str[start];
        } else {
            int min = (end - start) / 2 + start;
            String leftStr = longestCommonPrefix(str, start, min);
            String rightStr = longestCommonPrefix(str, min + 1, end);

            return commonPreFix(leftStr, rightStr);

        }
    }

    private String commonPreFix(String leftStr, String rightStr) {
        int minLength = Math.min(leftStr.length(), rightStr.length());
        for (int i = 0; i < minLength; i++) {
            if (leftStr.charAt(i) != rightStr.charAt(i)) {
                return leftStr.substring(0, i);
            }
        }
        return leftStr.substring(0, minLength);
    }


    /**
     * 方法四：二分查找
     * <p>
     * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。用 minLength 表示字符串数组中的最短字符串的长度，
     * 则可以在[0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。每次取查找范围的中间值mid，
     * 判断每个字符串的长度为mid 的前缀是否相同，如果相同则最长公共前缀的长度一定大于或等于 mid，
     * 如果不相同则最长公共前缀的长度一定小于 mid，通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度。
     * <p>
     * ["leets","leetcode","leetc","leeds"]
     * <p>
     * 最小长度字符串：     leets   将其二分
     * <p>
     * lee                               ts 再将ts二分
     * <p>
     * leetcode ✅                  t            s
     * leetc    ✅               leetcode ✅
     * leeds    ✅               leetc    ✅
     * leeds    ❌
     * <p>
     * 结果：lee
     */
    public String longestCommonPrefix3(String[] str) {
        if (str == null || str.length == 0) return "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            minLength = Math.min(str[i].length(), minLength);
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(str, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return str[0].substring(0, low);

    }

    private boolean isCommonPrefix(String[] str, int lenth) {
        String firstStr = str[0].substring(0, lenth);
        for (int j = 1; j < str.length; j++) {
            for (int i = 0; i < firstStr.length(); i++) {
                if (firstStr.charAt(i) != str[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }


}