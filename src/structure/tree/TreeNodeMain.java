package structure.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeMain {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node.setLeft(node1);
        node.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        levelOrder(node);
        System.out.println();
        node.preOrder();
        print(node.getOrder());
        System.out.println();
        node.inOrder();
        print(node.getOrder());
        System.out.println();
        node.sufOrder();
        print(node.getOrder());
    }

    public static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + "、");
        }
    }

    public static void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            list.add(poll.getValue());
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.offer(poll.getRight());
            }
        }
        print(list);
    }
}
