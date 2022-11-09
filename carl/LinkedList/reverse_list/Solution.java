package reverse_list;

/**
 * 题意：反转一个单链表。
 * <p>
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */

class Solution1 {// 双指针法

    // 不包含虚拟头节点
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;// 保存cur的下一个节点
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;// 翻转操作
            pre = cur;// 更新pre 和 cur指针
            cur = temp;
        }
        return pre;
    }
}

class Solution2 {// 递归法

    public ListNode reverseList(ListNode head) {
        // 和双指针法初始化是一样的逻辑
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        //可以和双指针法的代码进行对比，如下递归的写法，其实就是做了这两步
        return reverse(cur, temp);
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
