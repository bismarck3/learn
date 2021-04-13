/**
 * @projectName springbootTest
 * @package springboot.write.node
 * @className springboot.write.node.DeleteNode
 * @copyright Copyright 2021 Thuisoft, Inc. All rights reserved.
 */
package springboot.write.node;
/**
 * DeleteNode
 *
 * @description 删除链表节点
 * @author wangjing
 * @date 2021/4/12 21:42
 * @version v1.0.0
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.get(new int[] {4, 5, 1, 9});
        new DeleteNode().deleteNode(listNode);
    }
}
