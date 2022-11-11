package remove_nth_from_end;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Solution {// 快慢指针法

    public ListNode removeNthFromEnd(ListNode listNode, int n) {
        // 创建虚拟头节点
        ListNode head = new ListNode(0, listNode);
        ListNode slow = head;
        ListNode fast = head;
        // 以下这两个while循环相当于定位出倒数第n个的位置，即n=fast-slow
        while (n-- >= 0 && fast != null) {// 因为包含了虚拟头节点，所以要进行n+1次移动
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除倒数第n个节点
        slow.next = slow.next.next;
        return head.next;
    }
}


class ListNode {
    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
