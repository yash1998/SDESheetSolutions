package LinkedList;

public class Add2NumsLL {

    public static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummy = new LinkedListNode(-1), temp = dummy;

        int carry = 0, sum = 0;
        while(head1 != null || head2 != null || carry == 1) {
            sum = 0;
            if(head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if(head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            sum += carry;
            carry = sum /10;
            temp.next = new LinkedListNode(sum%10);
            temp = temp.next;
        }
        temp.next = null;
        return head1;
    }

    public static class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }
    
}
