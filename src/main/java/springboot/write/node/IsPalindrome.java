/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.IsPalindrome
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;

import java.util.LinkedList;

/**
 * IsPalindrome
 *
 * @description 回文链表
 * @author wangjing
 * @date 2021/4/20 22:58
 * @version v1.0.0
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tempHead = head;
        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head != null) {
            listNodes.push(new ListNode(head.val));
            head = head.next;
        }
        while (!listNodes.isEmpty() && tempHead != null) {
            if (listNodes.pop().val != tempHead.val) {
                return false;
            }
            tempHead = tempHead.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode temp = head;
        ListNode reverseNode = reverseListNode2(temp);
        while (head != null && reverseNode != null) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode node) {
        ListNode tail = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = tail;
            tail = node;
            node = temp;
        }
        return tail;
    }

    private ListNode reverseListNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode node = reverseListNode2(next);
        // 此处的node为反转之后的node
        next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.get(new int[] {1, 2, 2, 1});
        System.out.println(new IsPalindrome().isPalindrome2(node));
    }
}
