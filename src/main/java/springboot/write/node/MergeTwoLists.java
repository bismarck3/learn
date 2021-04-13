/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.MergeTwoLists
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * MergeTwoLists
 *
 * @description 合并两个有序链表
 * @author wangjing
 * @date 2021/4/12 23:00
 * @version v1.0.0
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = l1;
        while (l1 != null) {
            int n1 = l1.val;
            ListNode temp = l2;
            while (l2 != null) {
                int n2 = l2.val;
                if (n1 <= n2 && l1.next.val > n2) {
                    ListNode t1 = l1.next;
                    l1.next = l2;
                    l2.next = t1.next;
                }
                l2 = l2.next;
            }
            result = l1;
            l1 = l1.next;
            l2 = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.get(new int[] {1, 2, 4});
        ListNode l2 = ListNode.get(new int[] {1, 3, 4});
        new MergeTwoLists().mergeTwoLists(l1, l2);
    }
}
