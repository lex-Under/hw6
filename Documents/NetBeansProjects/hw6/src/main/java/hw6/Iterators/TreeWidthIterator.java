package hw6.Iterators;

import hw6.Trees.TreeNode;
import java.util.*;

public class TreeWidthIterator implements Iterator<TreeNode> {

    Queue<TreeNode> queue;
    Iterator<TreeNode> queueIterator;

    public TreeWidthIterator(TreeNode startFrom) {
        queue = new LinkedList<>();
        queue.add(startFrom);
        initNodes(startFrom);
        queueIterator = queue.iterator();
    }

    private void initNodes(TreeNode node) {
        for (TreeNode child : node.getChildren()) {
            if (child != null) {
                queue.add(child);
            }
        }
        for (TreeNode child : node.getChildren()) {
            if (child != null) {
                initNodes(child);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return queueIterator.hasNext();
    }

    @Override
    public TreeNode next() {
        return queueIterator.next();
    }

}
