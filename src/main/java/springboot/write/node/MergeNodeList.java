/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.MergeNodeList
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * MergeNodeList
 *
 * @description 合并链表
 * @author wangjing
 * @date 2021/4/16 23:43
 * @version v1.0.0
 */
public class MergeNodeList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int n2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            int n;
            if (n1 <= n2) {
                n = n1;
                if (l1 != null) {
                    l1 = l1.next;
                }
            } else {
                n = n2;
                l2 = l2.next;
            }
            if (head == null) {
                head = tail = new ListNode(n);
            } else {
                tail.next = new ListNode(n);
                tail = tail.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.get(new int[]{1, 2, 4});
        ListNode l2 = ListNode.get(new int[] {1, 3, 4});
        new MergeNodeList().mergeTwoLists2(l1, l2);
    }
}
