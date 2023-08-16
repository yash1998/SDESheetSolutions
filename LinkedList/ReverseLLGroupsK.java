package LinkedList;

public class ReverseLLGroupsK {
    public static Node kReverse(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        int length = lengthOfLL(head);

        Node dummy = new Node();
        dummy.next = head;

        Node prev = dummy, curr, next;

        while (length >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i <= k - 1; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            length -= k;
        }
        return dummy.next;
    }

    public static int lengthOfLL(Node head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
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
