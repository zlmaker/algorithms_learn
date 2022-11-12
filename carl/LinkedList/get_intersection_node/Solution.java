package get_intersection_node;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 简单来说，就是求两个链表交点节点的指针。 这里同学们要注意，交点不是数值相等，而是指针相等。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 求链表A、B的长度
        int lenA = getListNodeLength(headA);
        int lenB = getListNodeLength(headB);
        int gap;
        // 判断A和B谁更长，移动相差gap个指针
        if (lenA > lenB) {
            gap = lenA - lenB;
            while (gap-- > 0) {
                curA = curA.next;
            }
        } else {
            gap = lenB - lenA;
            while (gap-- > 0) {
                curB = curB.next;
            }
        }
        // 依次判断是否相等
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    private int getListNodeLength(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
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
