/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.ReverseList
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * ReverseList
 *
 * @description 反转链表
 * @author wangjing
 * @date 2021/4/12 21:27
 * @version v1.0.0
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
           ListNode temp = head.next;
           head.next = tail;
           tail = head;
           head = temp;
        }
        return tail;




    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.get(new int[]{1,2,3,4,5});
        System.out.println(new ReverseList().reverseList(listNode));
    }
}


