// 2 Add Two Numbers https://leetcode.com/problems/add-two-numbers/

// my code
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int overflow = 0;
        ListNode head = new ListNode(0);
        ListNode cur = new ListNode(0);
        int count = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            overflow = 0;

            if(sum>=10) {
                overflow = 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);

            l1 = l1.next;
            l2 = l2.next;
            cur.next = node;
            cur = cur.next;
            count++;
        }

        while(l1 != null) {
            int sum = l1.val + overflow;
            overflow = 0;
            if(sum>=10) {
                overflow = 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + overflow;
            overflow = 0;

            if(sum>=10) {
                overflow = 1;
                sum = sum%10;
            }
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }
        
        if(overflow != 0) {
            ListNode node = new ListNode(overflow);
            cur.next = node;
        }

        return head.next;
    }
}

// other...

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode results = new ListNode(0);
        ListNode p = l1, q = l2, current = results; 
        int carry = 0;
        
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            
            int sum = x + y + carry;
            carry = sum/10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if(p != null) { p = p.next; }
            if(q != null) { q = q.next; }
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return results.next;
    }
}