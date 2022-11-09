package my_linked_list;

/**
 * 题意：
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * <p>
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * <p>
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * <p>
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * <p>
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * //获取第index个节点的数值
     *
     * @param index
     * @return
     */
    public int getNodeVal(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    /**
     * 包含虚拟头节点的后插法，-1表示在虚拟头节点后插入，size-1表示在尾节点后插入
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index >= size || index < -1) {
            return;
        }
        ListNode node = new ListNode(val);
        if (index == -1) {
            node.next = head.next;
            head.next = node;
            size++;
            return;
        }
        ListNode currentNode = head;
        //找到要插入节点的前驱
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;
        size++;
    }

    /**
     * 删除第index个节点
     *
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }
}
