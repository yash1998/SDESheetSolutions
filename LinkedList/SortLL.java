package LinkedList;

public class SortLL {

    public static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;
        return sortLL(head);
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head, fast = head, midPrev = null;
        while (fast != null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node temp = midPrev.next;
        midPrev.next = null;

        Node h1 = sortLL(head);
        Node h2 = sortLL(temp);

        return merge2SortedLL(h1, h2);
    }

    public static Node merge2SortedLL(Node h1, Node h2) {
        Node newHead = new Node(), curr = newHead;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
            curr.next = null;
        }
        while (h1 != null) {
            curr.next = h1;
            h1 = h1.next;
            curr = curr.next;
            curr.next = null;
        }
        while (h2 != null) {
            curr.next = h2;
            h2 = h2.next;
            curr = curr.next;
            curr.next = null;
        }

        return newHead.next;
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
