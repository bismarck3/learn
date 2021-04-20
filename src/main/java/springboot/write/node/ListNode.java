/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.ListNode
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * ListNode
 *
 * @description 链表
 * @author wangjing
 * @date 2021/4/12 21:43
 * @version v1.0.0
 */
class ListNode {
    int val;
    ListNode next;


    static ListNode get(int[] nums) {
        ListNode listNode = new ListNode(nums[0]);
        ListNode result = listNode;
        for (int i = 1; i < nums.length; i++) {
            listNode.next = new ListNode(nums[i]);
            listNode = listNode.next;
        }
        return result;
    }

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
