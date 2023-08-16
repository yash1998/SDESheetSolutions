package LinkedList;

public class ReverseLL {
    public static Node reverseDLL(Node head){
        return iterativeDLL(head);
        // return recursive1DLL(head);
        // return recursive2DLL(null, head);
    }

    public static Node iterativeDLL(Node head) {
        if (head == null) return null;

        Node prev = null, curr = head;
        while(curr!= null) {
            Node temp = curr.next;
            curr.next = prev;
            curr.prev = temp;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static Node recursive1DLL(Node head) {
        if (head == null || head.next == null) return head;

        Node restHead = recursive1DLL(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.prev = head.next;
        head.next = null;

        return restHead;
    }

    public static Node recursive2DLL(Node prev, Node curr) {
        if (curr == null) return prev;

        Node temp = curr.next;
        curr.next = prev;
        curr.prev = temp;
        return recursive2DLL(curr, temp);
    }
    
    public static Node reverseLinkedList(Node head) {
        return iterativeLL(head);
        // return recursive1LL(head);
        // return recursive2LL(null, head);
    }

    public static Node iterativeLL(Node head) {
        if (head == null) return null;

        Node prev = null, curr = head;
        while(curr!= null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static Node recursive1LL(Node head) {
        if (head == null || head.next == null) return head;

        Node restHead = recursive1LL(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;

        return restHead;
    }

    public static Node recursive2LL(Node prev, Node curr) {
        if (curr == null) return prev;

        Node temp = curr.next;
        curr.next = prev;
        return recursive2LL(curr, temp);
    }

    static class Node {
        public int data;
        public Node next;
        public Node prev;
   
        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }
   
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
   
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }
}