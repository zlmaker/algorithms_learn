package remove_elements;

/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1：
 * 输入：current = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：current = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：current = [7,7,7,7], val = 7
 * 输出：[]
 */
class Solution1 {// 添加头节点的方式

    public ListNode removeElements(ListNode listNode, int val) {
        ListNode head = new ListNode(-1, listNode);// 添加头节点到源链表
        ListNode current = head;// 保存源链表的位置
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head.next;
    }
}

class Solution2 {// 不添加头节点的方式

    public ListNode removeElements(ListNode listNode, int val) {
        // 删除头部节点
        while (listNode != null && listNode.val == val) {
            listNode = listNode.next;
        }
        ListNode current = listNode;
        // 删除非头部节点
        while (current != null) {
            if (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return listNode;
    }
}
