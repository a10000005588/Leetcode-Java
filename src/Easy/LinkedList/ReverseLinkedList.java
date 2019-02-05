class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
                
        while(cur != null) {
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
        }
        
        return prev;
    }
}