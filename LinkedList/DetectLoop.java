package LinkedList;

public class DetectLoop {

    public static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static Node firstNodeOfLoop(Node head) {
		if(head == null || head.next == null) return null;

        Node slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
			if(slow == fast) {
				fast = head;
				while(slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
        }
		return null;
    }

    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head, fast = head;
        while(fast!= null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                int length = 1;
                fast = fast.next;
                while (slow != fast) {
                    length++;
                    fast = fast.next;
                }
                return length;
            }
        }
        return 0;
    }

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }
}
