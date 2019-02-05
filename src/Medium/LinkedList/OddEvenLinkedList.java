// 328 Odd Even Linked List   https://leetcode.com/problems/odd-even-linked-list/

// My solution... space complexity... O(3) using extra two node (odd, even)

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode res = new ListNode(0);

        ListNode even = new ListNode(0);
        ListNode evenCurr = even;

        ListNode odd = new ListNode(0);
        ListNode oddCurr = odd;

        int count = 1;
        while(head != null) {
            if(count %2 == 0) {
                ListNode node = new ListNode(head.val);
                evenCurr.next = node;
                evenCurr = evenCurr.next;
            } else {
                ListNode node = new ListNode(head.val);
                oddCurr.next = node;
                oddCurr = oddCurr.next;
            }
            head = head.next;
            count++;
        }

        oddCurr.next = even.next;

        res.next = odd.next;
        res = res.next;

        return res;
    }
}

// other.. with O(1) space complexity

public class Solution {
  public ListNode oddEvenList(ListNode head) {
      if (head != null) {
      
          ListNode odd = head, even = head.next, evenHead = even;
          while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
          }
          odd.next = evenHead; 
      }
    return head;
  }
}