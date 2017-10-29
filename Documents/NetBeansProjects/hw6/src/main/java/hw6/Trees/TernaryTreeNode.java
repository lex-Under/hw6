package hw6.Trees;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс узла троичного дерева.
 */
public class TernaryTreeNode extends TreeNode {

    public TernaryTreeNode(int val) {
        this.value = val;
        this.children = Arrays.asList(null, null, null);
    }

    public void addLeft(TernaryTreeNode child) {
        this.children.set(0, child);
        child.parent = this;
    }

    public void addBottom(TernaryTreeNode child) {
        this.children.set(1, child);
        child.parent = this;
    }

    public void addRight(TernaryTreeNode child) {
        this.children.set(2, child);
        child.parent = this;
    }

}
