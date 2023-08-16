package LinkedList;

public class RotateLL {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        int n = 0;
        Node curr = head;

        // Finding Length of LL
        while(curr != null) {
            curr = curr.next;
            n++;
        }
        int diff = k%n;
        
        // modulo rotations = 0, means no rotation effectively
        if(diff == 0) return head;

        // total items need to be rotated
        diff = n-diff;

        curr = head;
        // getting head of LL from where rotation will happen
        while(curr!= null) {
            diff--;
            if(diff==0) break;
            curr = curr.next;
        }

        // curr = previous node from where rotation will happen
        Node restHead = curr.next;
        curr.next = null;
        curr = restHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return restHead;
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
