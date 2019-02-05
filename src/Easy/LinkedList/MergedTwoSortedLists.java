
// recursive version

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// iterative version

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null) 
            return l2;
        if(l2 == null) 
            return l1;
        ListNode newlist;
        ListNode p;
        // decide the head
        if(l1.val < l2.val) {
            newlist = l1; 
            l1 = l1.next;
        } else {
            newlist =l2; 
            l2 = l2.next;
        }
        p = newlist;
        while(l1 != null || l2 != null) {
            if(l1 == null) {p.next = l2; break;}
            if(l2 == null) {p.next = l1; break;}
            if(l1.val < l2.val) {
                p.next = l1; 
                l1 = l1.next; 
                p = p.next;
            } else {
                p.next = l2; 
                l2 = l2.next; 
                p = p.next;
            }
        }
        return newlist;
    }
}