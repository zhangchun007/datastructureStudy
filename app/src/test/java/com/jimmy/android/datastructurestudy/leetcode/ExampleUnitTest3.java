package com.jimmy.android.datastructurestudy.leetcode;

import org.junit.Test;


/**
 * 环形列表
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @return
 */
public class ExampleUnitTest3 {
    @Test
    public void addition_isCorrect() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode cycle = detectCycle(node1);
        System.out.println("环形列表：==" + cycle.val);
    }

    /**
     * 思路与算法
     * <p>
     * 我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后，slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。
     * 如果链表中存在环，则fast 指针最终将再次与 slow 指针在环中相遇。
     * <p>
     * <p>
     * 根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
     * a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
     * <p>
     * 有了 a=c+(n-1)(b+c)a=c+(n−1)(b+c) 的等量关系，我们会发现：从相遇点到入环点的距离加上 n-1n−1 圈的环长，恰好等于从链表头部到入环点的距离。
     * <p>
     * 因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 tr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

