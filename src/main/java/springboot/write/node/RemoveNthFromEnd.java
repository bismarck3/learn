/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.RemoveNthFromEnd
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * RemoveNthFromEnd
 *
 * @description 删除链表的倒数第N的节点
 * @author wangjing
 * @date 2021/4/12 21:54
 * @version v1.0.0
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        int size = 1;
        ListNode temp = head;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        head = temp;
        int index = size - n;
        while (head.next != null) {
            index--;
            if (index < 0) {
                head = head.next;
                temp = head;
                break;
            }
            if (index == 0) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.get(new int[] {1, 2});
        new RemoveNthFromEnd().removeNthFromEnd(listNode, 2);
    }
}
