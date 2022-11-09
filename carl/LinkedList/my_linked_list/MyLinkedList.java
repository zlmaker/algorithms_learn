package my_linked_list;

//单链表
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
