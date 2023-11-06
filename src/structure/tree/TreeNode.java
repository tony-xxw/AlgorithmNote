package structure.tree;



import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public List<Integer> getOrder() {
        return order;
    }



    private List<Integer> order = new ArrayList<>();

    public void preOrder() {
        order.clear();
        preOrder(this);
    }

    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        order.add(treeNode.value);
        preOrder(treeNode.left);
        preOrder(treeNode.right);

    }

    public void inOrder() {
        order.clear();
        inOrder(this);
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        order.add(treeNode.value);
        inOrder(treeNode.right);

    }

    public void sufOrder() {
        order.clear();
        sufOrder(this);
    }

    public void sufOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        sufOrder(treeNode.left);
        sufOrder(treeNode.right);
        order.add(treeNode.value);
    }
}
