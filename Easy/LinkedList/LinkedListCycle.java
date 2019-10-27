
// 自己寫的粗糙版本 若node長度超過10000 無法作用
public class Solution {
    public boolean hasCycle(ListNode head) {
        int count = 0;
        if (head == null) {
            return false;
        }
        while(head.next != null) {
            head = head.next;
            count++;
            if(count > 10000) {
                return true;
            }
        }
        return false;
    }
}

// 每次測fast 和 fast.next 不能為null
public class Solution {
       public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
