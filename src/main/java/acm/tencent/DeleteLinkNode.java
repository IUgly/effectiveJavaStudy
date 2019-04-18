package acm.tencent;

/**
 * @author kuangjunlin
 */

/**
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */

/**
 * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
 *
 * 因为我们无法访问我们想要删除的节点之前的节点，我们始终不能修改该节点的 next 指针。
 * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点
 *
 * 因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
 */
class DeleteLinkNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
