package hw6.Trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс узла двоичного дерева.
 */
public class BinaryTreeNode extends TreeNode {

    public BinaryTreeNode(int val) {
        this.value = val;
        this.children = Arrays.asList(null, null);
    }

    public void addLeft(BinaryTreeNode child) {
        children.set(0, child);
        child.parent = this;
    }

    public void addRight(BinaryTreeNode child) {
        children.set(1, child);
        child.parent = this;
    }

}
