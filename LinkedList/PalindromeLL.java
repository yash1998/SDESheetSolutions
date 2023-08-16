package LinkedList;

public class PalindromeLL {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverse(slow.next);
        fast = head;
        while (slow != null) {
            if (slow.data != fast.data)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static Node reverse(Node head) {
        if (head == null)
            return null;

        Node prev = null, curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
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
