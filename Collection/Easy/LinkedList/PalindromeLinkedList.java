
// time out
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        
        String x = "";
        String y = "";
        
        // reverse the list
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            x += Integer.toString(cur.val);
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
        }
        
        while (prev != null) {
            y += Integer.toString(prev.val);
            prev = prev.next;
        }
      
        if (x.equals(y)) {
            return true;
        } else {
            return false;
        }
    }
}

// O(n) version

public boolean isPalindrome(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast != null) { // odd nodes: let right half smaller
        slow = slow.next;
    }
    slow = reverse(slow);
    fast = head;
    
    while (slow != null) {
        if (fast.val != slow.val) {
            return false;
        }
        fast = fast.next;
        slow = slow.next;
    }
    return true;
}

public ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}