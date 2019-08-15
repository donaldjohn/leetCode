import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class P2AddTwoNumber
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        int shiftFlag = 0;

        if(l1.val + l2.val + shiftFlag >= 10)
        {
            currentNode = new ListNode(l1.val + l2.val + shiftFlag - 10);
            shiftFlag = 1;
        }
        else
        {
            currentNode = new ListNode(l1.val + l2.val + shiftFlag);
            shiftFlag = 0;
        }

        result = currentNode;

        while(null != l1.next && null != l2.next)
        {
            l1 = l1.next;
            l2 = l2.next;

            ListNode nextNode = null;

            if(l1.val + l2.val + shiftFlag >= 10)
            {
                nextNode = new ListNode(l1.val + l2.val + shiftFlag - 10);
                shiftFlag = 1;
            }
            else
            {
                nextNode = new ListNode(l1.val + l2.val + shiftFlag);
                shiftFlag = 0;
            }

            currentNode.next = nextNode;
            currentNode = nextNode;
        }


        if (null == l1.next)
        {
            l1.next = l2.next;
        }

        while(null != l1.next)
        {
            l1 = l1.next;
            if (l1.val + shiftFlag >= 10)
            {
                currentNode.next = new ListNode(l1.val + shiftFlag - 10);
                currentNode = currentNode.next;
                shiftFlag = 1;
            }
            else
            {
                currentNode.next = new ListNode(l1.val + shiftFlag);
                currentNode = currentNode.next;
                shiftFlag = 0;
            }
        }

        if (1 == shiftFlag)
        {
            currentNode.next = new ListNode(shiftFlag);
        }

        return result;
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);


        ListNode result = addTwoNumbers(l1, l2);

        System.out.println(result.val);
        while (null != result.next)
        {
            result = result.next;
            System.out.println(", " + result.val);
        }
    }
}
