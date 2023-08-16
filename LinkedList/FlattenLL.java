package LinkedList;

public class FlattenLL {
    public static Node flattenLinkedList(Node head) {
        // Write your code here
        if (head == null || head.next == null)
            return head;

        head.next = flattenLinkedList(head.next);
        head = mergeTwoLists(head, head.next);
        return head;
    }

    public static Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);
        Node curr = temp;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                temp.child = a;
                temp = temp.child;
                a = a.child;
            } else {
                temp.child = b;
                temp = temp.child;
                b = b.child;
            }
        }

        if (a != null) {
            temp.child = a;
        } else {
            temp.child = b;
        }
        return curr.child;
    }

    static class Node {
        public int data;
        public Node next;
        public Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }
}
