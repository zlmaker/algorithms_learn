package detect_cycle;

/**
 * 题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 */
public class Solution {// 快慢指针法

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;// 定义快慢指针
        ListNode slow = head;
        // 由于fast是走两个节点的，因此也要判断fast.next是否为null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 如果有环的话，那么fast一定可以追上slow的，即相遇点
            if (slow == fast) {
                // 这里如何找到入口有些难度，这里也讲不清处，建议去网上查看资料
                ListNode index1 = slow;// 这里也可以用fast
                ListNode index2 = head;
                // 但index1和index2相等的时候，就说明两个同时处于环的入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;// 也可以返回index1
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
