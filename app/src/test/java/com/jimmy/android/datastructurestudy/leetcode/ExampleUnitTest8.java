package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 1：左括号必须用相同类型的右括号闭合。
 * 2：左括号必须以正确的顺序闭合。
 * <p>
 * 示例1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @return
 */
public class ExampleUnitTest8 {
    @Test
    public void addition_isCorrect() {
        String s = "()[]{}";
        boolean result=isValid(s);
        System.out.println("有效的括号：s==" + result);
        String s1 = "([)]";
        boolean result1=isValid(s1);
        System.out.println("有效的括号：s1==" + result1);

    }

    /**
     * 判断括号的有效性可以使用「栈」这一数据结构来解决。
     *
     * 我们遍历给定的字符串 ss。当我们遇到一个左括号时，我们会期望在后续的遍历中，有一个相同类型的右括号将其闭合。由于后遇到的左括号要先闭合，因此我们可以将这个左括号放入栈顶。
     *
     * 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。如果不是相同的类型，或者栈中并没有左括号，那么字符串 ss 无效，返回 \text{False}False。为了快速判断括号的类型，我们可以使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
     *
     * 在遍历结束后，如果栈中没有左括号，说明我们将字符串 ss 中的所有左括号闭合，返回 \text{True}True，否则返回 \text{False}False。
     *
     * 注意到有效字符串的长度一定为偶数，因此如果字符串的长度为奇数，我们可以直接返回 \text{False}False，省去后续的遍历判断过程。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> paris = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (paris.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != paris.get(ch)) {
                    return false;
                }
                stack.pop();

            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }


}
