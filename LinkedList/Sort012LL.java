package LinkedList;

public class Sort012LL {

    public static Node sortList(Node head) {
        Node zeroHead = new Node(-1), zeroTail = zeroHead;
        Node oneHead = new Node(-1), oneTail = oneHead;
        Node twoHead = new Node(-1), twoTail = twoHead;
        Node curr = head;

        while(curr != null) {
            if (curr.data == 0) {
                zeroTail.next = curr;
                zeroTail = zeroTail.next;
            } else if(curr.data == 1) {
                oneTail.next = curr;
                oneTail = oneTail.next;
            } else {
                twoTail.next = curr;
                twoTail = twoTail.next;
            }
            curr = curr.next;
        }

        if (oneHead.next != null) {
            zeroTail.next = oneHead.next;
        } else {
            zeroTail.next = twoHead.next;
        }
        oneTail.next = twoHead.next;
        twoTail.next = null;
        return zeroHead.next;
    }
    
    static class Node {
        public int data;
        public Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
