package hw6.Trees;

import hw6.Iterators.TreeDepthIterator;
import hw6.Iterators.TreeWidthIterator;
import java.util.Iterator;

public abstract class Tree implements Iterable {

    protected TreeNode root;

    public enum IteratorType {
        DEPTH,
        WIDTH
    }

    /**
     * Итератор по умолчанию возвращающий итератор в ширину. Для получения
     * другого итератора используйте перегрузку с параметром.
     */
    @Override
    public Iterator iterator() {
        return new TreeWidthIterator(root);
    }

    /**
     * Итератор заданного типа
     */
    public Iterator iterator(IteratorType type) {
        switch (type) {
            case DEPTH:
                return new TreeDepthIterator(root);
            case WIDTH:
                return new TreeWidthIterator(root);
            default:
                throw new UnsupportedOperationException("The iterator type \"" + type + "\" is not supported yet");
        }
    }
}
