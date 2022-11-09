package swap_listnode_pairs;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
class Solution1 {// 包含虚拟头节点的迭代法

    public ListNode swapPairs(ListNode head) {
        // 设置一个虚拟头结点
        ListNode listNode = new ListNode(0, head);
        ListNode cur = listNode;// 将虚拟头结点指向cur，这样方面后面操作
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;// 记录第三个临时节点
            ListNode temp1 = cur.next;// 记录第一个临时节点
            cur.next = cur.next.next;// 步骤一
            cur.next.next = temp1;// 步骤二
            cur.next.next.next = temp;// 步骤三
            cur = cur.next.next;// cur移动两位，准备下一轮交换
        }
        return listNode.next;
    }
}

class Solution2 {// 递归法

    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) {
            return head;
        }
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;
        return next;
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
