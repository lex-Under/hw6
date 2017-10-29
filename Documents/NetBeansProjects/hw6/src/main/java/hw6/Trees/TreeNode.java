package hw6.Trees;

import java.util.List;

public class TreeNode {

    protected int value;
    protected TreeNode parent;
    protected List<TreeNode> children;

    public boolean isLeaf() {
        return children.stream().allMatch(node -> node == null);
    }

    protected TreeNode() {
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void print() {
        if (isLeaf()) {
            System.out.format("[branch, value: %d]", this.value);
        } else {
            System.out.format("[leaf, value: %d]", this.value);
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
