package hw6.Iterators;

import hw6.Trees.TreeNode;
import java.util.*;

public class TreeDepthIterator implements Iterator<TreeNode> {

    Queue<TreeNode> queue;
    Iterator<TreeNode> queueIterator;

    public TreeDepthIterator(TreeNode startFrom) {
        queue = new LinkedList<>();
        initNodes(startFrom);
        queueIterator = queue.iterator();
    }

    private void initNodes(TreeNode node) {
        if (node != null) {
            queue.add(node);
            for (TreeNode child : node.getChildren()) {
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
