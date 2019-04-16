package acm;

import java.util.List;

/**
 * @author kuangjunlin
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}
/**
 * @author kuangjunlin
 */
public class AddTwoNumber {
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 ==null && carry==0){
            return null;
        }
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = x + y + carry;
        ListNode result = new ListNode(sum%10);
        carry = sum/10;
        result.next = addTwoNumbers((l1 != null) ? l1.next : null,
                                    (l2 != null) ? l2.next : null);
        return result;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode listNode = addTwoNumber.addTwoNumbers(l1, l2);
        ListNode l = listNode;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(l.val+" -> ");
        }while ((l = l.next) !=null);
        System.out.println(stringBuilder.toString());
    }
}
