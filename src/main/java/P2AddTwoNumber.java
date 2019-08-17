import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
